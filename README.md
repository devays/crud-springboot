# Criação de um Backend Java/SpringBoot

## Descrição
Este é um sistema de backend construído com o Spring Boot que permite a criação, atualização, exclusão e consulta de produtos. Cada produto tem um nome, preço e desconto. O sistema também inclui verificações para garantir a integridade dos dados no banco de dados.

## Funcionalidades Principais
- Criar novos produtos com nome, preço e desconto.
- Verificar se um produto com o mesmo nome já existe no banco de dados durante a criação.
- Consultar produtos de várias maneiras:
  - Filtrar todos os produtos.
  - Filtrar produtos por página (Página e Valores).
  - Filtrar produtos por nome.
- Atualizar informações de produtos com verificação de duplicatas no nome.
- Excluir produtos por ID com mensagens de erro personalizadas.

## Como Usar
Para usar este projeto, siga estas etapas:

1. Altere as configurações do banco de dados em `application.properties` conforme necessário.
2. Verifique as dependências no arquivo `pom.xml` e certifique-se de que todas estão configuradas corretamente.
3. Utilize o Postman ou outra ferramenta similar para interagir com o sistema e enviar requisições para o banco de dados.

## Configuração do Banco de Dados
Certifique-se de configurar corretamente o banco de dados no arquivo `application.properties`. Você pode ajustar as configurações, como o tipo de banco de dados, nome do banco, usuário e senha, de acordo com suas necessidades.

## Dependências
Este projeto depende das seguintes bibliotecas e frameworks do Spring Boot:
- Spring Boot Web Starter
- Spring Boot DevTools
- Spring Boot Test Starter
- Spring Boot Data JPA Starter
- MySQL Connector for Java (v8.0.32)
- Spring Boot Validation Start


© Devays - [github.com/devays]
