package com.arai.mario.service;

import java.util.List;

import com.arai.mario.dto.SourceDTO;

public interface ISourceService {

	public List<SourceDTO> getSources();
	public void create(SourceDTO source);

}