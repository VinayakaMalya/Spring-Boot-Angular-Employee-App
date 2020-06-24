package com.employee.error;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Vinayaka
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JsonResponse
{
	private String responseMessage;
	
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
