package rave.code.moneycontrol.website.data.model;

public class MoneyControlGenericBSEActiveModel extends MoneyControlGenericModel {

    private String group;
    private String percentageChange;
    private String valueInCrores;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(String percentageChange) {
        this.percentageChange = percentageChange;
    }

    public String getValueInCrores() {
        return valueInCrores;
    }

    public void setValueInCrores(String valueInCrores) {
        this.valueInCrores = valueInCrores;
    }
}
