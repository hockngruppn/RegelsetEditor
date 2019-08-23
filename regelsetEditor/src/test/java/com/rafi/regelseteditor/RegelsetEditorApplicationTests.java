package com.rafi.regelseteditor;

import com.rafi.regelseteditor.api.IRegelService;
import com.rafi.regelseteditor.model.*;
import com.rafi.regelseteditor.util.RegelContainer;
import com.rafi.regelseteditor.util.Regeldetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegelsetEditorApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private IRegelService service;

	@Test
	public void streamTests() {
		List<Regelparam> paramList = service.findRegelparamByRegelkonfId(104315L);
		paramList.stream().forEach(param -> System.out.println(param));
		Assert.assertEquals(4, paramList.size());
	}

	/**
	 * test service and database.
	 * TODO work out solution for ManyToOne RegelParam-Regelkonf, still not sure about that
	 * @throws Exception
	 */
	@Test
	public void serviceTests() {
		Assert.assertNotNull(context);
		Assert.assertNotNull(service);

		List<Regelset> setList = new ArrayList<>();
		for (Regelset set : service.findAllRegelsets()) {
			setList.add(set);
		}
		Assert.assertEquals(15, setList.size());

		Regelset regelset = service.findRegelsetById(200000L);
		List<Regelkonf> konfList = service.findRegelkonfByRegelsetId(regelset.getId());

		List<Regeldef> defList = new ArrayList<>();
		List<Regelparam> paramList = new ArrayList<>();
		List<Regelparamdef> paramdefList = new ArrayList<>();

		for (Regelkonf regelkonf : konfList) {
			Regeldef def = regelkonf.getRegeldef();
			defList.add(def);
			List<Regelparamdef> defs = service.findRegelparamdefByRegeldefId(def.getId());
			paramdefList.addAll(defs);
			List<Regelparam> params = service.findRegelparamByRegelkonfId(regelkonf.getId());
			paramList.addAll(params);
		}

		RegelContainer container = getRegelContainer(regelset, konfList, defList, paramList, paramdefList);
		Assert.assertEquals(13, container.getRegeldefList().size());
		Assert.assertEquals(13, container.getRegelparamdefList().size());

		List<Regeldetail> detailList = service.getRegeldetailList(container);
		for (Regeldetail detail : detailList) {
			System.out.println(detail);
		}

		Assert.assertNotNull(regelset);
		Assert.assertTrue("DN_PRUEFFORM_E11_v4".equals(regelset.getName()));

		Assert.assertEquals(13, konfList.size());

		for (Regelkonf konf : konfList) {
			if (konf.getReihenfolge() == 100) {
				System.out.println("## regelkonf found");
				Assert.assertEquals(new Long(800009), konf.getId());
			}
		}

		Assert.assertEquals(13, defList.size());
		Assert.assertEquals(13, paramdefList.size());
		System.out.println("## paramdefListDef items");
		for (Regelparamdef def : paramdefList) {
			System.out.println(def);
		}
	}

	@Test
	public void getRegelContainer() {
		Regelset set = service.findRegelsetById(200000L);
		RegelContainer container = service.getRegelContainer(set);
		Assert.assertNotNull(container);
		Assert.assertEquals(13, container.getRegeldefList().size());
		Assert.assertEquals(13, container.getRegelparamdefList().size());
	}

	@Test
	public void getRegeldetails() {
		Regelset set = service.findRegelsetById(200000L);
		RegelContainer container = service.getRegelContainer(set);
		List<Regeldetail> detailList = null;
		detailList = service.getRegeldetailList(container);
		Assert.assertEquals(13, detailList.size());
		Assert.assertEquals(new Integer(10), detailList.get(0).getReihenfolge());
		Assert.assertEquals(new Integer(140), detailList.get(12).getReihenfolge());
		Assert.assertEquals(new Integer(100), detailList.get(8).getReihenfolge());
		Assert.assertEquals("E11V4PruefungAbtfckp", detailList.get(8).getKlasse());
	}

	private RegelContainer getRegelContainer(Regelset regelset, List<Regelkonf> konfList, List<Regeldef> defList, List<Regelparam> paramList, List<Regelparamdef> paramdefList) {
		RegelContainer container = new RegelContainer();
		container.setRegelset(regelset);
		container.setRegeldefList(defList);
		container.setRegelkonfList(konfList);
		container.setRegelparamdefList(paramdefList);
		container.setRegelparamList(paramList);
		return container;
	}

}
