package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.config.MinioProperties;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MinioStorageService {

    private final MinioClient minioClient;
    private final MinioProperties properties;

    public void ensureBucket() {
        try {
            boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(properties.getBucket()).build());
            if (!exists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(properties.getBucket()).build());
            }
        } catch (Exception e) {
            throw new RuntimeException("Falha ao garantir bucket MinIO", e);
        }
    }

    public String upload(MultipartFile file, String objectNamePrefix) {
        try (InputStream is = file.getInputStream()) {
            String ext = extractExtension(file.getOriginalFilename(), file.getContentType());
            String objectName = buildObjectName(objectNamePrefix, ext);
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(objectName)
                    .contentType(file.getContentType())
                    .stream(is, file.getSize(), -1)
                    .build();
            minioClient.putObject(args);
            return objectName;
        } catch (IOException e) {
            throw new RuntimeException("Erro de I/O no upload para MinIO", e);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao enviar objeto para MinIO", e);
        }
    }

    public String upload(byte[] bytes, String contentType, String objectNamePrefix) {
        try (InputStream is = new ByteArrayInputStream(bytes)) {
            String ext = extensionFromContentType(contentType);
            String objectName = buildObjectName(objectNamePrefix, ext);
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(objectName)
                    .contentType(contentType)
                    .stream(is, bytes.length, -1)
                    .build();
            minioClient.putObject(args);
            return objectName;
        } catch (Exception e) {
            throw new RuntimeException("Falha ao enviar objeto para MinIO", e);
        }
    }

    public GetObjectResponse download(String objectName) {
        try {
            return minioClient.getObject(GetObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(objectName)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao baixar objeto do MinIO", e);
        }
    }

    public void remove(String objectName) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(objectName)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao remover objeto no MinIO", e);
        }
    }

    public String presignedGetUrl(String objectName, Integer minutes) {
        try {
            int exp = minutes != null ? minutes : properties.getUrlExpirationMinutes();
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(properties.getBucket())
                            .object(objectName)
                            .expiry(exp, java.util.concurrent.TimeUnit.MINUTES)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Falha ao gerar URL pré-assinada do MinIO", e);
        }
    }

    private String buildObjectName(String prefix, String ext) {
        String uuid = UUID.randomUUID().toString();
        String file = uuid + (ext != null && !ext.isBlank() ? (ext.startsWith(".") ? ext : "." + ext) : "");
        if (prefix == null || prefix.isBlank()) return file;
        String p = prefix.endsWith("/") ? prefix.substring(0, prefix.length() - 1) : prefix;
        return p + "/" + file;
    }

    private String extractExtension(String filename, String contentType) {
        if (filename != null && filename.contains(".")) {
            return filename.substring(filename.lastIndexOf('.') + 1);
        }
        return extensionFromContentType(contentType);
    }

    private String extensionFromContentType(String contentType) {
        if (contentType == null) return null;
        return switch (contentType) {
            case MediaType.IMAGE_PNG_VALUE -> "png";
            case MediaType.IMAGE_JPEG_VALUE -> "jpg";
            case MediaType.IMAGE_GIF_VALUE -> "gif";
            default -> null;
        };
    }
}
