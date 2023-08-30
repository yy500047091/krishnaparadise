package com.yogesh.coding.services.Impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.yogesh.coding.services.StorageService;
@Service
public class StorageServiceImpl implements StorageService {

	

	@Value("${disk.upload.basepath}")
	private String BASEPATH; 
	
	@Override
	public String store(MultipartFile file) {
	    String filename = file.getOriginalFilename();
	 

	    // Validate that the required fields in ProductDTO are not null
	    if (filename != null && !filename.isEmpty()) {
	    	   String filePath = BASEPATH + File.separator + filename;

	        try {
	            FileOutputStream out = new FileOutputStream(filePath);
	            FileCopyUtils.copy(file.getInputStream(), out);
	            return filename;
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        	throw new RuntimeException(e);
	            // Handle the exception appropriately, e.g., log the error or throw a custom exception
	        }

	       
	    } else {
	        // Handle the case where the filename is null or empty
	        throw new IllegalArgumentException("Invalid file name");
	    }
	}


	@Override
	public FileSystemResource load(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		System.out.println("Loading file:" + fileName );
		if(filePath.exists())
			return new FileSystemResource(filePath);
		return null;
	}

	@Override
	public List<String> loadAll() {
		File dirPath = new File(BASEPATH);
		return Stream.of(dirPath.list()).collect(Collectors.toList());
	}

	@Override
	public void delete(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		if(filePath.exists())
			filePath.delete();
	}

}
