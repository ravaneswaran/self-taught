package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSETopDividendEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class BSETopDividendDataAccess extends StockMarketHistoryEnabledDataAccess<BSETopDividendEntity> {

    public BSETopDividendDataAccess(){
        this(BSETopDividendEntity.class);
    }

    public BSETopDividendDataAccess(Class<BSETopDividendEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSETopDividendEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        for (BSETopDividendEntity moneyControlBSETopDividendEntity : entities) {
            Object retVal = this.findBy(moneyControlBSETopDividendEntity.getCompanyName());
            if (null != retVal) {
                entityManager.merge(moneyControlBSETopDividendEntity);
            } else {
                entityManager.persist(moneyControlBSETopDividendEntity);
            }
        }
        entityManager.getTransaction().commit();
    }

}
