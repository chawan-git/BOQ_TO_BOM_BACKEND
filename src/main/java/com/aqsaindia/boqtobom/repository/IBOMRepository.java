package com.aqsaindia.boqtobom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.BOMTable;

@Repository
public interface IBOMRepository extends JpaRepository<BOMTable, Integer> {

	@Query("SELECT BOM FROM BOMTable BOM WHERE BOM.BOMId = ?1")
	public BOMTable findByBOMId(String BOMId);

}
