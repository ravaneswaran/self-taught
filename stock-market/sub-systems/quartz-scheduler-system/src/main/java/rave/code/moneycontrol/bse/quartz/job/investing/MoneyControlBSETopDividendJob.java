package rave.code.moneycontrol.bse.quartz.job.investing;

import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSETopDividendParser;
import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlTradingJob;
import rave.code.moneycontrol.website.data.model.MoneyControlDividendModel;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSETopDividendDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSETopDividendEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MoneyControlBSETopDividendJob extends AbstractMoneyControlTradingJob<MoneyControlDividendModel, MoneyControlBSETopDividendEntity> {

    @Override
    public List<MoneyControlDividendModel> getDataFromSource() {
        return new MoneyControlBSETopDividendParser().parse();
    }

    @Override
    public List<MoneyControlBSETopDividendEntity> transformSourceData(List<MoneyControlDividendModel> sourceData) {
        List<MoneyControlBSETopDividendEntity> entities = new ArrayList<>();
        for (MoneyControlDividendModel moneyControlDividendModel : sourceData) {
            MoneyControlBSETopDividendEntity moneyControlBSETopDividendEntity = new MoneyControlBSETopDividendEntity();

            moneyControlBSETopDividendEntity.setId(UUID.randomUUID().toString());
            moneyControlBSETopDividendEntity.setCompanyName(moneyControlDividendModel.getCompanyName());
            moneyControlBSETopDividendEntity.setLastPrice(moneyControlDividendModel.getLastPrice());
            moneyControlBSETopDividendEntity.setLatestDividendPercentage(moneyControlDividendModel.getLatestDividendPercentage());
            moneyControlBSETopDividendEntity.setDividendYieldPercentage52High(moneyControlDividendModel.getDividendYieldPercentAt52High());
            moneyControlBSETopDividendEntity.setDividendYieldPercentage52Low(moneyControlDividendModel.getDividendYieldPercentAt52Low());
            moneyControlBSETopDividendEntity.setDividendYieldPercentageAtCurrent(moneyControlDividendModel.getDividendYieldPercentAtCurrent());

            Date toDate = new Date();
            moneyControlBSETopDividendEntity.setCreatedDate(toDate);
            moneyControlBSETopDividendEntity.setModifiedDate(toDate);
            moneyControlBSETopDividendEntity.setCreatedBy("SYSTEM");
            moneyControlBSETopDividendEntity.setModifiedBy("SYSTEM");

            entities.add(moneyControlBSETopDividendEntity);
        }
        return entities;
    }

    @Override
    public void saveTransformedData(List<MoneyControlBSETopDividendEntity> transformedData) {
        MoneyControlBSETopDividendDataAccess moneyControlBSETopDividendDataAccess = new MoneyControlBSETopDividendDataAccess();
        for (MoneyControlBSETopDividendEntity moneyControlBSETopDividendEntity : transformedData) {
            moneyControlBSETopDividendDataAccess.save(moneyControlBSETopDividendEntity);
        }
    }
}
