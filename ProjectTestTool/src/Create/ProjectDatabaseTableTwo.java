package Create;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProjectDatabaseTableTwo {
	
   @Id
   @GeneratedValue
   private int statsID;
   
   private int chkbox1;
   private int chkbox2;
   private int chkbox3;
   private int chkbox4;
   private int chkbox5;
   private String commentField;
   
   public ProjectDatabaseTableTwo(){
	   
   }
   
public ProjectDatabaseTableTwo(int statsID, int chkbox1, int chkbox2, int chkbox3, int chkbox4, int chkbox5,
		String commentField) {
	super();
	this.statsID = statsID;
	this.chkbox1 = chkbox1;
	this.chkbox2 = chkbox2;
	this.chkbox3 = chkbox3;
	this.chkbox4 = chkbox4;
	this.chkbox5 = chkbox5;
	this.commentField = commentField;
}
public int getChkbox1() {
	return chkbox1;
}
public void setChkbox1(int chkbox1) {
	this.chkbox1 = chkbox1;
}
public int getChkbox2() {
	return chkbox2;
}
public void setChkbox2(int chkbox2) {
	this.chkbox2 = chkbox2;
}
public int getChkbox3() {
	return chkbox3;
}
public void setChkbox3(int chkbox3) {
	this.chkbox3 = chkbox3;
}
public int getChkbox4() {
	return chkbox4;
}
public void setChkbox4(int chkbox4) {
	this.chkbox4 = chkbox4;
}
public int getChkbox5() {
	return chkbox5;
}
public void setChkbox5(int chkbox5) {
	this.chkbox5 = chkbox5;
}
public String getCommentField() {
	return commentField;
}
public void setCommentField(String commentField) {
	this.commentField = commentField;
}
public int getStatsID() {
	return statsID;
}
@Override
public String toString() {
	return "ProjectDatabaseTableTwo [statsID=" + statsID + ", chkbox1=" + chkbox1 + ", chkbox2=" + chkbox2
			+ ", chkbox3=" + chkbox3 + ", chkbox4=" + chkbox4 + ", chkbox5=" + chkbox5 + ", commentField="
			+ commentField + "]";
}
   
}
