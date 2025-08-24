package rave.code.stockmarket.repository;

import rave.code.stockmarket.entity.BSEStockBaseEntity;
import rave.code.stockmarket.entity.NSEStockBaseEntity;
import rave.code.stockmarket.entity.StockBaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockBaseRepository extends StockMarketRepository<StockBaseEntity> {

    private static final Logger LOGGER = Logger.getLogger(StockBaseRepository.class.getName());

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
            if (stockBaseEntity.isNewEntity()) {
                entityManager.persist(stockBaseEntity);
            } else {
                entityManager.merge(stockBaseEntity);
            }
        }
        entityTransaction.commit();
    }


    public StockBaseEntity findBy(String source, String mkt, String series, String stockSymbol, String stockName) {

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT stockBaseEntity FROM StockBaseEntity stockBaseEntity").append(" ");
        queryBuilder.append("WHERE").append(" ");
        queryBuilder.append("type(stockBaseEntity)").append("=").append(":source").append(" AND ");
        queryBuilder.append("stockBaseEntity.mkt").append("=").append(":mkt").append(" AND ");
        queryBuilder.append("stockBaseEntity.series").append("=").append(":series").append(" AND ");
        queryBuilder.append("stockBaseEntity.stockSymbol").append("=").append(":stockSymbol").append(" AND ");
        queryBuilder.append("stockBaseEntity.stockName").append("=").append(":stockName");

        Class sourceType = null;
        switch (source) {
            case "NSE":
                sourceType = NSEStockBaseEntity.class;
                break;
            case "BSE":
                sourceType = BSEStockBaseEntity.class;
                break;
        }

        Query query = this.getEntityManager().createQuery(queryBuilder.toString());
        query.setParameter("source", sourceType);
        query.setParameter("mkt", mkt);
        query.setParameter("series", series);
        query.setParameter("stockSymbol", stockSymbol);
        query.setParameter("stockName", stockName);

        List<StockBaseEntity> stockBaseEntities = query.getResultList();

        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), stockBaseEntities.size()));

        if (stockBaseEntities.size() > 0 && stockBaseEntities.size() == 1) {
            StockBaseEntity stockBaseEntity = stockBaseEntities.get(0);
            stockBaseEntity.setNewEntity(false);
            return stockBaseEntity;
        } else {
            return null;
        }
    }
}