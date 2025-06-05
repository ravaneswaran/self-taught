package rave.code.moneycontrol.website.data.model;

public class MoneyControlCapGainerModel extends MoneyControlGenericBSEActiveModel{

    private String group;

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public void setGroup(String group) {
        this.group = group;
    }
}
