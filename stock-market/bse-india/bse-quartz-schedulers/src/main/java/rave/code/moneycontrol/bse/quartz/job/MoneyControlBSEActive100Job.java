package rave.code.moneycontrol.bse.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSEActive100Parser;
import rave.code.moneycontrol.website.data.model.MoneyControlBSEActive100Model;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEActive100DataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100Entity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class MoneyControlBSEActive100Job implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MoneyControlBSEActive100Job in Action.....");

        NumberFormat format = NumberFormat.getInstance();
        MoneyControlBSEActive100Parser moneyControlBSEActive100Parser = new MoneyControlBSEActive100Parser();
        MoneyControlBSEActive100DataAccess moneyControlBSEActive100DataAccess = new MoneyControlBSEActive100DataAccess(MoneyControlBSEActive100Entity.class);
        List<MoneyControlBSEActive100Model> moneyControlBSEActive100Models = moneyControlBSEActive100Parser.parse();

        for (MoneyControlBSEActive100Model moneyControlBSEActive100Model  : moneyControlBSEActive100Models){
            MoneyControlBSEActive100Entity moneyControlBSEActive100Entity = new MoneyControlBSEActive100Entity();
            moneyControlBSEActive100Entity.setCompanyName(moneyControlBSEActive100Model.getCompanyName());
            moneyControlBSEActive100Entity.setCategory(moneyControlBSEActive100Model.getGroup());
            Number value = null;

            double doubleHIgh = 0.00;
            try {
                value = format.parse(moneyControlBSEActive100Model.getHigh());
                moneyControlBSEActive100Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive100Entity.setHigh(String.valueOf(doubleHIgh));
            }

            double doubleLow = 0.00;
            try {
                value = format.parse(moneyControlBSEActive100Model.getLow());
                moneyControlBSEActive100Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive100Entity.setLow(String.valueOf(doubleLow));
            }

            double doubleLastPrice = 0.00;
            try {
                value = format.parse(moneyControlBSEActive100Model.getLastPrice());
                moneyControlBSEActive100Entity.setLastPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive100Entity.setLastPrice(String.valueOf(doubleLastPrice));
            }

            double doublePercentageChange = 0.00;
            try {
                value = format.parse(moneyControlBSEActive100Model.getPercentageChange());
                moneyControlBSEActive100Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive100Entity.setPercentageChange(String.valueOf(doublePercentageChange));
            }

            double doubleValueInCrores = 0.00;
            try {
                value = format.parse(moneyControlBSEActive100Model.getPercentageChange());
                moneyControlBSEActive100Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive100Entity.setValueInCrores(String.valueOf(doubleValueInCrores));
            }

            Date toDate = new Date();
            moneyControlBSEActive100Entity.setCreatedDate(toDate);
            moneyControlBSEActive100Entity.setModifiedDate(toDate);
            moneyControlBSEActive100Entity.setCreatedBy("SYSTEM");
            moneyControlBSEActive100Entity.setModifiedBy("SYSTEM");

            moneyControlBSEActive100DataAccess.save(moneyControlBSEActive100Entity);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        MoneyControlBSEActive100Job moneyControlBSEActive100Job = new MoneyControlBSEActive100Job();
        moneyControlBSEActive100Job.execute(null);
    }
}