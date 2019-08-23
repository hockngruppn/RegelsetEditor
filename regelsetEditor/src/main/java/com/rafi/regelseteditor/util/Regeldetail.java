package com.rafi.regelseteditor.util;

/**
 *  this object holds all reasonable data
 *  about the rule for representation.
 */
public class Regeldetail {

    private Integer reihenfolge;
    private String klasse;
    private String fehlermeldung;
    private String fehlercode;
    private String name;
    private String beschreibung;
    private String datatype;
    private String wert;
    private Boolean aktiv;

    public Regeldetail() {
    }

    public Regeldetail(Integer reihenfolge, String klasse, String fehlermeldung, String fehlercode,
                       String name, String beschreibung, String datatype, String wert, Boolean aktiv) {
        this.reihenfolge = reihenfolge;
        this.klasse = klasse;
        this.fehlermeldung = fehlermeldung;
        this.fehlercode = fehlercode;
        this.name = name;
        this.beschreibung = beschreibung;
        this.datatype = datatype;
        this.wert = wert;
        this.aktiv = aktiv;
    }

    public Boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(Boolean aktiv) {
        this.aktiv = aktiv;
    }

    public String getWert() {
        return wert;
    }

    public void setWert(String wert) {
        this.wert = wert;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public Integer getReihenfolge() {
        return reihenfolge;
    }

    public void setReihenfolge(Integer reihenfolge) {
        this.reihenfolge = reihenfolge;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public String getFehlermeldung() {
        return fehlermeldung;
    }

    public void setFehlermeldung(String fehlermeldung) {
        this.fehlermeldung = fehlermeldung;
    }

    public String getFehlercode() {
        return fehlercode;
    }

    public void setFehlercode(String fehlercode) {
        this.fehlercode = fehlercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public String toString() {
        return "Regeldetail [" +
                "reihenfolge=" + reihenfolge +
                ", klasse='" + klasse + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", datatype='" + datatype + '\'' +
                ", wert='" + wert + '\'' +
                ", aktiv=" + aktiv +
                ']';
    }
}
