package rave.code.stockmarket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StockMarketHistoryEnabledDataAccess<T> extends StockMarketDataAccess<T>{

    private static final String PERSISTENCE_UNIT_NAME = "stock_market";
    private static EntityManagerFactory factory;

    private EntityManager entityManager;

    private Class<T> type;

    public StockMarketHistoryEnabledDataAccess(Class<T> type) {
        super(type);
        this.type = type;

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.entityManager = factory.createEntityManager();
    }

    protected EntityManager getEntityManager() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        if (null == this.entityManager) {
            this.entityManager = factory.createEntityManager();
        } else {
            if (!this.entityManager.isOpen()) {
                this.entityManager = factory.createEntityManager();
            }
        }
        return this.entityManager;
    }

    protected void closeEntityManager() {
        if (null != this.entityManager && this.entityManager.isOpen()) {
            this.entityManager.close();
        }
    }

    public T findBy(String id) {
        return this.entityManager.find(this.type, id);
    }

    public T save(T entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    public T delete(T entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    public T update(T entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    // method introduced specially to moving the data to the history tables...
    public List findAll(){
        EntityManager entityManager = this.getEntityManager();
        String queryString = "from ? entity".replace("?", type.getName());
        Query query = entityManager.createQuery(queryString, type);
        return query.getResultList();
    }

    public  void moveToHistoryAndDeleteSource(final String MOVE_TO_HISTORY_QUERY, final String DELETE_SOURCE_QUERY){
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery(MOVE_TO_HISTORY_QUERY);
        int result = query.executeUpdate();
        if (result > 0) {
            query = entityManager.createNativeQuery(DELETE_SOURCE_QUERY);
            result = query.executeUpdate();
        }

        entityManager.getTransaction().commit();
    }

}
