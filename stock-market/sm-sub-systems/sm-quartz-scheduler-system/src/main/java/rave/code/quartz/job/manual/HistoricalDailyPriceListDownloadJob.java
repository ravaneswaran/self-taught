package rave.code.quartz.job.manual;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.job.AbstractQuartzJob;
import rave.code.quartz.job.moneycontrol.misc.StockBaseJob;
import rave.code.stockmarket.entity.HolidayEntity;
import rave.code.stockmarket.repository.HolidayRepository;
import rave.code.stockmarket.repository.StockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoricalDailyPriceListDownloadJob extends AbstractQuartzJob {

    private static final Logger LOGGER = Logger.getLogger(HistoricalDailyPriceListDownloadJob.class.getName());

    private int noOfDaysInPast = 1;
    private HolidayRepository holidayRepository = new HolidayRepository();
    private StockBaseRepository stockBaseRepository = new StockBaseRepository();


    public HistoricalDailyPriceListDownloadJob(){
        this(1);
    }

    public HistoricalDailyPriceListDownloadJob(int noOfDaysInPast){
        this.noOfDaysInPast = noOfDaysInPast;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.log(Level.FINE, "Deleting the stock base repository...");
        this.stockBaseRepository.deleteAll();
        List<Date> dates = this.getHistoricalDates(this.noOfDaysInPast);
        for (Date date: dates){
            StockBaseJob stockBaseJob = new StockBaseJob(date);
            stockBaseJob.execute(jobExecutionContext);
        }
    }

    public List<Date> getHistoricalDates(int noOfDaysInPast){
        List<Date> dates = new ArrayList<>();

        LocalDate today = LocalDate.now();
        List<HolidayEntity> holidayEntities =  this.holidayRepository.findAll();

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

        return dates;
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        HistoricalDailyPriceListDownloadJob historicalDailyPriceListDownloadJob = new HistoricalDailyPriceListDownloadJob(8);
        historicalDailyPriceListDownloadJob.execute(null);
    }
}
