# Simples aplicação usando Arquitetura Hexagonal

## Descrição
Esse projeto realiza um processo muito simples de buscar um registro na API pública https://api.adviceslip.com/ pelo identificador de um registro e salva numa tabela no banco de dados. 

## Tecnologias Utilizadas
- Java 21
- Spring Boot
- Gradle
- Docker Compose
- PostgreSQL
- Flyway

## Requisitos
- Java 21
- Gradle
- Docker
- Docker Compose
 

### Inicialização do Banco de Dados
>Para iniciar o banco de dados PostgreSQL utilizando Docker Compose, execute o comando:

```bash
docker-compose up -d
```

### Migrações de Banco de Dados
As migrações de banco de dados são gerenciadas pelo Flyway. Para aplicar as migrações, execute o projeto após iniciar o banco de dados. As migrações serão aplicadas automaticamente.

#### Padrão de Nomeação das Migrações
Os arquivos de migração devem seguir o padrão "semver" e ser organizados dentro de um diretório com a versão do sistema. O formato do nome do arquivo deve ser: `V<versão>__<descrição>.sql`.

> Exemplos:

```css
V1.0.0__cria_tabela_usuario.sql
V1.1.0__adiciona_coluna_email.sql
```

Esses arquivos devem ser colocados dentro de um diretório correspondente à versão do sistema, como por exemplo:


## Construção e Execução do Projeto
Para construir o projeto, execute:

```bash
gradle build
``` 
Para executar o projeto, execute:

```bash
gradle bootRun
``` 

## Utilização de IDE
Este projeto pode ser utilizado em qualquer IDE. Recomendamos as seguintes IDEs:

- IntelliJ IDEA
- Eclipse
- VS Code

> Para importar o projeto na sua IDE, siga os procedimentos padrão de importação de projetos Gradle.

## Comandos Úteis

### Docker Compose
- Iniciar os containers:
```bash
docker-compose up -d
``` 

- Parar os containers:

```bash
docker-compose down
``` 
### Gradle
- Construir o projeto:

```bash
gradle build
``` 

- Executar o projeto:

```bash
gradle bootRun
```