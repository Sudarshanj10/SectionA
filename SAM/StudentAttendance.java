package SAM;

import java.io.*;
import java.util.*;

public class StudentAttendance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Student> students = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println("\nEnter details for Student " + i);

				System.out.print("Enter Roll No: ");
				int rollno = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Course: ");
				String course = sc.nextLine();

				System.out.print("Enter Attendance : ");
				double attendance = sc.nextDouble();

				System.out.print("ENter Score: ");
				double score = sc.nextDouble();

				if (attendance < 60) {
					throw new LowAttendanceException(
							" Low Attendance " + name + " (" + attendance + "). Not eligible!!!.");
				}

				students.add(new Student(rollno, name, course, attendance, score));

			} catch (LowAttendanceException e) {
				System.out.println(e.getMessage());
				System.out.println("Skipping this student");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input type. Please enter correct values.");
				sc.nextLine();
				i--;
			}
		}

		try {
			FileOutputStream fos = new FileOutputStream("students.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(students);
			oos.close();
			fos.close();
			System.out.println("Student data serialized successfully ");

			
			FileInputStream fis = new FileInputStream("students.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Student> deserializedList = (List<Student>) ois.readObject();
			ois.close();
			fis.close();

			deserializedList.sort((a, b) -> Double.compare(b.getAttendance_percentage(), a.getAttendance_percentage()));

			System.out.println(" Students sorted by Attendance :");
			for (Student s : deserializedList) {
				System.out.println(s);
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}