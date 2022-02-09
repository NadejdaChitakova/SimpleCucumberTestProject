package Models;

import java.time.LocalDate;
import java.util.List;

public class Calendar {
    private List<LocalDate> availableDate;


    public List<LocalDate> getAvailableDate() {
        return this.availableDate;
    }

    public void setAvailableDate(List<LocalDate> availableDate) {
        this.availableDate = availableDate;
    }
}
