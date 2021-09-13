/**
 * 
 */
package com.springcloud.microservice.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.microservice.data.model.Access;

/**
 * @author SIVA KUMAR
 */
@Repository
public interface IAccessRepository extends PagingAndSortingRepository<Access, Long> {

}
