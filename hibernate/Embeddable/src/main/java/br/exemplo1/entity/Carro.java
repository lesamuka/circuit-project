package br.exemplo1.entity;

import br.exemplo1.embeddable.ServiceBook;
import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_carro")
public class Carro implements Serializable {

    private static final long serialVersionUID = -1126242111171968609L;

    @Id
    @GeneratedValue
    @Column(name = "car_id", nullable = false)
    private Integer id;

    @Column(name = "car_producer", nullable = false)
    private String producer;

    @Column(name = "car_model", nullable = false)
    private String model;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "area", column = @Column(name = "landmark")),
        @AttributeOverride(name = "pincode", column = @Column(name = "postal_code"))})
    private ServiceBook serviceBook;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ServiceBook getServiceBook() {
        return serviceBook;
    }

    public void setServiceBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

}
