package br.exemplo1.embeddable;

import br.exemplo1.entity.RepairShop;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class ServiceBook implements Serializable {

    private static final long serialVersionUID = 3807202898974104724L;

    @Column(name = "clm_service_book_number")
    private String bookNumber;

    @Column(name = "service_book_owner")
    private Integer owner;

    @OneToOne
    @JoinColumn(name = "rps_id", referencedColumnName = "rps_id")
    private RepairShop repairShop;

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public RepairShop getRepairShop() {
        return repairShop;
    }

    public void setRepairShop(RepairShop repairShop) {
        this.repairShop = repairShop;
    }

}
