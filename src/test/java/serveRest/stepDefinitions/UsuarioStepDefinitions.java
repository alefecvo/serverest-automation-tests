package serveRest.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.response.ValidatableResponse;
import org.json.JSONException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Path.*;
import static org.junit.Assert.assertEquals;
import static serveRest.service.UsuarioService.*;

import static serveRest.support.utils.RestContext.getResponse;


public class UsuarioStepDefinitions {
    ValidatableResponse response;

    @Dado("que desejo criar uma nova conta válida")
    public void que_desejo_criar_uma_nova_conta_válida() {

        System.out.println("Criando massa de dados... " + gerarDadosUsuario().toString());
    }

    @Quando("fazer requisição")
    public void fazer_requisição() {

        System.out.println("Fazendo requisição... -> ambiente: ");

        cadastrarUsuario();
    }

    @Então("valido conta criada com sucesso")
    public void valido_conta_criada_com_sucesso() throws JSONException, IOException {
        System.out.println("Obtendo resposta... ");
        response = getResponse().then();

        System.out.println("Validando mensagem -> Cadastro realizado com sucesso");
        assertEquals("Cadastro realizado com sucesso",
                response.extract().jsonPath().getString("message"));
        validarUsuarioCadastrado(response);

        System.out.println("Validando status code -> 201 ");
        response = getResponse().then().statusCode(201);

    }
}
