package master_assignment.bean;

import java.util.Date;
import java.util.Set;

public class TestResult implements Comparable<TestResult> {
	public Date testdate;
	public int testid;
	public int studentId;
	public int marks;
	public int out_of_marks;

	public TestResult(Date testdate, int testid, int Test_studentId, int marks, int out_of_marks) {

		this.testdate = testdate;
		this.testid = testid;
		this.studentId = Test_studentId;
		this.marks = marks;
		this.out_of_marks = out_of_marks;
	}

	public String toString() {
		return ("test date:  " + this.testdate + " " + "test id:  " + this.testid + " " + "test Test_studentId: "
				+ this.studentId + " " + "test marks: " + this.marks + " " + "test out of marks: "
				+ this.out_of_marks + "\n");

	}

	@Override
	public int compareTo(TestResult o) {
		// TODO Auto-generated method stub
		
		
		return o.marks-this.marks;
		
		
	}

	
}
