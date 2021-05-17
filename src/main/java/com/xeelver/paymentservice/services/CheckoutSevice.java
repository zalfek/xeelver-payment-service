package com.xeelver.paymentservice.services;

import com.xeelver.paymentservice.repositories.CheckoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class CheckoutSevice {

    private final static Logger LOGGER = Logger.getLogger(CheckoutSevice.class.getName());
    private final CheckoutRepository checkoutRepository;


    public String createOrder(String orderDetails) {
        LOGGER.info("Forwarding create Order request to Repository");
        return checkoutRepository.createOrder(orderDetails);
    }
}
