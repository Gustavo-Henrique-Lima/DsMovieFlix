# DsMovieFlix
Projeto desenvolvido para avaliação do capítulo 05 Consultas ao banco de dados durante o bootcamp Spring 3.0 da DevSuperior
## Como Rodar o Projeto

### Pré-requisitos

- Java JDK 11 ou superior
- Maven 3.1 ou superior
### Passos

1. **Clonar o Repositório:**

   ```bash
   git clone git@github.com:Gustavo-Henrique-Lima/DsMovieFlix.git

2. **Navegue até o diretório do projeto:**

    ```bash
    cd DsMovieFlix

3. **Instale as dependências:**

    ```bash
    mvn install

4. **Inicie o servidor de desenvolvimento:**

    ```bash
   mvn spring-boot:run

## Funcionalidades
   ### Gêneros

    Listar Gêneros:
      Endpoint para recuperar a lista completa de gêneros.
      
  ### Filmes

      Listar Filmes:
        Endpoint para recuperar a lista completa de filmes.
      
      Detalhes da Categoria:
        Endpoint para obter detalhes de um filme específico com base no ID.
      
  ### Comentários

      Listar Comentários:
        Endpoint para recuperar a lista completa de comentários.
      
      Cadastrar Comentários:
        Endpoint para adicionar um novo comentário à base de dados.
      
  ### Login
      Realizar login:
        Endpoint para realizar login do usuário.
        
## Documentação

  O projeto inclui documentação detalhada para facilitar o entendimento e a interação com a aplicação.
  A seguir estão os recursos de documentação disponíveis.

  ### Swagger

   A API é documentada usando o Swagger, que fornece uma interface interativa para explorar os endpoints 
  da aplicação.
  ### Acesso ao Swagger:
  **Com o projeto rodando**
  
  O Swagger pode ser acessado através do link: [Swagger UI](http://localhost:8080/swagger-ui/index.html).
  
  A interface do Swagger oferece uma visão interativa dos endpoints, permitindo testar as operações
  diretamente na documentação.

## Perfis de configuração

  O projeto oferece um perfil de configuração : **test** (padrão).

  #### **Perfil de Teste (Padrão)**
  
  - **Banco de Dados**: Utiliza o H2 Database, dispensando configurações adicionais.

## Licença
 Este projeto está licenciado sob a licença MIT.
