package javathreads_studentregistration;

import java.util.Scanner;

public class StudentsRegistrationThread implements Runnable{

	private RegistrationPortal p;
	private int studentCount;
	private int threadId;
	
	
	
	public StudentsRegistrationThread(RegistrationPortal p, int studentCount, int threadId) {
		
		this.p = p;
		this.studentCount = studentCount;
		this.threadId = threadId;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		for(int i=1;i <= studentCount;i++) {
			p.register(new Student("id-" + threadId + "-" + i, "name-" + i));
		}
		//sc.close();
		
	}
	

}
