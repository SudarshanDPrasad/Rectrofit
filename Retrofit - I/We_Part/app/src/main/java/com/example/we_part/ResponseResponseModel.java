package com.example.we_part;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResponseResponseModel implements Serializable {

	@SerializedName("data")
	private DataResponseModel data;

	@SerializedName("support")
	private SupportResponseModel support;

	public DataResponseModel getData(){
		return data;
	}

	public SupportResponseModel getSupport(){
		return support;
	}
}