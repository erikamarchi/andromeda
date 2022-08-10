# andromeda

Quando o projeto é criado é criada a primeira galaxia chamada `andromeda` e criados 5 planetas com nomes aleatórios.
As sondas podem ser pousadas em qualquer um desses planetas e movimentadas.
Uma sonda em órbita é uma sonda a caminho do planeta.

O nome da galaxia e a área (largura vs comprimento) dos planetas são configuradas pelo `application.properties`

## Como subir o projeto

Clonar o projeto e rodar com Java 17.

## Endpoints

- pegar as galaxias 

`GET http://localhost:8080/galaxias`
```json
[
  {
    "nome": "andromeda"
  }
]
```

- pegar uma galaxia por nome

`GET http://localhost:8080/galaxias/andromeda`
```json
{
  "nome": "andromeda"
}
```

- pegar os planetas de uma galaxia

`GET http://localhost:8080/galaxias/andromeda/planetas`
```json
[
  {
    "nome": "FWG565",
    "id": 0,
    "valorMaximoX": 5,
    "valorMaximoY": 5
  },
  {
    "nome": "WHF265",
    "id": 1,
    "valorMaximoX": 5,
    "valorMaximoY": 5
  }
]
```

- pegar um planeta de uma galaxia por id do planeta

`GET http://localhost:8080/galaxias/andromeda/planetas/0`
```json
{
  "nome": "FWG565",
  "id": 0,
  "valorMaximoX": 5,
  "valorMaximoY": 5
}
```

- pousar uma sonda em um planeta de uma galaxia

`POST http://localhost:8080/galaxias/andromeda/planetas/0/sondas`
  - Requisição:
```json
{
  "x":3,
  "y":3,
  "sentido":"LESTE"
}
```
  - Resposta:
```json
{
  "id": 0,
  "x": 3,
  "y": 3,
  "sentido": "LESTE"
}
```

- recuperar uma sonda por id

`GET http://localhost:8080/galaxias/andromeda/planetas/0/sondas/0`
```json
{
  "id": 0,
  "x": 3,
  "y": 3,
  "sentido": "LESTE"
}
```

`POST http://localhost:8080/galaxias/andromeda/planetas/1/sondas/0/comandos`
- Requisição:
```json
{
  "comandos": "MMRMMRMRRML"
}
```
- Resposta:
```json
{
  "id": 0,
  "x": 5,
  "y": 1,
  "sentido": "NORTE"
}
```
