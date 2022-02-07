package com.example.demo.user.controller;


import com.example.demo.user.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private KafkaProducer producer;

    @PostMapping("/push/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        producer.sendMessage(message);

        return "success";
    }
}
