package com.project.spy;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources"
        ,glue={"com/project/step"}
)
public class CucumberTest {

//
//
//
//    public static void main(String[] args) {
//
//    }
//
//
//    @BeforeClass
//    public void init(){
//        WebDriver driver = new ChromeDriver();
//
//    }
//
//
//    @Test
//    public void main() throws Exception {
//    }

}