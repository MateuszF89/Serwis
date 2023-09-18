package pl.coderslab.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.serwis.enums.MovementType;
import pl.coderslab.serwis.model.PartMovementHistory;
import pl.coderslab.serwis.model.Warehouse;
import pl.coderslab.serwis.repository.PartMovementHistoryRepository;
import pl.coderslab.serwis.repository.WarehouseRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private PartMovementHistoryRepository partMovementHistoryRepository;

    public List<Warehouse> getPartsList() {
        return warehouseRepository.findAll();
    }

    public void addPartQuantity(Long id, Integer addQuantity) {

        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (warehouseOptional.isPresent()) {
            Warehouse part = warehouseOptional.get();

            PartMovementHistory historyEntry = new PartMovementHistory();
            historyEntry.setName(part.getName());
            historyEntry.setType(part.getType());
            historyEntry.setIndexNumber(part.getIndexNumber());
            historyEntry.setQuantity(part.getQuantity());
            historyEntry.setMovementType(MovementType.DODANO);
            historyEntry.setOperationDate(LocalDateTime.now());
            partMovementHistoryRepository.save(historyEntry);

            Integer quantity = part.getQuantity() + addQuantity;
            part.setQuantity(quantity);
            warehouseRepository.save(part);

        } else {
            throw new NoSuchElementException("Nie znaleziono obiektu części o podanym ID: " + id);
        }
    }

    public void deletePartQuantity(Long id, Integer removeQuantity) {

        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (warehouseOptional.isPresent()) {
            Warehouse part = warehouseOptional.get();

            PartMovementHistory historyEntry = new PartMovementHistory();
            historyEntry.setName(part.getName());
            historyEntry.setType(part.getType());
            historyEntry.setIndexNumber(part.getIndexNumber());
            historyEntry.setQuantity(part.getQuantity());
            historyEntry.setMovementType(MovementType.USUNIĘTO);
            historyEntry.setOperationDate(LocalDateTime.now());
            partMovementHistoryRepository.save(historyEntry);

            Integer quantity = part.getQuantity() - removeQuantity;
            part.setQuantity(quantity);
            warehouseRepository.save(part);

        } else {
            throw new NoSuchElementException("Nie znaleziono obiektu części o podanym ID: " + id);
        }
    }

    public Warehouse findPartById(Long id) {

        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (warehouseOptional.isPresent()) {
            return warehouseOptional.get();
        } else {
            throw new NoSuchElementException("Nie znaleziono obiektu części o podanym ID: " + id);
        }
    }

    public void editPart(Warehouse part){

        PartMovementHistory historyEntry = new PartMovementHistory();
        historyEntry.setName(part.getName());
        historyEntry.setType(part.getType());
        historyEntry.setIndexNumber(part.getIndexNumber());
        historyEntry.setQuantity(part.getQuantity());
        historyEntry.setMovementType(MovementType.EDYTOWANO);
        historyEntry.setOperationDate(LocalDateTime.now());
        partMovementHistoryRepository.save(historyEntry);

        warehouseRepository.save(part);

    }

    public void addPart(Warehouse part){

        PartMovementHistory historyEntry = new PartMovementHistory();
        historyEntry.setName(part.getName());
        historyEntry.setType(part.getType());
        historyEntry.setIndexNumber(part.getIndexNumber());
        historyEntry.setQuantity(part.getQuantity());
        historyEntry.setMovementType(MovementType.DODANO);
        historyEntry.setOperationDate(LocalDateTime.now());
        partMovementHistoryRepository.save(historyEntry);

        warehouseRepository.save(part);
    }

    public void deletePart(Long id){

        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (warehouseOptional.isPresent()) {
            Warehouse part = warehouseOptional.get();

            PartMovementHistory historyEntry = new PartMovementHistory();
            historyEntry.setName(part.getName());
            historyEntry.setType(part.getType());
            historyEntry.setIndexNumber(part.getIndexNumber());
            historyEntry.setQuantity(part.getQuantity());
            historyEntry.setMovementType(MovementType.USUNIĘTO);
            historyEntry.setOperationDate(LocalDateTime.now());
            partMovementHistoryRepository.save(historyEntry);

        } else {
            throw new NoSuchElementException("Nie znaleziono obiektu części o podanym ID: " + id);
        }

        warehouseRepository.deleteById(id);

    }

    public List<PartMovementHistory> getHistory(){
        return partMovementHistoryRepository.findAll();
    }



}
