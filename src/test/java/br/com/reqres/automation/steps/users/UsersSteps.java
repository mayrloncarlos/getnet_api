package br.com.reqres.automation.steps.users;

import br.com.reqres.automation.actions.UsersAction;
import br.com.reqres.automation.common.Paths;
import br.com.reqres.automation.validacoes.UsersAsserts;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class UsersSteps extends UsersAction {

    private UsersAsserts usersAsserts = new UsersAsserts();

    // --------------------------------------------------------- DADO --------------------------------------------------------//
    @Dado("que o usuário queira listar todos os usuários")
    public void queOUsuarioQueiraListarTodosOsUsuarios(){
        listarUsers = true;
    }

    @Dado("que o usuário queira listar apenas um usuário específico")
    public void queOUsuarioQUeiraListarApenasUmUsuarioEspecifico(){
        consultarUsers = true;
        idUser = "1";
    }

    @Dado("que o usuário queira listar um usuário inexistente")
    public void queOUsuarioQueiraListarUmUsuarioInexistente(){
        consultarUsers = true;
        idUser = "23";
    }
    // --------------------------------------------------------- QUANDO --------------------------------------------------------//
    @Quando("o serviço (.*) é consultado resultando status (.+)")
    public void oServicoEhConsultado(String path, int codigo){
        setPathEmExecucao(path);
        switch (path){
            case Paths.PATH_USERS:
                if(listarUsers){
                    requestGet(path, codigo);
                } else if(consultarUsers){
                    requestGetWithId(idUser, path, codigo);
                }
                break;
        }
    }
    // --------------------------------------------------------- ENTAO --------------------------------------------------------//
    @Então("é retornado a lista de usuários")
    public void ehRetornadoAListaDeUsuarios(){
        usersAsserts.validarUsers();
    }

    @Então("é retornado o usuário pesquisado")
    public void ehRetornadoOUsuarioPesquisado(){
        usersAsserts.validarUsuarioUnico();
    }

    @Então("é retornado erro")
    public void ehRetornadoErro(){
        usersAsserts.validarErro();
    }
}
