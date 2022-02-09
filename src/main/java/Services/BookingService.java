package Services;

import Models.*;

import java.time.LocalDate;
import java.util.List;

public class BookingService {
    private CalendarService _service;
    private Booking booking;

    public BookingService(){
        _service = new CalendarService();
        booking = new Booking();
    }

    public boolean AddBooking(RoleEnum role, LocalDate period, Account account){
            if (role.equals(RoleEnum.DENTIST) || role.equals(RoleEnum.EMPLOYEE)){
                booking.setFirstname(account.getFirstName());
                booking.setHasAccount(true);
            }else {
                booking.setFirstname(account.getFirstName());
                booking.setLastname(account.getLastName());
                booking.setEmail(account.getEmail());
                booking.setHasAccount(false);
            }
            return true;
    }
    public boolean SendConfirmationEmail(boolean isRegistrationSuccessfull, RoleEnum role){
        return isRegistrationSuccessfull && role.equals(RoleEnum.USER) ? true : false;
    }
}
