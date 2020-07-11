package com.github.akhuntsaria.protectedservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/protected")
public class ProtectedController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<String> getSomeSensitiveData(HttpServletRequest request) {
        String linkWithSensitiveData = "https://youtu.be/s35rVw1zskA";
        String responseBody;

        // display link nicely in browser
        if (isRequestFromBrowser(request)) {
            responseBody = wrapLinkInHtmlTag(linkWithSensitiveData);
        } else {
            responseBody = linkWithSensitiveData;
        }

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // check if 'Accept' header in request contains passed content type
    private boolean acceptHeaderContainsContentType(HttpServletRequest request, String contentType) {
        String acceptHeader = request.getHeader("Accept");

        if (acceptHeader == null) {
            return false;
        }

        return acceptHeader.contains(contentType);
    }

    private boolean isRequestFromBrowser(HttpServletRequest request) {
        return acceptHeaderContainsContentType(request, MediaType.TEXT_HTML.toString());
    }

    private String wrapLinkInHtmlTag(String link) {
        return String.format("<a href='%s'>%s</a>", link, link);
    }
}
