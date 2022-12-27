# Cadastro de usuário simples 


- Objetivo:
  - validar conceitos básicos
  - organização do projeto
  - spring validation
  - controller Advices
  - model Mapper
- v2
  - Adicionar o h2 para persistencia
  - Adicionar recurso para listar os usuários cadastrados
  
 - regras:
 
 ```
 -  O usuário cadastrado não pode ser menor de 18 anos
 -  O usuário cadastrado não pode deixar o campo do nome em branco nem prencher com o valor nulo
 -  Caso as duas condições anteriores sejam validas o sistema deverá retornar um 400 'pois o erro ocorreu no
 lado do cliente' e no body deve ser enviado as exceções de cada atributo
 ```
