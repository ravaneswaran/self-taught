package rave.code.quartz.job.moneycontrol.misc;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.job.AbstractQuartzJob;
import rave.code.stockmarket.repository.*;
import rave.code.stockmarket.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StockBaseJob extends AbstractQuartzJob{

    private StockBaseRepository stockBaseRepository = new StockBaseRepository();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    }
}
