package array.view;

import javax.swing.JFrame;
import array.controller.ArrayController;

public class ArrayFrame extends JFrame
{
	private ArrayPanel startPanel;

	public ArrayFrame(ArrayController baseController)
	{	
		startPanel = new ArrayPanel(baseController);

		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(startPanel);
		this.setSize(900, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}
