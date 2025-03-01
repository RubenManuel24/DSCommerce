DSCommerce

DSCommerce é um sistema de e-commerce desenvolvido com Java, Spring Boot, Spring JPA, H2 e outras tecnologias. O sistema permite o CRUD de artigos e cadastro/login de usuários.

Tecnologias Utilizadas

Java 17

Spring Boot 3.x

Spring JPA

H2 Database (banco de dados em memória para testes)

Maven (para gestão de dependências)

Swagger (para documentação da API)

JWT (JSON Web Token) para autenticação

Funcionalidades

Cadastro e login de usuários (com autenticação JWT)

CRUD de produtos (artigos)

Persistência com banco de dados H2 (ou outro banco configurado)

Documentação da API com Swagger

Controle de permissões e autenticação de usuários

Como Rodar o Projeto

1. Clonar o Repositório

    git clone https://github.com/seu-usuario/dscommerce.git
    cd dscommerce

2. Configurar o Banco de Dados H2 (Opcional)

O projeto já está configurado para usar H2. Caso deseje outro banco, edite o arquivo application.properties.

3. Executar o Projeto

    ./mvnw spring-boot:run

Ou, se estiver usando Maven instalado:

    mvn spring-boot:run

O servidor iniciará em http://localhost:8080.

4. Acessar o Console do H2 (Banco de Testes)

Acesse: http://localhost:8080/h2-console

Configuração:

URL JDBC: jdbc:h2:mem:testdb

Usuário: sa

Senha: (vazio, por padrão)

5. Documentação da API

Acesse o Swagger para testar os endpoints:

    http://localhost:8080/swagger-ui.html

Estrutura do Projeto

    dscommerce/
    ├── src/
    │   ├── main/
    │   │   ├── java/com/seuusuario/dscommerce/
    │   │   │   ├── controllers/
    │   │   │   ├── entities/
    │   │   │   ├── repositories/
    │   │   │   ├── services/
    │   │   │   └── config/
    │   └── test/

Autor

Ruben Manuel

Sinta-se à vontade para contribuir e sugerir melhorias!

Licença

Este projeto está sob a licença MIT - veja o arquivo LICENSE para mais detalhes
