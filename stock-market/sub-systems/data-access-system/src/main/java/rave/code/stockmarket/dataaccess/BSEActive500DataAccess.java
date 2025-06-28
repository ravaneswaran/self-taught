package rave.code.stockmarket.dataaccess;

import rave.code.stockmarket.dataaccess.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.entity.BSEActive500Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSEActive500DataAccess extends StockMarketHistoryEnabledDataAccess<BSEActive500Entity> {

    public BSEActive500DataAccess() {
        this(BSEActive500Entity.class);
    }

    public BSEActive500DataAccess(Class<BSEActive500Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEActive500Entity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSEActive500Entity bseActive500Entity : entities) {
            //BSEActive500Entity fromDB = this.findBy(bseActive500Entity.getCompanyName());
            if (bseActive500Entity.isNewEntity()) {
                //String priceMovement = String.format("%s->%s", fromDB.getLastPrice(), bseActive500Entity.getLastPrice());
                entityManager.persist(bseActive500Entity);
            } else {
                entityManager.merge(bseActive500Entity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSEActive500Entity findBy(String primaryKey) {
        BSEActive500Entity bseActive500Entity = super.findBy(primaryKey);
        if (null != bseActive500Entity) {
            bseActive500Entity.setNewEntity(false);
        }
        return bseActive500Entity;
    }
}
