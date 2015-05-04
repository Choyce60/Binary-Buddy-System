package SystemPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BinaryBuddySystemGUI 
{
	private ArrayList<Memory> memArray;
	private int maxHeight;
	private JPanel listPane;
	private JFrame frame;
	
	private int heightAdjustment = 28;
	private final int MEM_BLOCK_SCALE = 10; 
	private final int MEM_BLOCK_WIDTH = 192; 
	private final int MEM_BLOCK_WIDTH_ADJUST = 16; 
	
	public BinaryBuddySystemGUI()
	{
		
		
		frame = new JFrame();
	
		frame.setPreferredSize( new Dimension( MEM_BLOCK_WIDTH + MEM_BLOCK_WIDTH_ADJUST , 64 * MEM_BLOCK_SCALE + heightAdjustment) );
		//frame.setSize(MEM_BLOCK_WIDTH, 64 * MEM_BLOCK_SCALE); // for testing
		listPane = new JPanel();
		listPane.setLayout(new FlowLayout());
		listPane.setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.add(listPane);
		frame.pack();
		listPane.setVisible(true);
		frame.setVisible(true);
		
	}
	
	public void drawGUI(int maxHeight, ArrayList<Memory> memArray)
	{
		if(memArray.size() <= 1)
		{
			heightAdjustment = 28;
		}
		else
		{
			heightAdjustment = 8;
		}
		listPane.removeAll();
		frame.setPreferredSize(new Dimension(MEM_BLOCK_WIDTH + MEM_BLOCK_WIDTH_ADJUST, (maxHeight * MEM_BLOCK_SCALE) + (memArray.size() * MEM_BLOCK_SCALE) + heightAdjustment));
		listPane.setBackground(Color.BLACK);
		
		for(Memory mem: memArray) 
		{
			listPane.add(createPnnel(mem));	
		}
		
		frame.pack();
		frame.repaint();
		frame.revalidate();
		
	}
	
	public JTextArea createPnnel(Memory mem)
	{
		JTextArea thisTextArea = new JTextArea();
		thisTextArea.setPreferredSize(new Dimension(MEM_BLOCK_WIDTH, mem.getValue() * MEM_BLOCK_SCALE));
		if(mem.getActive())
		{
			thisTextArea.setBackground(Color.GREEN);
		}
		else
		{
			thisTextArea.setBackground(Color.RED);
		}
		thisTextArea.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		thisTextArea.append(mem.toString());
		
		return thisTextArea;
	}

	public ArrayList getMemArray() 
	{
		return memArray;
	}

	public void setMemArray(ArrayList memArray) 
	{
		this.memArray = memArray;
	}

	public int getMaxHeight() 
	{
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) 
	{
		this.maxHeight = maxHeight;
	}
}
