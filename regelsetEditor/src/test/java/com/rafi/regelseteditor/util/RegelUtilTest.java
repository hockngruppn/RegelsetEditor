package com.rafi.regelseteditor.util;

import com.rafi.regelseteditor.api.IRegelService;
import com.rafi.regelseteditor.model.Regelkonf;
import com.rafi.regelseteditor.model.Regelparam;
import com.rafi.regelseteditor.model.Regelparamdef;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegelUtilTest {

    @Autowired
    private IRegelService service;

    @Test
    public void getRegelparamdefFromListByRegeldefId() {
        List<Regelparamdef> regelparamdefList = service.findAllRegelparamdefs();
        Assert.assertEquals(203, regelparamdefList.size());
        Long regeldefId = 104195L;
        List<Regelparamdef> foundByRegeldefList = RegelUtil.getRegelparamdefFromListByRegeldefId(regelparamdefList, regeldefId);
        Assert.assertEquals(4, foundByRegeldefList.size());
    }

    @Test
    public void getRegelparamFromListByRegelKonfId() {
        List<Regelparam> regelparamList = service.findAllRegelparams();
        Assert.assertEquals(427, regelparamList.size());
        Long regelkonfId = 108673L;
        List<Regelparam> foundByRegelkonfList = RegelUtil.getRegelparamFromListByRegelKonfId(regelparamList, regelkonfId);
        Assert.assertEquals(3, foundByRegelkonfList.size());
    }

    @Test
    public void getRegelparamFromListByRegelParamDefId() {
        List<Regelparam> regelparamList = service.findAllRegelparams();
        Long regelparamdefId = 100111L;
        List<Regelparam> foundByRegelparamList = RegelUtil.getRegelparamFromListByRegelParamDefId(regelparamList, regelparamdefId);
        Assert.assertEquals(4, foundByRegelparamList);
    }

    @Test
    public void getRegelkonfFromListByRegeldefId() {
        List<Regelkonf> regelkonfList = service.findAllRegelkonfs();
        Assert.assertEquals(247, regelkonfList.size());
        Long regeldefId = 104305L;
        List<Regelkonf> foundByRegeldefList = RegelUtil.getRegelkonfFromListByRegeldefId(regelkonfList, regeldefId);
        Assert.assertEquals(7, foundByRegeldefList.size());
    }
}