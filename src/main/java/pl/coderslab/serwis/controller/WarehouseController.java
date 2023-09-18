package pl.coderslab.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.serwis.model.PartMovementHistory;
import pl.coderslab.serwis.model.Warehouse;
import pl.coderslab.serwis.service.WarehouseService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;


    @GetMapping("/stockLevel")
    public String showAllParts(Model model) {
        List<Warehouse> partsList = warehouseService.getPartsList();
        model.addAttribute("parts", partsList);
        return "warehouse/stockLevel";
    }

    @PostMapping("/stockLevel/add")
    public String addPartQuantity(@RequestParam("partId") Long id, @RequestParam("addQuantity") Integer quantity) {
        warehouseService.addPartQuantity(id, quantity);
        return "redirect:/warehouse/stockLevel";
    }

    @PostMapping("/stockLevel/delete")
    public String deletePartQuantity(@RequestParam("partId") Long id, @RequestParam("removeQuantity") Integer quantity) {
        warehouseService.deletePartQuantity(id, quantity);
        return "redirect:/warehouse/stockLevel";
    }

    @GetMapping("/stockLevel/edit")
    public String editPart(@RequestParam("partId") Long id, Model model) {
        Warehouse part = warehouseService.findPartById(id);
        model.addAttribute("part", part);
        return "warehouse/edit";
    }

    @PostMapping("/stockLevel/edit")
    public String editPart(@ModelAttribute("part") @Valid Warehouse part, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "warehouse/edit";
        }

        warehouseService.editPart(part);
        return "redirect:/warehouse/stockLevel";
    }

    @GetMapping("/stockLevel/addPart")
    public String showAddPartForm(Model model) {
        model.addAttribute("part", new Warehouse());
        return "warehouse/add";
    }

    @PostMapping("/stockLevel/addPart")
    public String addPartForm(@ModelAttribute("part") @Valid Warehouse part, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "warehouse/add";
        }
        warehouseService.addPart(part);
        return "redirect:/warehouse/stockLevel";
    }

    @PostMapping("/stockLevel/deletePart")
    public String deletePart(@RequestParam("partId") Long id){
        warehouseService.deletePart(id);
        return "redirect:/warehouse/stockLevel";
    }

    @GetMapping("/history")
    public String showHistory(Model model) {
        List<PartMovementHistory> partMovementHistoryList = warehouseService.getHistory();
                model.addAttribute("history", partMovementHistoryList);
        return "warehouse/history";
    }


}
