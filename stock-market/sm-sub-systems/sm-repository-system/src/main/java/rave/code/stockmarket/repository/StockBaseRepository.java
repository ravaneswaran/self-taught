package rave.code.stockmarket.repository;

import org.hibernate.query.internal.QueryImpl;
import rave.code.stockmarket.entity.StockBaseEntity;

import javax.persistence.*;
import java.util.List;

public class StockBaseRepository extends StockMarketRepository<StockBaseEntity> {

    public StockBaseRepository() {
        this(StockBaseEntity.class);
    }

    public StockBaseRepository(Class<StockBaseEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<StockBaseEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (StockBaseEntity stockBaseEntity : entities) {
            entityManager.persist(stockBaseEntity);
        }
        entityTransaction.commit();
    }
}
