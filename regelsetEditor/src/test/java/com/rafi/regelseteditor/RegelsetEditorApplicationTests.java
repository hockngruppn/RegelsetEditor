package com.rafi.regelseteditor;

import com.rafi.regelseteditor.api.IRegelService;
import com.rafi.regelseteditor.model.*;
import com.rafi.regelseteditor.util.RegelContainer;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegelsetEditorApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private IRegelService service;

	@Test
	public void contextLoads() {
	}

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

		RegelContainer container = new RegelContainer();
		container.setRegelset(regelset);
		container.setRegeldefList(defList);
		container.setRegelkonfList(konfList);
		container.setRegelparamdefList(paramdefList);
		container.setRegelparamList(paramList);

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

}
