package com.xeelver.paymentservice.controllers;

import com.xeelver.paymentservice.services.CheckoutService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class PaymentController {

    private final CheckoutService checkoutService;


    @GetMapping("/api/v1/payment/healthz")
    public String getInfo() {
        return "Payment Service is Alive!!1";
    }

    @PostMapping(value = "/api/v1/payment/klarna", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> checkoutWithKlarna(@RequestBody String requestBody) {
        String response = checkoutService.createOrder(requestBody);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
