package com.it.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import com.beust.jcommander.Parameters;
import com.google.common.reflect.Parameter;
import com.it.entity.UserEntity;
import com.it.model.PaymentDto;
import com.it.model.ReportDto;
import com.it.repository.PaymentRepository;
import com.it.repository.UserRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;

@Service
public class Reportservice {

	@Autowired
	private UserRepository userrepo;
	
	public String exportReport(String formatReport,Date dateFrom,Date dateTo) throws FileNotFoundException,JRException{
		String path="D:\\testReport";
		List<UserEntity> useren = userrepo.findAll();
		//load file and compile it
		File file = ResourceUtils.getFile("C:\\Users\\Lenovo\\Downloads\\project (2)\\projectBF\\src\\main\\resources\\report\\reportuser.jrxml");
		JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(useren);
		Map<String, Object> parameters=new HashMap<>();
		parameters.put("ceateBy", "Me");
		 parameters.put("dateFrom", dateFrom);
		    parameters.put("dateTo", dateTo);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource);
		if(formatReport.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\reportuser.html");
		}if(formatReport.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\reportuser.pdf");
		}
		return "report generate in path :"+path;
	}
	
	
//	public ByteArrayOutputStream generateReport(String dateFormStr,String dateToStr)throws IOException {
//		log.info("generateReport : Start ::dateFormStr :{},dateTo :{} ", dateFormStr, dateToStr);
//		ByteArrayOutputStream out = null;
//		try {
//			List<PaymentDto> paymentdto = paymentser.findByDate(dateFormStr, dateToStr);
//			if(CollectionUtils.isEmpty(paymentdto)) {
//				List<ReportDto> reportmodel =  
//			}
//		}catch(Exception e){
//			
//		}return null;
//	}
//	
//	private List<ReportDto> convertToReportDto(List<PaymentDto> paymentdto){
//		List<ReportDto> result = new ArrayList<ReportDto>();
//		if(CollectionUtils.isEmpty(paymentdto)) {
//			for(PaymentDto dto : paymentdto) {
//				List<ReportDto> reportdto = dto.getReportdetail().stream().map(d ->{
//					String timeDate = new SimpleDateFormat("dd/mm/yy").format(dto.getPaymentDate());
//					return ReportDto.builder().paymentDate(timeDate)
//				});
//			}
//		}return result;
//	} 
//	String filepath = "C:\\Users\\Lenovo\\Downloads\\project (2)\\projectBF\\src\\main\\resources\\templates\\test.jrxml";
//	Map<String, Object> parameter = new HashMap<>();

}
