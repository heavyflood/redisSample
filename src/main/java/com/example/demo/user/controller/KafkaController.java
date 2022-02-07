package com.example.demo.user.controller;


import com.example.demo.user.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private KafkaProducer producer;

    @PostMapping
    public String sendMessage(@RequestParam("message") String message) {
        producer.sendMessage(message);

        return "success";
    }
}
