package br.edu.uniopet.locationapi.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class JwtConfig {
    @Value("${security.jwt.uri:/auth/**}")
    private String Uri;

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.expiration:#{86400000}}")
    private int expiration;

    @Value("${security.jwt.secret:M3uP@uS3mS3nh@}")
    private String secret;
}
