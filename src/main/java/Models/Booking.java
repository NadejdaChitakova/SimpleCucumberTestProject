package Models;

import java.time.LocalDate;

public class Booking {
    private String firstname;
    private String lastname;
    private String phoneNum;
    private String email;
    private Calendar period;
    private boolean hasAccount;
    private  Role whoMakeBooking;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setPeriod(Calendar period) {
        this.period = period;
    }

    public Calendar getPeriod() {
        return period;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setHasAccount(boolean hasAccount) {
        this.hasAccount = hasAccount;
    }

    public Role getWhoMakeBooking() {
        return whoMakeBooking;
    }

    public void setWhoMakeBooking(Role whoMakeBooking) {
        this.whoMakeBooking = whoMakeBooking;
    }
}
