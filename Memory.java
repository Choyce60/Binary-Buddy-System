public class Memory 
{
	private String id;
	private int value;
	private boolean active;
	private boolean hasBuddy;
	private Memory buddy;
	
	
	public Memory(int value)
	{
		this.id = "";
		this.value = value;
		this.active = false;
		this.hasBuddy = false;
		buddy = null;
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
	
	public boolean getHasBuddy()
	{
		return hasBuddy;
	}
	
	public void setHasBuddy(boolean tf)
	{
		hasBuddy = tf;
	}
	
	
	public void setBuddy(Memory newFriend)
	{
		buddy = newFriend;
	}
	public Memory getBuddy()
	{
		return buddy;
	}
	public void setID(String name)
	{
		id = name;
	}
	public String getName()
	{
		return id;
	}
	
}
