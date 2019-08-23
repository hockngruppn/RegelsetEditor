package com.rafi.regelseteditor.impl;

import com.rafi.regelseteditor.api.*;
import com.rafi.regelseteditor.model.*;
import com.rafi.regelseteditor.util.RegelContainer;
import com.rafi.regelseteditor.util.Regeldetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RegelService implements IRegelService {

    @Autowired
    IRegelsetRepo regelsetRepo;

    @Autowired
    IRegeldefRepo regeldefRepo;

    @Autowired
    IRegelkonfRepo regelkonfRepo;

    @Autowired
    IRegelparamRepo regelparamRepo;

    @Autowired
    IRegelparamdefRepo regelparamdefRepo;

    @Override
    public List<Regelset> findAllRegelsets() {
        return regelsetRepo.findAll();
    }

    @Override
    public List<Regelparamdef> findAllRegelparamdefs() {
        return regelparamdefRepo.findAll();
    }

    @Override
    public List<Regelparam> findAllRegelparams() {
        return regelparamRepo.findAll();
    }

    @Override
    public List<Regelkonf> findAllRegelkonfs() {
        return regelkonfRepo.findAll();
    }

    @Override
    public Regelset findRegelsetByName(String name) {
        return regelsetRepo.findRegelsetByName(name);
    }

    @Override
    public Regelset findRegelsetById(Long id) {
        return regelsetRepo.findRegelsetById(id);
    }

    @Override public Regeldef findRegeldefByName(String name) {
        return regeldefRepo.findRegeldefByName(name);
    }

    @Override public Regeldef findRegeldefById(Long id) {
        return regeldefRepo.findRegeldefById(id);
    }

    @Override public List<Regelkonf> findRegelkonfByRegelsetId(Long regelsetId) {
        return regelkonfRepo.findByRegelsetId(regelsetId);
    }

    @Override public List<Regelkonf> findRegelkonfByRegeldef(Long regeldefId) {
        return regelkonfRepo.findByRegeldef(regeldefId);
    }

    @Override public List<Regelparam> findRegelparamByRegelkonfId(Long regelkonfId) {
        return regelparamRepo.findRegelparamByRegelkonfId(regelkonfId);
    }

    @Override public List<Regelparamdef> findRegelparamdefByRegeldefId(Long regeldefId) {
        return regelparamdefRepo.findByRegeldefId(regeldefId);
    }

    public RegelContainer getRegelContainer(Regelset set) {
        List<Regelkonf> konfList = findRegelkonfByRegelsetId(set.getId());

        List<Regeldef> defList = new ArrayList<>();
        List<Regelparam> paramList = new ArrayList<>();
        List<Regelparamdef> paramdefList = new ArrayList<>();

        for (Regelkonf regelkonf : konfList) {
            Regeldef def = regelkonf.getRegeldef();
            defList.add(def);
            List<Regelparamdef> defs = findRegelparamdefByRegeldefId(def.getId());
            paramdefList.addAll(defs);
            List<Regelparam> params = findRegelparamByRegelkonfId(regelkonf.getId());
            paramList.addAll(params);
        }
        return new RegelContainer(set, konfList, paramList, defList, paramdefList);
    }

    public List<Regeldetail> getRegeldetailList(RegelContainer container){
        List<Regeldetail> detailList = new ArrayList<>();
        for (Regelkonf konf : container.getRegelkonfList()) {
            // TODO - not sure about OneToOne, just in case...
            List<Regelparam> params = findRegelparamByRegelkonfId(konf.getId());
            if (params.size() > 1) {
                System.out.println("## TODO ManyToOne Param<->Konf");
                params.stream().forEach(param -> System.out.println(" +--> " + param));

            }

            Regeldetail detail = new Regeldetail();
            detail.setReihenfolge(konf.getReihenfolge());
            detail.setAktiv(konf.getAktiv());
            detail.setBeschreibung(konf.getRegeldef().getBeschreibung());
            detail.setKlasse(konf.getRegeldef().getName());
            if (params != null && params.size() > 0) {
                detail.setDatatype(params.get(0).getDatatype());
                detail.setWert(params.get(0).getValue());
            }
            detailList.add(detail);
        }
        detailList.sort(Comparator.comparing(Regeldetail::getReihenfolge));
        return detailList;
    }

}
