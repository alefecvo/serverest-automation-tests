package serveRest.service;

import io.restassured.response.Response;
import org.apache.commons.lang.math.RandomUtils;
import serveRest.model.Usuario;
import serveRest.support.enums.ApiBaseUri;
import serveRest.support.enums.ApiPath;

import java.util.Random;

import static serveRest.support.utils.RestContext.*;

public class UsuarioService {
    public static Response cadastrarUsuario(){
        initRequest();
        setPath(ApiBaseUri.URI_SERVE_REST.getPath(), ApiPath.PATH_USUARIOS.getPath());
        setHeaderDefault();

        setBody(dadosUsuario().toString());
        requestPost();
        return getResponse();
    }

    public static Usuario dadosUsuario(){
        Usuario usuario = Usuario.builder()
                .nome("serverest"+RandomUtils.nextInt())
                .email("serverest-mail"+RandomUtils.nextInt()+"@hotmail.com")
                .password("10203"+RandomUtils.nextInt())
                .administrador("true")
                .build();
        return usuario;
    }
}
