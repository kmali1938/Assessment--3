package javathreads_studentregistration;

import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the number of threads between 1 and 10000: ");
		int threadCount = sc.nextInt();
		int[] studentCount = new int[threadCount];
		
		for(int i=0;i<threadCount;i++) {
			System.out.println("Enter the number of students for the thread -"+(i+1)+" : ");
			studentCount[i]=sc.nextInt();
		}
		
		RegistrationPortal p = RegistrationPortal.getRegistrationPortal();
		Thread[] thread = new Thread[threadCount];
		
		for(int i=0;i<threadCount;i++) {
			thread[i] = new Thread(new StudentsRegistrationThread(p,studentCount[i],i+1));
		}
		
		for(Thread threads : thread) {
			threads.start();
		}
		
		for(Thread threads :thread) {
			try {
				threads.join();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
        List<Student> registeredStudents = p.getRegisteredStudents();
        System.out.println("Registered Students:");
        for (Student student : registeredStudents) {
            System.out.println(student.getId() + " " + student.getName());
        }

	}

}
