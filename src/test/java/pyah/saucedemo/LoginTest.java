package pyah.saucedemo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoginTest extends BaseTest{

    private static final String STANDARD_USER = "standard_user";
    private static final String LOCKED_OUT_USER = "locked_out_user";
    private static final String PROBLEM_USER = "problem_user";
    private static final String PERFORMANCE_USER = "performance_glitch_user";
    private static final String ERROR_USER = "error_user";
    private static final String VISUAL_USER = "visual_user";
    private static final String  PASSWORD = "secret_sauce";


    @ParameterizedTest(name = "Run: {index}, values : {arguments}")
    @MethodSource(value = "testCases")
    void loginOfUsers(String param1, String param2) {

        LoginPage loginPage = new LoginPage(driver);
        SwabLabsPage swabLabsPage = new SwabLabsPage(driver);

        loginPage.login(param1, param2);

        if(param1.equals(LOCKED_OUT_USER)){
            assertFalse(swabLabsPage.isLoggedIn());
//            assertTrue(swabLabsPage.isLoggedIn()); in this case test is failed
        } else {
            swabLabsPage.waiter(swabLabsPage.logo, 5);
            assertTrue(swabLabsPage.isLoggedIn());
        }
    }
    public static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(STANDARD_USER, PASSWORD),
                arguments(LOCKED_OUT_USER, PASSWORD),
                arguments(PROBLEM_USER, PASSWORD),
                arguments(PERFORMANCE_USER, PASSWORD),
                arguments(ERROR_USER, PASSWORD),
                arguments(VISUAL_USER, PASSWORD)
        );
    }
}
