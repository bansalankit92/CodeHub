package com.ankitbansal.output;

import java.util.List;

import com.ankitbansal.model.SubmissionsModel;
import com.ankitbansal.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class SubmissionsResponseBody {
	@JsonView(Views.Public.class)
	String msg;
	
	@JsonView(Views.Public.class)
	String code;
	
	@JsonView(Views.Public.class)
	List<SubmissionsModel> result;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<SubmissionsModel> getResult() {
		return result;
	}

	public void setResult(List<SubmissionsModel> result) {
		this.result = result;
	}

}
