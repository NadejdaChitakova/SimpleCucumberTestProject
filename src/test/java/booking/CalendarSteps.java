package booking;

import Models.Account;
import Models.RoleEnum;
import Services.CalendarService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalendarSteps {

    private CalendarService _calendarService ;
    private List<LocalDate> localDates;
    private List<LocalDate> newPeriods;
    Account account;
    public CalendarSteps(){
        _calendarService = new CalendarService();
        localDates = new ArrayList<LocalDate>();
        newPeriods = new ArrayList<LocalDate>();
        account = new Account("firstname","lastname","somePhoneNum","email@email.com",RoleEnum.DENTIST);
    }

    @Given("I want to get available periods")
    public void i_want_to_get_available_periods() {
        localDates =  _calendarService.GetAvailableData();
    }
    @When("I add new periods")
    public void i_add_new_periods() {
        newPeriods.add(LocalDate.from(LocalDateTime.now()));
    }
    @Then("I see successfuly added periods")
    public void i_see_successfuly_added_periods() {
       boolean result = _calendarService.AddAvailablePeriods(account,newPeriods);
        assertTrue(result);
    }
    @When("I try to insert new dates")
    public void i_try_to_insert_new_dates() {
       account.setRole(RoleEnum.EMPLOYEE);
    }
    @Then("I get exception")
    public void i_get_exception() {
        boolean result = _calendarService.AddAvailablePeriods(account,newPeriods);
        assertFalse(result);
    }

}
