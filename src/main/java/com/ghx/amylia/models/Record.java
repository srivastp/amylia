package com.ghx.amylia.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Record {
    private UUID id;
    private String physicianFirstName;
    private String physicianLastName;
    private String hospitalName;
    private String procedure;
    private BigDecimal cost;
    private Date procedureDate;
}
