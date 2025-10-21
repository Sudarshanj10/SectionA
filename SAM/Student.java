package SAM;

import java.io.Serializable;

public class Student implements Serializable {
	private int rollno;
	private String sname;
	private String course;
	private double attendance_percentage;
	private double score;

	public Student() {

	}

	public Student(int rollno, String sname, String course, double attendance_percentage, double score) {
		this.rollno = rollno;
		this.sname = sname;
		this.course = course;
		this.attendance_percentage = attendance_percentage;
		this.score = score;
	}

	public int getRollno() {
		return rollno;
	}

	public String getSname() {
		return sname;
	}

	public String getCourse() {
		return course;
	}

	public double getAttendance_percentage() {
		return attendance_percentage;
	}

	public double getScore() {
		return score;
	}

	public String calculateGrade() {
		int gradeRange = (int) (score / 10);
		return switch (gradeRange) {
		case 10, 9 -> "a+";
		case 8 -> "a";
		case 7 -> "b";
		case 6 -> "c";
		default -> "d";
		};
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
