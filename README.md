# Automação de Testes do ReqRes

Projeto contendo a automação dos testes da API do ReqRes

## Pré-requisitos

- Java 8 ou superior
- Intellij(recomendado) ou Eclipse
- Plugin do TestNG
- Plugin do Cucumber

## Principal arquivo do projeto para rodar a automação
- Path.runners - classe para executar os testes do módulo.

## Executando os testes

- Executar todos os testes de um path: src\test\java\br.com.reqres.automation\runners\UsersRunner.java.
    -  Clicar com o botão direito em cima da classe runner desejada, e clicar em Run.

- Executar um teste específico de um path.
    - Ir no arquivo feature do path, por exemplo, users.feature, e adicionar uma tag no teste desejado.
    - Após incluir a tag na feature, colocar a tag desejada na classe runner, clicar com o botão direito na classe e clicar em Run.

