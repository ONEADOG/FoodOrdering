package com.it.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.it.entity.PaymentEntity;
import com.it.model.PaymentDto;
import com.it.repository.PaymentRepository;
import com.it.repository.UserRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentrepo;
	@Autowired
	private ModelMapper mm;
	@Autowired 
	private UserRepository userrepo;

	
	public List<PaymentDto> getAll(){
		List<PaymentEntity> paymenten = paymentrepo.findAll();
		List<PaymentDto> paymentres = null;
		if(paymenten != null ) {
			paymentres = new ArrayList<>();
			for(PaymentEntity paymentojb : paymenten) {
				PaymentDto paymentre = new PaymentDto();
				paymentre.setPaymentId(paymentojb.getPaymentId());
				paymentre.setTableName(paymentojb.getTableName());
				paymentre.setGuestQty(paymentojb.getGuestQty());
				paymentre.setPromotion(paymentojb.getPaymentId());
				paymentre.setTotalPrice(paymentojb.getTotalPrice());
				paymentre.setSlipImage(paymentojb.getSlipImage());
				paymentre.setPaymentDate(paymentojb.getPaymentDate());
				paymentre.setPaymentStatus(paymentojb.getPaymentStatus());
				paymentre.setPaymentType(paymentojb.getPaymentType());
				paymentre.setOrdersId(paymentojb.getOrdersId());
				paymentres.add(paymentre);
			}
		}return paymentres;
		
	}
	
	public PaymentDto getById(Integer paymentId) {
		Optional<PaymentEntity> paymenten = paymentrepo.findById(paymentId);
		PaymentDto paymentres = null;
		
		if(paymenten.isPresent()) {
			PaymentEntity paymente = paymenten.get(); 
			paymentres = new PaymentDto();
			paymentres.setPaymentId(paymente.getPaymentId());
			paymentres.setTableName(paymente.getTableName());
			paymentres.setGuestQty(paymente.getGuestQty());
			paymentres.setPromotion(paymente.getPromotion());
			paymentres.setTotalPrice(paymente.getTotalPrice());
			paymentres.setSlipImage(paymente.getSlipImage());
			paymentres.setPaymentDate(paymente.getPaymentDate());
			paymentres.setPaymentType(paymente.getPaymentType());
			paymentres.setPaymentStatus(paymente.getPaymentStatus());
			paymentres.setOrdersId(paymente.getOrdersId());
		}return paymentres;
	}
	
	public PaymentEntity save(PaymentDto request) throws IOException {
		PaymentEntity paymenten = new PaymentEntity();
		MultipartFile file = request.getFile();
		if(request != null) {
			
			paymenten.setTableName(request.getTableName());
			paymenten.setGuestQty(request.getGuestQty());
			paymenten.setPromotion(request.getPromotion());
			paymenten.setTotalPrice(request.getTotalPrice());
			paymenten.setPaymentType(request.getPaymentType());
			paymenten.setPaymentDate(new Date());
			paymenten.setPaymentStatus(1);
			paymenten.setOrdersId(request.getOrdersId());
			if(file != null && !file.isEmpty()) {
			
			String filename = file.getOriginalFilename();
			String filepath = "D:\\ProjectFontend\\fontendproject\\src\\assets\\image\\Slip/" + filename;
			String finalpath = "assets"+"/image/Slip/"+filename;
			Path path = Path.of(filepath);
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		
			paymenten.setSlipImage(finalpath);
		}
		}return paymentrepo.save(paymenten);
	}
	
