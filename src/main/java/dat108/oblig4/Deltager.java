package dat108.oblig4;

public class Deltager {
    private String fornavn;
    private String etternavn;
    private String mobil;
    private String passord;
    private String bekreftPassord;
    private String kjonn;

    public Deltager() {
        // Default constructor for data binding
    }

    public Deltager(String fornavn, String etternavn, String mobil, String passord, String bekreftPassord, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
        this.passord = passord;
        this.bekreftPassord = bekreftPassord;
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
    public String getBekreftPassord() {
        return bekreftPassord;
    }
    public String getKjonn() {
        return kjonn;
    }

    @Override
    public String toString() {
        return fornavn + " " + etternavn + ", mobil: " + mobil + ", Kjønn" + kjonn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public void setBekreftPassord(String bekreftPassord) {
        this.bekreftPassord = bekreftPassord;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

}
