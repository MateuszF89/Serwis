package pl.coderslab.serwis.model;

import pl.coderslab.serwis.enums.MovementType;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity

public class PartMovementHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String indexNumber;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private MovementType movementType;

    private LocalDateTime operationDate;

    public PartMovementHistory() {
    }

    public PartMovementHistory(Long id, String name, String type, String indexNumber, Integer quantity, MovementType movementType, LocalDateTime operationDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.indexNumber = indexNumber;
        this.quantity = quantity;
        this.movementType = movementType;
        this.operationDate = operationDate;
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

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
    }

    @Override
    public String toString() {
        return "PartMovementHistory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", quantity=" + quantity +
                ", movementType=" + movementType +
                ", operationDate=" + operationDate +
                '}';
    }
}
