package dat108.oblig4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {

    @GetMapping("/deltagerliste")
    public String deltagerliste() {
        return "deltagerliste";
    }
    @GetMapping("/paamelding_med_melding")
    public String paamelding_med_melding() {
        return "paamelding_med_melding";
    }
    @GetMapping("/paameldt")
    public String paameldt() {
        return "paameldt";
    }
    @PostMapping("/paamelding_med_melding")
    public String registrerDeltager(@RequestParam String fornavn, @RequestParam String etternavn, Model model,
                                    @RequestParam String mobil, @RequestParam String passord,
                                    @RequestParam String bekreftPassord, @RequestParam String kjonn) {
        return "redirect:/paameldt";
    }
}