package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEMidCapGainerEntity;
import rave.code.stockmarket.bse.entity.MoneyControlBSESmallCapGainerEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class MoneyControlBSEMidCapGainerDataAccess extends StockMarketHistoryEnabledDataAccess<MoneyControlBSEMidCapGainerEntity> {

    public MoneyControlBSEMidCapGainerDataAccess(){
        this(MoneyControlBSEMidCapGainerEntity.class);
    }

    public MoneyControlBSEMidCapGainerDataAccess(Class<MoneyControlBSEMidCapGainerEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<MoneyControlBSEMidCapGainerEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        for (MoneyControlBSEMidCapGainerEntity moneyControlBSEMidCapGainerEntity : entities) {
            Object retVal = this.findBy(moneyControlBSEMidCapGainerEntity.getCompanyName());
            if (null != retVal) {
                entityManager.merge(moneyControlBSEMidCapGainerEntity);
            } else {
                entityManager.persist(moneyControlBSEMidCapGainerEntity);
            }
        }
        entityManager.getTransaction().commit();
    }

}
