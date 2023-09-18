package pl.coderslab.serwis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pole jest wymagane.")
    private String name;
    @NotBlank(message = "Pole jest wymagane.")
    private String type;

    @NotBlank(message = "Pole jest wymagane.")
    private String indexNumber;

    @NotNull
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Wartość musi być liczbą całkowitą")
    private Integer quantity;


    public Warehouse() {
    }

    public Warehouse(Long id, String name, String type, String indexNumber, Integer quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.indexNumber = indexNumber;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
