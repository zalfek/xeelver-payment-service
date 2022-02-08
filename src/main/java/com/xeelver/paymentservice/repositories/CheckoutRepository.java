package com.xeelver.paymentservice.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Repository
public class CheckoutRepository implements PaymentRepository{

    private final static Logger LOGGER = Logger.getLogger(CheckoutRepository.class.getName());

    @Value("${klarnaBaseUrl}")
    private String klarnaUrl;

    @Value("${klarnaUsername}")
    private String klarnaUsername;

    @Value("${klarnaPassword}")
    private String klarnaPassword;

    @Value("${klarnaCheckoutPath}")
    private String klarnaCheckoutPath;

    private RestTemplate restTemplate;

    @PostConstruct
    private void Init() {
        restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(
                new BasicAuthenticationInterceptor(klarnaUsername, klarnaPassword));
    }


    public String createOrder(String orderDetails) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        LOGGER.info("Sending create Order request to Klarna");
        return restTemplate.exchange(klarnaUrl + klarnaCheckoutPath, HttpMethod.POST, new HttpEntity<>(orderDetails, headers), String.class).getBody();
    }


}
