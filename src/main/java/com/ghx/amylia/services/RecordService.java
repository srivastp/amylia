package com.ghx.amylia.services;

import com.ghx.amylia.models.Hospital;
import com.ghx.amylia.models.Physician;
import com.ghx.amylia.models.Procedure;
import com.ghx.amylia.models.Record;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ghx.amylia.utils.UtilityHelper.*;

@Service
public class RecordService {
    private List<Record> records;

    public RecordService() {
        records = new ArrayList<>();
    }

    public List<Record> getRecords(Optional<String> hospitalName,
                                   Optional<String> physicianFirstName,
                                   Optional<String> physicianLastName,
                                   Optional<String> procedureName) {
        if (records.isEmpty()) {
            records = generateRecords();
        }

        List<Record> filteredRecords = records;
        if (hospitalName.isPresent()) {
            filteredRecords = filteredRecords.stream()
                    .filter(c -> c.getHospital().trim().equalsIgnoreCase(hospitalName.get()))
                    .collect(Collectors.toList());
        }
        if (physicianFirstName.isPresent()) {
            filteredRecords = filteredRecords.stream()
                    .filter(c -> c.getPhysician().trim().equalsIgnoreCase(physicianFirstName.get()))
                    .collect(Collectors.toList());
        }
        if (procedureName.isPresent()) {
            filteredRecords = filteredRecords.stream()
                    .filter(c -> c.getProcedureName().equalsIgnoreCase(procedureName.get()))
                    .collect(Collectors.toList());
        }
        return filteredRecords;
    }

    public List<Hospital> listHospitals() {
        return listAllHospitals();
    }

    public List<Procedure> listProcedures() {
        return listAllProcedures();
    }

    public List<Physician> listPhysicians() {
        return listAllPhysicians();
    }
}
