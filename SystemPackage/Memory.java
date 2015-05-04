package SystemPackage;
public class Memory 
{
	private String id;
	private int value;
	private boolean active;
	private Memory parent;
	
	public Memory(int value)
	{
		this.id = "";
		this.value = value;
		this.active = false;
		parent = null;
	}
	
	public void setParent(Memory papa)
	{
		parent = papa;
	}
	
	
	public Memory getParent()
	{
		return parent;
	}

	public int getValue() 
	{
		return value;
	}

	public void setValue(int value) 
	{
		this.value = value;
	}
	
	public boolean getActive()
	{
		return active;
	}
	
	public void setActive(boolean active)
	{
		this.active = active;
	}
	
	public void setID(String name)
	{
		id = name;
	}
	public String getName()
	{
		return id;
	}
	
	public String toString()
	{
		return ("Value: " + value + ", Active: " + active + ", ID: " + id);	
	}
	
}
