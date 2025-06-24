package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSETopDividendEntity;
import rave.code.stockmarket.bse.entity.BSEVolumeShockerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSEVolumeShockerDataAccess extends StockMarketHistoryEnabledDataAccess<BSEVolumeShockerEntity> {

    public BSEVolumeShockerDataAccess() {
        this(BSEVolumeShockerEntity.class);
    }

    public BSEVolumeShockerDataAccess(Class<BSEVolumeShockerEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEVolumeShockerEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSEVolumeShockerEntity bseVolumeShockerEntity : entities) {
            //BSEVolumeShockerEntity fromDB = this.findBy(bseVolumeShockerEntity.getCompanyName());
            if (bseVolumeShockerEntity.isNewEntity()) {
                //String priceMovement = String.format("%s->%s", fromDB.getLastPrice(), bseVolumeShockerEntity.getLastPrice());
                entityManager.persist(bseVolumeShockerEntity);
            } else {
                entityManager.merge(bseVolumeShockerEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSEVolumeShockerEntity findBy(String primaryKey) {
        BSEVolumeShockerEntity bseVolumeShockerEntity = super.findBy(primaryKey);
        if (null != bseVolumeShockerEntity) {
            bseVolumeShockerEntity.setNewEntity(false);
        }
        return bseVolumeShockerEntity;
    }
}
