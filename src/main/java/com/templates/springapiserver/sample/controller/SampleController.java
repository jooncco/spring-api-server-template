package com.templates.springapiserver.sample.controller;

import com.templates.springapiserver.sample.dto.res.ClientInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/api/client-info")
    public ResponseEntity<ClientInfoDTO> apiClientInfo(ClientInfoDTO clientInfoDTO) {
        return ResponseEntity.ok(clientInfoDTO);
    }
}
