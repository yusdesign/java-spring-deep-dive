package com.annotationlessons.proof;

import com.annotationlessons.core.*;
import org.springframework.stereotype.*;
import org.springframework.core.annotation.AnnotationUtils;
import java.lang.annotation.Annotation;

public class AnnotationProof {
    
    public static void demonstrateInheritance() {
        System.out.println("🎯 ДЕМОНСТРАЦИЯ НАСЛЕДОВАНИЯ АННОТАЦИЙ SPRING\n");
        
        proveComponentInheritance();
        proveWithSpringAPI();
    }
    
    private static void proveComponentInheritance() {
        System.out.println("1. ПРЯМОЕ НАСЛЕДОВАНИЕ ОТ @Component:");
        
        checkClassInheritance(ComponentClass.class, "@Component");
        checkClassInheritance(ServiceClass.class, "@Service");
        checkClassInheritance(RepositoryClass.class, "@Repository");
        checkClassInheritance(ControllerClass.class, "@Controller");
    }
    
    private static void checkClassInheritance(Class<?> clazz, String type) {
        boolean hasComponent = clazz.isAnnotationPresent(Component.class);
        Annotation[] annotations = clazz.getAnnotations();
        
        System.out.printf("\n📦 %s:%n", type);
        System.out.printf("   Имеет @Component: %s%n", hasComponent ? "✅ ДА" : "❌ НЕТ");
        System.out.printf("   Аннотации класса: ");
        for (Annotation ann : annotations) {
            System.out.printf("%s ", ann.annotationType().getSimpleName());
        }
        
        // Покажем мета-аннотации
        if (annotations.length > 0) {
            Annotation primary = annotations[0];
            System.out.printf("%n   Мета-аннотации %s: ", primary.annotationType().getSimpleName());
            Annotation[] metas = primary.annotationType().getAnnotations();
            for (Annotation meta : metas) {
                System.out.printf("%s ", meta.annotationType().getSimpleName());
            }
        }
    }
    
    private static void proveWithSpringAPI() {
        System.out.println("\n\n2. ПОДТВЕРЖДЕНИЕ ЧЕРЕЗ SPRING ANNOTATION UTILS:");
        
        Component serviceComponent = AnnotationUtils.findAnnotation(ServiceClass.class, Component.class);
        Component repoComponent = AnnotationUtils.findAnnotation(RepositoryClass.class, Component.class);
        Component controllerComponent = AnnotationUtils.findAnnotation(ControllerClass.class, Component.class);
        
        System.out.printf("%n@Service → @Component: %s", serviceComponent != null ? "✅" : "❌");
        System.out.printf("%n@Repository → @Component: %s", repoComponent != null ? "✅" : "❌");
        System.out.printf("%n@Controller → @Component: %s", controllerComponent != null ? "✅" : "❌");
    }
}
