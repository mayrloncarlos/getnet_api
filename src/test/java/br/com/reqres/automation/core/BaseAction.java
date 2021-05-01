package br.com.reqres.automation.core;

import br.com.reqres.automation.propriedades.Propriedades;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Map;

public class BaseAction {

    protected static ThreadLocal<Response> response = new ThreadLocal<>();

    /**
     * Metodo que realiza uma requisicao do tipo GET.
     *
     * @param path        caminho para a requisicao
     */
    public void requestGet(String path, int statusCode) {
        response.set(RestAssured.given()
                .when()
                .contentType("application/json")
                .get("https://reqres.in/api/"+path)
                .then()
                .extract()
                .response());

        afterRequest(statusCode);
    }

    /**
     * Metodo que realiza uma requisicao do tipo GET.
     *
     * @param id          parametro id da requisicao
     * @param path        caminho para a requisicao
     */
    public void requestGetWithId(String id, String path, int statusCode) {
        response.set(RestAssured.given()
                .queryParam("id", id)
                .when()
                .contentType("application/json")
                .get("https://reqres.in/api/"+path)
                .then()
                .extract()
                .response());

        afterRequest(statusCode);
    }

    /**
     * Metodo que captura o valor de uma coluna de um array do elemento content da requisicao.
     *
     * @param index indice do array da requisicao
     * @param value coluna a ser retornado o valor
     * @return retorna o valor da coluna
     */
    protected String getJsonDataValue(int index, String value) {
        ArrayList<Map<String, ?>> jsonContent = response.get().path("data");

        if (jsonContent.get(index).get(value) == null) {
            return "";
        } else {
            return jsonContent.get(index).get(value).toString();
        }
    }

    /**
     * Metodo que captura o valor de uma coluna da requisicao.
     *
     * @param value coluna a ser retornado o valor
     * @return retorna o valor da coluna
     */
    protected String getJsonValue(String value) {
        if (response.get().jsonPath().getString(value) == null) {
            return "";
        } else {
            return response.get().jsonPath().getString(value);
        }
    }

//----------------------------------------------------------------------------------------------------------------------//

    /**
     * Metodo para setar qual o path que esta sendo requisitado.
     *
     * @param path path sendo requisitado
     */
    protected void setPathEmExecucao(String path) {
        Propriedades.PATH.set(path);
    }

    /**
     * Metodo que valida o status code da requisicao.
     *
     * @param statusCode status code da requisicao
     */
    private void validarStatusCode(int statusCode) {
        if (response.get().statusCode() != statusCode) {
            Assert.fail("Esperado [" + statusCode + "], mas retornou [" + response.get().statusCode() + "]");
        }
    }

    /**
     * Metodo para logar a requisicao, a response e validar o status code da resposta.
     *
     * @param statusCode status code esperado
     */
    private void afterRequest(int statusCode) {
        validarStatusCode(statusCode);
    }

    /**
     * Metodo que captura o codigo de retorno da requisicao.
     *
     * @return retorna o codigo
     */
    protected int getStatusCode() {
        return response.get().statusCode();
    }
}

