package selection;

/*course class*/
public class Course {
	private int id;
	private String name;
	
	public Course(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setId(int newId)
	{
		this.id = newId;
	}
}
