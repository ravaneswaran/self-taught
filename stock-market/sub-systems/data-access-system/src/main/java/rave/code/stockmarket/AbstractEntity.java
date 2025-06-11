package rave.code.stockmarket;

public abstract class AbstractEntity {

    private boolean newEntity;

    public AbstractEntity(){
        this.setNewEntity(true);
    }

    public boolean isNewEntity() {
        return newEntity;
    }

    public void setNewEntity(boolean newEntity) {
        this.newEntity = newEntity;
    }
}
