package spring.controller;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import spring.model.Address;
import spring.model.OrderItem;

@Getter
@Setter
@ToString
public class OrderCommand {

	private List<OrderItem> orderItems;
	private Address address;

}