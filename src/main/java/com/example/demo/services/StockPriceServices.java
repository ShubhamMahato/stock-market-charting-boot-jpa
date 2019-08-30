package com.example.demo.services;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.StockPriceDao;
import com.example.demo.entity.Company;
import com.example.demo.entity.Sectors;
import com.example.demo.entity.StockPriceDetail;

@Service
public class StockPriceServices 
{
	@Autowired
	private StockPriceDao stockpricedao;
	
	@Autowired
	private SectorsServices sectorsservices;
	
	@Autowired
	private CompanyService companyServices;
	
	@Autowired         
	private StockPriceServices stockpriceservice;
	
	public List<StockPriceDetail> findAll()
	{
		return stockpricedao.findAll();
	}
	
	
	
	
	
	//////////////////////////get price////////////////////////
	public List<Float>getPriceList()
	{
		List<Float>pricelist=new ArrayList<Float>();
		List<StockPriceDetail>al=stockpricedao.findAll();
		for(int i=0;i<al.size();i++)
		{
			pricelist.add(al.get(i).getCurrentPrice());
		}
		return pricelist;
	}
	
	////////////////////////getdate//////////////////////////
	public List<Date>getDateList()
	{
		List<Date>datelist=new ArrayList<Date>();
		List<StockPriceDetail>al=stockpricedao.findAll();
		for(int i=0;i<al.size();i++)
		{
			datelist.add(al.get(i).getDate());
		}
		return datelist;
	}
	
	//////////////////////////gettime//////////////////////////
	public List<Time>getTimeList()
	{
		 List<Time>timelist=new ArrayList<Time>();
		List<StockPriceDetail>al=stockpricedao.findAll();
		for(int i=0;i<al.size();i++)
		{
					
			timelist.add(al.get(i).getTime());
		}
		return timelist;
	}
	
	
	
