package serveRest.service;


import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomUtils;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import serveRest.model.Usuario;
import serveRest.support.enums.ApiBaseUri;
import serveRest.support.enums.ApiPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static serveRest.support.utils.RestContext.*;

public class UsuarioService {

    public static Usuario gerarDadosUsuario(){
        Usuario usuario = Usuario.builder()
                .nome("serverest"+ RandomUtils.nextInt())
                .email("serverest-mail"+RandomUtils.nextInt()+"@hotmail.com")
                .password("10203"+RandomUtils.nextInt())
                .administrador("true")
                .build();
        return usuario;
    }

    public static Response cadastrarUsuario(){
        initRequest();
        setPath(ApiBaseUri.URI_SERVE_REST.getPath(), ApiPath.PATH_USUARIOS.getPath());
        setHeaderDefault();

        setBody(gerarDadosUsuario().toString());
        requestPost();
        return getResponse();
    }

    public static void validarUsuarioCadastrado(ValidatableResponse response) throws IOException, JSONException {
        String retornaUsuarioCadastrado = new String((Files.readAllBytes(Paths.get("src/test/resources/payloads/usuarioCadastrado.json"))));

        JSONAssert.assertEquals(retornaUsuarioCadastrado,response.extract().asString(),false);

    }
}
