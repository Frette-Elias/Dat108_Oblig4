package dat108.oblig4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

    @GetMapping("/deltagerliste")
    public String sjekk() {
        return "deltagerliste";
    }
    @GetMapping("/")
    public String sjekk1() {
        return "paamelding_med_melding";
    }
    @GetMapping("/2")
    public String sjekk2() {
        return "paameldt";
    }
}
