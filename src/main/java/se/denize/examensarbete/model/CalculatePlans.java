package se.denize.examensarbete.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

//For local use only - not to store in db.
public class CalculatePlans {


    private List<Day> daysForUser1;
    private List<Day> daysForUser2;

    public CalculatePlans(List<Day> daysForUser1, List<Day> daysForUser2) {
        this.daysForUser1 = daysForUser1;
        this.daysForUser2 = daysForUser2;
    }

    public CalculatePlans() {
    }

    @ElementCollection
    public List<Day> getDaysForUser1() {
        return daysForUser1;
    }

    public void setDaysForUser1(List<Day> daysForUser1) {
        this.daysForUser1 = daysForUser1;
    }

    @ElementCollection
    public List<Day> getDaysForUser2() {
        return daysForUser2;
    }

    public void setDaysForUser2(List<Day> daysForUser2) {
        this.daysForUser2 = daysForUser2;
    }
}
