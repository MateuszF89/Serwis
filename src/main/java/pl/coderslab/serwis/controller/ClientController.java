package pl.coderslab.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.serwis.model.Client;
import pl.coderslab.serwis.model.Device;
import pl.coderslab.serwis.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/listOfClients")
    public String showAllClients(Model model) {
        List<Client> clientList = clientService.getClientList();
        model.addAttribute("clients", clientList);
        return "client/listOfClients";
    }


    @GetMapping("/addClient")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/add";
    }

    @PostMapping("/addClient")
    public String addClientForm(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "client/add";
        }
        clientService.addClient(client);
        return "redirect:/client/listOfClients";
    }

    @GetMapping("/editClient")
    public String editClient(@RequestParam("clientId") Long id, Model model) {
        Client client = clientService.findClient(id);
        model.addAttribute("client", client);
        return "client/edit";
    }

    @PostMapping("/editClient")
    public String editClient(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "client/edit";
        }
        clientService.editClient(client);
        return "redirect:/client/listOfClients";
    }

    @GetMapping("/addDevice")
    public String showAddDeviceForm(@RequestParam("clientId") Long id, Model model) {
        model.addAttribute("device", new Device());
        model.addAttribute("client", clientService.findClient(id));
        return "client/addDevice";
    }

    @PostMapping("/addDevice")
    public String addDeviceForm(@ModelAttribute("device") @Valid Device device, BindingResult bindingResult, @RequestParam("clientId") Long clientId) {
        if (bindingResult.hasErrors()) {
            return "client/addDevice";
        }
        clientService.setClientForDevice(device, clientId);
        clientService.addDevice(device);
        return "redirect:/client/listOfClients";
    }


    @GetMapping("/editDevice")
    public String editDevice(@RequestParam("deviceId") Long deviceId, @RequestParam("clientId") Long clientId, Model model) {
        Device device = clientService.findDevice(deviceId);
        Client client = clientService.findClient(clientId);
        model.addAttribute("device", device);
        model.addAttribute("client", client);
        return "client/editDevice";
    }

    @PostMapping("/editDevice")
    public String editDevice(@ModelAttribute("device") @Valid Device updatedDevice, BindingResult bindingResult, @RequestParam("clientId") Long clientId, @RequestParam("deviceId") Long deviceId) {
        if (bindingResult.hasErrors()) {
            return "client/editDevice";
        }
        clientService.editDevice(clientId, deviceId, updatedDevice);
        return "redirect:/client/listOfClients";
    }


}
