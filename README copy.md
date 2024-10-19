# Projeto Hotel - BackEnd API

## Descrição

O principal objetivo do sistema é aumentar a eficiência no gerenciamento de reservas do hotel, oferecendo uma interface intuitiva e simples para os funcionários. O acesso às funcionalidades do sistema será controlado de acordo com as credenciais de cada usuário, garantindo uma hierarquia de permissões. Apenas o gerente terá acesso total a todos os níveis e funcionalidades do sistema, enquanto outros funcionários terão acesso restrito às funções necessárias para seu papel.

## Tecnologias Utilizadas

- Java 22
- Apache-Maven 3.9.9

## Instalação

1. **Clone o repósitorio**
    ```bash
   git clone https://github.com/davi-brazcubas/trabalho-api
   ```

2. **Navegue até o diretório do projeto:**

   ```bash
   cd Trabalho-API
   ```

3. **Configure o banco de dados:**

   Edite o arquivo [application.yaml](src/main/resources/application.yaml) com as configurações do seu banco de dados.


4. **Compile e execute o projeto:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   A API estará disponível em `http://localhost:8080`.

## Documentação da API (Swagger)

A documentação da API pode ser acessada por meio do Swagger. Após iniciar o backend, você pode acessar a documentação por meio da seguinte URL:

[/swagger-ui/index.html](http://localhost:8080//swagger-ui/index.html)

## Endpoints

Abaixo está a descrição dos principais endpoints da API:

### **1. GET /api/client**

- **Descrição:** Retorna uma lista de clientes.
- **Parâmetros de Consulta:**
  - `page` (opcional): Número da página.
  - `size` (opcional): Número de itens por página.
- **Resposta:**
  - **200 OK**
    ```json
    [
      {
        "id": 1,
        "nome": "João",
        "email": "joao@exemplo.com"
      },
      // ...
    ]
    ```

### **2. POST /api/clients**

- **Descrição:** Cria um novo cliente.
- **Corpo da Requisição:**
  ```json
  {
    "nome": "Maria",
    "email": "maria@exemplo.com"
  }
  ```
- **Resposta:**
  - **201 Created**
    ```json
    {
      "id": 2,
      "nome": "Maria",
      "email": "maria@exemplo.com"
    }
    ```

### **3. GET /api/clients/{id}**

- **Descrição:** Retorna um cliente específico pelo ID.
- **Parâmetros de Caminho:**
  - `id`: ID do cliente.
- **Resposta:**
  - **200 OK**
    ```json
    {
      "id": 1,
      "nome": "João",
      "email": "joao@exemplo.com"
    }
    ```
  - **404 Not Found** (se o cliente não for encontrado)

### **4. PUT /api/clients/{id}**

- **Descrição:** Atualiza um cliente existente.
- **Corpo da Requisição:**
  ```json
  {
    "nome": "João Atualizado",
    "email": "joaoatualizado@exemplo.com"
  }
  ```
- **Parâmetros de Caminho:**
  - `id`: ID do cliente.
- **Resposta:**
  - **200 OK**
    ```json
    {
      "id": 1,
      "nome": "João Atualizado",
      "email": "joaoatualizado@exemplo.com"
    }
    ```
  - **404 Not Found** (se o usuário não for encontrado)

### **5. DELETE /api/clients/{id}**

- **Descrição:** Remove um cliente pelo ID.
- **Parâmetros de Caminho:**
  - `id`: ID do cliente.
- **Resposta:**
  - **204 No Content**
  - **404 Not Found** (se o usuário não for encontrado)

