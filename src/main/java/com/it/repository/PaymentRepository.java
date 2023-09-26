package com.it.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.entity.PaymentEntity;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

	@Query("SELECT SUM(f.totalPrice) FROM PaymentEntity f ")
	Integer total();
	
	@Query("SELECT SUM(f.guestQty) FROM PaymentEntity f ")
	Integer totalguest();
	 
	public PaymentEntity findByOrdersId(Integer ordersId);
//	@Query("SELECT f FROM PaymentEntity f WHERE f.tableName = :tableName ORDER BY f.paymentDate DESC  ")
//	PaymentEntity findByTableName(@Param("tableName") String tableName);
	
	Page<PaymentEntity> findByTableNameOrderByPaymentDateDesc(String tableName, Pageable pageable);
	@Query(value = "SELECT f FROM PaymentEntity f WHERE date(f.paymentDate) BETWEEN STR_TO_DATE(:dateFormStr,'%Y-%m-%d')AND STR_TO_DATE(:dateToStr,'%Y-%m-%d') ")
	List<PaymentEntity> findPaymentByDateToReport(@Param("dateFormStr")String dateFormStr,@Param("dateFormStr")String dateToStr); 
}
