package SystemPackage;

import java.util.Scanner;

public class StandardizedInput 
{
	private Scanner scanLine;
	
	public StandardizedInput()
	{
		scanLine = new Scanner(System.in);
	}
	
	public String scanString()
	{
		return scanLine.nextLine();
	}
	
	public int scanIntegerBetween(int min, int max)
	{
		boolean incorrectInput = false;
		do{
			String temp = scanLine.nextLine();
			for(int i = min; i<=max;i++)
			{
				if((String.valueOf(i)).equals(temp))
				{
					return Integer.parseInt(temp);
				}
			}
			System.out.println("INCORRECT INPUT ... TRY AGAIN ... VALID BETWEEN "+min+" - "+max);
			incorrectInput = true;
		}while(incorrectInput);
		return 0;	
	}
	
	public void closeScanner()
	{
		scanLine.close();
	}
}
