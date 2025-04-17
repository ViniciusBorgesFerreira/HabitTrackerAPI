# Habit Tracker API 🧠✅

API RESTful desenvolvida em Java com Spring Boot para controle de hábitos diários. Permite o cadastro de usuários, criação de hábitos e marcação de hábitos como concluídos, além de manter um histórico.

---

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (banco em memória)
- Gradle
- Swagger (Springdoc OpenAPI)

---

📌 Funcionalidades
 Cadastro de usuários

 Criação de hábitos

 Marcação de hábito como concluído

 Histórico de hábitos concluídos

 Remoção de hábitos

 Integração com Swagger
 

🧠 Diagrama de Classes
```mermaid
classDiagram
    class User {
        Long id
        String name
        String email
        String password
    }

    class Habit {
        Long id
        String name
        Long idUser
        List~Historic~ historicList
        setConcluido()
    }

    class Historic {
        Long id
        LocalDateTime date
        Boolean completed
    }

    User --> Habit : has many
    Habit --> Historic : has many
    
```

