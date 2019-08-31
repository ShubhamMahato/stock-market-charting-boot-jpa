package com.example.demo.controller;

import java.util.Date;
import java.io.IOException;
import java.sql.Time;
import java.text.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Company;
import com.example.demo.entity.StockPriceDetail;
import com.example.demo.services.AdminService;
import com.example.demo.services.CompanyService;
import com.example.demo.services.EventsService;
import com.example.demo.services.SectorsServices;
import com.example.demo.services.StockService;




import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Controller
public class AdminController 
{
	@Autowired(required=true)
	private AdminService adminservice; 
	@Autowired
	private SectorsServices sectorservice;
	
	@Autowired         
	private CompanyService companyservice;

	@Autowired
	private StockService stockservice;
	
	@Autowired
	EventsService eventsService;
	
	
	static ArrayList<String> dublicateDataList = new ArrayList<String>();
	static Date minDate,maxDate,refDate;
	static int count=0,noOfRecords=0;
	static ArrayList<Date> missingDates = new ArrayList<>(); 
	
	@RequestMapping("/openPage")
	public String demo(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute("admin",admin);
		return "AdminLogin";
		
	}
	
	@RequestMapping(value="adminlogin", method = RequestMethod.GET)
	public ModelAndView loginAuth(Model model,@RequestParam("adminUserName") String adminUserName, @RequestParam("passwordAdmin") String passwordAdmin,Model  modell) 
	{  
		if(adminservice.findByAdminUserNameAndPasswordAdmin(adminUserName,passwordAdmin)!=null)
		{
			ModelAndView mc=new ModelAndView();
			mc.addObject("company",new Company());
			List<Company>list=companyservice.findAll();
			String s=stockservice.StockList();
			mc.addObject("StringList",s);

			String s1=sectorservice.SectorsList();
			mc.addObject("StringList1",s1);
			modell.addAttribute("list",list);
			mc.setViewName("ManageCompany");
			return mc; 
		}
		else
		{
			ModelAndView mc=new ModelAndView();
			model.addAttribute("admin",new Admin());
			model.addAttribute("msg","Invalid Login Credentials");
			mc.setViewName("AdminLogin");
			return mc;
		}
		
	}
	
