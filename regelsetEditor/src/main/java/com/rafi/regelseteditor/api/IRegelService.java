package com.rafi.regelseteditor.api;

import com.rafi.regelseteditor.model.*;
import com.rafi.regelseteditor.util.RegelContainer;
import com.rafi.regelseteditor.util.Regeldetail;

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

    /**
     * gui uses this method to display a readable list of rules
     * @param container {@link RegelContainer}
     * @return Regeldetail object for representation in gui
     */
    List<Regeldetail> getRegeldetailList(RegelContainer container);

    /**
     * gui uses this method to collect all data for this ruleset
     * @param set {@link Regelset}
     * @return RegelContainer complete ruleset
     */
    RegelContainer getRegelContainer(Regelset set);

}
