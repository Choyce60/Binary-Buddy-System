import java.util.*;
public class BinaryBuddySystem 
{
	public static int BINARY_MODIFIER = 2;
	public static Scanner scanInt = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		int memoryBlockSize = setSystemSize();
		System.out.println(memoryBlockSize);
		
		ArrayList<Memory> currentBank = createMemoryBlock(memoryBlockSize);
		System.out.println(currentBank.get(0).getValue());
		
		while(0==0)
		{
			System.out.println("Please indicate a numeric action:"+"\n"+"1: Check System Status" +"\n"+"2: Add A Process"+"\n"+"3: Deactivate A Process"+"\n"+"4: Exit");
			int input = scanInt.nextInt();
			if(!(input>0 && input<5))
			{
				System.out.println("Invalid Numeric Input");
			}
			else
			{
				if(input==1)
				{
					for(int i = 0; i<currentBank.size();i++)
					{
						System.out.println("Location: "+i+"\t"+"Value: "+currentBank.get(i).getValue()+"\t"+"Active Process? "+currentBank.get(i).getActive()+"\t"+"ID Name: "+currentBank.get(i).getName());
					}
				}
				else if(input==2)
				{
					addProcess(currentBank,createProcess());
				}
				else if(input==3)
				{
					System.out.println("Please input the name of the process to deallocate: ");
					String target = scanInt.next();
					currentBank = deallocate(currentBank, target);
					System.out.println(currentBank);
				}
				else if(input==4)
				{
					
				}
			}
		}
	}
	
	private static int roundSize (int inputBlock)
	   {
	        int power = 2;        
	        while (power < inputBlock) {
	                power = power * 2;
	        }
		int blockAsPowerTwo = power;
	        return blockAsPowerTwo;
	   }
	
	private static int setSystemSize()
	{
		System.out.println("Please input the the size of allocated space for memory storage (rounded to the nearest power of 2 in Mb): ");
		int size = scanInt.nextInt();
		if(size < 1)
		{
		System.out.println("ERROR, Please input the the size of allocated space for memory storage greater than 0 ");
		}else
		{
		return roundSize(size);
		}
	}
	
	private static ArrayList<Memory> createMemoryBlock(int systemSize)
	{
		Memory x = new Memory(systemSize);
		ArrayList<Memory> memoryBlock = new ArrayList<Memory>();
		memoryBlock.add(x);
		return memoryBlock;
	}
	
	private static Memory createProcess()
	{
		System.out.println("Please input the size of the process (in Mb): ");
		int size = scanInt.nextInt();
		if(size < 1)
		{
		System.out.println("ERROR, Please input size greater than 0");
		}else
		{
		Memory newProcess = new Memory(size);
		System.out.println("Please input a string to identify this process: ");
		String name = scanInt.next();
		newProcess.setID(name);
		newProcess.setActive(true);
		return newProcess;
		}
	}
	
	private static ArrayList<Memory> addProcess(ArrayList<Memory> currentState, Memory newProcess)
	{
		for(int i = 0; i<currentState.size(); i++)
		{
			int roundedProcessValue = roundSize(newProcess.getValue());
			if(!currentState.get(i).getActive())
			{
				if(currentState.get(i).getValue()==roundedProcessValue)
				{
					currentState.get(i).setValue(newProcess.getValue());
					currentState.get(i).setActive(true);
					currentState.get(i).setID(newProcess.getName());
					break;
				}
				else if(currentState.get(i).getValue()>roundedProcessValue)
				{
					currentState = split(currentState, i);
					i=-1;
				}
			}
		}
		return currentState;
	}
	
	private static ArrayList<Memory> split(ArrayList<Memory> editableList, int locationOfEdit)
	{
		if(editableList.get(locationOfEdit).getValue()>1)
		{
			int tempNum = editableList.get(locationOfEdit).getValue()/2;
			editableList.get(locationOfEdit).setValue(tempNum);
			Memory splitMem = new Memory(tempNum);
			editableList.add(locationOfEdit, splitMem);
			editableList.get(locationOfEdit).setHasBuddy(true);
			editableList.get(locationOfEdit+1).setHasBuddy(true);
			editableList.get(locationOfEdit+1).setBuddy(editableList.get(locationOfEdit));
			editableList.get(locationOfEdit).setBuddy(editableList.get(locationOfEdit+1));
			
			return editableList;
		}
		return null;
	}
	
	private static ArrayList<Memory> deallocate(ArrayList<Memory> editableList, String name)
	{
		Memory finishedMem = findProcess(editableList, name);
		finishedMem.setActive(false);
		finishedMem.setID("");
		return merge(editableList,finishedMem);
	}
	
	private static ArrayList<Memory> merge(ArrayList<Memory> editableList,Memory emptyMem)
	{
		boolean flag = false;
		while(!flag)
		{
			flag=true;
		if(!(emptyMem.getActive())&& (emptyMem.getHasBuddy()))
		{
			if(!(emptyMem.getBuddy().getActive()))
			{
				editableList.remove(emptyMem.getBuddy());
				emptyMem.setValue(roundSize(emptyMem.getValue())*BINARY_MODIFIER);
				//Memory newMem = editableList.get(editableList.indexOf(emptyMem));
				for(int i=1;i<editableList.size();i++)
				{
					if(!editableList.get(i).getActive()&&!editableList.get(i-1).getActive()&&editableList.get(i).getValue()==editableList.get(i-1).getValue())
					{
						flag=false;
						emptyMem=editableList.get(i);
						emptyMem.setBuddy(editableList.get(i-1));
					}
				}
			}
		}
		}

		return editableList;
	}
	
	private static Memory findProcess(ArrayList<Memory> editableList,String name)
	{
		
			
			for(int i = 0;i<editableList.size()-1;i++)
			{
				if(editableList.get(i).getName().equals(name))
					return editableList.get(i);
			}
			System.out.println("Process was not found in memory!");
			return new Memory(0);
		
		
	}
	
	private static void assignBuddy(Memory first, Memory second)
	{
		first.setHasBuddy(true);
		second.setHasBuddy(true);
		second.setBuddy(first);
		first.setBuddy(second);
	}
}