	@RequestMapping(value="importdata")
	public ModelAndView openImportPage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ImportData");
		return mv;
	}
	
	

	@RequestMapping("/ab")
	public void importData(@RequestParam("file") MultipartFile fileAddress) throws IOException, InvalidFormatException {
		System.out.println("Mubarka");
		//Checking the extensions of file for.xlsx)
		if (fileAddress.getOriginalFilename().endsWith(".xlsx")) {
			XSSFWorkbook workbook = new XSSFWorkbook(fileAddress.getInputStream());
			XSSFSheet worksheet = workbook.getSheetAt(0);
			//Checking the column names(companycode,StockExchange,currentprice,date,time are allowed respectively) 
			if(!checkFormat(worksheet.getRow(0),null,1)) {
				System.out.println("Worksheet not correct");
				workbook.close();
				return;
			}else {
				System.out.println("Correct file");
			}
			//Reading the excel file
			int i = 1;
			while (i <= worksheet.getLastRowNum()) {
				XSSFRow row = worksheet.getRow(i++);
				StockPriceDetail stockPriceDetailData = setStockObject(row, null, 1);
				if(stockPriceDetailData!=null) {
					stockPriceDetailData.setCompany(companyservice.checkCompany(stockPriceDetailData.getCompanyCode()));
					eventsService.importData(stockPriceDetailData);
				}
			}
			//Closing the workbook stream
			workbook.close();

		} else if (fileAddress.getOriginalFilename().endsWith(".xls")				//Checking the extensions of file for.xlsx)
				&& !fileAddress.getOriginalFilename().endsWith(".xlsx")) {
			HSSFWorkbook workbook = new HSSFWorkbook(fileAddress.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);

			//Checking the column names(companycode,StockExchange,currentprice,date,time are allowed respectively) 
			if(!checkFormat(null,worksheet.getRow(0),2)) {
				System.out.println("Worksheet not correct");
				workbook.close();
				return;
			}else {
				System.out.println("Correct file");
			}

			//Reading the excel file
			int i = 1;
			while (i <= worksheet.getLastRowNum()) {
				HSSFRow row = worksheet.getRow(i++);
				StockPriceDetail stockPriceDetailData = setStockObject(null, row, 2);
				if(stockPriceDetailData!=null)
				eventsService.importData(stockPriceDetailData);
			}
			//Closing the workbook stream
			workbook.close();
		}

  System.out.println(minDate+" ******* "+maxDate+"********"+noOfRecords);
	}

	
	// Setting the object for stock price details model class
	public StockPriceDetail setStockObject(XSSFRow XSSFrow, HSSFRow HSSFrow, int index) {
		StockPriceDetail stockPriceDetails = new StockPriceDetail();

		if (index == 1){
			//String objectCompanyCode = XSSFrow.getCell(0).getStringCellValue();
			int objectStockExchange = (int) XSSFrow.getCell(1).getNumericCellValue();
			float objectCurrentPrice = (float) XSSFrow.getCell(2).getNumericCellValue();
			Date objectDate = XSSFrow.getCell(3).getDateCellValue();
			//double objectTime=XSSFrow.getCell(4).getNumericCellValue();
			
			
			
			 DataFormatter formatter0 = new DataFormatter(); 
			 Cell cell0 = XSSFrow.getCell(0);
			 String ss0 = formatter0.formatCellValue(cell0); 
			
			//////////time column//////////////////////
			 DataFormatter formatter = new DataFormatter(); 
			 Cell cell = XSSFrow.getCell(4);
			 String ss = formatter.formatCellValue(cell); 
			 Time t=java.sql.Time.valueOf(ss);
			 
			 
			 
			  
			
			String data = dateToString(objectDate)+ss0+ss;
			//System.out.println(data+"hhh");
			if (checkDublicateData(dublicateDataList, data)&&(checkCompany(ss0)))
			{
				
				dateRange(objectDate);
				stockPriceDetails.setCompanyCode(ss0);
				stockPriceDetails.setStockExchange(objectStockExchange);
				stockPriceDetails.setCurrentPrice(objectCurrentPrice);
				stockPriceDetails.setDate(objectDate);
				stockPriceDetails.setTime(t);
			}else {
				System.out.println("null xslx object");
				return null;
			}
		} else if (index == 2) {
			
			//String objectCompanyCode = HSSFrow.getCell(0).getStringCellValue();
			int objectStockExchange = (int) HSSFrow.getCell(1).getNumericCellValue();
			float objectCurrentPrice = (float) HSSFrow.getCell(2).getNumericCellValue();
			Date objectDate = HSSFrow.getCell(3).getDateCellValue();
			//String objectTime=HSSFrow.getCell(4).getStringCellValue();
			
			
			
			 DataFormatter formatter0 = new DataFormatter(); 
			 Cell cell0 = XSSFrow.getCell(0);
			 String ss0 = formatter0.formatCellValue(cell0); 
			
			//////////time column//////////////////////
			 DataFormatter formatter = new DataFormatter(); 
			 Cell cell = XSSFrow.getCell(4);
			 String ss = formatter.formatCellValue(cell); 
			 Time t=java.sql.Time.valueOf(ss);
			
			String data = dateToString(objectDate)+ss0;
			if (checkDublicateData(dublicateDataList, data)&&checkCompany(ss0))
			{
				dateRange(objectDate);
				stockPriceDetails.setCompanyCode(ss0);
				stockPriceDetails.setStockExchange(objectStockExchange);
				stockPriceDetails.setCurrentPrice(objectCurrentPrice);
				stockPriceDetails.setDate(objectDate);
				
				stockPriceDetails.setTime(t);	
			}else {
				return null;
			}

		}
		return stockPriceDetails;
	}




	//Function for Checking the format
	public boolean checkFormat(XSSFRow XSSFrow,HSSFRow HSSFrow,int index) {

		String columnName="";
		if(index==1) { 
			for(int i =0;i<5;i++){
				columnName = columnName+ XSSFrow.getCell(i).getStringCellValue().trim();
			}
			if(columnName.equalsIgnoreCase("companycodestockexchangecurrentpricedatetime")) 
				return true;
		}else {
			for(int i =0;i<5;i++){
				columnName = columnName+ HSSFrow.getCell(i).getStringCellValue().trim();
			}
			if(columnName.equalsIgnoreCase("companycodestockexchangecurrentpricedatetime")) {
				return true;
			}
		}
		return false;
	}

	public boolean checkCompany(String companyCode) {
		return companyservice.checkCompany(companyCode)!=null;
	}


	
	public static boolean checkDublicateData(ArrayList<String> dublicateDataList,String data) {
		if(dublicateDataList.contains(data)) {
			return false;
			}
		else
			dublicateDataList.add(data);
		return true;

	}

	public String dateToString(Date date) { 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dateFormat.format(date); 
		return strDate;
	}
	
	public void dateRange(Date objectDate) {
		noOfRecords++;
		if(count==0) {
			minDate = objectDate;
			maxDate=objectDate;
			count++;
		}
		if(count==1) {
			refDate=objectDate;
			count++;
		}
		
		if(minDate.compareTo(objectDate)>0) {
			System.out.println("date query");
			minDate = objectDate;
		}
		if(maxDate.compareTo(objectDate)<0) {
			maxDate=objectDate;
		}
		
		/*
		 * if(count!=1) { Calendar c = Calendar.getInstance(); c.setTime(refDate);
		 * c.add(Calendar.DATE, 1); while(objectDate.compareTo(c.getTime())!=0) {
		 * 
		 * }
		 * 
		 * }
		 */
		 
		
	}
	
	
}
