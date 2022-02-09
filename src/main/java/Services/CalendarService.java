package Services;

import Models.Account;
import Models.Calendar;
import Models.RoleEnum;
import java.time.LocalDate;
import java.util.List;


public class CalendarService {
    private Calendar _availablePeriods;
    public CalendarService(){
        _availablePeriods = new Calendar();
    }

    public List<LocalDate> GetAvailableData(){
        return _availablePeriods.getAvailableDate();
    }
    public boolean AddAvailablePeriods(Account account, List<LocalDate> period) {
        if (account.getRole().equals(RoleEnum.DENTIST)) {
            _availablePeriods.setAvailableDate(period);
            return  true;
        }
        else {
            return false;
        }
    }
}
