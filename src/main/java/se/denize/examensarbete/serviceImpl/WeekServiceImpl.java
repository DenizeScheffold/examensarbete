package se.denize.examensarbete.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.CalculatePlans;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.repository.WeekRepository;
import se.denize.examensarbete.service.WeekService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class WeekServiceImpl implements WeekService {


    //TODO: see if this is convention?
    private final CalculatePlans calculatePlans;
    private final WeekRepository weekRepository;

    @Autowired
    public WeekServiceImpl(WeekRepository weekRepository) {
        this.weekRepository = weekRepository;
        calculatePlans = new CalculatePlans();
    }

    @Override
    public ResponseEntity<Day> savePlan(Day day) {
        try {
            weekRepository.save(new Day(day.getDayId(), day.getWeekNumber(), day.getPlanDay(), day.getUserId()));
            return new ResponseEntity<>(day, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Day> getPlanDays() {
        List<Day> userPlanDays = new ArrayList<>(weekRepository.findAll());

        if (userPlanDays.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity(userPlanDays, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Day> deleteByWeekId(long weekId) {
        try {
            weekRepository.deleteById(weekId);
            return new ResponseEntity("Item deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Item not found: " + e, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Day> editWeek(Day day, long weekId) {
        Day dayInDB = weekRepository.findById(weekId).get();

        if (Objects.nonNull(day.getUserId()))
            dayInDB.setUserId(day.getUserId());

        if (Objects.nonNull(day.getPlanDay()))
            dayInDB.setUserPlanDay(day.getPlanDay());

        if (Objects.nonNull(day.getWeekNumber()))
            dayInDB.setWeekNumber(day.getWeekNumber());

        if (Objects.nonNull(day.getDayId()))
            dayInDB.setDayId(day.getDayId());

        return new ResponseEntity(weekRepository.save(dayInDB), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Day> getFullWeek(long weekNumber) {
        List<Day> userWeek = new ArrayList<>(weekRepository.findByWeekNumber(weekNumber));

        if (userWeek.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity(userWeek, HttpStatus.OK);
    }

    //TODO: start calculation when both weeks are submitted. Now user 1 has to submit before user2
    @Override
    public ResponseEntity<List<Day>> getUser1FullWeek(long weekNumber, long userId) {
        List<Day> userWeek = new ArrayList<>(weekRepository.findByWeekNumberAndUser(weekNumber, userId));

        if (userWeek.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        try {
            calculatePlans.setDaysForUser1(userWeek);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userWeek, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Day>> getUser2FullWeek(long weekNumber, long userId) {
        List<Day> userWeek = new ArrayList<>(weekRepository.findByWeekNumberAndUser(weekNumber, userId));
        if (userWeek.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        calculatePlans.setDaysForUser2(userWeek);
        calculatePlans.comparePlans();
        return new ResponseEntity<>(userWeek, HttpStatus.OK);
    }

}