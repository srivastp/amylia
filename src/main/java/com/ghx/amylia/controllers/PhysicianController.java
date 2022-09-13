package com.ghx.amylia.controllers;

import com.ghx.amylia.models.Physician;
import com.ghx.amylia.models.Procedure;
import com.ghx.amylia.services.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhysicianController {

    private final RecordService recordService;
    public PhysicianController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/physicians")
    public List<Physician> lisPhysicians() {
        return recordService.listPhysicians();
    }
}