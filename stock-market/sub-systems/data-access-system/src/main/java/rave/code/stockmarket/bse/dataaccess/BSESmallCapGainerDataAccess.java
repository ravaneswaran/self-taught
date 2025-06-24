package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketDataAccess;
import rave.code.stockmarket.bse.entity.BSEMidCapGainerEntity;
import rave.code.stockmarket.bse.entity.BSEPriceShockerEntity;
import rave.code.stockmarket.bse.entity.BSESmallCapGainerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSESmallCapGainerDataAccess extends StockMarketDataAccess<BSESmallCapGainerEntity> {

    public BSESmallCapGainerDataAccess() {
        this(BSESmallCapGainerEntity.class);
    }

    public BSESmallCapGainerDataAccess(Class<BSESmallCapGainerEntity> type) {
        super(type);
    }

    public void bulkUpsert(List<BSESmallCapGainerEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSESmallCapGainerEntity bseSmallCapGainerEntity : entities) {
            //BSESmallCapGainerEntity fromDB = this.findBy(bseSmallCapGainerEntity.getCompanyName());
            if (bseSmallCapGainerEntity.isNewEntity()) {
                //String priceMovement = String.format("%s->%s", fromDB.getLastPrice(), bseSmallCapGainerEntity.getLastPrice());
                entityManager.persist(bseSmallCapGainerEntity);
            } else {
                entityManager.merge(bseSmallCapGainerEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSESmallCapGainerEntity findBy(String primaryKey) {
        BSESmallCapGainerEntity bseSmallCapGainerEntity = super.findBy(primaryKey);
        if (null != bseSmallCapGainerEntity) {
            bseSmallCapGainerEntity.setNewEntity(false);
        }
        return bseSmallCapGainerEntity;
    }
}
