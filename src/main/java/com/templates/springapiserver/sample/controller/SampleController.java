package com.templates.springapiserver.sample.controller;

import com.templates.springapiserver.sample.dto.res.ClientInfoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/api/clientInfo")
    public ClientInfoDTO apiClientInfo(ClientInfoDTO clientInfoDTO) {
        return clientInfoDTO;
    }

    @GetMapping({"/api/a", "/api/b"})
    public String apiTest() {
        return "API TEST";
    }
}
