/**
 * 
 */
package com.springcloud.microservice.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.microservice.data.model.UserOrderedPayment;

/**
 * @author SIVA KUMAR
 */
@Repository
public interface IUserOrderedPaymentRepository extends PagingAndSortingRepository<UserOrderedPayment, Long> {

}
