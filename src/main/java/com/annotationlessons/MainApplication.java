package com.annotationlessons;

import com.annotationlessons.proof.AnnotationProof;
import com.annotationlessons.proof.MetaAnnotationProof;
import com.annotationlessons.service.CalculatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainApplication.class, args);
        
        System.out.println("=".repeat(60));
        System.out.println("🚀 SPRING АННОТАЦИИ: ГЛУБОКОЕ ПОГРУЖЕНИЕ");
        System.out.println("=".repeat(60));
        
        // Демонстрация работы сервиса
        CalculatorService calculator = context.getBean(CalculatorService.class);
        System.out.printf("%n🧮 %s%n", calculator.getServiceInfo());
        System.out.printf("   5 + 3 = %d%n", calculator.add(5, 3));
        System.out.printf("   5 * 3 = %d%n", calculator.multiply(5, 3));
        
        System.out.println("\n" + "=".repeat(60));
        
        // Доказательства наследования аннотаций
        AnnotationProof.demonstrateInheritance();
        
        System.out.println("\n" + "=".repeat(60));
        
        // Исследование мета-аннотаций
        MetaAnnotationProof.investigateMetaLevels();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎉 УРОК ЗАВЕРШЕН! АННОТАЦИИ РАСКРЫТЫ!");
        System.out.println("=".repeat(60));
    }
}
