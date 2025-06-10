package rave.code.website.data.model.moneycontrol;

public class CapitalGainerModel extends BSEGenericActiveModel {

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
