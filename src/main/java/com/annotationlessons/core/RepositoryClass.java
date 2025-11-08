package com.annotationlessons.core;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryClass {
    public String getInfo() {
        return "@Repository наследует от @Component";
    }
}
