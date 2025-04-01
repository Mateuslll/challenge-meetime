# 🚀 **Meetime HubSpot Integration API**

Este projeto é uma API para integração com a plataforma HubSpot. A API foi desenvolvida com **Spring Boot**, **Java 21** e **OpenAPI** para expor a documentação de endpoints de forma interativa. Abaixo estão as instruções de configuração e execução do projeto.

---

## **Tecnologias Utilizadas**

- **Java 21**: A versão do Java utilizada para desenvolvimento da aplicação.
- **Spring Boot 3.x**: Framework para desenvolvimento da aplicação back-end.
- **Spring Web**: Para criação de endpoints RESTful.
- **Springdoc OpenAPI**: Para gerar e expor a documentação interativa da API.
- **Maven**: Gerenciador de dependências e build.

---

## **Configuração do Projeto**

### **Passos para Executar o Projeto**

### 1. **Clonar o Repositório**
Clone o repositório do projeto para a sua máquina local:

```bash
git clone https://github.com/seu-repositorio/meetime-hubspot-integration.git
cd meetime-hubspot-integration
```

### 2. Configurar o Projeto Maven
Certifique-se de que as dependências estão corretamente configuradas no arquivo pom.xml. O projeto usa Java 21 e Spring Boot 3.4.4.

### 3. Executar o Projeto
Executar a aplicação
Para rodar o projeto localmente, execute o comando abaixo:

```bash
mvn spring-boot:run
```
A aplicação estará disponível em: http://localhost:8080.

### 4. Testar os Endpoints com o Postman
Após iniciar a aplicação, você pode testar os endpoints utilizando o Postman.

A collection do Postman com os endpoints da API está disponível no arquivo Meetime-HubSpot-API.postman_collection.json na raiz do projeto.

## Documentação Interativa - OpenAPI
A documentação interativa da API está disponível através do Swagger UI, fornecido pela integração do Springdoc OpenAPI. Após iniciar o projeto, você pode acessar a documentação interativa em:

```bash
http://localhost:8080/swagger-ui/index.html

```

### Aplicação em Produção
Se você deseja rodar a aplicação em um ambiente de produção, será necessário configurar variáveis de ambiente e garantir que as credenciais de acesso à API do HubSpot estejam seguras. A URL do redirect URI deve ser configurada para um domínio seguro (HTTPS).

```bash
# Nome da aplicação
spring.application.name=meetime-hubspot-integration

# URI de conexão com o HubSpot
hubspot.client.id=seu-client-id
hubspot.client.secret=seu-client-secret
hubspot.redirect.uri=http://localhost:8080/oauth/callback

```

## **Anexos de integração com o hubspot**

### 1. **Obter URL de Autorização**
http://localhost:8080/oauth/authorization-url

![image](https://github.com/user-attachments/assets/52994d5e-27be-497a-9187-95f037a29120)

### 2. **Conectando ao hubspot**

![image](https://github.com/user-attachments/assets/804c96da-01ca-45d8-b2fa-fa863db99f8c)

### 3. **Callback de Autorização**

![image](https://github.com/user-attachments/assets/21bbc864-7c8d-4d4b-a2cf-7675d1c156c0)

### 4. **Receber Webhook de Criação de Contato**
Uso do [ngrok](https://ngrok.com/) para utilizar o weebhook diretamente do hotspot

![image](https://github.com/user-attachments/assets/2408f685-e0e9-4598-912b-59f1218a517d)

### 5. Exemplo "https://fdc0-187-19-231-92.ngrok-free.appwebhook/contact-creation"
 
![image](https://github.com/user-attachments/assets/b77626fe-1c20-4b04-9588-9f98664001f1)

### 6. Retorno no terminal da IDE
   ![image](https://github.com/user-attachments/assets/cc36bb36-1dc9-49ad-b181-d69d88284e93)



