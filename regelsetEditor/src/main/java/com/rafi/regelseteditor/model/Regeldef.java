package com.rafi.regelseteditor.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RE_REGEL_DEF")
public class Regeldef implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegelDefSeq")
    @SequenceGenerator(name = "RegelDefSeq", sequenceName = "BO_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "KATEGORIE")
    private String kategorie;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REGEL_CLASS_NAME")
    private String regelclassname;

    @Column(name = "BESCHREIBUNG")
    private String beschreibung;

    @Column(name = "VERSION_BEZEICHNUNG")
    private String versionbezeichnung;

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

    public String getRegelclassname() {
        return regelclassname;
    }

    public void setRegelclassname(String regelclassname) {
        this.regelclassname = regelclassname;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getVersionbezeichnung() {
        return versionbezeichnung;
    }

    public void setVersionbezeichnung(String versionbezeichnung) {
        this.versionbezeichnung = versionbezeichnung;
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
}
