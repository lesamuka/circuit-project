package br.exemplo2;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Office {

    @TableGenerator(name = "office_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", table = "id_gen")
    @Id
    @GeneratedValue(generator = "office_gen", strategy = GenerationType.TABLE)
    private int idoffice;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "area", column = @Column(name = "landmark")),
        @AttributeOverride(name = "pincode", column = @Column(name = "postal_code"))})
    private Address address;

    public int getIdoffice() {
        return idoffice;
    }

    public void setIdoffice(int idoffice) {
        this.idoffice = idoffice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
