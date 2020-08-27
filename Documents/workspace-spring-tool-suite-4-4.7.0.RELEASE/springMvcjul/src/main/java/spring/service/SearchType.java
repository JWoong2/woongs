package spring.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
public class SearchType {

	private int code;
	private String text;
	
	public SearchType(int code, String text) {
		this.code = code;
		this.text = text;
	}

}