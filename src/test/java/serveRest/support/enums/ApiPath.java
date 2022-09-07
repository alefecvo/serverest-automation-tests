package serveRest.support.enums;

public enum ApiPath {
    PATH_USUARIOS("/usuarios");

    private String path;

    ApiPath(String path){this.path=path;}

    public String getPath(){return path;}
}
