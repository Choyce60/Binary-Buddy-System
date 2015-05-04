package SystemPackage;

public class BinaryBuddySystemRunner 
{
	public static void main(String[] args)
	{
		//get input from user from either a File or from Keyboard
		StandardizedInput input = new StandardizedInput();
		System.out.println("Please Choose Input Type: Generated: 1  Keyboard: 2");
		int inputChoiceNum = input.scanIntegerBetween(1,2);
		if(inputChoiceNum == 1)
		{
			
		}
		//if user inputs 2 take input from keyboard
		else if(inputChoiceNum == 2)
		{
			System.out.println("Please input the the size of allocated space for memory storage (rounded to the nearest power of 2 in Mb): ");
			int systemSize = input.scanIntegerBetween(1, Integer.MAX_VALUE);
			BinaryBuddySystemTree BBST = new BinaryBuddySystemTree(systemSize);
			while(0==0)
			{
				//allow the user to choose from int 1 - 4 for actions check status, add process, deactivate, exit
				System.out.println("Please indicate a numeric action:"+"\n"+"1: Check System Status" +"\n"+"2: Add A Process"+"\n"+"3: Deactivate A Process"+"\n"+"4: Exit");
				int num = input.scanIntegerBetween(1, 4);
				if(num==1)
				{
					BBST.displayInfo();
				}
				else if(num==2)
				{
					System.out.println("Please input the size of the process (in Mb): ");
					int memSize = input.scanIntegerBetween(1, BBST.returnMaxPossibleInput());
					System.out.println("Please input a string to identify this process: ");
					String name = input.scanString();
					BBST.addProcess(memSize, name);
				}
				else if(num==3)
				{
					System.out.println("Please input the name of the process to deallocate: ");
					String target = input.scanString();
					BBST.deallocate(target);
				}
				else if(num==4)
				{
					input.closeScanner();
					System.exit(0);
				}
			}
		}
	}

}
