package com.annotationlessons;
    
import com.annotationlessons.service.CalculatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

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
        
        // Исправленная демонстрация наследования аннотаций
        demonstrateAnnotationInheritance();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎉 УРОК ЗАВЕРШЕН! SPRING АННОТАЦИИ РАБОТАЮТ!");
        System.out.println("=".repeat(60));
    }
    
    private static void demonstrateAnnotationInheritance() {
        System.out.println("🎯 ДЕМОНСТРАЦИЯ НАСЛЕДОВАНИЯ АННОТАЦИЙ");
        
        try {
            // Проверяем наследование аннотаций
            Class<?> serviceClass = Class.forName("com.annotationlessons.core.ServiceClass");
            Class<?> repositoryClass = Class.forName("com.annotationlessons.core.RepositoryClass");
            Class<?> controllerClass = Class.forName("com.annotationlessons.core.ControllerClass");
            Class<?> componentClass = Class.forName("com.annotationlessons.core.ComponentClass");
            
            // Используем Spring AnnotationUtils для поиска унаследованных аннотаций
            boolean serviceHasComponent = AnnotationUtils.findAnnotation(serviceClass, org.springframework.stereotype.Component.class) != null;
            boolean repositoryHasComponent = AnnotationUtils.findAnnotation(repositoryClass, org.springframework.stereotype.Component.class) != null;
            boolean controllerHasComponent = AnnotationUtils.findAnnotation(controllerClass, org.springframework.stereotype.Component.class) != null;
            boolean componentHasComponent = AnnotationUtils.findAnnotation(componentClass, org.springframework.stereotype.Component.class) != null;
            
            System.out.println("\n✅ НАСЛЕДОВАНИЕ ОТ @Component (через Spring AnnotationUtils):");
            System.out.printf("   @Service → @Component: %s%n", serviceHasComponent ? "ДА" : "НЕТ");
            System.out.printf("   @Repository → @Component: %s%n", repositoryHasComponent ? "ДА" : "НЕТ");
            System.out.printf("   @Controller → @Component: %s%n", controllerHasComponent ? "ДА" : "НЕТ");
            System.out.printf("   @Component → @Component: %s%n", componentHasComponent ? "ДА" : "НЕТ");
            
            // Показываем мета-аннотации @Service
            System.out.println("\n🔍 МЕТА-АННОТАЦИИ @Service:");
            Class<?> serviceAnnotation = org.springframework.stereotype.Service.class;
            java.lang.annotation.Annotation[] serviceMetas = serviceAnnotation.getAnnotations();
            
            for (java.lang.annotation.Annotation meta : serviceMetas) {
                String metaName = meta.annotationType().getSimpleName();
                System.out.printf("   ← %s%n", metaName);
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Классы для демонстрации не найдены");
        }
    }
}
