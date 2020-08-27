package spring.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class NewArticleCommand {
	// NewArticleComand command 의 프로퍼티 값과 같음

	private String title;
	private String content;
	private int parentId;

}