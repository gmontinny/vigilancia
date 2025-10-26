package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthResponse {
    private String token;
    private String tokenType;
    private long expiresIn;
    private Integer userId;
    private String email;
    private List<String> authorities;
}
