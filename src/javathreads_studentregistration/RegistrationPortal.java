package javathreads_studentregistration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationPortal {
	private List<Student> registeredStudents;
	
	private static RegistrationPortal instance;
	
	private RegistrationPortal() {
		registeredStudents = new ArrayList<>();
	}
	
	public static RegistrationPortal getRegistrationPortal() {
		if(instance==null) {
			instance= new RegistrationPortal();
		}
		return instance;
	}
	
	public synchronized void register(Student student) {
		registeredStudents.add(student);
	}
	
	public synchronized List<Student> getRegisteredStudents(){
		return registeredStudents;
		
	}

}
