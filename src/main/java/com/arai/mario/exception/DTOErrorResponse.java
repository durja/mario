package com.arai.mario.exception;

public class DTOErrorResponse {
	private int status;
	private long timestamp;
	private String message;
	
	public DTOErrorResponse(Throwable e, int status) {
		this.status = status;
		this.timestamp = System.currentTimeMillis();
		this.message = e.getMessage();
		
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
