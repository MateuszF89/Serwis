package pl.coderslab.serwis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.serwis.model.ServicePlan;
import pl.coderslab.serwis.service.ServiceProtocolService;



import java.util.List;


@Controller
@RequestMapping("serviceProtocol")
public class ServiceProtocolController {

    @Autowired
    private ServiceProtocolService serviceProtocolService;

    @GetMapping("/listOfProtocols")
    public String showAllProtocolToCreate(Model model) {
        List<ServicePlan> servicePlanList = serviceProtocolService.getProtocolToCreate();
        model.addAttribute("protocolsToCreate", servicePlanList);
        return "serviceProtocol/listOfProtocolsToCreate";
    }

    @GetMapping("/createProtocol")
    public String ShowCreateProtocolForm(@RequestParam("protocolId") Long id, Model model) {
        ServicePlan protocolToCreate = serviceProtocolService.getProtocolToCreate(id);
        model.addAttribute("protocolToCreate", protocolToCreate);
        model.addAttribute("deviceList", serviceProtocolService.getDevicesListForClient(id));
        return "serviceProtocol/protocolCreateForm";
    }

    @PostMapping("/addProtocol")
    public String addProtocolServiceForm(@ModelAttribute("protocolToCreate") ServicePlan serviceProtocol, @RequestParam("partsList") String partsListJson, @RequestParam("protocolId") Long protocolId) {
        serviceProtocolService.addProtocol(serviceProtocol, String.valueOf(partsListJson), protocolId);
        return "redirect:/serviceProtocol/listOfProtocols";
    }


}