public void update(Integer paymentId,PaymentDto request) throws IOException  {
	Optional<PaymentEntity > payen = paymentrepo.findById(paymentId);
	MultipartFile file = request.getFile();
	if(payen.isPresent()) {
	PaymentEntity	paye = payen.get();
	if(request != null) {
		paye.setTableName(request.getTableName());
		paye.setGuestQty(request.getGuestQty());
		paye.setPromotion(request.getPromotion());
		paye.setTotalPrice(request.getTotalPrice());
		paye.setPaymentStatus(request.getPaymentStatus());
		paye.setPaymentType(request.getPaymentType());
		if(file != null && !file.isEmpty()) {
		String filename = file.getOriginalFilename();
		String filepath = "D:\\saintrow/" + filename;
		Path path = Path.of(filepath);
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		paye.setSlipImage(filepath);
		}
	} paymentrepo.save(paye);
	}	
}
   public void deleteById(Integer paymentId) {
	   paymentrepo.deleteById(paymentId);
   }
   
   public PaymentDto getByTableName(String tableName) {
	   PaymentEntity paymenten = paymentrepo.findByTableNameOrderByPaymentDateDesc(tableName,PageRequest.of(0, 1)).getContent().get(0);
	   PaymentDto paymentdto = null;
	   if(paymenten != null) {
		   paymentdto = new PaymentDto();
		   paymentdto.setPaymentId(paymenten.getPaymentId());
		   paymentdto.setTableName(paymenten.getTableName());
		   paymentdto.setGuestQty(paymenten.getGuestQty());
		   paymentdto.setPromotion(paymenten.getPromotion());
		   paymentdto.setTotalPrice(paymenten.getTotalPrice());
		   paymentdto.setSlipImage(paymenten.getSlipImage());
		   paymentdto.setPaymentType(paymenten.getPaymentType());
		   paymentdto.setPaymentStatus(paymenten.getPaymentStatus());
		   paymentdto.setPaymentDate(paymenten.getPaymentDate());
		   
	   }return paymentdto;
	   
   }
   
   public List<PaymentDto> findByDate(String dateFromStr,String dateToStr){
	   List<PaymentEntity> paymenten = paymentrepo.findPaymentByDateToReport(dateFromStr, dateToStr);
	   List<PaymentDto> paymentdto = null;
	   if(CollectionUtils.isEmpty(paymenten)) {
		  paymentdto = new ArrayList<>();
		  for(PaymentEntity paymentojb : paymenten) {
			  PaymentDto paymentdtos = new PaymentDto();
			  paymentdtos.setPaymentDate(paymentojb.getPaymentDate());
			  paymentdtos.setTableName(paymentojb.getTableName());
			  paymentdtos.setGuestQty(paymentojb.getGuestQty());
			  paymentdtos.setPromotion(paymentojb.getPromotion());
			  paymentdtos.setTotalPrice(paymentojb.getTotalPrice());
			  paymentdtos.setPaymentType(paymentojb.getPaymentType());
			  paymentdtos.setPaymentStatus(paymentojb.getPaymentStatus());
//			  if(paymentojb.getPaymentStatus() != null) {
//				if(paymentojb.getPaymentStatus() == 1) {
//					paymentdtos.setPaymentStatus("สำเร็จ");
//				}
//			  }
			  paymentdto.add(paymentdtos);
		  }
	   }return paymentdto;
   }
   
//   public PaymentDto convertToPaymentDto(PaymentEntity paymententi) {
//	   PaymentDto paymentdto = mm.map(paymententi, PaymentDto.class);
//   }
   
   public PaymentDto getByOrdersId(Integer ordersId) {
	   PaymentEntity paymenten = paymentrepo.findByOrdersId(ordersId);
	   PaymentDto paymentdto = null;
	   if(paymenten != null) {
		   paymentdto = new PaymentDto();
		   paymentdto.setPaymentId(paymenten.getPaymentId());
		   paymentdto.setTableName(paymenten.getTableName());
		   paymentdto.setGuestQty(paymenten.getGuestQty());
		   paymentdto.setPromotion(paymenten.getPromotion());
		   paymentdto.setTotalPrice(paymenten.getTotalPrice());
		   paymentdto.setSlipImage(paymenten.getSlipImage());
		   paymentdto.setPaymentType(paymenten.getPaymentType());
		   paymentdto.setPaymentStatus(paymenten.getPaymentStatus());
		   paymentdto.setPaymentDate(paymenten.getPaymentDate());
		   
	   }return paymentdto;
	   
   }
}
