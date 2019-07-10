package com.arai.mario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arai.mario.dao.IGenericDAO;
import com.arai.mario.dao.ISourceDAO;
import com.arai.mario.dto.SourceDTO;
import com.arai.mario.entity.Source;

import javassist.bytecode.stackmap.TypeData.ClassName;

@Service
@Transactional
public class SourceService implements ISourceService {
	

	
	@Autowired
	ISourceDAO sourceDAO;
	
	IGenericDAO<Source> genericDAO;
	
	@Autowired
	public void setDAO(IGenericDAO<Source> daoToSet) {
		genericDAO = daoToSet;
		genericDAO.setClazz(Source.class);
	}

	@Override
	public List<SourceDTO> getSources() {

		List<Source> sources = sourceDAO.getSources();
		
		if (sources.size() > 0) {
			return sources
					.stream()
					.map(source -> convert(source))
					.collect(Collectors.toList());
		} else {
			return new ArrayList<>();
		}
	}
	
	private SourceDTO convert(Source source) {
		SourceDTO dto = new SourceDTO();
		BeanUtils.copyProperties(source, dto);
		return dto;
	}
	
	private Source convert(SourceDTO dto) {
		Source entity = new Source();
		dto.setId(0);
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public void create(SourceDTO dto) {
		Source source = convert(dto);
		genericDAO.create(source);
	}
}
