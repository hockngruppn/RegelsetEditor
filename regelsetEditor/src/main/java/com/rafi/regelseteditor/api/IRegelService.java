package com.rafi.regelseteditor.api;

import com.rafi.regelseteditor.model.*;

import java.util.List;

public interface IRegelService {

    List<Regelset> findAllRegelsets();
    List<Regelparamdef> findAllRegelparamdefs();
    List<Regelparam> findAllRegelparams();
    List<Regelkonf> findAllRegelkonfs();

    Regelset findRegelsetByName(String name);
    Regelset findRegelsetById(Long id);

    Regeldef findRegeldefByName(String name);
    Regeldef findRegeldefById(Long id);

    List<Regelkonf> findRegelkonfByRegelsetId(Long regelsetId);
    List<Regelkonf> findRegelkonfByRegeldef(Long regeldefId);

    List<Regelparam> findRegelparamByRegelkonfId(Long regelkonfId);

    List<Regelparamdef> findRegelparamdefByRegeldefId(Long regeldefId);
    Regelparamdef findRegelparamdefById(Long regelparamdefId);



//    Regelset findRegelset(Long regelsetId);
//    Regelset findRegelsetByRegelsetName(String name);
//    List<Regelset> findAllRegelsets();
//    Regelkonf findRegelkonfByRegelkonfId(Long regelkonfId);
//    List<Regelparam> findRegelparamByKonfId(Long regelkonfId);
//    Regeldef findRegeldefByRegeldefId(Long regeldefId);
//    Regeldef findRegeldefByRegelkonf(Regelkonf regelkonf);
//    List<Regelparamdef> findRegelparamdefByRegeldefId(Long regeldefId);
//    List<Regeldef> findRegelDefsByKategorie(String kategorie);
//    Regeldef findRegelDefByClassname(String classname);
//
//    Regelkonf saveRegelkonf(Regelkonf regelkonf);
}
