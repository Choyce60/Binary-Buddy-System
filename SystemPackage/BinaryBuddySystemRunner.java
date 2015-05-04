package SystemPackage;
import java.util.Random;
import java.util.ArrayList;
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
			BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
			ArrayList<String> active = new ArrayList();
			int counter = 1;
			do{
				
				Random rand = new Random();
				
				if(bbst.returnMaxPossibleInput()==64)
				{
					String processName = String.valueOf(counter);
					bbst.addProcess(rand.nextInt(64)+1, processName);
					active.add(processName);
					counter++;
					System.out.println("Allocate: "+bbst.findProcess(processName));
					sleep();
					
				}
				else if(bbst.returnMaxPossibleInput()<=4)
				{
					Memory temp = bbst.findProcess(active.remove(rand.nextInt(active.size())));
					System.out.println("Deallocate: "+temp);
					bbst.deallocate(temp.getName());
					sleep();					
					
				}
				else
				{
					int decision = rand.nextInt(100)%2;
					
					switch(decision){
					case 0: Memory temp = bbst.findProcess(active.remove(rand.nextInt(active.size())));
							System.out.println("Deallocate: "+temp);
							bbst.deallocate(temp.getName());
							sleep();
							break;
					case 1: String processName = String.valueOf(counter);
							bbst.addProcess(rand.nextInt(bbst.returnMaxPossibleInput()), processName);
							active.add(processName);
							counter++;
							System.out.println("Allocate: "+bbst.findProcess(processName));
							sleep();
							break;
					default: System.out.println("Invalid decision value, alloc or dealloc cannot be decided");
					
					}
							
						
							
				}
			}while(counter<100);
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
	//method to slow down the demo so we can observe the actions being performed
	private static void sleep()
	{
		try {
		    Thread.sleep(500);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}

}
