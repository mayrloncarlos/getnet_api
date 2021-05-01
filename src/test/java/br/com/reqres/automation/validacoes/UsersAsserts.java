package br.com.reqres.automation.validacoes;

import br.com.reqres.automation.actions.UsersAction;
import br.com.reqres.automation.utils.Log;
import org.testng.Assert;

public class UsersAsserts extends UsersAction {

    public void validarUsers(){
        Assert.assertEquals(getJsonDataValue(0, "id"), "1");
        Assert.assertEquals(getJsonDataValue(0, "email"), "george.bluth@reqres.in");
        Assert.assertEquals(getJsonDataValue(0, "first_name"), "George");
        Assert.assertEquals(getJsonDataValue(0, "last_name"), "Bluth");
        Assert.assertEquals(getJsonDataValue(0, "avatar"), "https://reqres.in/img/faces/1-image.jpg");

        Assert.assertEquals(getJsonDataValue(1, "id"), "2");
        Assert.assertEquals(getJsonDataValue(1, "email"), "janet.weaver@reqres.in");
        Assert.assertEquals(getJsonDataValue(1, "first_name"), "Janet");
        Assert.assertEquals(getJsonDataValue(1, "last_name"), "Weaver");
        Assert.assertEquals(getJsonDataValue(1, "avatar"), "https://reqres.in/img/faces/2-image.jpg");

        Assert.assertEquals(getJsonDataValue(2, "id"), "3");
        Assert.assertEquals(getJsonDataValue(2, "email"), "emma.wong@reqres.in");
        Assert.assertEquals(getJsonDataValue(2, "first_name"), "Emma");
        Assert.assertEquals(getJsonDataValue(2, "last_name"), "Wong");
        Assert.assertEquals(getJsonDataValue(2, "avatar"), "https://reqres.in/img/faces/3-image.jpg");

        Assert.assertEquals(getJsonDataValue(3, "id"), "4");
        Assert.assertEquals(getJsonDataValue(3, "email"), "eve.holt@reqres.in");
        Assert.assertEquals(getJsonDataValue(3, "first_name"), "Eve");
        Assert.assertEquals(getJsonDataValue(3, "last_name"), "Holt");
        Assert.assertEquals(getJsonDataValue(3, "avatar"), "https://reqres.in/img/faces/4-image.jpg");

        Assert.assertEquals(getJsonDataValue(4, "id"), "5");
        Assert.assertEquals(getJsonDataValue(4, "email"), "charles.morris@reqres.in");
        Assert.assertEquals(getJsonDataValue(4, "first_name"), "Charles");
        Assert.assertEquals(getJsonDataValue(4, "last_name"), "Morris");
        Assert.assertEquals(getJsonDataValue(4, "avatar"), "https://reqres.in/img/faces/5-image.jpg");

        Assert.assertEquals(getJsonDataValue(5, "id"), "6");
        Assert.assertEquals(getJsonDataValue(5, "email"), "tracey.ramos@reqres.in");
        Assert.assertEquals(getJsonDataValue(5, "first_name"), "Tracey");
        Assert.assertEquals(getJsonDataValue(5, "last_name"), "Ramos");
        Assert.assertEquals(getJsonDataValue(5, "avatar"), "https://reqres.in/img/faces/6-image.jpg");
    }

    public void validarUsuarioUnico(){
        Assert.assertEquals(getJsonValue("data.id"), "1");
        Assert.assertEquals(getJsonValue("data.email"), "george.bluth@reqres.in");
        Assert.assertEquals(getJsonValue("data.first_name"), "George");
        Assert.assertEquals(getJsonValue("data.last_name"), "Bluth");
        Assert.assertEquals(getJsonValue("data.avatar"), "https://reqres.in/img/faces/1-image.jpg");
    }

    public void validarErro(){
        if(getStatusCode() == statusCodeNotFound){
            Log.info("Nenhum Registro Encontrado!");
        }
    }
}
