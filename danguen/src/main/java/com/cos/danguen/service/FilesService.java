package com.cos.danguen.service;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cos.danguen.model.Files;
import com.cos.danguen.repository.FileRepository;


@Service
public class FilesService {
	
	private FileRepository fileRepository;
	
	public FilesService(FileRepository fileRepository) {
		this.fileRepository=fileRepository;
	}
	
	@Transactional
    public Long saveFile(Files file) {
        return fileRepository.save(file).getFno();
    }

    @Transactional
    public Files getFile(Long id) {
        Files file = fileRepository.findById(id).get();

        return file;
    }

}
