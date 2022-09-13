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
    private String physician;
    private String hospital;
    private String category;
    private String procedureName;
    private BigDecimal procedureCost;
    private Date procedureDate;
}
