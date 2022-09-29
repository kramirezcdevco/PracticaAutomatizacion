package org.karenramirez.practicaautomatizacion.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
    private String category;
    private String name;
}
