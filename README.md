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
  - [x] refatorar todo o código definido na v2 e avançar/remodelar adicionando novos recursos 
- v2 melhorias
  - [x] ajustado a modelagem do banco de dados para que o vinculo entre o usuário e a enquete fique na tabela de votação
  - [x] adicionado tratamento de possiveis bugs na persistencia dos dados como:
    - cadastrar usuario com o mesmo cpf. 
    - votar mais de uma vez na mesma enquete
    - tentar realizar voto com um código de usuário não cadastrado na base de dados
    - efetivar voto em uma enquete inexistente
  - [x] adicionado recurso para totalizar os votos por enquete
  - [x] adicionar recurso para listar todos os votos e seus relacionamentos.
  - [x] Inclusão do rabbitMq para poder consumir os dados da votação de uma fila que é produzida pelo projeto : 
    https://github.com/maxwellalvespe/rabbitmq-producer 'PENDENTE - atualizar o dto do producer para poder realizar o mapeamento no ms-votação e persistir os dados na base de dados'
  
 - regras:
 
 ```
 -  O usuário cadastrado não pode ser menor de 18 anos
 -  O usuário cadastrado não pode deixar o campo do nome em branco nem prencher com o valor nulo
 -  Caso as duas condições anteriores sejam validas o sistema deverá retornar um 400 'pois o erro ocorreu no
 lado do cliente' e no body deve ser enviado as exceções de cada atributo
 ```

# Atualizações.

#### Inicialmente o projeto tinha a finalidade de obter apenas recursos para o cadastro de usuários simples,<br>porém durante a revisão decidi criar uma enquete onde é possivel o front-end :
  - cadastrar usuarios
    - listar usuários cadastrados
  - cadastrar enquetes
    - listar enquetes
  - registrar voto por enquete
    - auditar votos
    - obter o resultado dos votos para cada enquete


## Organização do projeto:

 A estrutura do projeto segue o seguinte padrão.
 
    api        -> responsável pelos recursos ligados a request e response das requisições
    domain     -> Local utilizado para armazendar os objetos que representam a regra de négocio do sistema.
    service    -> camada responsável por especificar os contratos de cada recurso
      impl     -> camada responável por implementar a lógica para interagir entre a camada controladora e base de dados
    repository -> camada responsável por interagir com a base de dados.
