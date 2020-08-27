package spring.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class QueryLogCommand {
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	private Date from;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date to;

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}
}