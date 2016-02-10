package com.site.code.controllers;

import com.site.code.entity.ListData;
import com.site.code.dao.ListDataDAO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Controller
public class HomeController {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exampleHibernateJPA");
	EntityManager em = emf.createEntityManager();

	@Inject
	private ListDataDAO listDataDAO;
	
	@RequestMapping(method=RequestMethod.GET, value={"/", "/home"}) 
	public String showHomePage (ModelAndView mv) {
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listdata")
	public String listDatas(Model model) {
		List<ListData> listDatas = listDataDAO.getAllListData();
		model.addAttribute("listDatas", listDatas);
		return "listResults";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getlistdata")
	public String getListData(String title, Model model) {
		List<ListData> strs = listDataDAO.getListDataByTitle(title);
		model.addAttribute("strs", strs);
		return "listResults";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/upload")
	public String uploadFile(String description, @RequestParam(value="myFile")MultipartFile uploadedFile, Model model) {

		Long fileSize = uploadedFile.getSize();
		InputStream in = null;
		HSSFWorkbook wb = null;
		int key=0;
		String name="";
		double price=0;
		Date data = new Date();
		try {
			byte [] byteArr=uploadedFile.getBytes();
			in = new ByteArrayInputStream(byteArr);

			wb = new HSSFWorkbook(in);
			Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> it = sheet.iterator();
			while (it.hasNext()) {
				Row row = it.next();
				key = (int)row.getCell(0).getNumericCellValue();
				name = row.getCell(1).getStringCellValue();
				price = row.getCell(2).getNumericCellValue();
				data = row.getCell(3).getDateCellValue();
				dataAdd(em, key, name, price, data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "uploadSuccess";

	}

	private static void dataAdd(EntityManager em, int key, String name, double price, Date date) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ListData hobbit = new ListData();
		hobbit.setName(name);
		hobbit.setPrice(price);
		hobbit.setKey(key);
		hobbit.setDate(date);
		em.persist(hobbit);
		tx.commit();
	}

}
