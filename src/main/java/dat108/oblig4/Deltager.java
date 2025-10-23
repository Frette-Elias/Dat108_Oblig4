package dat108.oblig4;

public class Deltager {
    private String fornavn;
    private String etternavn;
    private String mobil;
    private String passord;
    private String bekreftPassord;

    public Deltager(String fornavn, String etternavn, String mobil, String passord, String bekreftPassord) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
        this.passord = passord;
        this.bekreftPassord = bekreftPassord;
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

    @Override
    public String toString() {
        return fornavn + " " + etternavn + ", mobil: " + mobil;
    }

}
