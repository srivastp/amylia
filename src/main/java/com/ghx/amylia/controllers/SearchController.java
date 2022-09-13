package com.ghx.amylia.controllers;

import com.ghx.amylia.models.Record;
import com.ghx.amylia.services.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {
    private final RecordService recordService;

    public SearchController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/")
    public List<Record> getRecords(
            @RequestParam(required = false) String hospitalName,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        Optional<String> optionalHospital = (hospitalName == null) ? Optional.empty() : Optional.of(hospitalName);
        Optional<String> optionalFname = (firstName == null) ? Optional.empty() : Optional.of(firstName);
        Optional<String> optionalLname = (lastName == null) ? Optional.empty() : Optional.of(lastName);
        return recordService.getRecords(optionalHospital, optionalFname, optionalLname);
    }
}
//physician
//totalCost

//what pacemaker being used in different hospitals
//Cost