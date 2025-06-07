package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSESmallCapGainerEntity;
import rave.code.stockmarket.bse.entity.MoneyControlBSETopDividendEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class MoneyControlBSETopDividendDataAccess extends StockMarketHistoryEnabledDataAccess<MoneyControlBSETopDividendEntity> {

    public MoneyControlBSETopDividendDataAccess(){
        this(MoneyControlBSETopDividendEntity.class);
    }

    public MoneyControlBSETopDividendDataAccess(Class<MoneyControlBSETopDividendEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<MoneyControlBSETopDividendEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        for (MoneyControlBSETopDividendEntity moneyControlBSETopDividendEntity : entities) {
            Object retVal = this.findBy(moneyControlBSETopDividendEntity.getCompanyName());
            if (null != retVal) {
                entityManager.merge(moneyControlBSETopDividendEntity);
            } else {
                entityManager.persist(moneyControlBSETopDividendEntity);
            }
        }
        entityManager.getTransaction().commit();
    }

}
