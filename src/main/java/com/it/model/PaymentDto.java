package com.it.model;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PaymentDto {

	private Integer paymentId;
	private String tableName;
	private Integer guestQty;
	private Integer promotion;
	private Integer totalPrice;
	private String slipImage;
	private String paymentType;
	private Date paymentDate;
	private Integer paymentStatus;
	private MultipartFile file;
	private Integer ordersId;
//	List<ReportDto> reportdetail ;
}
