package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.StockPriceDetail;

public interface StockPriceDao extends JpaRepository<StockPriceDetail,Integer>
{
	public StockPriceDetail findByCompanyCode(StockPriceDetail stockprice);
	
	
	@Query(value="select current_price,date,time from stock_price where company_code=:companyCode and date>:startd and date<:endd order by date asc",nativeQuery = true)
	public List<Object[]> getbydate(@Param("companyCode") String companycode,@Param("startd") String startdate,@Param("endd") String enddate);
	
	//public StockPriceDetail findByCompanyCode(String compc);
	
	public List<StockPriceDetail> findByCompanyCode(String compc);
	
	
}