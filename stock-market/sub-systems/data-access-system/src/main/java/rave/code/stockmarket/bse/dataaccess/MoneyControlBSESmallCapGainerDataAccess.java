package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSESmallCapGainerEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class MoneyControlBSESmallCapGainerDataAccess extends StockMarketDataAccess<MoneyControlBSESmallCapGainerEntity> {

    public MoneyControlBSESmallCapGainerDataAccess() {
        this(MoneyControlBSESmallCapGainerEntity.class);
    }

    public MoneyControlBSESmallCapGainerDataAccess(Class<MoneyControlBSESmallCapGainerEntity> type) {
        super(type);
    }

    public void bulkUpsert(List<MoneyControlBSESmallCapGainerEntity> moneyControlBSESmallCapGainerEntities) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        for (MoneyControlBSESmallCapGainerEntity moneyControlBSESmallCapGainerEntity : moneyControlBSESmallCapGainerEntities) {
            Object retVal = this.findBy(moneyControlBSESmallCapGainerEntity.getCompanyName());
            if (null != retVal) {
                entityManager.merge(moneyControlBSESmallCapGainerEntity);
            } else {
                entityManager.persist(moneyControlBSESmallCapGainerEntity);
            }
        }
        entityManager.getTransaction().commit();
    }
}
