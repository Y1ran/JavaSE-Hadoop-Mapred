package selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List_test {
	/*set arr list*/
	private ArrayList<Course> coursesToSelect;
	private String inp;
	private int num;
	
	public int i;
	
	public List_test(){
		this.coursesToSelect = new ArrayList<Course>();
		while(i < 5) {
		this.inp = getChar();
		//this.num = getId();
		coursesToSelect.add(new Course(i++, this.inp));
		}
	}
	
	public String getChar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the course:");
		String s = sc.next();
		
		return s;
	}
	public int getId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the id:");
		int n = sc.nextInt();
		//sc.close();
		return n;
	}
	
	public void testAdd() {
		/*add courses to List*/
		//Course c1 = new Course(this.num, this.inp);
		//coursesToSelect.add(c1);
		//Course temp = coursesToSelect.get(0);
		
		/*System.out.printf("Course %d:%s has been updated", temp.getId()
				, temp.getName());
				*/
		System.out.println("now the course is:");
		System.out.println("Course_id  " + "Course_Name ");
		for(Course c:coursesToSelect)
		{
			System.out.printf("   %2d     |     ", c.getId());
			System.out.println(c.getName());
		}

	}
}
