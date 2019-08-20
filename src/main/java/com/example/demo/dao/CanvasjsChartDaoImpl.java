package com.example.demo.dao;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Stock;
@Repository
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
	 private static  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
	static Map<Object,Object> map = null;
	static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
	static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();

	 @Autowired
	    private EntityManager entityManager;
	 
	@SuppressWarnings("unchecked")
	@Transactional
	public List<List<Map<Object, Object>>> getCanvasjsChartData(java.sql.Date date ) {
		
		List<Stock> y=entityManager.createNativeQuery("select stock_price.price from stock_price where stock_price.date<="+"'"+date+"'").getResultList();
		
		List<Stock> dat=entityManager.createNativeQuery("select `stock_price`.`date`from stock_price where stock_price.date<="+"'"+date+"'").getResultList();
		
		List<Stock> tim=entityManager.createNativeQuery("select `stock_price`.`time` from stock_price where stock_price.date<="+"'"+date+"'").getResultList();
		for(int i=0;i<tim.size();i++)
		{
		 long unixTime = 0;
	        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
	        try {
	            unixTime = dateFormat.parse(dat.get(i)+" "+tim.get(i)).getTime();
	            //unixTime = unixTime / 1000;
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        map = new HashMap<Object,Object>(); 
			map.put("x", unixTime); 
			map.put("y", y.get(i));
			dataPoints1.add(map);
			
		}
		list.add(dataPoints1);
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<List<Map<Object, Object>>> getFullCanvasjsChartData() {
		
		List<Stock> y=entityManager.createNativeQuery("select stock_price.price from stock_price ").getResultList();
		//List<Object[]> y=query.getResultList();
		
		List<Stock> dat=entityManager.createNativeQuery("select `stock_price`.`date`from stock_price ").getResultList();
		//List<Object[]>dat=query1.getResultList();
		
		List<Stock> tim=entityManager.createNativeQuery("select `stock_price`.`time` from stock_price ").getResultList();
		//List<Object[]>tim=query2.getResultList();
		for(int i=0;i<tim.size();i++)
		{
		 long unixTime = 0;
	        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30")); 
	        try {
	            unixTime = dateFormat.parse(dat.get(i)+" "+tim.get(i)).getTime();
	            //unixTime = unixTime / 1000;
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        map = new HashMap<Object,Object>(); 
			map.put("x", unixTime); 
			map.put("y", y.get(i));
			dataPoints1.add(map);
			
		}
		list.add(dataPoints1);
		return list;
	}
 
}                   