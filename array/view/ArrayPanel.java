package array.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import array.controller.ArrayController;

public class ArrayPanel extends JPanel
{
	private ArrayController baseController;
	private SpringLayout startLayout;
	private JTextField searchArrayTextfield;
	private JButton findArrayInfoButton;
	private JTextArea arrayInfoArea;
	private JScrollPane arrayInfoPane;
	private JTable instrumentTable;
	private JScrollPane arrayTablePane;
	private TableRender myRender = new TableRender();
	
	public ArrayPanel(ArrayController baseController)
	{
		this.baseController = baseController;

		startLayout = new SpringLayout();
		findArrayInfoButton = new JButton("Search");
		searchArrayTextfield = new JTextField(20);
		arrayInfoArea = new JTextArea(10, 30);
		arrayInfoPane = new JScrollPane(arrayInfoArea);
		instrumentTable = new JTable(new DefaultTableModel(baseController.getMyInstruments(), baseController.getInstrumentColumnNames()));
		arrayTablePane = new JScrollPane(instrumentTable);
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListners();
	}
	
	private void setupPane()
	{
		arrayInfoArea.setText("Array information appears here.");
		arrayInfoArea.setLineWrap(true);
		arrayInfoArea.setWrapStyleWord(true);
		arrayInfoArea.setEditable(false);
		for(int col = 0; col < instrumentTable.getColumnCount(); col++)
		{
			instrumentTable.getColumnModel().getColumn(col).setCellRenderer(myRender);
		}
	}
	
	private void setupPanel()
	{
		this.setSize(900, 400);
		this.setFocusable(true);
		this.setLayout(startLayout);
		this.add(searchArrayTextfield);
		this.add(findArrayInfoButton);
		this.add(arrayInfoPane);
		this.add(arrayTablePane);
	}
	
	private void setupLayout()
	{
		startLayout.putConstraint(SpringLayout.WEST, findArrayInfoButton, 0, SpringLayout.WEST, arrayInfoPane);
		startLayout.putConstraint(SpringLayout.NORTH, arrayInfoPane, 30, SpringLayout.NORTH, this);
		startLayout.putConstraint(SpringLayout.WEST, arrayInfoPane, 30, SpringLayout.WEST, this);
		startLayout.putConstraint(SpringLayout.NORTH, searchArrayTextfield, 6, SpringLayout.SOUTH, arrayInfoPane);
		startLayout.putConstraint(SpringLayout.EAST, searchArrayTextfield, 0, SpringLayout.EAST, arrayInfoPane);
		startLayout.putConstraint(SpringLayout.NORTH, findArrayInfoButton, -1, SpringLayout.NORTH, searchArrayTextfield);
		startLayout.putConstraint(SpringLayout.WEST, arrayTablePane, 370, SpringLayout.WEST, this);
	}
	
	private void setupListners()
	{
		findArrayInfoButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				if(searchArrayTextfield.getText().length() <=4)
				{
					try
					{
						Integer.parseInt(searchArrayTextfield.getText());
						int row = Integer.parseInt(searchArrayTextfield.getText().substring(0, 2));
						int col = Integer.parseInt(searchArrayTextfield.getText().substring(2, 4));
						try
						{
							arrayInfoArea.setText(baseController.getOneInstrument(row,col).toString());
						}
						catch(Exception exception)
						{
							JOptionPane.showMessageDialog(null, "This location doesn't exsist in the 2d array.");
						}
					}
					catch(Exception exception)
					{
						JOptionPane.showMessageDialog(null, "Please put into the format: 0102 where 01 is the row in array and 02 is the column in array.");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please put into the format: 0102 where 01 is row 1 in array and 02 is column 2 in array.");
				}
			}
		});
	}
}
