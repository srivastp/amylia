package com.ghx.amylia.controllers;

import com.ghx.amylia.models.Procedure;
import com.ghx.amylia.services.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProcedureController {

    private final RecordService recordService;
    public ProcedureController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/procedures")
    public List<Procedure> listProcedures() {
        return recordService.listProcedures();
    }
}
