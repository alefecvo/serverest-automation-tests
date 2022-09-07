package serveRest.step_definitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.response.ValidatableResponse;

import static org.junit.Assert.assertEquals;
import static serveRest.service.UsuarioService.*;

import static serveRest.support.utils.RestContext.getResponse;


public class UsuarioStepDefinitions {
    ValidatableResponse response;

    @Dado("que desejo criar uma nova conta válida")
    public void queDesejoCriarUmaNovaContaVálida() {
        System.out.println("Criando massa de dados... " + dadosUsuario().toString());
    }

    @Quando("fazer requisição")
    public void fazerRequisição() {
        System.out.println("Fazendo requisição... -> ambiente: ");

        cadastrarUsuario();
    }

    @Então("valido conta criada com sucesso")
    public void validoContaCriadaComSucesso() {
        System.out.println("Obtendo resposta... ");
        response = getResponse().then();

        System.out.println("Validando mensagem -> Cadastro realizado com sucesso");
        assertEquals("Cadastro realizado com sucesso",
                response.extract().jsonPath().getString("message"));

        System.out.println("Validando status code -> 201 ");
        response = getResponse().then().statusCode(201);
    }
}
