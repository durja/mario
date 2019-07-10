package com.arai.mario.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class CustomErrorResponse {
	private int status;
	private long timestamp;
	private String message;
	
	public CustomErrorResponse(Throwable e, int status) {
		this.status = status;
		this.timestamp = System.currentTimeMillis();
		this.message = ExceptionUtils.getRootCauseMessage(e);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
