package SystemPackage;

import java.util.ArrayList;

public class BinaryBuddySystemTree 
{
	private static ArrayList<Memory> currentBank;
	private static StandardizedInput input; 
	private static int systemSize;
	private static BinaryBuddySystemGUI BBSGUI;
	
	public BinaryBuddySystemTree()
	{
		currentBank = new ArrayList<Memory>();
		input = new StandardizedInput();
		BBSGUI = new BinaryBuddySystemGUI();
		setSystemSize();
	}

	//method that takes in input from user to set the size of space for memory storage
	private void setSystemSize()
	{
			System.out.println("Please input the the size of allocated space for memory storage (rounded to the nearest power of 2 in Mb): ");
			systemSize = input.scanIntegerBetween(1, Integer.MAX_VALUE);
			Memory x = new Memory(roundSize(systemSize));
			currentBank.add(x);
			BBSGUI.drawGUI(systemSize, currentBank);
	}

	public Memory createProcess()
	{
			System.out.println("Please input the size of the process (in Mb): ");
			int memSize = input.scanIntegerBetween(1, returnMaxPossibleInput());
				Memory newProcess = new Memory(memSize);
				System.out.println("Please input a string to identify this process: ");
				String name = input.scanString();
				newProcess.setID(name);
				newProcess.setActive(true);
				return newProcess;
	}
	//create a new process with size and the process name Id
	private Memory createProcess(int size, String name)
	{
		Memory newProcess = new Memory(size);
		newProcess.setID(name);
		newProcess.setActive(true);
		return newProcess;
	}

	public void addProcess()
	{
		Memory newProcess = createProcess();
		for(int i = 0; i<currentBank.size(); i++)
		{
			int roundedProcessValue = roundSize(newProcess.getValue());
			if(!currentBank.get(i).getActive())
			{
				if(currentBank.get(i).getValue()==roundedProcessValue)
				{
					currentBank.get(i).setValue(newProcess.getValue());
					currentBank.get(i).setActive(true);
					currentBank.get(i).setID(newProcess.getName());
					break;
				}
				else if(currentBank.get(i).getValue()>roundedProcessValue)
				{
					currentBank = split(i);
					i=-1;
				}
			}
		}
		BBSGUI.drawGUI(systemSize, currentBank);
	}
	//split a buddy
	private static ArrayList<Memory> split(int locationOfEdit)
	{
		if(currentBank.get(locationOfEdit).getValue()>1)
		{
			int tempNum = currentBank.get(locationOfEdit).getValue()/2;
			Memory splitMem = new Memory(tempNum);
			Memory splitMemTwo = new Memory(tempNum);
			splitMem.setParent(currentBank.get(locationOfEdit));
			splitMemTwo.setParent(currentBank.get(locationOfEdit));
			currentBank.remove(locationOfEdit);
			currentBank.add(locationOfEdit, splitMem);
			currentBank.add(locationOfEdit, splitMemTwo);
			return currentBank;
		}
		return null;
	}
	//deallocate method arrayList and using process name ID
	public void deallocate(String name)
	{
		Memory finishedMem = findProcess(name);
		finishedMem.setActive(false);
		finishedMem.setID("");
		finishedMem.setValue(roundSize(finishedMem.getValue()));
		merge(finishedMem);
		BBSGUI.drawGUI(systemSize, currentBank);
	}
	//using helper methods to find a buddy merge buddies to before split state
	private static void merge(Memory emptyMem)
	{
		boolean flag = false;
		while(!flag)
		{
			flag=true;
					for(int i=currentBank.size()-1;i>0;i--)
					{
						if(!currentBank.get(i).getActive()&&!currentBank.get(i-1).getActive()&&currentBank.get(i).getValue()==currentBank.get(i-1).getValue()&&currentBank.get(i).getParent().equals(currentBank.get(i-1).getParent()))
						{
							flag=false;
							Memory marker = currentBank.get(i).getParent();
							currentBank.set(i, marker);
							currentBank.remove(i-1);
						}
					}
		}
	}
	
	//method to round the size of user block size input to a power of 2
	private static int roundSize (int inputBlock)
	{
		int power = 2;        
		while (power < inputBlock) 
		{
			power = power * 2;
		}
		int blockAsPowerTwo = power;
		return blockAsPowerTwo;
	}
	//find a process in memory via process name
	private static Memory findProcess(String name)
	{
		for(int i = 0;i<currentBank.size();i++)
		{
			if(currentBank.get(i).getName().equals(name))
				return currentBank.get(i);
		}
		System.out.println("Process was not found in memory!");
		return new Memory(0);
	}

	//method that returns max possible inputs 
	private static int returnMaxPossibleInput()
	{
		int maxAllowedInput = 0;
		for(int i=0;i<currentBank.size();i++)
		{
			if(!currentBank.get(i).getActive()&&currentBank.get(i).getValue()>maxAllowedInput)
			{
				maxAllowedInput=currentBank.get(i).getValue();
			}
		}
		return maxAllowedInput;
	}
	
	public void displayInfo()
	{
		for(int i = 0; i < currentBank.size();i++)
		{
			System.out.println("Location: "+i+"\t"+"Value: "+currentBank.get(i).getValue()+"\t"+"Active Process? "+currentBank.get(i).getActive()+"\t"+"ID Name: "+currentBank.get(i).getName());
		}
		BBSGUI.drawGUI(systemSize, currentBank);
	}
}
