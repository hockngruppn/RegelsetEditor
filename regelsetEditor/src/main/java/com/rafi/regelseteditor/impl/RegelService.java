package com.rafi.regelseteditor.impl;

import com.rafi.regelseteditor.api.*;
import com.rafi.regelseteditor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Regelparamdef findRegelparamdefById(Long regelparamdefId) {
        return regelparamdefRepo.getOne(regelparamdefId);
    }

}
