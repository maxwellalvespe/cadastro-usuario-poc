# Cadastro de usuário simples 


- Objetivo:
  - [x] validar conceitos básicos
  - [x] organização do projeto
  - [x] spring validation
  - [x] controller Advices
  - [x] model Mapper
- v2
  - [x] Adicionar o h2 para persistencia
  - [x] Adicionar recurso para listar os usuários cadastrados
  - [x] Incluir uma nova entidade Enquete que possui uma descricação
  - [x] Incluir recurso para criar uma enquete
  - [x] Incluir recurso para listrar todas as enquetes
  - [x] Incluir recurso no usuario para se registrar a uma enqute
  - [ ] refatorar todo o código definido na v2 e avançar/remodelar adicionando novos recursos 
  
 - regras:
 
 ```
 -  O usuário cadastrado não pode ser menor de 18 anos
 -  O usuário cadastrado não pode deixar o campo do nome em branco nem prencher com o valor nulo
 -  Caso as duas condições anteriores sejam validas o sistema deverá retornar um 400 'pois o erro ocorreu no
 lado do cliente' e no body deve ser enviado as exceções de cada atributo
 ```
## observação

 Está sendo adicionado TODO em algumas partes do projeto, devido as pausas 
 durante o estudo que devem ser corrigidos até o fim dessa revisão.