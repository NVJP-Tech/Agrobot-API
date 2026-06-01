# 👨‍🚀 AgroBot - Global Solution 2026/1

> **"O Espaço é a Nova Fronteira"** – Solução inteligente para a gestão de estufas autônomas em ambientes extremos (Marte, Lua e regiões inóspitas da Terra).

Este projeto faz parte da **Global Solution 2026/1** da FIAP para o curso de **Engenharia de Software**. O AgroBot utiliza tecnologia de ponta para conectar a economia espacial a dores reais da Terra, como o agronegócio inteligente e a segurança alimentar em áreas remotas.

---

## 🏗 Arquitetura do Sistema

O sistema foi desenhado seguindo os princípios de **Clean Architecture** e **S.O.L.I.D.**, garantindo escalabilidade entre a telemetria IoT e a interface do usuário.

<img width="813" height="591" alt="Screenshot 2026-06-01 184431" src="https://github.com/user-attachments/assets/1026958b-8066-4292-ba7b-3988c01280b6" />



---

## 🚀 Tecnologias Utilizadas

- **Java 17** & **Spring Boot 3.x**
- **Oracle Database 19c** (Persistência em nuvem FIAP)
- **Spring Data JPA** (Mapeamento Objeto-Relacional)
- **Swagger / OpenAPI 3** (Documentação Interativa)
- **Maven** (Gerenciamento de dependências)

---

## 📋 Funcionalidades Core

### 1. Monitoramento de Habitats (Estufas)
Gestão em tempo real de pressão, temperatura, umidade e níveis de CO2/O2 nos módulos de cultivo.

### 2. Catálogo de Culturas (NASA Validated)
Base de dados com parâmetros biológicos ideais para plantas validadas pela NASA para o espaço (Batata Espacial, Tomate Red Robin, etc).

### 3. Gestão de Ciclos de Cultivo
Casamento dinâmico entre o **Astronauta responsável**, o **Habitat** e a **Planta**, com cálculo automático de previsão de colheita.

### 4. Telemetria e Alertas Inteligentes
Motor de processamento que recebe dados de sensores IoT. Se um valor ultrapassa o limite da planta, o sistema gera automaticamente um **Log Crítico** para o Dashboard.

---

## 🛠 Como Executar o Projeto

### Pré-requisitos
- JDK 17
- Git
- Acesso ao Oracle Database FIAP

### Instalação
1. Clone o repositório:
```bash
git clone https://github.com/NVJP-Tech/Agrobot-API.git
```

### 2. Configuração de Variáveis de Ambiente

O projeto utiliza variáveis de ambiente para proteger as credenciais de acesso ao banco de dados. Você deve configurá-las no seu sistema ou diretamente na sua IDE (IntelliJ/VS Code).

**Variáveis necessárias:**
- `SPRING_DATASOURCE_URL`: `jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL`
- `SPRING_DATASOURCE_USERNAME`: `Seu RM (Ex: RM000000)`
- `SPRING_DATASOURCE_PASSWORD`: `Sua Senha do Banco`

#### No IntelliJ IDEA:
1. Vá em `Run` > `Edit Configurations...`
2. Selecione a aplicação `AgrobotApplication`.
3. No campo **Environment variables**, clique no ícone da pasta e adicione as chaves e valores acima.
4. Clique em `Apply` e `OK`.

3. Rode a aplicação:
```code
Bash
./mvnw spring-boot:run
```

##📖 Documentação da API (Swagger)

A API possui documentação interativa completa. Com o projeto rodando, acesse:
```code
👉 http://localhost:8080/swagger-ui.html
```

---

## 📖 Principais Endpoints

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/api/habitat` | Lista o status de todos os módulos de estufa. |
| **GET** | `/api/plantas` | Retorna o catálogo de sementes e parâmetros ideais. |
| **POST** | `/api/cultivos/{pltId}/{habId}/{astId}` | Inicia um novo ciclo de vida botânico. |
| **POST** | `/api/logs/sensor/{culId}` | Recebe telemetria do IoT e gera alertas de severidade. |
| **GET** | `/api/logs` | Dashboard de notificações e histórico de alertas. |

---

## 👥 Equipe - NVJP Tech 2026

- **Nicolly Ramalho** - IoT & Security (JWT)
- **Vinicius Wince** - Front-end Mobile & Pitch Storytelling
- **Jean Matheus** - API Backend & Cloud Architecture
- **Pedro Gustavo** - Database Modeling & QA

---

## 📄 Regras de Contribuição

- Utilize o padrão **Conventional Commits**.
- Desenvolva sempre em branches `feature/*`.
- Pull Requests devem ser revisados por pelo menos um par.
