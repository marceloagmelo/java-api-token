# Java API Token

Criação de um CRUD para poder criar, alterar e excluir clientes.

Utilizar:

- Banco de dados Mysql.
- Criação de queries usando JPA respository.
- Spring Security com OAUTH2 utilizando "Password Flow" para autenticação, para posterior consumo da API com Access Token.
- Implementar test JUNIT
- Criação da imagem com a aplicação rodando em container docker.
- Modelo de publicação no Kubernetes.

## Regras do CRUD de cliente

Criar:

- Se o cliente não existir, incluir.
- Se o cliente existir, exibe mensagem "Cliente já existe!".

Alterar:

- Se o cliente não existir, exibe mensagem "Cliente não encontrado!".
- Se o cliente existir, executar alteração.

Excluir:

- Se o cliente não existir, exibe mensagem "Cliente não encontrado!".
- Se o cliente existir, executar exclusão.

Listar:

- Listar os clientes cadastrados.

Caso uma dessas regras não ser atendida, a transação não será autorizada.

## Containers

Para rodar em containers executar o seguinte comando:

```
./scripts/startContainers.sh
```

Irão subir os containers:

- Mysql: Banco de dados do backend
- Adminer: Aplicação web para administrar o banco de dados
> http://localhost:7070
Servidor: mysql-service
Usuário: root
Senha: 12345
Banco de Dados: java-api-token
- Api: Aplicação de API para o CRUD

## Serviços

## Autenticação

### Registrar usuário
```
Method: POST
URL: http://localhost:8080/api/user/register
Body (json):

{
"username": "username",
"password": "password"
}
```

### Autenticar
```
Method: POST
URL: http://localhost:8080/autenticate
Authorization / Auth Type / Basic Auth
"username": "username",
"password": "password"

** Retorna o TOKEN
```

## Cliente

### Criar

```
Method: POST
URL: http://localhost:8080/clientes
Authorization / Auth Type / Bearer Token
Body (json):
{
"nome": "nome"
}
```

### Alterar

```
Method: PUT
URL: http://localhost:8080/clientes/{id}
Authorization / Auth Type / Bearer Token

Body (json):
{
"nome": "nome"
}
```

### Excluir

```
Method: DELETE
URL: http://localhost:8080/clientes/{id}
Authorization / Auth Type / Bearer Token
```

### Listar
```
Method: GET
URL: http://localhost:8080/clientes
Authorization / Auth Type / Bearer Token
```

### Recuperar
```
Method: GET
URL: http://localhost:8080/clientes/{id}
Authorization / Auth Type / Bearer Token
```

## Scripts

_startContainersParcial_: Sobe os seguintes containers para rodar localmente:

- Mysql
- Adminer

_removeContainersParcial_: Derrubar os containers parciais

_startContainers_: Sobe os seguintes containers para rodar localmente em containers docker:

- Mysql
- Adminer
- Api

_removeContainers_: Derrubar os containers

_publishKubernetes_: Sobe os seguintes containers para rodar no cluster kubernetes:

- Mysql
- Adminer
- Api

_removeKubernetes_: Derrubar os containers no cluster kubernetes

## Observação

O projeto também roda executando por intermédio de uma IDE, basta abrir o projeto na sua IDE preferencial, mas necessita que antes suba os containers, executando o comando abaixo:

```
./scripts/startContainersParcial.sh
```
E executar as aplicações pela IDE e acessar os containers

## Kubernetes

Para rodar em containers no kubernetes executar o seguinte comando:

```
./scripts/startKubernetes.sh
```
Irão subir os containers    :

- Mysql: Banco de dados do backend
- Adminer: Aplicação web para administrar o banco de dados
> http://java.api.token.adminer.marceloagmelo.net

    Servidor: mysql-service
    Usuário: root
    Senha: 12345
    Banco de Dados: java-api-token
- Api: Aplicação de API para o CRUD

```
./scripts/removeKubernetes.sh
```
Irão derrubar os containers:

## Observação

Precisa atualizar o arquivo /etc/hosts com os seguintes dados:

```
IP_CLUSTER java.api.token.marceloagmelo.net java.api.token.adminer.marceloagmelo.net
