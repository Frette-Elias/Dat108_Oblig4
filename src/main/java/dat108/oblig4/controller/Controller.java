package dat108.oblig4.controller;

import dat108.oblig4.service.Deltager;
import dat108.oblig4.service.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    InputValidator inputValidator;

    @GetMapping("/deltagerliste")
    public String deltagerliste() {
        return "deltagerliste";
    }
    @GetMapping({"/", "/paamelding_med_melding"})
    public String paamelding_med_melding() {
        return "paamelding_med_melding";
    }
    @GetMapping("/paameldt")
    public String paameldt(Model model) {
        if (!model.containsAttribute("deltager")) {
            return "redirect:/";
        }
        return "paameldt";
    }
    @PostMapping("/paamelding_med_melding")
    public String registrerDeltager(@ModelAttribute Deltager deltager, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("deltager", deltager);
        return "redirect:/paameldt";
    }
}
