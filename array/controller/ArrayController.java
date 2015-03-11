package array.controller;

import array.model.Instrument;
import array.model.SortingMachine;
import array.view.ArrayFrame;

public class ArrayController
{
	private String[][] myStringArray;
	private int[][] myIntArray = { { 00, 01, 02, 03, 04, 05 }, { 10, 11, 12, 13, 14 }, { 20, 21, 22, 23, 24 } };
	private ArrayFrame appFrame;
	private Instrument[][] myInstruments;
	private String[] instrumentColumnNames;
	private String[] sortedInstrumentColumnNames;

	public ArrayController()
	{	
		buildArrays();
		appFrame = new ArrayFrame(this);
	}

	public void start()
	{
		// printIntArray(myIntArray);
		// printStringArray(myStringArray);
	}

	private void buildArrays()
	{
		myInstruments = new Instrument[3][4];
		myStringArray = new String[3][5];
		instrumentColumnNames = new String[4];
		sortedInstrumentColumnNames = new String[4];
		
		myInstruments[0][0] = new Instrument("Soprano Saxophone", 3, true);
		myInstruments[0][1] = new Instrument("Alto Saxophone", 5, true);
		myInstruments[0][2] = new Instrument("Tenor Saxophone", 6, true);
		myInstruments[0][3] = new Instrument("Baritone Saxopohone", 7, true);
		myInstruments[1][0] = new Instrument("Trumpet", 8, false);
		myInstruments[1][1] = new Instrument("French Horn", 6, false);
		myInstruments[1][2] = new Instrument("Baritone", 7, false);
		myInstruments[1][3] = new Instrument("Tuba", 9, false);
		myInstruments[2][0] = new Instrument("Violin", 2, false);
		myInstruments[2][1] = new Instrument("Viola", 3, false);
		myInstruments[2][2] = new Instrument("Cello", 3, false);
		myInstruments[2][3] = new Instrument("Bass", 4, false);

		myStringArray[0][0] = "AA";
		myStringArray[0][1] = "AB";
		myStringArray[0][2] = "AC";
		myStringArray[0][3] = "AD";
		myStringArray[0][4] = "AE";
		myStringArray[1][0] = "BA";
		myStringArray[1][1] = "BB";
		myStringArray[1][2] = "BC";
		myStringArray[1][3] = "BD";
		myStringArray[1][4] = "BE";
		myStringArray[2][0] = "CA";
		myStringArray[2][1] = "CB";
		myStringArray[2][2] = "CC";
		myStringArray[2][3] = "CD";
		myStringArray[2][4] = "CE";

		instrumentColumnNames[0] = "High Pitch";
		instrumentColumnNames[1] = "Medium-High Pitch";
		instrumentColumnNames[2] = "Medium-Low Pitch";
		instrumentColumnNames[3] = "Low Pitch";
		
		sortedInstrumentColumnNames[0] = "Best";
		sortedInstrumentColumnNames[1] = "";
		sortedInstrumentColumnNames[2] = "";
		sortedInstrumentColumnNames[3] = "Worst";
	}

	private void printIntArray(int[][] intArray)
	{
		for (int row = 0; row < intArray.length; row++)
		{
			for (int col = 0; col < intArray[row].length; col++)
			{
				System.out.print(intArray[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void printStringArray(String[][] stringArray)
	{
		for (int row = 0; row < stringArray.length; row++)
		{
			for (int col = 0; col < stringArray[row].length; col++)
			{
				System.out.print(stringArray[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public ArrayFrame getAppFrame()
	{
		return appFrame;
	}

	public Instrument[][] getMyInstruments()
	{
		return myInstruments;
	}
	
	public Instrument[][] setMyInstruments(Instrument[][] newInstruments)
	{
		myInstruments = newInstruments;
		return myInstruments;
	}

	public Instrument getOneInstrument(int row, int col)
	{
		return myInstruments[row][col];
	}

	public String[] getInstrumentColumnNames()
	{
		return instrumentColumnNames;
	}
	
	public String[] getSortedInstrumentColumnNames()
	{
		return sortedInstrumentColumnNames;
	}
}	