package br.gov.mt.vigilancia.saude.service;

import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.code.CodeGenerator;
import dev.samstevens.totp.code.DefaultCodeVerifier;
import dev.samstevens.totp.time.TimeProvider;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import dev.samstevens.totp.util.Utils;
import org.springframework.stereotype.Service;

/**
 * Serviço utilitário para geração e verificação de TOTP (2FA)
 */
@Service
public class TotpService {

    private final SecretGenerator secretGenerator;
    private final CodeGenerator codeGenerator;
    private final TimeProvider timeProvider;
    private final QrGenerator qrGenerator;

    public TotpService() {
        this.secretGenerator = new DefaultSecretGenerator();
        this.codeGenerator = new DefaultCodeGenerator(HashingAlgorithm.SHA1);
        this.timeProvider = new SystemTimeProvider();
        this.qrGenerator = new ZxingPngQrGenerator();
    }

    public String generateSecret() {
        return secretGenerator.generate();
    }

    public boolean verifyCode(String secret, String code) {
        if (secret == null || secret.isBlank() || code == null || code.isBlank()) {
            return false;
        }
        var verifier = new DefaultCodeVerifier(codeGenerator, timeProvider);
        // tolera 1 passo de drift (30s anterior ou posterior)
        verifier.setAllowedTimePeriodDiscrepancy(1);
        return verifier.isValidCode(secret, code);
    }

    public String buildOtpAuthUrl(String issuer, String accountName, String secret) {
        // Monta URL otpauth de forma explícita para evitar dependência de utilitários específicos
        String label = urlEncode(issuer + ":" + accountName);
        String url = "otpauth://totp/" + label
                + "?secret=" + urlEncode(secret)
                + "&issuer=" + urlEncode(issuer)
                + "&algorithm=SHA1&digits=6&period=30";
        return url;
    }

    private String urlEncode(String s) {
        try {
            return java.net.URLEncoder.encode(s, java.nio.charset.StandardCharsets.UTF_8);
        } catch (Exception e) {
            return s;
        }
    }

    public String generateQrCodeDataUri(String issuer, String accountName, String secret) {
        try {
            QrData data = new QrData.Builder()
                    .label(accountName)
                    .secret(secret)
                    .issuer(issuer)
                    .algorithm(HashingAlgorithm.SHA1)
                    .digits(6)
                    .period(30)
                    .build();
            byte[] imageData = qrGenerator.generate(data);
            String mimeType = qrGenerator.getImageMimeType();
            return Utils.getDataUriForImage(imageData, mimeType);
        } catch (Exception e) {
            throw new IllegalStateException("Falha ao gerar QR Code para TOTP", e);
        }
    }
}
