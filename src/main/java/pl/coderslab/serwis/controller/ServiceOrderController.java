package pl.coderslab.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.serwis.model.ServiceOrder;
import pl.coderslab.serwis.service.ServiceOrderService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("serviceOrder")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping("/listOfOrders")
    public String showAllOrders(Model model) {
        List<ServiceOrder> serviceOrderList = serviceOrderService.getOrders();
        model.addAttribute("orders", serviceOrderList);
        return "serviceOrder/listOfOrders";
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("orderId") Long id) {
        serviceOrderService.deleteOrder(id);
        return "redirect:/serviceOrder/listOfOrders";
    }
    @GetMapping("/addOrder")
    public String showAddOrderForm(Model model) {
        model.addAttribute("serviceOrder", new ServiceOrder());
        model.addAttribute("clients",serviceOrderService.getClients());
        return "serviceOrder/add";
    }

    @PostMapping("/addOrder")
    public String addOrderForm(@ModelAttribute("serviceOrder") @Valid ServiceOrder serviceOrder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "serviceOrder/add";
        }
        serviceOrderService.addOrder(serviceOrder);
        return "redirect:/serviceOrder/listOfOrders";
    }


}
