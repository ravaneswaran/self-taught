package rave.code.stockmarket.bse.entity;

import lombok.Data;
import rave.code.stockmarket.AbstractEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "holidays")
@Entity
@Data
@Table(name = "stock_market_holidays")
public class HolidayEntity extends AbstractEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    protected Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    protected Date modifiedDate;
    @Column(name = "created_by")
    protected String createdBy;
    @Column(name = "modified_by")
    protected String modifiedBy;
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "holidate")
    private String holidate;
    @Column(name = "holiday")
    private String holiday;
    @Column(name = "description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHolidate() {
        return holidate;
    }

    public void setHolidate(String holidate) {
        this.holidate = holidate;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
