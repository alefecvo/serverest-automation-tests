package serveRest.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.math.RandomUtils;

@Builder
@Getter
@Setter
public class Usuario {

    @Builder.Default
    private String nome = "automacao"+RandomUtils.nextInt();

    @Builder.Default
    private String email = "automacao-serverest-api"+RandomUtils.nextInt()+"@hotmail.com";

    @Builder.Default
    private String password = "102030"+RandomUtils.nextInt();

    @Builder.Default
    private String administrador = "true";

    @Override
    public String toString(){
        return "{\n" +
                "  \"nome\": \""+nome+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"administrador\": \""+administrador+"\"\n" +
                "}";
    }
}
