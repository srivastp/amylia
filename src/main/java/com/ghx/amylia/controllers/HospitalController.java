package com.ghx.amylia.controllers;

import com.ghx.amylia.models.Hospital;
import com.ghx.amylia.services.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {
    private final RecordService recordService;

    public HospitalController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/hospitals")
    public List<Hospital> listHospitals() {
        return recordService.listHospitals();
    }
}
