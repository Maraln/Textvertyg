package entity;

import java.io.Serializable;

/**
 *
 * @author yanting
 */


// @Entity(name = "question_option")


public class QuestionOption implements Serializable {
	
	/*
	@Id
	@Column(name = "option_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long optionId;
	
	@Column(name = "question_id", nullable = false)
	private long questionId;
	
	@Column(nullable = false, length = 255)
	private String text;
		
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Option ID: ").append(optionId);
		sb.append("  Question ID: ").append(questionId);
		sb.append("  Text: ").append(text);
		return sb.toString();
	}
	*/
}
