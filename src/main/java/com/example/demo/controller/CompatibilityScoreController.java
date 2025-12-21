package com.example.demo.controller;

import com.example.demo.entity.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compatibility")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping
    public CompatibilityScoreRecord compute(@RequestParam Long a,
                                            @RequestParam Long b) {
        return service.calculate(a, b);
    }
}
