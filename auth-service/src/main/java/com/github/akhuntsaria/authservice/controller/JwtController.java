package com.github.akhuntsaria.authservice.controller;

import com.github.akhuntsaria.authservice.dto.ErrorDto;
import com.github.akhuntsaria.authservice.dto.JwtParseRequestDto;
import com.github.akhuntsaria.authservice.dto.JwtParseResponseDto;
import com.github.akhuntsaria.authservice.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/jwt")
public class JwtController {

    private final Logger log = LoggerFactory.getLogger(JwtController.class);

    final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    /**
     * Validate and parse JWT
     */
    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public ResponseEntity<?> getSomeSensitiveData(@RequestBody JwtParseRequestDto requestDto) {
        try {
            JwtParseResponseDto jwtParseResponseDto = jwtService.parseJwt(requestDto.getToken());
            return new ResponseEntity<>(jwtParseResponseDto, HttpStatus.OK);

        } catch (Exception ex) {
            log.error("JWT parsing error: {}, token: {}", ex.getLocalizedMessage(), requestDto);
            ex.printStackTrace();

            return new ResponseEntity<>(new ErrorDto(ex.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
