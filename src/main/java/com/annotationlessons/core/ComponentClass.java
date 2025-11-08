package com.annotationlessons.core;

import org.springframework.stereotype.Component;

@Component
public class ComponentClass {
    public String getInfo() {
        return "Простой @Component";
    }
}
