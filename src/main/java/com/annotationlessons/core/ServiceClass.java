package com.annotationlessons.core;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    public String getInfo() {
        return "@Service наследует от @Component";
    }
}
