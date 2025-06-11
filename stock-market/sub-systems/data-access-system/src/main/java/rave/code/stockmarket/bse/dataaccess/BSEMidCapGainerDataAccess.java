package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEMidCapGainerEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class BSEMidCapGainerDataAccess extends StockMarketHistoryEnabledDataAccess<BSEMidCapGainerEntity> {

    public BSEMidCapGainerDataAccess() {
        this(BSEMidCapGainerEntity.class);
    }

    public BSEMidCapGainerDataAccess(Class<BSEMidCapGainerEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEMidCapGainerEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        for (BSEMidCapGainerEntity moneyControlBSEMidCapGainerEntity : entities) {
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
