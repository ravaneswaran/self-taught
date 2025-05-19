package rave.code.moneycontrol.bse.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSEActive200Parser;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericBSEActiveModel;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEActive200DataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200Entity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class MoneyControlBSEActive200Job implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MoneyControlBSEActive200Job in Action.....");

        NumberFormat format = NumberFormat.getInstance();
        MoneyControlBSEActive200Parser moneyControlBSEActive200Parser = new MoneyControlBSEActive200Parser();
        MoneyControlBSEActive200DataAccess moneyControlBSEActive200DataAccess = new MoneyControlBSEActive200DataAccess(MoneyControlBSEActive200Entity.class);
        List<MoneyControlGenericBSEActiveModel> moneyControlBSEActive200Models = moneyControlBSEActive200Parser.parse();

        for (MoneyControlGenericBSEActiveModel moneyControlBSEActive200Model : moneyControlBSEActive200Models) {
            MoneyControlBSEActive200Entity moneyControlBSEActive200Entity = new MoneyControlBSEActive200Entity();
            moneyControlBSEActive200Entity.setCompanyName(moneyControlBSEActive200Model.getCompanyName());
            moneyControlBSEActive200Entity.setCategory(moneyControlBSEActive200Model.getGroup());
            Number value = null;

            double doubleHIgh = 0.00;
            try {
                value = format.parse(moneyControlBSEActive200Model.getHigh());
                moneyControlBSEActive200Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive200Entity.setHigh(String.valueOf(doubleHIgh));
            }

            double doubleLow = 0.00;
            try {
                value = format.parse(moneyControlBSEActive200Model.getLow());
                moneyControlBSEActive200Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive200Entity.setLow(String.valueOf(doubleLow));
            }

            double doubleLastPrice = 0.00;
            try {
                value = format.parse(moneyControlBSEActive200Model.getLastPrice());
                moneyControlBSEActive200Entity.setLastPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive200Entity.setLastPrice(String.valueOf(doubleLastPrice));
            }

            double doublePercentageChange = 0.00;
            try {
                value = format.parse(moneyControlBSEActive200Model.getPercentageChange());
                moneyControlBSEActive200Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive200Entity.setPercentageChange(String.valueOf(doublePercentageChange));
            }

            double doubleValueInCrores = 0.00;
            try {
                value = format.parse(moneyControlBSEActive200Model.getPercentageChange());
                moneyControlBSEActive200Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                moneyControlBSEActive200Entity.setValueInCrores(String.valueOf(doubleValueInCrores));
            }

            Date toDate = new Date();
            moneyControlBSEActive200Entity.setCreatedDate(toDate);
            moneyControlBSEActive200Entity.setModifiedDate(toDate);
            moneyControlBSEActive200Entity.setCreatedBy("SYSTEM");
            moneyControlBSEActive200Entity.setModifiedBy("SYSTEM");

            moneyControlBSEActive200DataAccess.save(moneyControlBSEActive200Entity);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        MoneyControlBSEActive200Job moneyControlBSEActive200Job = new MoneyControlBSEActive200Job();
        moneyControlBSEActive200Job.execute(null);
    }
}