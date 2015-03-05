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
	private SortingMachine mySorter;

	public ArrayController()
	{
		myInstruments = new Instrument[3][4];
		myStringArray = new String[3][5];
		instrumentColumnNames = new String[4];
		fillArrays();
		appFrame = new ArrayFrame(this);
	}

	public void start()
	{
		// printIntArray(myIntArray);
		// printStringArray(myStringArray);
	}

	private void fillArrays()
	{
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
		
//		myInstruments = this.sortInstruments(myInstruments);
		!!!!!!!!!!!!!
		myInstruments = mySorter.sortInstruments(myInstruments);

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
	
	
	
	
	
	
//	/**
//	 * This method sorts a 2d array of Instrument based on the Instrument compareTo method.
//	 * The Instruments are sorted highest to lowest starting at the top left
//	 * and going left to right then moving to the next row. (Standard English Paragraph Reading)
//	 * @param Instruments
//	 * @return Sorted 2d array of Instruments
//	 */
//	public Instrument[][] sortInstruments(Instrument[][] Instruments)
//	{
//		Instrument[] sorterInstruments = instrumentConvertTwoDArrayToOneD(Instruments);
//		for (int currentLocationToFill = 0; currentLocationToFill < sorterInstruments.length; currentLocationToFill++)
//		{
//			Instrument bestInstrument = sorterInstruments[currentLocationToFill];
//			int currentLocationToSwap = currentLocationToFill;
//			for (int location = currentLocationToFill; location < sorterInstruments.length; location++)
//			{
//				if ((bestInstrument.compareTo(sorterInstruments[location])) <= -1)
//				{
//					bestInstrument = sorterInstruments[location];
//					currentLocationToSwap = location;
//				}
//			}
//			swapInstruments(sorterInstruments, currentLocationToFill, currentLocationToSwap);
//		}
//		Instruments = instrumentConvertOneDArrayToTwoD(sorterInstruments, Instruments.length, Instruments[0].length);
//
//		return Instruments;
//	}
//	
//	public Instrument[] instrumentConvertTwoDArrayToOneD(Instrument[][] twoDArray)
//	{
//		int counter = 0;
//		Instrument[] oneDArray = new Instrument[(twoDArray.length) * (twoDArray[0].length)];
//		for (int row = 0; row < twoDArray.length; row++)
//		{
//			for (int col = 0; col < twoDArray[row].length; col++)
//			{
//				oneDArray[counter] = twoDArray[row][col];
//				counter++;
//			}
//		}
//		
//		return oneDArray;
//	}
//	
//	public Instrument[][] instrumentConvertOneDArrayToTwoD(Instrument[] oneDArray, int twoDRows, int twoDColumns)
//	{
//		int counter = 0;
//		Instrument[][] twoDArray = new Instrument[twoDRows][twoDColumns];
//		for (int row = 0; row < twoDArray.length; row++)
//		{
//			for (int col = 0; col < twoDArray[row].length; col++)
//			{
//				twoDArray[row][col] = oneDArray[counter];
//				counter++;
//			}
//		}
//
//		return twoDArray;
//	}
//	
//	public void swapInstruments(Instrument[] array, int position, int change)
//	{
//		Instrument temp = array[position];
//		array[position] = array[change];
//		array[change] = temp;
//	}
}
