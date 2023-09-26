 package com.it.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.it.entity.TestregisEntity;
import com.it.model.TestregisDto;

import com.it.repository.TestregisterRepository;

@Service
public class TestregisService {

	@Autowired
	private TestregisterRepository testrepo;
	
	public List<TestregisDto> getAll(){
		List<TestregisEntity> testre = testrepo.findAll();
		List<TestregisDto> testres = null;
		
		if(testre != null) {
			testres = new ArrayList<>();
			for(TestregisEntity testojb : testre) {
				TestregisDto tests = new TestregisDto();
				tests.setTestId(testojb.getTestId());
				tests.setTestImage(testojb.getTestImage());
				tests.setTestAge(testojb.getTestAge());
				tests.setTestName(testojb.getTestName());
				testres.add(tests);
				
				
			}
		}return testres;
	}
	
	public TestregisEntity register(TestregisDto request) throws IOException {
		TestregisEntity test = new TestregisEntity();
		test.setTestName(request.getTestName());
		test.setTestAge(request.getTestAge());
		
		MultipartFile file = request.getFile();
		if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String filePath = "D:\\saintrow/" + fileName;            
            Path pathfile = Path.of(filePath);
            Files.copy(file.getInputStream(), pathfile, StandardCopyOption.REPLACE_EXISTING);
            // Save image file to the desired location
            // ...
            
            test.setTestImage(filePath);
        }
        
		return testrepo.save(test);
	}
	
	public void update(Integer testId,TestregisDto request) throws IOException{
		Optional<TestregisEntity> testen = testrepo.findById(testId);
		MultipartFile file = request.getFile();
		if(testen.isPresent()) {
			TestregisEntity teste = testen.get();
			if(request != null) {
				if (file != null && !file.isEmpty()) {
				String filename = file.getOriginalFilename();
				String filepath = "D:\\saintrow/" + filename;
				
				Path pathfile = Path.of(filepath);
				Files.copy(file.getInputStream(), pathfile, StandardCopyOption.REPLACE_EXISTING);
				
				teste.setTestImage(filepath);
				}
				teste.setTestAge(teste.getTestAge() -  request.getTestAge());
				teste.setTestName(request.getTestName());
				
				testrepo.save(teste);
			}
		}
	}
}
