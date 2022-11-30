package com.example.webshopbackend.controller;


import com.example.webshopbackend.dto.CreatePayment;
import com.example.webshopbackend.dto.CreatePaymentResponse;
import com.example.webshopbackend.dto.ProductDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stripe")
public class PaymentController {

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody ProductDto productDto) throws StripeException {
        Stripe.apiKey = "sk_test_51M9GfrAkLxkRHMJPc5XFm9R1r9xHXpgRVcW9Z33lOjAhhfFXgsigqLp0dtk2mWpQnDQOhdXRWh5bqDkZ5Uhz1uld00MgLXOI4Y";
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                        .setAmount(productDto.price()) // createPayment.... What does user want to buy and how much does product cost?
                        .setCurrency("sek")
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams.AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();
        PaymentIntent paymentIntent = PaymentIntent.create(params);
        return new CreatePaymentResponse(paymentIntent.getClientSecret());
    }
}





