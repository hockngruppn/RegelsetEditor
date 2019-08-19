package com.rafi.regelseteditor.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RE_REGELSET")
public class Regelset {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegelsetSeq")
    @SequenceGenerator(name = "RegelsetSeq", sequenceName = "BO_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "KATEGORIE")
    private String kategorie;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BESCHREIBUNG")
    private String beschreibung;

    @Column(name = "VERKNUEPFUNGSTYP")
    private String verknuepfungstyp;

    @Column(name = "GUELTIG_VON")
    private Date gueltigVon;

    @Column(name = "GUELTIG_BIS")
    private Date gueltigBis;

    @Column(name = "ERSTELLT_AM")
    private Date erstelltAm;

    @Column(name = "GEAENDERT_AM")
    private Date geaendertAm;

    @Column(name = "ERSTELLT_VON")
    private String erstelltVon;

    @Column(name = "GEAENDERT_VON")
    private String geaendertVon;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "AKTIV_TYP")
    private String aktivTyp;

    @Column(name = "ERROR_HANDLING_TYP")
    private String errorhandlingtyp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
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

    public String getVerknuepfungstyp() {
        return verknuepfungstyp;
    }

    public void setVerknuepfungstyp(String verknuepfungstyp) {
        this.verknuepfungstyp = verknuepfungstyp;
    }

    public Date getGueltigVon() {
        return gueltigVon;
    }

    public void setGueltigVon(Date gueltigVon) {
        this.gueltigVon = gueltigVon;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public Date getErstelltAm() {
        return erstelltAm;
    }

    public void setErstelltAm(Date erstelltAm) {
        this.erstelltAm = erstelltAm;
    }

    public Date getGeaendertAm() {
        return geaendertAm;
    }

    public void setGeaendertAm(Date geaendertAm) {
        this.geaendertAm = geaendertAm;
    }

    public String getErstelltVon() {
        return erstelltVon;
    }

    public void setErstelltVon(String erstelltVon) {
        this.erstelltVon = erstelltVon;
    }

    public String getGeaendertVon() {
        return geaendertVon;
    }

    public void setGeaendertVon(String geaendertVon) {
        this.geaendertVon = geaendertVon;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getAktivTyp() {
        return aktivTyp;
    }

    public void setAktivTyp(String aktivTyp) {
        this.aktivTyp = aktivTyp;
    }

    public String getErrorhandlingtyp() {
        return errorhandlingtyp;
    }

    public void setErrorhandlingtyp(String errorhandlingtyp) {
        this.errorhandlingtyp = errorhandlingtyp;
    }

    @Override
    public String toString() {
        return "Regelset [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ']';
    }

}
