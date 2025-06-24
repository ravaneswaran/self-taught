package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEMidCapGainerEntity;
import rave.code.stockmarket.bse.entity.BSEPriceShockerEntity;

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
            //BSEPriceShockerEntity fromDB = this.findBy(bsePriceShockerEntity.getCompanyName());
            if (bsePriceShockerEntity.isNewEntity()) {
                //String priceMovement = String.format("%s->%s", fromDB.getCurrentPrice(), bsePriceShockerEntity.getCurrentPrice());
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
