````markdown
# Fórum Hub - Challenge Alura & Oracle Next Education

## 📖 Sobre o Projeto

Fórum Hub é uma API REST completa para uma plataforma de fórum, desenvolvida como parte do Challenge de Back-end do programa Oracle Next Education (ONE) em parceria com a Alura. A aplicação permite a gestão completa de tópicos de discussão, cursos e usuários, com um sistema de autenticação seguro baseado em JSON Web Tokens (JWT).

O objetivo deste desafio foi construir do zero uma API RESTful seguindo as melhores práticas do mercado, utilizando o ecossistema Spring.

---

## ✨ Funcionalidades Principais

- **Autenticação e Autorização:** Sistema de login seguro com JWT para proteger os endpoints.

- **CRUD de Tópicos:**
  - Cadastrar um novo tópico (associado a um curso e um autor).
  - Listar todos os tópicos com paginação e ordenação.
  - Detalhar um tópico específico pelo seu ID.
  - Atualizar as informações de um tópico.
  - Excluir um tópico.

- **CRUD de Usuários:**
  - Cadastrar um novo usuário com senha criptografada (BCrypt).
  - Listar, detalhar, atualizar e excluir usuários.

- **CRUD de Cursos:**
  - Cadastrar, listar, detalhar, atualizar e excluir cursos.

- **Validações de Negócio:**
  - Impedir o cadastro de tópicos e cursos duplicados.
  - Impedir o cadastro de usuários com e-mail já existente.

- **Documentação de API:** Geração de documentação interativa com Swagger (OpenAPI).

- **Migrações de Banco de Dados:** Gerenciamento do versionamento do schema do banco de dados com Flyway.

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

- **Java 24**
- **Spring Boot 3**
- **Spring Security:** Para autenticação e autorização.
- **Spring Data JPA:** Para persistência de dados com o banco.
- **Hibernate:** Implementação do JPA.
- **MySQL:** Banco de dados relacional.
- **Flyway:** Ferramenta para versionamento de banco de dados.
- **Maven:** Gerenciador de dependências e build.
- **Lombok:** Para reduzir código boilerplate em entidades e DTOs.
- **JWT (JSON Web Token):** Biblioteca java-jwt da Auth0 para geração e validação de tokens.
- **SpringDoc (Swagger):** Para documentação da API.

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos

- Java 24 ou superior.
- Maven 3.8 ou superior.
- Uma instância de banco de dados MySQL em execução.

### Passos

#### Clone o repositório:

```bash
git clone https://github.com/seu-usuario/forumhub.git
cd forumhub
```

#### Configure o Banco de Dados:

Abra o arquivo `src/main/resources/application.properties` e altere as seguintes propriedades com as credenciais do seu banco de dados MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost/forumhub
spring.datasource.username=seu_usuario_mysql
spring.datasource.password=sua_senha_mysql
```

O Flyway criará automaticamente as tabelas quando a aplicação iniciar pela primeira vez.

#### Execute a Aplicação:

Use o Maven para compilar e executar o projeto:

```bash
mvn spring-boot:run
```

A API estará disponível em [http://localhost:8080](http://localhost:8080).

---

## 🚀 Acessando a Documentação (Swagger)

Com a aplicação em execução, você pode acessar a documentação interativa da API no seu navegador:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Nesta página, você pode visualizar todos os endpoints, seus parâmetros, e testá-los diretamente.

Para testar endpoints protegidos:

1. Use o endpoint **POST /login** para se autenticar com um usuário cadastrado.
2. Copie o token JWT retornado.
3. Clique no botão "Authorize" no topo da página e cole o token no formato `Bearer seu_token_aqui`.
4. Agora você pode executar requisições para todos os endpoints protegidos.

---

## ✒️ Autor

Fernando Ramalho

- [LinkedIn](https://www.linkedin.com/in/fernando-ramalho-programador/)
- [GitHub](https://github.com/Atered01)
---

## 🙏 Agradecimentos

Este projeto foi desenvolvido como parte do programa de formação Oracle Next Education (ONE), uma iniciativa da Oracle em parceria com a Alura.
````
