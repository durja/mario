package com.arai.mario.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SourcesDTO {

	private String status;
	private List<SourceDTO> sources;
	
	public SourcesDTO() {}

	public SourcesDTO(String status, List<SourceDTO> sources) {

		this.status = status;
		this.sources = sources;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SourceDTO> getSources() {
		return sources;
	}

	public void setSources(List<SourceDTO> sources) {
		this.sources = sources;
	}
	
	
}
