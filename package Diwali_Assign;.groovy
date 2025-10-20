package Diwali_Assign;

import java.util.*;

// Custom exception
class LowAttendanceException extends Exception {
    public LowAttendanceException(String message) {
        super(message);
    }
}

// Student class
class Student {
    int rollno;
    String sname;
    String course;
    float attendance_percentage;
    double score;

    public Student(int rollno, String sname, String course, double attendance, double score)
            throws LowAttendanceException {
        if (attendance < 60) {
            throw new LowAttendanceException("Attendance less than 60% for student: " + sname);
        }
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendance_percentage = (float) attendance;
        this.score = score;
    }

    public String calculateGrade() {
        if (score >= 90) return "A";
        else if (score >= 75) return "B";
        else if (score >= 60) return "C";
        else if (score >= 40) return "D";
        else return "F";
    }

    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", sname=" + sname + ", course=" + course +
                ", attendance=" + attendance_percentage + "%, score=" + score +
                ", grade=" + calculateGrade() + "]";
    }
}

// Main class
public class StudentManagement {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        // Add students
        addStudent(studentList, 101, "Ram", "Math", 92.0, 88);
        addStudent(studentList, 102, "Sham", "Physics", 85.0, 76);
        addStudent(studentList, 103, "Bob", "Chemistry", 58.0, 60); // throws exception
        addStudent(studentList, 104, "Charlie", "Math", 65.0, 90);
        addStudent(studentList, 105, "Eva", "Biology", 78.0, 55);
        addStudent(studentList, 106, "Farhan", "Math", 98.0, 95);
        addStudent(studentList, 107, "Grace", "Physics", 80.0, 60);
        addStudent(studentList, 108, "Hemant", "Math", 70.0, 75);
        addStudent(studentList, 109, "Ian", "Chemistry", 88.0, 82);
        addStudent(studentList, 110, "Jane", "Biology", 60.0, 50);

        // Sort by decreasing attendance
        studentList.sort((s1, s2) -> Float.compare(s2.attendance_percentage, s1.attendance_percentage));

        // Print students
        System.out.println("\n📋 Sorted Students:");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    private static void addStudent(List<Student> list, int rollno, String name, String course, double attendance, double score) {
        try {
            Student s = new Student(rollno, name, course, attendance, score);
            list.add(s);
        } catch (LowAttendanceException e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }
}
