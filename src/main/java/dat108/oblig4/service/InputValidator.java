package dat108.oblig4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputValidator {

    @Autowired
    private DeltagerList deltagerList;

    public boolean erGyldigFornavn(String fornavn) {
        if (fornavn == null) {
            return false;
        }
        return fornavn.matches("^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\- ]{1,19}$");
    }

    public boolean erGyldigEtternavn(String etternavn) {
        if (etternavn == null) {
            return false;
        }
        return etternavn.matches("^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]{1,19}$");
    }

    public boolean erGyldigMobil(String mobil) {
        if (mobil == null) {
            return false;
        }
        return mobil.matches("^[0-9]{8}$");
    }
    public boolean mobilFinnes(String mobil) {
        if (mobil == null) {
            return false;
        }
        return deltagerList.getDeltagerList().stream()
                .anyMatch(deltager -> deltager.getMobil().equals(mobil));

    }
    public boolean erGyldigPassord(String passord) {
        if (passord == null) {
            return false;
        }
        return passord.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    }

    public boolean erGyldigKjonn(String kjonn) {
        if (kjonn == null) {
            return false;
        }
        return kjonn.equals("Mann") || kjonn.equals("Kvinne");
    }


}
