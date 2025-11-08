package com.annotationlessons.core;

import org.springframework.stereotype.Controller;

@Controller
public class ControllerClass {
    public String getInfo() {
        return "@Controller наследует от @Component";
    }
}
