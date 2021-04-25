package com.xeelver.paymentservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/api/payment")
    public String getInfo(){
        return "Reply from Payment Service";
    }

}
