package com.templates.springapiserverasync.rest.sample;

import com.templates.springapiserverasync.constant.ClientInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTestController {

    @GetMapping("/api/clientInfo")
    public ClientInfo apiClientInfo(ClientInfo clientInfo) {
        return clientInfo;
    }
    @GetMapping({"/api/a", "/api/b"})
    public String apiTest() {
        return "API TEST";
    }
}
