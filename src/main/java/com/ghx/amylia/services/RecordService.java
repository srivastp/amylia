package com.ghx.amylia.services;

import com.ghx.amylia.models.Record;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ghx.amylia.utils.UtilityHelper.generateRecords;

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
                    .filter(c -> c.getHospitalName().trim().equalsIgnoreCase(hospitalName.get()))
                    .collect(Collectors.toList());
        }
        if (physicianFirstName.isPresent()) {
            filteredRecords = filteredRecords.stream()
                    .filter(c -> c.getPhysicianFirstName().trim().equalsIgnoreCase(physicianFirstName.get()))
                    .collect(Collectors.toList());
        }
        if (physicianLastName.isPresent()) {
            filteredRecords = filteredRecords.stream()
                    .filter(c -> c.getPhysicianLastName().trim().equalsIgnoreCase(physicianLastName.get()))
                    .collect(Collectors.toList());
        }
        if (procedureName.isPresent()) {
            filteredRecords = filteredRecords.stream()
                    .filter(c -> c.getProcedure().equalsIgnoreCase(procedureName.get()))
                    .collect(Collectors.toList());
        }
        return filteredRecords;
    }
}
