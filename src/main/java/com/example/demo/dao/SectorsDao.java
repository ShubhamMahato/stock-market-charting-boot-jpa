package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Sectors;
@Repository
public interface SectorsDao extends JpaRepository<Sectors, Integer>
{
	public Sectors findByCompanySectorName(String companySectorName);
}
