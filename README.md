
# Avaliação Java / Spring: API Rest para Controle de Contatos

O desafio consiste em criar uma aplicação API Rest para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos, onde cada Pessoa pode ter vários Contatos. O principal objetivo é permitir que operações CRUD (Criar, Ler, Atualizar, Deletar) sejam realizadas
na estrutura de Pessoas e Contatos.



**GitHub** ## Tecnologias Utilizadas

**JAVA-JDK:** 21.0.3; 

**MariaDB:** 11.5.1-rc;

**Spring Boot:** 3.2.7;

**Postman**;

**Eclipse IDE:** v2024-06;

**Docker Desktop**;

**DBeaver:** 24.1.1


## Instruções para executar a aplicação

**1 - Acesse o diretório do Workspace da sua IDE e clone o repositório**

No seu prompt de comando, acesse o diretório:
```bash
  Ex: cd C:\Users\pedro\capacitacao-minsait
```
Em seguida clone o repositório:
```bash
  git clone https://github.com/PedroLGS/AppContatos.git
```

**2 - Abrir a IDE e seguir esta ordem:**

File > Import > Maven > Existing Maven Projects > Browse.. > Selecione a pasta do Projeto que foi feito o clone > Precisa aparecer o pom.xml em Projects: >> Finish >> Aguarde a IDE fazer a instalação das dependências.

**3 - Como executar o projeto**

1) Realize a instalação do docker desktop

Depois de instalar o docker, abra o prompt de comando e digite:
```bash
  docker
```
Se a instalação foi feita corretamente, vai aparecer os comandos do docker.

Com o docker aberto, execute este comando para instalar o banco de dados no docker:
```bash
  docker pull mariadb:11.5.1-rc
```

Crie um volume de dados para o banco de dados:
```bash
  docker volume create mariadb_data
```

Execute o banco de dados:
```bash
  docker run --detach --name mariadb --env MARIADB_ROOT_PASSWORD=123456 -p 3309:3306 -v mariadb_data:/var/lib/mysql mariadb:11.5.1-rc
```

No docker em Containers, aperte o botão de run, e seu banco de dados MariaDB vai estar rodando na porta 3309.

2) Instale o DBeaver

Depois de instalar o DBeaver, vai em nova conexão e selecione MariaDB.
Altere a porta de 3306 para 3309, digite em Database: sys, escreva a senha 123456 e aperte em testar conexão.
Com a conexão bem sucedida aperte em concluir, na parte esquerda do DBeaver, aperte com o botão direito do mouse em Banco de dados e criar novo banco de dados, digite o nome do banco de dados: avaliacaojp.

3) Na IDE abre a classe AppContatosApplication.java e aperte no botão de run, a aplicação vai subir no servidor tomcat na porta 8080.

**4 - Swagger UI | Documentação OpenApi**

Acesse o link: http://localhost:8080/swagger-ui/index.html#/

A documentação e os endpoint estarão disponíveis para manipulação dos dados.

## Autor

- [@Pedro Luiz Gomes Sampaio](https://www.github.com/PedroLGS)

## Agradecimentos

- Gostaria de agradecer ao Mestre [@Eduardo Henrique Marques Ferreira](https://www.github.com/eduardohen1), que em pouco tempo de treinamento foi capaz de transmitir muito conhecimento sobre Java.

