package SystemPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * BinaryBuddySystemGUI
 * Creates a graphical Representation of the Binary Buddy System
 * @author Travis
 */

public class BinaryBuddySystemGUI 
{
	private ArrayList<Memory> memArray;
	private int maxHeight;
	private JPanel listPane;
	private JFrame frame;
	
	private int heightAdjustment = 26;
	private final int MEM_BLOCK_SCALE = 13; 
	private final int MEM_BLOCK_WIDTH = 256; 
	private final int MEM_BLOCK_WIDTH_ADJUST = 16; 
	private final int INITIAL_HEIGHT = 64; 
	
	/**
	 * Creates a new BinaryBuddySystemGUI
	 * 
	 */
	public BinaryBuddySystemGUI()
	{
		
		frame = new JFrame();
	
		frame.setPreferredSize(new Dimension(MEM_BLOCK_WIDTH + MEM_BLOCK_WIDTH_ADJUST , INITIAL_HEIGHT));
		listPane = new JPanel();
		listPane.setLayout(new FlowLayout());
		listPane.setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.add(listPane);
		frame.pack();
		frame.setLocation(64,64);	
		listPane.add(startPannel());
		listPane.setVisible(true);
		frame.setVisible(true);	
	}
	
	
	/**
	 * Redraws the BinaryBuddySystemGUI
	 * If the memArray contains 1 or less memory objects the size of the GUI is adjusted.
	 * Cycles through the memArray to build a number of memory panels based on the memArray size.
	 * @param maxHeight Height relating to the amount of memory objects in the memory Array.
	 * @param memArray The Array of memory objects
	 */
	public void drawGUI(int maxHeight, ArrayList<Memory> memArray)
	{
		if(memArray.size() <= 1)
		{
			heightAdjustment = 26;
		}
		else
		{
			heightAdjustment = 0;
		}
		
		listPane.removeAll();
		frame.setPreferredSize(new Dimension(MEM_BLOCK_WIDTH + MEM_BLOCK_WIDTH_ADJUST, (maxHeight * MEM_BLOCK_SCALE) + (memArray.size() * MEM_BLOCK_SCALE) + heightAdjustment));
		listPane.setBackground(Color.BLACK);
		
		for(Memory mem: memArray) 
		{
			listPane.add(createPannel(mem));
		}
		
		frame.pack();
		frame.repaint();
		frame.revalidate();
	}
	
	/**
	 * Builds a specific memory JTextArea based on the data provided.
	 * Green means active.
	 * Red means not Active.
	 * Provides memory information.
	 * @param mem Current memory object that is being represented by this JTextArea.
	 * @return returns the JTextArea.
	 */
	public JTextArea createPannel(Memory mem)
	{
		JTextArea thisTextArea = new JTextArea();
		
		int power = 2;        
		while (power < mem.getValue()) 
		{
			power = power * 2;
		}
		int blockAsPowerTwo = power;
		
		thisTextArea.setPreferredSize(new Dimension(MEM_BLOCK_WIDTH, blockAsPowerTwo * MEM_BLOCK_SCALE));
		if(mem.getActive())
		{
			thisTextArea.setBackground(Color.GREEN);
		}
		else
		{
			thisTextArea.setBackground(Color.RED);
		}
		thisTextArea.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		thisTextArea.append("  " + mem.toString());
		
		return thisTextArea;
	}
	
	/**
	 * Builds the starting JTextArea.
	 * @return Returns the JTextArea.
	 */
	public JTextArea startPannel()
	{
		JTextArea thisTextArea = new JTextArea();
		thisTextArea.setBackground(Color.BLACK);
		thisTextArea.setForeground(Color.WHITE);
		thisTextArea.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		thisTextArea.append("Status: Ready");
		
		return thisTextArea;
	}

	/**
	 * Gets the memory ArrayList
	 * @return memArray
	 */
	public ArrayList getMemArray() 
	{
		return memArray;
	}

	/**
	 * Sets the memory ArrayList
	 * @param memArray The ArrayList to be set.
	 */
	public void setMemArray(ArrayList memArray) 
	{
		this.memArray = memArray;
	}

	/**
	 * Gets the maxHeight
	 * @return maxHeight
	 */
	public int getMaxHeight() 
	{
		return maxHeight;
	}

	/**
	 * Sets the maxHeight
	 * @param maxHeight
	 */
	public void setMaxHeight(int maxHeight) 
	{
		this.maxHeight = maxHeight;
	}
}
