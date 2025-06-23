package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
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
        for (BSEPriceShockerEntity bseVolumeShockerEntity : entities) {
            BSEPriceShockerEntity fromDB = this.findBy(bseVolumeShockerEntity.getCompanyName());
            if (null != fromDB) {
                String priceMovement = String.format("%s->%s", fromDB.getCurrentPrice(), bseVolumeShockerEntity.getCurrentPrice());
                entityManager.merge(bseVolumeShockerEntity);
            } else {
                entityManager.persist(bseVolumeShockerEntity);
            }
        }
        entityTransaction.commit();
    }

}
