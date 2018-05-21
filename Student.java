package selection;
import java.util.Set;
import java.util.HashSet;

public class Student {

	private String id;
	private String name;
	private Set courses;
	
	public Student(String id,String name){
		this.id = id;
		this.name = name;
		
		this.courses = new HashSet();
		
	}
	
	
}
