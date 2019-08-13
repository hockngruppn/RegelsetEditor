package com.rafi.regelseteditor;

import com.rafi.regelseteditor.impl.RegelService;
import com.rafi.regelseteditor.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class RegelServiceMockTest {
    private RegelService service;

    @Before
    public void initMocks() {
        Regelset regelset1 = getRegelset("Regelset_v1", 1001L);
        Regeldef regeldef1 = getRegeldef("Regeldef1", 2001L);
        Regelkonf regelkonf1 = getRegelkonf("Regelkonf1", 3001L);
        Regelkonf regelkonf2 = getRegelkonf("Regelkonf2", 3002L);
        Regelparam regelparam1 = getRegelparam("Regelparam1", 4001L);
        Regelparamdef regelparamdef1 = getRegelparamdef("Regelparamdef1", 5001L);

        List<Regelkonf> regelkonfList1 = new ArrayList<>();
        List<Regelkonf> regelkonfList2 = new ArrayList<>();
        List<Regelparam> regelparamList = new ArrayList<>();
        List<Regelparamdef> regelparamdefList = new ArrayList<>();
        regelparamdefList.add(regelparamdef1);
        regelparamList.add(regelparam1);
        regelkonfList1.add(regelkonf1);
        regelkonfList2.add(regelkonf2);

        service = Mockito.mock(RegelService.class);

        Mockito.when(service.findRegelsetByName("Regelset1")).thenReturn(regelset1);
        Mockito.when(service.findRegelsetById(1001L)).thenReturn(regelset1);
        Mockito.when(service.findRegeldefByName("Regeldef1")).thenReturn(regeldef1);
        Mockito.when(service.findRegeldefById(2001L)).thenReturn(regeldef1);
        Mockito.when(service.findRegelkonfByRegeldef(2001L)).thenReturn(regelkonfList1);
        Mockito.when(service.findRegelkonfByRegelsetId(1001L)).thenReturn(regelkonfList2);
        Mockito.when(service.findRegelparamByRegelkonfId(3001L)).thenReturn(regelparamList);
        Mockito.when(service.findRegelparamdefByRegeldefId(2001L)).thenReturn(regelparamdefList);
    }

    @Test
    public void getRegelparamdefByRegeldefId() {
        List<Regelparamdef> regelparamdefList = service.findRegelparamdefByRegeldefId(2001L);
        Assert.assertEquals(1, regelparamdefList.size());
        Assert.assertEquals("Regelparamdef1", regelparamdefList.get(0).getName());
        Assert.assertEquals(new Long(5001L), regelparamdefList.get(0).getId());
    }

    @Test
    public void getRegelparamByRegelkonfId() {
        List<Regelparam> regelparamList = service.findRegelparamByRegelkonfId(3001L);
        Assert.assertEquals(1, regelparamList.size());
        Assert.assertEquals("Regelparam1", regelparamList.get(0).getName());
        Assert.assertEquals(new Long(4001), regelparamList.get(0).getId());
    }

    @Test
    public void getRegelkonfByRegeldef() {
        List<Regelkonf> regelkonfList = service.findRegelkonfByRegeldef(2001L);
        Assert.assertEquals(1, regelkonfList.size());
        Assert.assertEquals("Regelkonf1", regelkonfList.get(0).getName());
        Assert.assertEquals(new Long(3001L), regelkonfList.get(0).getId());
    }

    @Test
    public void getRegelkonfByRegelsetId() {
        List<Regelkonf> regelkonfList = service.findRegelkonfByRegelsetId(1001L);
        Assert.assertEquals(1, regelkonfList.size());
        Assert.assertEquals("Regelkonf2", regelkonfList.get(0).getName());
        Assert.assertEquals(new Long(3002L), regelkonfList.get(0).getId());
    }

    @Test
    public void getRegeldefByName() {
        Regeldef regeldef = service.findRegeldefByName("Regeldef1");
        Assert.assertEquals("Regeldef1", regeldef.getName());
        Assert.assertEquals(new Long(2001), regeldef.getId());
    }

    @Test
    public void getRegeldefById() {
        Regeldef regeldef = service.findRegeldefById(2001L);
        Assert.assertEquals("Regeldef1", regeldef.getName());
        Assert.assertEquals(new Long(2001), regeldef.getId());
    }

    @Test
    public void getRegelsetById() {
        Regelset regelset = service.findRegelsetById(1001L);
        Assert.assertEquals("Regelset_v1", regelset.getName());
        Assert.assertEquals(new Long(1001), regelset.getId());
    }

    @Test
    public void getRegelsetByName() {
        Regelset regelset = service.findRegelsetByName("Regelset1");
        Assert.assertEquals("Regelset_v1", regelset.getName());
        Assert.assertEquals(new Long(1001), regelset.getId());
    }

    private Regelset getRegelset(String name, Long id) {
        Regelset regelset = new Regelset();
        regelset.setName(name);
        regelset.setId(id);

        return regelset;
    }

    private Regeldef getRegeldef(String name, Long id) {
        Regeldef regeldef = new Regeldef();
        regeldef.setName(name);
        regeldef.setId(id);

        return regeldef;
    }

    private Regelkonf getRegelkonf(String name, Long id) {
        Regelkonf regelkonf = new Regelkonf();
        regelkonf.setName(name);
        regelkonf.setId(id);

        return regelkonf;
    }

    private Regelparam getRegelparam(String name, Long id) {
        Regelparam regelparam = new Regelparam();
        regelparam.setName(name);
        regelparam.setId(id);

        return regelparam;
    }

    private Regelparamdef getRegelparamdef(String name, Long id) {
        Regelparamdef regelparamdef = new Regelparamdef();
        regelparamdef.setName(name);
        regelparamdef.setId(id);

        return regelparamdef;
    }
}
