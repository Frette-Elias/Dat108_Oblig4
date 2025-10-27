package dat108.oblig4.entity;

import jakarta.persistence.*;

public class DeltagerForm {

    private String mobil;
    private String fornavn;
    private String etternavn;
    private String passord;
    private String bekreftPassord;
    private String kjonn;

    public DeltagerForm(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
        this.passord = passord;
        this.kjonn = kjonn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getPassord() {
        return passord;
    }

    public String getBekreftPassord() {return bekreftPassord;
    }

    public void setBekreftPassord(String bekreftPassord) {
        this.bekreftPassord = bekreftPassord;
    }
    public String getKjonn() {
        return kjonn;
    }

    @Override
    public String toString() {
        return fornavn + " " + etternavn + ", mobil: " + mobil + ", Kjønn" + kjonn;
    }
}
