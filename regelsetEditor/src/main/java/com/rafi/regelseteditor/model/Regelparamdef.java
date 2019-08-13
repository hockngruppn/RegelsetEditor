package com.rafi.regelseteditor.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RE_REGEL_PARAM_DEF")
public class Regelparamdef implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegelParamDefSeq")
    @SequenceGenerator(name = "RegelParamDefSeq", sequenceName = "BO_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "REGEL_DEF_ID")
    private Long regeldefId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BESCHREIBUNG")
    private String beschreibung;

    @Column(name = "DATATYPE")
    private String datatype;

    @Column(name = "DEFAULT_VALUE")
    private String defaultvalue;

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

    public Long getRegeldefId() {
        return regeldefId;
    }

    public void setRegeldefId(Long regeldefId) {
        this.regeldefId = regeldefId;
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

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue;
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

    @Override
    public String toString() {
        return "Regelparamdef{" +
                "id=" + id +
                ", defaultvalue='" + defaultvalue + '\'' +
                '}';
    }
}
