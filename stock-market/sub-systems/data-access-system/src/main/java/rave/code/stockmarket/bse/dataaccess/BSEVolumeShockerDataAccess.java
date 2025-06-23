package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEVolumeShockerEntity;

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
        throw new RuntimeException("Yet to implement....");
    }

    @Override
    public BSEVolumeShockerEntity save(BSEVolumeShockerEntity entity) {
        BSEVolumeShockerEntity fromDB = this.findBy(entity.getCompanyName());
        if (null == fromDB) {
            EntityTransaction entityTransaction = this.getEntityManager().getTransaction();
            entityTransaction.begin();
            this.getEntityManager().persist(entity);
            entityTransaction.commit();
        } else {
            return fromDB;
        }
        return entity;
    }
}
