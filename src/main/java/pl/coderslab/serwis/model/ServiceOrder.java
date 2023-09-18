package pl.coderslab.serwis.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate orderDate;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    public ServiceOrder() {
    }

    public ServiceOrder(Long id, LocalDate orderDate, Client client, Service service) {
        this.id = id;
        this.orderDate = orderDate;
        this.client = client;
        this.service = service;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", client=" + client +
                ", service=" + service +
                '}';
    }
}
