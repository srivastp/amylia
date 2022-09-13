package com.ghx.amylia.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Category {
    private String name;
}
