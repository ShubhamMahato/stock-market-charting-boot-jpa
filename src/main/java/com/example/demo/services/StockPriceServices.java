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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.example.demo.dao.StockPriceDao;
import com.example.demo.entity.StockPriceDetail;

@Service
public class StockPriceServices 
{
	@Autowired
	private StockPriceDao stockpricedao;
	
	
	
	
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
	           unixTime = dateFormat.parse(date.get(i)+" "+timee.get(i)).getTime();
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
	
	
	public Map<Integer,Object> findByDate( String startdate, String enddate)
	{
	
		  List<Object[]> result = stockpricedao.findByDate(startdate, enddate);
	       Map<Integer,Object> map = null;
	       if(result != null && !result.isEmpty()){
	          map = new HashMap<Integer,Object>();
	          for (Object[] object : result) {
	            map.put(((Integer)object[0]),object[1]);
	          }
	       }
	         System.out.println(map);
	         return map;
	}
	
	
	

	
}



