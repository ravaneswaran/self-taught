package rave.code.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Transaction {

    @XmlElement(name = "checkoutType")
    private String checkoutType;

    public String getCheckoutType() {
        return checkoutType;
    }

    public void setCheckoutType(String checkoutType) {
        this.checkoutType = checkoutType;
    }
}
