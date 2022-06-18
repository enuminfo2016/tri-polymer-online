package com.enuminfo.cloud.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Catalog;

@Repository
public interface ICatalogRepository extends PagingAndSortingRepository<Catalog, Long> {
	Catalog findByStartDateAndEndDate(Date startDate, Date endDate);
	List<Catalog> findByStatus(Boolean status);
}
