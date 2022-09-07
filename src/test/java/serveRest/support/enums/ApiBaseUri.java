package serveRest.support.enums;

import static serveRest.support.utils.GetProperties.getProp;

public enum ApiBaseUri {
    URI_SERVE_REST(getProp("baseurl"));

    private String path;

    ApiBaseUri(String path){this.path=path;}

    public String getPath(){return path;}
}
