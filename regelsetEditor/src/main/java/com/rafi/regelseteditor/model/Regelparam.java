package com.rafi.regelseteditor.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RE_REGEL_PARAM")
public class Regelparam implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegelParamSeq")
    @SequenceGenerator(name = "RegelParamSeq", sequenceName = "BO_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "REGEL_KONF_ID")
    private Long regelkonfId;

    @Column(name = "REGEL_PARAM_DEF_ID")
    private Long regelParamDefId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATATYPE")
    private String datatype;

    @Column(name = "VALUE")
    private String value;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegelkonfId() {
        return regelkonfId;
    }

    public void setRegelkonfId(Long regelkonfId) {
        this.regelkonfId = regelkonfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Long getRegelParamDefId() {
        return regelParamDefId;
    }

    public void setRegelParamDefId(Long regelParamDefId) {
        this.regelParamDefId = regelParamDefId;
    }

    @Override
    public String toString() {
        return "Regelparam [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ']';
    }
}
