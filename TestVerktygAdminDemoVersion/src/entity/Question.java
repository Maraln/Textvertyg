package entity;

import java.io.Serializable;

/**
 * Question entity class
 * 
 * This represents the question which will only have a text connected with the
 * question body. The available options are stored as a separate entity.
 * 
 * @author yanting
 */

//@Entity(name = "question")

public class Question implements Serializable {
	
	/*
	@Id
	@Column(name = "question_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		sb.append("Question ID: ").append(questionId);
		sb.append("  Text: ").append(text);
		return sb.toString();
	}
	*/
}
