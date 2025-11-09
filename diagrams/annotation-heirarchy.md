# 📊 Визуализация иерархии аннотаций

## Дерево наследования Spring аннотаций

```mermaid
graph TD
    A["Annotation"] --> B["@Retention"]
    A --> C["@Target"] 
    A --> D["@Documented"]
    
    B --> E["RUNTIME"]
    C --> F["TYPE"]
    
    D --> B
    D --> C
    
    G["@Component"] --> B
    G --> C
    G --> D
    
    H["@Service"] --> G
    I["@Repository"] --> G
    J["@Controller"] --> G
    
    style A fill:#f9f,stroke:#333,stroke-width:2px
    style G fill:#9f9,stroke:#333,stroke-width:2px
    style H,I,J fill:#99f,stroke:#333,stroke-width:2px
```

Рекурсивные мета-аннотации

```mermaid
graph LR
    A["@Target"] --> B["@Retention"]
    B --> A
    
    C["@Documented"] --> A
    C --> B
    
    style A fill:#ff9999
    style B fill:#99ff99  
    style C fill:#9999ff
```

Spring сканирование аннотаций

```mermaid
sequenceDiagram
    participant S as Spring Scanner
    participant C as ClassPath
    participant AC as Annotation Context
    
    S->>C: Сканируй пакеты на @Component
    C->>S: Найдены классы с @Service, @Repository...
    S->>AC: Зарегистрируй бины с наследованными аннотациями
    AC->>AC: Все стереотипы обрабатываются как @Component
```

## Запуск проекта:

```bash
# Клонируй и запускай
git clone https://github.com/yusdesign/java-spring-deep-dive.git
cd java-spring-deep-dive
./gradlew bootRun
```

О природе JAVA Spring аннотаций… 🎯
