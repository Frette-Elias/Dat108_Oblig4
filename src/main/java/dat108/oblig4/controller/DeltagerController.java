package dat108.oblig4.controller;

import dat108.oblig4.entity.Deltager;
import dat108.oblig4.entity.DeltagerForm;
import dat108.oblig4.repository.DeltagerRepository;
import dat108.oblig4.service.DeltagerList;
import dat108.oblig4.service.InputValidator;
import dat108.oblig4.service.LoginUtil;
import dat108.oblig4.service.PassordHasher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class DeltagerController {

    @Autowired
    private InputValidator inputValidator;
    @Autowired
    private DeltagerList deltagerList;
    @Autowired
    private PassordHasher passordHasher;
    @Autowired
    private LoginUtil loginUtil;
    @Autowired
    private DeltagerRepository dr;


    @GetMapping("/deltagerliste")
    public String deltagerliste(Model model, HttpSession session, RedirectAttributes ra) {

        if(!loginUtil.erBrukerLoggetInn(session)) {
            ra.addFlashAttribute("message", "Du må være innlogget");
            return "redirect:/login";
        }

        model.addAttribute("deltagere", deltagerList.getDeltagerList());
        model.addAttribute("mobil", session.getAttribute("mobil"));

        return "deltagerliste";
    }

    @GetMapping({"/", "/paamelding_med_melding"})
    public String paamelding_med_melding() {
        return "paamelding_med_melding";
    }

    @GetMapping("/paameldt")
    public String paameldt() {
        return "paameldt";
    }
    @PostMapping("/paamelding_med_melding")
    public String registrerDeltager(@ModelAttribute DeltagerForm DeltagerForm, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        //Fornavn validering
        if (!inputValidator.erGyldigFornavn(DeltagerForm.getFornavn())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Fornavn må være mellom 2-20 bokstaver og starte med stor forbokstav");
            redirectAttributes.addFlashAttribute("deltager", DeltagerForm);
            return "redirect:/";
        }
        //Etternavn validering
        if (!inputValidator.erGyldigEtternavn(DeltagerForm.getEtternavn())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Etternavn må være mellom 2-20 bokstaver og starte med stor forbokstav");
            redirectAttributes.addFlashAttribute("deltager", DeltagerForm);
            return "redirect:/";
        }
        //Mobil validering
        if (!inputValidator.erGyldigMobil(DeltagerForm.getMobil())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Mobilnummer må bestå av 8 siffer");
            redirectAttributes.addFlashAttribute("deltager", DeltagerForm);
            return "redirect:/";
        }
        if (inputValidator.mobilFinnes(DeltagerForm.getMobil())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Mobilnummer er allerede registrert");
            redirectAttributes.addFlashAttribute("deltager", DeltagerForm);
            return "redirect:/";
        }
        //Passord validering
        if (!inputValidator.erGyldigPassord(DeltagerForm.getPassord())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Minst 8 tegn, En stor bokstav og tall");
            redirectAttributes.addFlashAttribute("deltager", DeltagerForm);
            return "redirect:/";
        }
        //Passord samsvar validering
        if (!DeltagerForm.getPassord().equals(DeltagerForm.getBekreftPassord())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Passordene må være like");
            redirectAttributes.addFlashAttribute("deltager", DeltagerForm);
            return "redirect:/";
        }
        //Kjønn validering
        if (!inputValidator.erGyldigKjonn(DeltagerForm.getKjonn())) {
            redirectAttributes.addFlashAttribute("feilmelding", "Kjønn må være enten 'Mann' eller 'Kvinne'");
            redirectAttributes.addFlashAttribute("deltager", DeltagerForm);
            return "redirect:/";
        }

        Deltager nyDeltager = new Deltager(
                DeltagerForm.getFornavn(),
                DeltagerForm.getEtternavn(),
                DeltagerForm.getMobil(),
                passordHasher.hashPassord(DeltagerForm.getPassord()),
                DeltagerForm.getKjonn()
        );

        dr.save(nyDeltager);
        HttpSession session1 = request.getSession();
        session1.setAttribute("mobil", nyDeltager.getMobil());
        session1.setAttribute("fornavn", nyDeltager.getFornavn());
        session1.setAttribute("etternavn", nyDeltager.getEtternavn());
        session1.setMaxInactiveInterval(60);


        redirectAttributes.addFlashAttribute("deltager", DeltagerForm);
        return "redirect:/paameldt";
    }
}
