package pl.coderslab.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.serwis.model.Client;
import pl.coderslab.serwis.model.Device;
import pl.coderslab.serwis.repository.ClientRepository;
import pl.coderslab.serwis.repository.DeviceRepository;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public List<Client> getClientList() {
        return clientRepository.findAll();
    }

    public void deleteClient(Long id) {
        deviceRepository.deleteDevicesByClientId(id);
        clientRepository.deleteById(id);
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public Client findClient(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            return clientOptional.get();
        } else {
            throw new NoSuchElementException("Nie znaleziono obiektu klienta o podanym ID: " + id);
        }
    }

    public void editClient(Client client) {
        clientRepository.save(client);
    }

    public void addDevice(Device device) {
        deviceRepository.save(device);
    }

    public void setClientForDevice(Device device, Long clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            device.setClient(client);
            deviceRepository.save(device);
        } else {
            throw new NoSuchElementException("Nie znaleziono klienta o podanym ID: " + clientId);
        }

    }

    public void deleteDevice(Long deviceId) {
        deviceRepository.deleteById(deviceId);
    }

    public Device findDevice(Long id) {
        Optional<Device> deviceOptional = deviceRepository.findById(id);
        if (deviceOptional.isPresent()) {
            return deviceOptional.get();
        } else {
            throw new NoSuchElementException("Nie znaleziono urządzenia o podanym ID: " + id);
        }
    }

    public void editDevice(Long clientId, Long deviceId, Device updatedDevice) {
        Optional<Device> deviceOptional = deviceRepository.findById(deviceId);
        if (deviceOptional.isPresent()) {
            Device existingDevice = deviceOptional.get();
            existingDevice.setType(updatedDevice.getType());
            existingDevice.setSerialNumber(updatedDevice.getSerialNumber());
            existingDevice.setYearOfManufacture(updatedDevice.getYearOfManufacture());
            setClientForDevice(existingDevice, clientId);
            deviceRepository.save(existingDevice);

        } else {
            throw new NoSuchElementException("Nie znaleziono urządzenia o podanym ID: " + deviceId);
        }


    }
}