	public List<List<Map<Object, Object>>> getFullCanvasjsChartData() {
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		 Map<Object,Object> map = null;
		 List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		 List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		
		 List<Float>price=getPriceList();
		 List<Date>date=getDateList();
		 List<Time>timee=getTimeList();
		
		
		for(int i=0;i<date.size();i++)
		{
		   long unixTime = 0;
	        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30")); 
	        try {
	        	DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        	String output = outputFormatter.format(date.get(i)); 
	        	String out = output.substring(0, 10); 
	          
	           unixTime = dateFormat.parse(out+" "+timee.get(i)).getTime();
	           // unixTime = unixTime / 1000;
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        map = new HashMap<Object,Object>(); 
			map.put("x", unixTime); 
			map.put("y", price.get(i));
			dataPoints1.add(map);
			
		}
		list.add(dataPoints1);
		return list;
	}
	

	public  List<List<Map<Object, Object>>> findByDate( String companycode, String startdate, String enddate)
	{
		  
		
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		 String[] companyCode = companycode.split(",");
		 for(int j=0;j<companyCode.length;j++)
		 {
			 List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		  List<Object[]> result = stockpricedao.getbydate(companyCode[j], startdate, enddate);
		
		  Map<Object,Object> chart = null;
	       Map<Long,Object> map = null;
	     
	      
	       System.out.println("result size         "+result.size());
	      if(result.size()>0)
	      {
	    	  if(result != null && !result.isEmpty()){
		          map = new TreeMap<Long,Object>();
		          for (Object[] object : result) {
		        	  long unixTime = 0;
				        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30")); 
				        try {
				        	DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
				        	String output = outputFormatter.format(object[1]); 
				        	String out = output.substring(0, 10); 
				           unixTime = dateFormat.parse(out+" "+(Time)object[2]).getTime();
				            //unixTime = unixTime / 1000;
				        } catch (ParseException e) {
				            e.printStackTrace();
				        }
		        	  if(map.containsKey(unixTime))
		        	  {
		        		  System.out.println("contains    "+unixTime);
		        		  unixTime=unixTime+1;
		        	  }
		            map.put(unixTime,object[0]);
		          }
		       }
	       ArrayList<Long>x=new ArrayList<Long>();
	       ArrayList<Object>y=new ArrayList<Object>();
	       ArrayList<Object>time=new ArrayList<Object>();
	       
	    
	       
	       for(Long i: map.keySet())
	       {
	           x.add(i);
	       }
	       for(Object i: map.values())
	       {
	           y.add(i);
	       }
	       
	       if(result != null && !result.isEmpty()){
		          map = new TreeMap<Long,Object>();
		          for (Object[] object : result) {
		        	  long unixTime = 0;
				        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30")); 
				        try {
				        	DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
				        	String output = outputFormatter.format(object[1]); 
				        	String out = output.substring(0, 10); 
				           unixTime = dateFormat.parse(out+" "+(Time)object[2]).getTime();
				            //unixTime = unixTime / 1000;
				        } catch (ParseException e) {
				            e.printStackTrace();
				        }
				        if(map.containsKey(unixTime))
			        	  {
			        		  unixTime=unixTime+1;
			        	  }
		        	  
		            map.put(unixTime,object[2]);
		          }
		       }
	       
	       for(Object i: map.values())
	       {
	           time.add(i);
	       }
	       
	       for(int i=0;i<x.size();i++)
	       {
	    	   
	    	   
		        chart = new HashMap<Object,Object>(); 
		        chart.put("x", x.get(i)); 
		        chart.put("y", y.get(i));
				dataPoints1.add(chart);
	       }
	       list.add(dataPoints1);
	  	 
		 }
	      
	      
		 }
		  
		 System.out.println(list);
	      
	       return list;
	}
	
	public List<StockPriceDetail> findByCompanyCode(String compc)
	{
		return stockpricedao.findByCompanyCode(compc);
	}
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////
	
	
	
	
	
	public List<List<Map<Object, Object>>> getSectorCanvasjsChartData(String ssectors,String startdate, String enddate) {
		
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		 Map<Object,Object> map = null;
		 List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		
		
		
		 String[] secc = ssectors.split(",");
		 for(int k=0;k<secc.length;k++)
		 {
			 List<Float>price=new ArrayList<Float>();
			 List<Time>time=new ArrayList<Time>();
			 List<Date>date=new ArrayList<Date>();
			 List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		 if(sectorsservices.findByCompanySectorName(secc[k])!=null)
		 {
			
			 
			 Sectors sec=sectorsservices.findByCompanySectorName(secc[k]);
			 List<Company> comp=companyServices.findBySector(sec);
			
			 for(int i=0;i<comp.size();i++)
			 {
				 
				 String companycode=comp.get(i).getCompanyCode();
				 System.out.println(companycode);
				 List<StockPriceDetail> stockp=stockpriceservice.findByCompanyCode(companycode);
				 for(int j=0;j<stockp.size();j++)
				 {
					 	price.add(stockp.get(j).getCurrentPrice());
					 	time.add(stockp.get(j).getTime());
					 	date.add(stockp.get(j).getDate());
				 }
			 }
		
			
		}
		
		
	
		
		
		
		for(int i=0;i<date.size();i++)
		{
		   long unixTime = 0;
	        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30")); 
	        try {
	        	DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        	String output = outputFormatter.format(date.get(i)); 
	        	String out = output.substring(0, 10); 
	           unixTime = dateFormat.parse(out+" "+time.get(i)).getTime();
	           // unixTime = unixTime / 1000;
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        map = new HashMap<Object,Object>(); 
			map.put("x", unixTime); 
			map.put("y", price.get(i));
			dataPoints1.add(map);
			
			
		}
		list.add(dataPoints1);
		 }
		 
		return list;
	}
	
	
	////////////////////////////////////////////////

	public List<List<Map<Object, Object>>> getDataByCompanyAndSector(String Company,String ssectors,String startdate, String enddate) {
		
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		 Map<Object,Object> map = null;
		 List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		 List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		 Sectors sec=sectorsservices.findByCompanySectorName(ssectors);
		List<Float>price=new ArrayList<Float>();
		 List<Time>time=new ArrayList<Time>();
		 List<Date>date=new ArrayList<Date>();
		 if(companyServices.findByCompanyCodeAndSector(Company, sec)!=null)
		 {
			
			 Company comp=companyServices.findByCompanyCodeAndSector(Company, sec);
			 
				 String companycode=comp.getCompanyCode();
				 List<StockPriceDetail> stockp=stockpriceservice.findByCompanyCode(companycode);
				 for(int j=0;j<stockp.size();j++)
				 {
					 	price.add(stockp.get(j).getCurrentPrice());
					 	time.add(stockp.get(j).getTime());
					 	date.add(stockp.get(j).getDate());
				 }
			 
		
			
		}
		
		
	
		
		
		
		for(int i=0;i<date.size();i++)
		{
		   long unixTime = 0;
	        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30")); 
	        try {
	        	DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        	String output = outputFormatter.format(date.get(i)); 
	        	String out = output.substring(0, 10); 
	           unixTime = dateFormat.parse(out+" "+time.get(i)).getTime();
	           // unixTime = unixTime / 1000;
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        map = new HashMap<Object,Object>(); 
			map.put("x", unixTime); 
			map.put("y", price.get(i));
			dataPoints1.add(map);
			
		}
		 
		list.add(dataPoints1);
		return list;
	}
	
}



