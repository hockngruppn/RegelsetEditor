package com.rafi.regelseteditor.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RE_REGEL_KONF")
public class Regelkonf implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegelKonfSeq")
    @SequenceGenerator(name = "RegelKonfSeq", sequenceName = "BO_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "REGELSET_ID")
    private Long regelsetId;

    @ManyToOne
    @JoinColumn(name = "REGEL_DEF_ID", nullable = false)
    private Regeldef regeldef;

    @Column(name = "SEVERITY")
    private String severity;

    @Column(name = "REIHENFOLGE")
    private Integer reihenfolge;

    @Column(name = "ABBRUCH_BEI_VIOLATION")
    private Boolean abbruchbeiviolation;

    @Column(name = "AKTIV")
    private Boolean aktiv;

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

    @Column(name = "NAME")
    private String name;

    @Column(name = "ABBRUCH_BEI_SUCCESS")
    private Boolean abbruchbeisuccess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegelsetId() {
        return regelsetId;
    }

    public void setRegelsetId(Long regelsetId) {
        this.regelsetId = regelsetId;
    }

    public Regeldef getRegeldef() {
        return regeldef;
    }

    public void setRegeldef(Regeldef regeldef) {
        this.regeldef = regeldef;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Integer getReihenfolge() {
        return reihenfolge;
    }

    public void setReihenfolge(Integer reihenfolge) {
        this.reihenfolge = reihenfolge;
    }

    public Boolean getAbbruchbeiviolation() {
        return abbruchbeiviolation;
    }

    public void setAbbruchbeiviolation(Boolean abbruchbeiviolation) {
        this.abbruchbeiviolation = abbruchbeiviolation;
    }

    public Boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(Boolean aktiv) {
        this.aktiv = aktiv;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAbbruchbeisuccess() {
        return abbruchbeisuccess;
    }

    public void setAbbruchbeisuccess(Boolean abbruchbeisuccess) {
        this.abbruchbeisuccess = abbruchbeisuccess;
    }
}
