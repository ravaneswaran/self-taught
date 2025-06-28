package rave.code.stockmarket.dataaccess;

import rave.code.stockmarket.dataaccess.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.entity.BSESensexEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSESensexDataAccess extends StockMarketHistoryEnabledDataAccess<BSESensexEntity> {

    public BSESensexDataAccess() {
        this(BSESensexEntity.class);
    }

    public BSESensexDataAccess(Class<BSESensexEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSESensexEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSESensexEntity bseSensexEntity : entities) {
            //BSEActive100Entity fromDB = this.findBy(bseActive100Entity.getCompanyName());
            if (bseSensexEntity.isNewEntity()) {
                entityManager.persist(bseSensexEntity);
            } else {
                entityManager.merge(bseSensexEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSESensexEntity findBy(String primaryKey) {
        BSESensexEntity bseSensexEntity = super.findBy(primaryKey);
        if (null != bseSensexEntity) {
            bseSensexEntity.setNewEntity(false);
        }
        return bseSensexEntity;
    }
}
