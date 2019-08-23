package com.rafi.regelseteditor.util;


import com.rafi.regelseteditor.model.*;

import java.util.List;

/**
* Beinhaltet sämtliche D
 */
public class RegelContainer {
    private Regelset regelset;
    private List<Regelkonf> regelkonfList;
    private List<Regelparam> regelparamList;
    private List<Regeldef> regeldefList;
    private List<Regelparamdef> regelparamdefList;

    public RegelContainer() {
    }

    public RegelContainer(Regelset regelset, List<Regelkonf> regelkonfList, List<Regelparam> regelparamList, List<Regeldef> regeldefList,
            List<Regelparamdef> regelparamdefList) {
        this.regelset = regelset;
        this.regelkonfList = regelkonfList;
        this.regelparamList = regelparamList;
        this.regeldefList = regeldefList;
        this.regelparamdefList = regelparamdefList;
    }

    public Regelset getRegelset() {
        return regelset;
    }

    public void setRegelset(Regelset regelset) {
        this.regelset = regelset;
    }

    public List<Regelkonf> getRegelkonfList() {
        return regelkonfList;
    }

    public void setRegelkonfList(List<Regelkonf> regelkonfList) {
        this.regelkonfList = regelkonfList;
    }

    public List<Regelparam> getRegelparamList() {
        return regelparamList;
    }

    public void setRegelparamList(List<Regelparam> regelparamList) {
        this.regelparamList = regelparamList;
    }

    public List<Regeldef> getRegeldefList() {
        return regeldefList;
    }

    public void setRegeldefList(List<Regeldef> regeldefList) {
        this.regeldefList = regeldefList;
    }

    public List<Regelparamdef> getRegelparamdefList() {
        return regelparamdefList;
    }

    public void setRegelparamdefList(List<Regelparamdef> regelparamdefList) {
        this.regelparamdefList = regelparamdefList;
    }

    public String toString() {
        // TODO
        return "";
    }
}
