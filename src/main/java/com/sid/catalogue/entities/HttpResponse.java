package com.sid.catalogue.entities;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class HttpResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="MM-dd-yyyy hh:mm:ss",timezone = "GMT+1")
	private Date timestamp;
	private int httpStatusCode;
	private HttpStatus httpStatus;
	private String reason;
	//devoloper message - json
	private String message;
	public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
		super();
		this.timestamp = new Date();
		this.httpStatusCode = httpStatusCode;
		this.httpStatus = httpStatus;
		this.reason = reason;
		this.message = message;
	}
	
	
}
