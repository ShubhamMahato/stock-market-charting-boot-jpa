package com.example.demo.dao;



import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.StockPriceDetail;

public interface StockPriceDao extends JpaRepository<StockPriceDetail,Integer>
{
	public StockPriceDetail findByCompanyCode(StockPriceDetail stockprice);
	
	
	
	 public List<StockPriceDetail> getAllEmployeesByDeptId(Date startDate,Date endDate);
	
}