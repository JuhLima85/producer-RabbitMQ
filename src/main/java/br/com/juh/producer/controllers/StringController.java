package br.com.juh.producer.controllers;

import br.com.juh.producer.services.StringService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produces")
@RequiredArgsConstructor
public class StringController {

    private final StringService stringService;

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam("message") String message){
        stringService.produce(message);
        return ResponseEntity.ok().body("Sending Message");
    }
}
