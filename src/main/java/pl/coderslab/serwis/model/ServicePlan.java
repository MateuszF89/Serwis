package pl.coderslab.serwis.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ServicePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate planeDate;

    @Column(nullable = false)
    private LocalDate executionDate;

    @NotBlank(message = "Pole jest wymagane.")
    private String description;

    private String comments;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "service_order_id")
    private ServiceOrder serviceOrder;

    @OneToOne
    @JoinColumn(name = "list_of_parts_id")
    private ListOfParts listOfParts;

    public ServicePlan() {
    }

    public ServicePlan(Long id, LocalDate planeDate, LocalDate executionDate, String description, String comments, Employee employee, ServiceOrder serviceOrder, ListOfParts listOfParts) {
        this.id = id;
        this.planeDate = planeDate;
        this.executionDate = executionDate;
        this.description = description;
        this.comments = comments;
        this.employee = employee;
        this.serviceOrder = serviceOrder;
        this.listOfParts = listOfParts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPlaneDate() {
        return planeDate;
    }

    public void setPlaneDate(LocalDate planeDate) {
        this.planeDate = planeDate;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public ListOfParts getListOfParts() {
        return listOfParts;
    }

    public void setListOfParts(ListOfParts listOfParts) {
        this.listOfParts = listOfParts;
    }

    @Override
    public String toString() {
        return "ServicePlan{" +
                "id=" + id +
                ", planeDate=" + planeDate +
                ", executionDate=" + executionDate +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                ", employee=" + employee +
                ", serviceOrder=" + serviceOrder +
                ", listOfParts=" + listOfParts +
                '}';
    }
}
