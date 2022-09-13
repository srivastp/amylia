package com.ghx.amylia.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Procedure {
    private long id;
    private String name;
    private Category category;
}
