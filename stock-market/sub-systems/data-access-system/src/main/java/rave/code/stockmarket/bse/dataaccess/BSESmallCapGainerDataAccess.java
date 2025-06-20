package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketDataAccess;
import rave.code.stockmarket.bse.entity.BSESmallCapGainerEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class BSESmallCapGainerDataAccess extends StockMarketDataAccess<BSESmallCapGainerEntity> {

    public BSESmallCapGainerDataAccess() {
        this(BSESmallCapGainerEntity.class);
    }

    public BSESmallCapGainerDataAccess(Class<BSESmallCapGainerEntity> type) {
        super(type);
    }

    public void bulkUpsert(List<BSESmallCapGainerEntity> moneyControlBSESmallCapGainerEntities) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        for (BSESmallCapGainerEntity moneyControlBSESmallCapGainerEntity : moneyControlBSESmallCapGainerEntities) {
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
