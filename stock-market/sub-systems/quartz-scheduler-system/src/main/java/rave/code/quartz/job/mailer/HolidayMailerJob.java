package rave.code.quartz.job.mailer;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.stockmarket.bse.dataaccess.HolidayDataAccess;
import rave.code.stockmarket.bse.entity.HolidayEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HolidayMailerJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date toDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, YYYY");
        String formattedToDate = simpleDateFormat.format(toDate);

        HolidayDataAccess stockMarketHolidayDataAccess = new HolidayDataAccess();
        List<HolidayEntity> entities = stockMarketHolidayDataAccess.findAll();

        for (HolidayEntity entity : entities) {
            if (formattedToDate.trim().equals(entity.getHolidate().trim())) {
                System.out.println("SENDING MAIL....");
            }
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        HolidayMailerJob holidayMailerJob = new HolidayMailerJob();
        holidayMailerJob.execute(null);
    }

}
