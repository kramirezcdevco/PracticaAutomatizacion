package org.karenramirez.practicaautomatizacion.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Credentials {
    private final String username;
    private final String password;


}
