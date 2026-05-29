# Agrobot API

API REST desenvolvida em Java com Spring Boot para o projeto Global Solution.

---

## Tecnologias

- Java 17
- Spring Boot 3.5.0
- Maven
- Git/GitHub

---

## Pré-requisitos

Antes de começar, instale:

### 1. Java 17

Verificar instalação:

```bash
java -version
```

Deverá aparecer algo parecido com:

```bash
java version "17"
```

### 2. Maven (Opcional)

O projeto já possui Maven Wrapper (`mvnw`), então não é obrigatório instalar Maven globalmente.

### 3. Git

Verificar instalação:

```bash
git --version
```

### 4. IntelliJ IDEA

IDE recomendada: IntelliJ IDEA

---

# Como clonar o projeto

## 1. Criar pasta de projetos

Exemplo:

```bash
mkdir C:/facul
```

## 2. Entrar na pasta

```bash
cd C:/facul
```

## 3. Clonar o repositório

```bash
git clone https://github.com/NVJP-Tech/Agrobot-API.git
```

## 4. Entrar no projeto

```bash
cd Agrobot-API
```

---

# Como abrir no IntelliJ

1. Abrir IntelliJ
2. Clique em `Open`
3. Selecionar a pasta:

```txt
C:/facul/Agrobot-API
```

4. Esperar o Maven baixar as dependências

---

# Como rodar o projeto

## Pelo IntelliJ

Rodar a classe:

```txt
AgrobotApplication
```

Clique no botão ▶ ao lado do método `main`.

---

## Pelo terminal

Na raiz do projeto:

### Git Bash

```bash
./mvnw spring-boot:run
```

### CMD/PowerShell

```bash
mvnw spring-boot:run
```

---

# Endpoint atual

## Monitoramento das Estufas

### GET

```http
http://localhost:8080/api/estufas
```

Resposta esperada:

```json
[
  {
    "id": 1,
    "nome": "Estufa Alpha",
    "planta": "Alface Crespa",
    "temp": 22.5,
    "umid": 65.0,
    "status": "OPERACIONAL"
  }
]
```

---

# Fluxo Git do Projeto

## Branches

| Branch | Função |
|---|---|
| main | Produção |
| homolog | Homologação/testes |
| develop | Integração |
| feature/* | Desenvolvimento individual |

---

# Como criar uma feature

## 1. Atualizar develop

```bash
git checkout develop
git pull
```

## 2. Criar branch da feature

```bash
git checkout -b feature/nome-da-feature
```

Exemplo:

```bash
git checkout -b feature/login-jwt
```

---

# Como enviar alterações

## 1. Adicionar arquivos

```bash
git add .
```

## 2. Commit

```bash
git commit -m "feat(api): descrição da feature"
```

## 3. Push

Primeira vez:

```bash
git push -u origin feature/nome-da-feature
```

Próximas vezes:

```bash
git push
```

---

# Como atualizar sua branch

```bash
git checkout develop
git pull

git checkout feature/nome-da-feature
git merge develop
```

---

# Regras do Projeto

- NÃO commitar direto na `main`
- NÃO desenvolver direto na `develop`
- Sempre criar `feature/*`
- Sempre fazer pull antes de começar
- Não subir `.idea`, `target` ou arquivos locais

---

# Estrutura do Projeto

```txt
src/main/java/com/fiap/agrobot
│
├── controller
├── dto
├── model
├── service
```
