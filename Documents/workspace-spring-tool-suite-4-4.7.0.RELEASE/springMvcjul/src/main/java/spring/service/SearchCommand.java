package spring.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SearchCommand {
	private String type;
	private String query;
	private int page;

}