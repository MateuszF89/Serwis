package pl.coderslab.serwis.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @NotBlank(message = "Pole jest wymagane.")
    private String typeOfService;

    public ServiceOrder() {
    }

    public ServiceOrder(Long id, LocalDate orderDate, Client client, String typeOfService) {
        this.id = id;
        this.orderDate = orderDate;
        this.client = client;
        this.typeOfService = typeOfService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", client=" + client +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }
}
