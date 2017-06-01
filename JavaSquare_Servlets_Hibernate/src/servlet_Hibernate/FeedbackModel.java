package servlet_Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback_Hibernate_Annotations",schema = "scott")
public class FeedbackModel {
	
	@Id
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Portal")
	private String how;
	
	@Column(name = "Subject")
	private String subject;
	
	@Column(name = "Message")
	private String message;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHow() {
		return how;
	}
	public void setHow(String how) {
		this.how = how;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
