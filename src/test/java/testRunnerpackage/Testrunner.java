package testRunnerpackage;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions

(features="C:\\Users\\mkuma\\eclipse-workspace\\Module1.0\\src\\test\\java\\feature\\contact.feature",
glue= {"Stepdef"},
plugin= {"pretty","json:C:\\Users\\mkuma\\eclipse-workspace\\Module1.0\\target\\contactpage.json","html:C:\\Users\\mkuma\\eclipse-workspace\\Module1.0\\target\\contactpage-html-report.html"}, 
monochrome=true ,
publish = true)
public class Testrunner {

}
