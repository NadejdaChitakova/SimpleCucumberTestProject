package booking;

import Models.Account;
import Models.RoleEnum;
import Services.BookingService;
import Services.CalendarService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookingSteps {

    private BookingService _bookingService;
    private CalendarService _calendarService;
    private List<LocalDate> _availablePeriods;
    private List<LocalDate> newPeriods;
    private List<LocalDate> selectedPeriods;
    private Account account;

    public  BookingSteps(){
        newPeriods = new ArrayList<LocalDate>();
        _calendarService = new CalendarService();
        selectedPeriods = new ArrayList<LocalDate>();
        _availablePeriods = new ArrayList<LocalDate>();
        account = new Account("firstname","lastname","phonenum","email.com", RoleEnum.DENTIST);
        _bookingService = new BookingService();
    }

    @Given("I want to see available periods")
    public void i_want_to_see_available_periods() {
        newPeriods.add(LocalDate.from(LocalDateTime.now()));
        boolean result = _calendarService.AddAvailablePeriods(account,newPeriods);
        _availablePeriods = _calendarService.GetAvailableData();

    }
    @When("I select available period")
    public void i_select_available_period() {
        selectedPeriods.add(_availablePeriods.get(0));
    }
    @And("Enter my data")
    public void enter_my_data() {
       //we already initialized this values in constructor
    }
    @Then("I receive a confirmation email")
    public void i_receive_a_confirmation_email() {
       account.setRole(RoleEnum.USER);
       boolean addBooking = _bookingService.AddBooking(account.getRole(),selectedPeriods.get(0),account);
       boolean getEmail = _bookingService.SendConfirmationEmail(addBooking,account.getRole());
       assertTrue(addBooking);
       assertTrue(getEmail);
    }
    @Then("I dont receive a confirmation email")
    public void i_dont_receive_a_confirmation_email() {
        account.setRole(RoleEnum.DENTIST);
        boolean addBooking = _bookingService.AddBooking(account.getRole(),selectedPeriods.get(0),account);
        boolean getEmail = _bookingService.SendConfirmationEmail(addBooking,account.getRole());
        assertTrue(addBooking);
        assertFalse(getEmail);
    }

}