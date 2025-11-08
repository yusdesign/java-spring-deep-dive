package com.annotationlessons.proof;

import org.springframework.stereotype.*;
import java.lang.annotation.*;

public class MetaAnnotationProof {
    
    public static void investigateMetaLevels() {
        System.out.println("🔍 ИССЛЕДОВАНИЕ МЕТА-АННОТАЦИЙ\n");
        
        System.out.println("1. МЕТА-АННОТАЦИИ SPRING СТЕРЕОТИПОВ:");
        showMetaChain(Component.class, "@Component");
        showMetaChain(Service.class, "@Service");
        showMetaChain(Repository.class, "@Repository");
        showMetaChain(Controller.class, "@Controller");
        
        System.out.println("\n2. РЕКУРСИВНЫЕ МЕТА-АННОТАЦИИ JAVA:");
        showMetaChain(Target.class, "@Target");
        showMetaChain(Retention.class, "@Retention");
        showMetaChain(Documented.class, "@Documented");
    }
    
    private static void showMetaChain(Class<? extends Annotation> annotationClass, String name) {
        System.out.printf("%n%s:%n", name);
        printAnnotationTree(annotationClass, "");
    }
    
    private static void printAnnotationTree(Class<? extends Annotation> annotationClass, String prefix) {
        Annotation[] metas = annotationClass.getAnnotations();
        
        if (metas.length == 0) {
            System.out.printf("%s└── %s (корень)%n", prefix, annotationClass.getSimpleName());
            return;
        }
        
        System.out.printf("%s├── %s%n", prefix, annotationClass.getSimpleName());
        for (int i = 0; i < metas.length; i++) {
            boolean isLast = i == metas.length - 1;
            String newPrefix = prefix + (isLast ? "    " : "│   ");
            printAnnotationTree(metas[i].annotationType(), newPrefix);
        }
    }
}
