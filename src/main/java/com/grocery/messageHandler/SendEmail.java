package com.grocery.messageHandler;

import com.grocery.dto.EmailResponseMessage;
import com.grocery.dto.HtmlEmail;
import com.grocery.dto.SimpleEmail;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class SendEmail {

    public static EmailResponseMessage sendSimpleEmail(SimpleEmail simpleEmail) {

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity requestEntity = new HttpEntity(simpleEmail,httpHeaders);

        return restTemplate.postForObject("http://localhost:8081/mail/simple/execution", requestEntity, EmailResponseMessage.class);
    }

    public static EmailResponseMessage sendHtmlEmail(HtmlEmail htmlEmail) {

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity requestEntity = new HttpEntity(htmlEmail,httpHeaders);

        return restTemplate.postForObject("http://localhost:8081/mail/html/execution", requestEntity, EmailResponseMessage.class);
    }

}
