package serveRest.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber-reports/Report.json"},
        monochrome = true,
        glue = {"serveRest.step_definitions"},
        tags = "",
        features = "src/test/resources/features"
)

public class RunnerTest {
    public static void main(String[] args)    {
        {io.cucumber.core.cli.Main.main(args);}
    }
}
