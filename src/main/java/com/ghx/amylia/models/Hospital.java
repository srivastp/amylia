package com.ghx.amylia.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Hospital {
    private long id;
    private String name;
}


