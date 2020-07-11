package com.github.akhuntsaria.authservice.dto;

public class JwtParseRequestDto {

    private String token;

    public JwtParseRequestDto() {
    }

    public JwtParseRequestDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JwtParseRequestDto{" +
                "token='" + token + '\'' +
                '}';
    }
}
