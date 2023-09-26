package com.it.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.it.entity.UploadEntity;
import com.it.model.UploadDto;
import com.it.repository.UploadRepository;

@Service
public class UploadService {

	@Autowired 
	private UploadRepository uploadrepo;
	
	public List<UploadDto> getAll(){
		List<UploadEntity> uploaden = uploadrepo.findAll();
		List<UploadDto> uploaddto = null;
		if(uploaden != null) {
			uploaddto = new ArrayList<>();
			for(UploadEntity uploadojb : uploaden) {
				UploadDto uploads = new UploadDto();
				uploads.setId(uploadojb.getId());
				uploads.setImagePath(uploadojb.getImagePath());
				uploads.setImageDate(uploadojb.getImageDate());
				uploaddto.add(uploads);
	}
	}return uploaddto;
	}
	public UploadEntity save(UploadDto request) throws IOException {
		MultipartFile file = request.getFile();
		long maxFileSize = 20 * 1024 * 1024;
		long fileSize = file.getSize();
		
		if(fileSize > maxFileSize) {
			  throw new IllegalArgumentException("ไฟล์มีขนาดใหญ่เกินกว่า 20 MB");
		}
		String filename = file.getOriginalFilename();
		String filepath = "D:\\ProjectFontend\\fontendproject\\src\\assets\\image/"+filename;
		String finalpath = "\\assets\\image/"+filename;
		Path pathfile = Path.of(filepath);
		Files.copy(file.getInputStream(), pathfile, StandardCopyOption.REPLACE_EXISTING);
		UploadEntity uploaden = new UploadEntity();
		uploaden.setImagePath(finalpath);
		uploaden.setImageDate(new Date());
		return	uploadrepo.save(uploaden);
     }
}
