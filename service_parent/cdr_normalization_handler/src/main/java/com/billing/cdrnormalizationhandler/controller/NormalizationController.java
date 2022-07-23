package com.billing.cdrnormalizationhandler.controller;

import com.billing.cdrnormalizationhandler.service.NormalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/normalization")
public class NormalizationController {
    private final NormalizationService normalizationService;

    @Autowired
    public NormalizationController(NormalizationService normalizationService) {
        this.normalizationService = normalizationService;
    }

    @PostMapping("/start-process")
    public ResponseEntity<?> startProcess() {
        normalizationService.start();
        return ResponseEntity.ok().body("");
    }
}
