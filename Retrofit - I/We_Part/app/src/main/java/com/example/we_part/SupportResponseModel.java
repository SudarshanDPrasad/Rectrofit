package com.example.we_part;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class SupportResponseModel implements Serializable {

	@SerializedName("url")
	private String url;

	@SerializedName("text")
	private String text;

	public String getUrl(){
		return url;
	}

	public String getText(){
		return text;
	}
}