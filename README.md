# java-spring-deep-dive
Java Spring Annotations Deep Dive Tutorial

# 🎯 Spring Аннотации: Глубокое Погружение

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)](https://spring.io/)
[![Java](https://img.shields.io/badge/Java-17-blue)](https://openjdk.org/)

Исследование иерархии Spring аннотаций и их мета-аннотаций. Доказательство того, что `@Service`, `@Repository` и `@Controller` наследуются от `@Component`.

## 📚 Что вы узнаете

- ✅ **Наследование аннотаций** в Spring
- ✅ **Мета-аннотации** и их рекурсивная природа  
- ✅ **Практическое применение** стереотипных аннотаций
- ✅ **Доказательства через рефлексию** и Spring API

## 🏗️ Структура проекта

```

spring-annotations-deep-dive/
├──src/main/java/com/annotationlessons/
│├── MainApplication.java          # Точка входа
│├── proof/                        # Доказательства
││   ├── AnnotationProof.java      # Наследование аннотаций
││   └── MetaAnnotationProof.java  # Мета-уровни
│├── service/                      # Практический пример
││   └── CalculatorService.java    # Сервис с @Service
│└── core/                         # Классы для доказательств
│├── ComponentClass.java       # @Component
│├── ServiceClass.java         # @Service
│       ├── RepositoryClass.java      # @Repository
│└── ControllerClass.java      # @Controller

```

## 🚀 Быстрый старт

```bash
# Клонирование репозитория
git clone https://github.com/your-username/spring-annotations-deep-dive.git
cd spring-annotations-deep-dive

# Сборка и запуск
./gradlew bootRun
```

🔍 Ключевые открытия

1. Наследование Spring стереотипов

```java
// Фактическая реализация в Spring:
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component  // ← Наследование!
public @interface Service {}

// Аналогично для:
// - @Repository ← @Component  
// - @Controller ← @Component
```

2. Рекурсивные мета-аннотации Java

```
@Target ← @Retention ← @Target
@Retention ← @Target
@Documented ← @Target + @Retention
```

3. Доказательство через код

```java
// Все возвращают true:
ServiceClass.class.isAnnotationPresent(Component.class);
RepositoryClass.class.isAnnotationPresent(Component.class); 
ControllerClass.class.isAnnotationPresent(Component.class);
```

📊 Визуализация иерархии

```mermaid
graph TB
    A[@Target] --> B[@Retention]
    B --> A
    C[@Documented] --> A
    C --> B
    
    D[@Component] --> A
    D --> B
    D --> C
    
    E[@Service] --> D
    F[@Repository] --> D  
    G[@Controller] --> D
    
    class A,B,C metaAnnotations
    class D baseAnnotation
    class E,F,G springStereotypes
```

🧪 Запуск доказательств

Проект автоматически демонстрирует:

1. Рабочий Spring сервис (CalculatorService)
2. Наследование аннотаций от @Component
3. Рекурсивную природу мета-аннотаций
4. Подтверждение через Spring API

📖 Уроки

· Урок 1: Все Spring стереотипы - это @Component с семантикой
· Урок 2: Аннотации Java рекурсивно описывают сами себя
· Урок 3: Spring сканирует наследованные аннотации

🤝 Развитие проекта

Добавьте:

· Тесты для каждого доказательства
· Дополнительные кастомные аннотации
· Визуализацию через AspectJ
· Сравнение с другими DI-фреймворками

---

Создано для глубокого понимания Spring аннотаций 🎯
