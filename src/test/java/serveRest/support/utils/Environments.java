package serveRest.support.utils;

public class Environments {
    public static String getEnvironments(){
        String environments = System.getProperty(("environment"));

        if (environments==null){
            environments = "local";
        }
        System.out.println(environments);
        return  environments;
    }
}
