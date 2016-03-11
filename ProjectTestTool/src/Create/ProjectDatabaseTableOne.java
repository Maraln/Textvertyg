package Create;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProjectDatabaseTableOne {
  
  @Id
  @GeneratedValue
  private int QuestionID;
  
  private String Question;
  private String chkboxQuestion1;
  private String chkboxQuestion2;
  private String chkboxQuestion3;
  private String chkboxQuestion4;
  private String chkboxQuestion5;
  private String questionField;
  
  public ProjectDatabaseTableOne(){
		
	}
  
  
public ProjectDatabaseTableOne(int questionID, String question, String chkboxQuestion1, String chkboxQuestion2,
		String chkboxQuestion3, String chkboxQuestion4, String chkboxQuestion5, String questionField) {
	
	QuestionID = questionID;
	this.Question = question;
	this.chkboxQuestion1 = chkboxQuestion1;
	this.chkboxQuestion2 = chkboxQuestion2;
	this.chkboxQuestion3 = chkboxQuestion3;
	this.chkboxQuestion4 = chkboxQuestion4;
	this.chkboxQuestion5 = chkboxQuestion5;
	this.questionField = questionField;	
	
	

}
public String getQuestion() {
	return Question;
}
public void setQuestion(String question) {
	Question = question;
}
public String getChkboxQuestion1() {
	return chkboxQuestion1;
}
public void setChkboxQuestion1(String chkboxQuestion1) {
	this.chkboxQuestion1 = chkboxQuestion1;
}
public String getChkboxQuestion2() {
	return chkboxQuestion2;
}
public void setChkboxQuestion2(String chkboxQuestion2) {
	this.chkboxQuestion2 = chkboxQuestion2;
}
public String getChkboxQuestion3() {
	return chkboxQuestion3;
}
public void setChkboxQuestion3(String chkboxQuestion3) {
	this.chkboxQuestion3 = chkboxQuestion3;
}
public String getChkboxQuestion4() {
	return chkboxQuestion4;
}
public void setChkboxQuestion4(String chkboxQuestion4) {
	this.chkboxQuestion4 = chkboxQuestion4;
}
public String getChkboxQuestion5() {
	return chkboxQuestion5;
}
public void setChkboxQuestion5(String chkboxQuestion5) {
	this.chkboxQuestion5 = chkboxQuestion5;
}
public String getQuestionField() {
	return questionField;
}
public void setQuestionField(String questionField) {
	this.questionField = questionField;
}
public int getQuestionID() {
	return QuestionID;
}
@Override
public String toString() {
	return "ProjectDatabaseTabeOne [QuestionID=" + QuestionID + ", Question=" + Question + ", chkboxQuestion1="
			+ chkboxQuestion1 + ", chkboxQuestion2=" + chkboxQuestion2 + ", chkboxQuestion3=" + chkboxQuestion3
			+ ", chkboxQuestion4=" + chkboxQuestion4 + ", chkboxQuestion5=" + chkboxQuestion5 + ", questionField="
			+ questionField + "]";
}
  
}
