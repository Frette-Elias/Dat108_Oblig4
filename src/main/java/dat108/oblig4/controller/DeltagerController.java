package dat108.oblig4.controller;

import dat108.oblig4.entity.Deltager;
import dat108.oblig4.service.DeltagerList;
import dat108.oblig4.service.InputValidator;
import dat108.oblig4.service.PassordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class DeltagerController {

    @Autowired
    InputValidator inputValidator;
    @Autowired
    DeltagerList deltagerList;
    @Autowired
    PassordHasher passordHasher;


    @GetMapping("/deltagerliste")
    public String deltagerliste(Model model) {

        model.addAttribute("deltagere", deltagerList.deltagereSortert());

        return "deltagerliste";
    }

    @GetMapping({"/", "/paamelding_med_melding"})
    public String paamelding_med_melding(Model model) {

        return "paamelding_med_melding";
    }

    @GetMapping("/paameldt")
    public String paameldt() {
        return "paameldt";
    }
    @PostMapping("/paamelding_med_melding")
    public String registrerDeltager(@ModelAttribute Deltager deltager, RedirectAttributes redirectAttributes) {

        //Fornavn validering
        if (!inputValidator.erGyldigFornavn(deltager.getFornavn())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Fornavn må være mellom 2-20 bokstaver og starte med stor forbokstav");
            redirectAttributes.addFlashAttribute("deltager", deltager);
            return "redirect:/";
        }
        //Etternavn validering
        if (!inputValidator.erGyldigEtternavn(deltager.getEtternavn())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Etternavn må være mellom 2-20 bokstaver og starte med stor forbokstav");
            redirectAttributes.addFlashAttribute("deltager", deltager);
            return "redirect:/";
        }
        //Mobil validering
        if (!inputValidator.erGyldigMobil(deltager.getMobil())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Mobilnummer må bestå av 8 siffer");
            redirectAttributes.addFlashAttribute("deltager", deltager);
            return "redirect:/";
        }
        if (inputValidator.mobilFinnes(deltager.getMobil())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Mobilnummer er allerede registrert");
            redirectAttributes.addFlashAttribute("deltager", deltager);
            return "redirect:/";
        }
        //Passord validering
        if (!inputValidator.erGyldigPassord(deltager.getPassord())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Minst 8 tegn, En stor bokstav og tall");
            redirectAttributes.addFlashAttribute("deltager", deltager);
            return "redirect:/";
        }
        //Passord samsvar validering
        if (!deltager.getPassord().equals(deltager.getBekreftPassord())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Passordene må være like");
            redirectAttributes.addFlashAttribute("deltager", deltager);
            return "redirect:/";
        }
        //Kjønn validering
        if (!inputValidator.erGyldigKjonn(deltager.getKjonn())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Kjønn må være enten 'Mann' eller 'Kvinne'");
            redirectAttributes.addFlashAttribute("deltager", deltager);
            return "redirect:/";
        }

        Deltager nyDeltager = new Deltager(
                deltager.getFornavn(),
                deltager.getEtternavn(),
                deltager.getMobil(),
                passordHasher.hashPassord(deltager.getPassord()),
                deltager.getKjonn()
        );

        deltagerList.leggTil(nyDeltager);
        redirectAttributes.addFlashAttribute("deltager", deltager);
        return "redirect:/paameldt";
    }
}
