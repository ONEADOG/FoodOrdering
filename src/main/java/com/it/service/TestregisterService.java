package com.it.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.it.entity.TestnumberEntity;
import com.it.entity.UploadEntity;
import com.it.model.TestDto;

import com.it.model.UploadDto;
import com.it.repository.TestRepository;
import com.it.repository.UploadRepository;

@Service
public class TestregisterService {
//@Autowired
//private UploadRepository uploadrepo;
//@Autowired
//private TestRepository testrepo;
//
//
//public void s(TestDto request) {
//	
//}
//public UploadEntity save(UploadDto request,TestDto testdto) throws IOException {
//	if(request != null) {
//	MultipartFile file = request.getFile();
//	String filename = file.getOriginalFilename();
//	String filepath = "C:\\Users\\Lenovo\\Downloads\\project (2)\\projectBF\\src\\UserImage/"+filename;
//	
//	Path pathfile = Path.of(filepath+filename);
//	Files.copy(file.getInputStream(), pathfile, StandardCopyOption.REPLACE_EXISTING);
//	UploadEntity uploaden = new UploadEntity();
//	TestnumberEntity testen = new TestnumberEntity();
//	uploaden.setImagePath(filepath);
//	uploaden.setImageDate(new Date());
//	uploaden = uploadrepo.save(uploaden);
//	if(testdto != null) {
//	testen.setNames(uploaden.getImagePath());
//	testen.setNumber(testdto.getNumber());
//	 testrepo.save(testen);}
//	} return null;
// }
//}
}