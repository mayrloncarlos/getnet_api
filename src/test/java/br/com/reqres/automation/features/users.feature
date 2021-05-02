#  language: pt

@AllCenarios
Funcionalidade: Consulta de Usuários

  Cenário: Listar usuários
    Dado que o usuário queira listar todos os usuários
    Quando o serviço users é consultado resultando status 200
    Então é retornado a lista de usuários

  Cenário: Consultar usuário específico
    Dado que o usuário queira listar apenas um usuário específico
    Quando o serviço users é consultado resultando status 200
    Então é retornado o usuário pesquisado

  Cenário: Consultar usuário inexistente
    Dado que o usuário queira listar um usuário inexistente
    Quando o serviço users é consultado resultando status 404
    Então é retornado erro