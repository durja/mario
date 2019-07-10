package com.arai.mario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arai.mario.dto.SourceDTO;
import com.arai.mario.dto.SourcesDTO;
import com.arai.mario.exception.DTOValidationException;
import com.arai.mario.service.ISourceService;

@RestController
@RequestMapping("/sources")
public class SourceController {

	@Autowired
	ISourceService service;
	
	@GetMapping
	public SourcesDTO getSources() {
		SourcesDTO dto = new SourcesDTO();
		dto.setSources(service.getSources());
		dto.setStatus("ok");
		return dto;
	}
	
	@PostMapping
	public void createSource(@RequestBody @Valid SourceDTO dto, BindingResult bindingResult) {
		checkAndHandleBindingResultErrors(bindingResult);
		service.create(dto);
		
	}
	
	private void checkAndHandleBindingResultErrors(BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			StringBuilder exception = new StringBuilder();
			
			bindingResult
				.getFieldErrors()
				.forEach(err -> exception.append(err.getField() + ": " + err.getDefaultMessage() + ", "));
			
			throw new DTOValidationException(exception.toString());	
		}
	}
}
