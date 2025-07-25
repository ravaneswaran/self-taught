package rave.code.stockmarket.dataaccess;

import rave.code.stockmarket.dataaccess.StockMarketDataAccess;
import rave.code.stockmarket.entity.StockBaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class StockBaseDataAccess extends StockMarketDataAccess<StockBaseEntity> {

    public StockBaseDataAccess() {
        super(StockBaseEntity.class);
    }

    @Override
    public void bulkUpsert(List<StockBaseEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (StockBaseEntity stockBaseEntity : entities) {
            if (stockBaseEntity.isNewEntity()) {
                entityManager.persist(stockBaseEntity);
            } else {
                entityManager.merge(stockBaseEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public StockBaseEntity findBy(String primaryKey) {
        StockBaseEntity stockBaseEntity = super.findBy(primaryKey);
        if (null != stockBaseEntity) {
            stockBaseEntity.setNewEntity(false);
        }
        return stockBaseEntity;
    }
}
