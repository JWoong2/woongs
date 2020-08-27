package spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class OrderItem {

	private Integer itemId;
	private Integer number;
	private String remark;

}