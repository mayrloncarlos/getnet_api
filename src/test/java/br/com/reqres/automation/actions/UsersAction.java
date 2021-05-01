package br.com.reqres.automation.actions;

import br.com.reqres.automation.core.BaseAction;

public class UsersAction extends BaseAction {

    protected String idUser;

    protected Boolean listarUsers = false;
    protected Boolean consultarUsers = false;
    protected Boolean consultarUserInexistente = false;
    protected Integer statusCodeOk = 200;
    protected Integer statusCodeNotFound = 404;
}
