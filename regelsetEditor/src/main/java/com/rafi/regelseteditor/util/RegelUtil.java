package com.rafi.regelseteditor.util;

import com.rafi.regelseteditor.model.Regelkonf;
import com.rafi.regelseteditor.model.Regelparam;
import com.rafi.regelseteditor.model.Regelparamdef;

import java.util.List;
import java.util.stream.Collectors;

public class RegelUtil {

    public static List<Regelparamdef> getRegelparamdefFromListByRegeldefId(List<Regelparamdef> regelparamdefList, Long regeldefId) {
        return regelparamdefList.stream()
                .filter(regelparamdef -> regelparamdef.getRegeldefId().equals(regeldefId))
                .collect(Collectors.toList());
    }

    public static List<Regelparam> getRegelparamFromListByRegelKonfId(List<Regelparam> regelparamList, Long regelkonfId) {
        List<Regelparam> returnList = regelparamList.stream()
                .filter(regelparam -> regelparam.getRegelkonfId().equals(regelkonfId))
                .collect(Collectors.toList());
        return returnList;
    }

    public static List<Regelparam> getRegelparamFromListByRegelParamDefId(List<Regelparam> regelparamList, Long regelparamdefId) {
        List<Regelparam> returnList = regelparamList.stream()
                                        .filter(regelparam -> regelparam.getRegelParamDefId().equals(regelparamdefId))
                                        .collect(Collectors.toList());
        return returnList;
    }

    public static List<Regelkonf> getRegelkonfFromListByRegeldefId(List<Regelkonf> regelkonfList, Long regeldefId) {
        List<Regelkonf> returnList = regelkonfList.stream()
                                        .filter(regelkonf -> regelkonf.getId().equals(regeldefId))
                                        .collect(Collectors.toList());
        return returnList;
    }
}
