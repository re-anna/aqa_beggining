import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {


    @Test
    public void userCreateAccount(){
        //Подготовка
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Логика теста
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Anna");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Mikhailova");

        SelenideElement address = element(Selectors.byId("customer.address.street"));
        address.sendKeys("Green street");

        SelenideElement city = element(Selectors.byId("customer.address.street"));
        city.sendKeys("Saint-P");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("No");

        SelenideElement zipCode = element((Selectors.byId("customer.address.zipCode")));
        zipCode.sendKeys("1234567");

        SelenideElement phoneNumber = element((Selectors.byId("customer.phoneNumber")));
        phoneNumber.sendKeys("7654321");

        SelenideElement ssn = element((Selectors.byId("customer.ssn")));
       ssn.sendKeys("7645678");

        SelenideElement username = element((Selectors.byId("customer.username")));
        username.sendKeys("Anna");

        SelenideElement password = element((Selectors.byId("customer.password")));
        password.sendKeys("dsfhdkjfh");

        SelenideElement passwordConfirm = element((Selectors.byId("repeatedPassword")));
        passwordConfirm.sendKeys("dsfhdkjfh");




    }

    @Test
    public void userCantCreateAccountOnlyWithName(){
        //Подготовка
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Логика теста
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Anna");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Mikhailova");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Проверка ожидаемого результата
        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement cityError = element(Selectors.byId("customer.city.errors"));
        addressError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.state.errors"));
        addressError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipError = element(Selectors.byId("customer.zipCode.errors"));
        addressError.shouldHave(Condition.exactText("State is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        addressError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        addressError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passWordError = element(Selectors.byId("customer.password.errors"));
        addressError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement passwordConfirmationError = element(Selectors.byId("repeatedPassword.errors"));
        addressError.shouldHave(Condition.exactText("Password confirmation is required."));
    }
}
