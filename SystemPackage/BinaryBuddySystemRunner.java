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
			BinaryBuddySystemTree BBST = new BinaryBuddySystemTree();
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
					BBST.addProcess();
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
