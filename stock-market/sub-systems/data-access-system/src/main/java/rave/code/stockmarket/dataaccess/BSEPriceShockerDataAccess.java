package rave.code.stockmarket.dataaccess;

import rave.code.stockmarket.dataaccess.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.entity.BSEPriceShockerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSEPriceShockerDataAccess extends StockMarketHistoryEnabledDataAccess<BSEPriceShockerEntity> {

    public BSEPriceShockerDataAccess() {
        this(BSEPriceShockerEntity.class);
    }

    public BSEPriceShockerDataAccess(Class<BSEPriceShockerEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEPriceShockerEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSEPriceShockerEntity bsePriceShockerEntity : entities) {
            if (bsePriceShockerEntity.isNewEntity()) {
                entityManager.persist(bsePriceShockerEntity);
            } else {
                entityManager.merge(bsePriceShockerEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSEPriceShockerEntity findBy(String primaryKey) {
        BSEPriceShockerEntity bsePriceShockerEntity = super.findBy(primaryKey);
        if (null != bsePriceShockerEntity) {
            bsePriceShockerEntity.setNewEntity(false);
        }
        return bsePriceShockerEntity;
    }

}
