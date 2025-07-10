package com.lousanter.toolsAI.AI;


import com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {

    @Autowired
    public AIService service;

    @GetMapping("/api/v1/conversar/{sms}")
    public ResponseEntity<String> conversar(@PathVariable String sms){
        return service.conversar(sms);
    }
}
