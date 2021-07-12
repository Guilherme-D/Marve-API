# Marve-API

O projeto utiliza o banco de dados MYSQL.

Após clonar o projeto, alterar no arquivo application.properties, em src/resources, os dados para conexão do banco de dados e do flyway nas seguintes linhas:

```
spring.datasource.username = root
spring.datasource.password = 12345678

flyway.user = root
flyway.password = 12345678
```

Após isso, basta rodar o projeto que o flyway irá criar o banco, e adicionar os tipos de listas iniciais necessários no banco.

Quando o Spring terminar de executar seu construtor, o método presente na classe **FillDbWithJson** anotado com **@PostConstruct** irá executar e carregar no banco, os valores dos personagens presentes no arquivo data.json.

Depois de finalizado, basta acessar a url http://localhost:8080/swagger-ui.html para testar as seguintes rotas.

```
Lista todos os personagens paginado
/v1/public/character

Recebe dois parametros, **limit** e **page_number**

**page_number** -> página a ser visualizada
**limit** -> quantidade de personagens a ser mostrado por página
```

```
Busca um personagem pelo id
/v1/public/character/{characterId}

Recebe um parametro, **characterId**

**characterId** -> Id de um personagem
```

```
Busca as revistas relacionadas ao personagem (Em desenvolvimento)
/v1/public/character/{characterId}/comics

Recebe um parametro, **characterId**

**characterId** -> Id de um personagem
```

```
Busca os eventos relacionadas ao personagem (Em desenvolvimento)
/v1/public/character/{characterId}/events

Recebe um parametro, **characterId**

**characterId** -> Id de um personagem
```

```
Busca as series relacionadas ao personagem (Em desenvolvimento)
/v1/public/character/{characterId}/series

Recebe um parametro, **characterId**

**characterId** -> Id de um personagem
```

```
Busca as storias relacionadas ao personagem (Em desenvolvimento)
/v1/public/character/{characterId}/stories

Recebe um parametro, **characterId**

**characterId** -> Id de um personagem
```
