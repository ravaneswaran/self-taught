package rave.code.quartz.job.manual;

import rave.code.stockmarket.entity.HolidayEntity;
import rave.code.stockmarket.repository.HolidayRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

public class BusinessDateNavigator {

    public static HolidayRepository holidayRepository = new HolidayRepository();

    public static void main(String[] args) {

        int noOfDaysInPast = 50;
        List<Date> dates = new ArrayList<>();

        LocalDate today = LocalDate.now();
        List<HolidayEntity> holidayEntities =  holidayRepository.findAll();

        for (int index = 1; index <= noOfDaysInPast; index++) {
            LocalDate businessDaysBackInTime = today.minusDays(index);
            String dayOfWeek = businessDaysBackInTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            if(dayOfWeek.equalsIgnoreCase("saturday") || dayOfWeek.equalsIgnoreCase("sunday")){
                index++;
                noOfDaysInPast += 2;
                continue;
            }
            Date businessDateInPast = Date.from(businessDaysBackInTime.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // now we need to check the 'businessDateInPast' is a holiday or not...
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
            for(HolidayEntity holyDayEntity : holidayEntities){
                LocalDate holyDate = LocalDate.parse(holyDayEntity.getHolidate(), formatter);
                Date dateObject = Date.from(holyDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                if(dateObject.equals(businessDateInPast)){
                    index++;
                    noOfDaysInPast += 1;
                    break;
                }
            }
            dates.add(businessDateInPast);
        }

        Collections.reverse(dates);
    }
}
