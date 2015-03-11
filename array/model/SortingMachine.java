package array.model;

public class SortingMachine
{
	private long startTime;
	private long endTime;
	private long sortTime;
	
	public long getSortTime()
	{
		return sortTime;
	}
	
	public String sortingTime(long sortTime)
	{
		String timeToSort = "";
		
		timeToSort += "Days: " + sortTime/(1000*60*60*24) + "\n";
		timeToSort += "Hours: " + sortTime/(1000*60*60) % 24 + "\n";
		timeToSort += "Minutes: " + sortTime/(1000*60) % 60 + "\n";
		timeToSort += "Seconds: " + sortTime/(1000) % 60 + "\n";
		timeToSort += "Milliseconds: " + sortTime % 1000 + "\n";
		
		return timeToSort;
	}
	
	public int[] selectionSortInt(int [] toBeSorted)
	{
		int minimum;
		int minimumPosition;
		startTime = System.currentTimeMillis();
		for(int position = 0; position < toBeSorted.length; position++)
		{
			minimumPosition = position;
			minimum = toBeSorted[position];
			for(int next = position + 1; next < toBeSorted.length; next++)
			{
				if(toBeSorted[next] < minimum)
				{
					minimum = toBeSorted[next];
					minimumPosition = next;
				}
			}
			if(minimumPosition != position)
			{
				swapInt(toBeSorted, position, minimumPosition);
			}
		}
		endTime = System.currentTimeMillis();
		
		sortTime = endTime - startTime;
		
		return toBeSorted;
	}
	
	private void swapInt(int[] array, int position, int change)
	{
		int temp = array[position];
		array[position] = array[change];
		array[change] = temp;
	}
	
	public Instrument[][] sortInstrumentsByNoiseLevel(Instrument[][] Instruments)
	{
		startTime = System.currentTimeMillis();
		Instrument[] sorterInstruments = instrumentConvertTwoDArrayToOneD(Instruments);
		for (int currentLocationToFill = 0; currentLocationToFill < sorterInstruments.length; currentLocationToFill++)
		{
			Instrument topInstrument = sorterInstruments[currentLocationToFill];
			int currentLocationToSwap = currentLocationToFill;
			for (int location = currentLocationToFill; location < sorterInstruments.length; location++)
			{
				if (topInstrument.getNoiseLevel() < sorterInstruments[location].getNoiseLevel())
				{
					topInstrument = sorterInstruments[location];
					currentLocationToSwap = location;
				}
			}
			swapInstruments(sorterInstruments, currentLocationToFill, currentLocationToSwap);
		}
		Instruments = instrumentConvertOneDArrayToTwoD(sorterInstruments, Instruments.length, Instruments[0].length);
		endTime = System.currentTimeMillis();
		sortTime = endTime - startTime;
		
		return Instruments;
	}
	
	public Instrument[][] sortInstrumentsAlphabetically(Instrument[][] Instruments)
	{
		startTime = System.currentTimeMillis();
		Instrument[] sorterInstruments = instrumentConvertTwoDArrayToOneD(Instruments);
		for (int currentLocationToFill = 0; currentLocationToFill < sorterInstruments.length; currentLocationToFill++)
		{
			Instrument topInstrument = sorterInstruments[currentLocationToFill];
			int currentLocationToSwap = currentLocationToFill;
			for (int location = currentLocationToFill; location < sorterInstruments.length; location++)
			{
				if ((topInstrument.toString().compareTo(sorterInstruments[location].toString())) >= 1)
				{
					topInstrument = sorterInstruments[location];
					currentLocationToSwap = location;
				}
			}
			swapInstruments(sorterInstruments, currentLocationToFill, currentLocationToSwap);
		}
		Instruments = instrumentConvertOneDArrayToTwoD(sorterInstruments, Instruments.length, Instruments[0].length);
		endTime = System.currentTimeMillis();
		sortTime = endTime - startTime;
		
		return Instruments;
	}
	
	/**
	 * This method sorts a 2d array of Instrument based on the Instrument compareTo method.
	 * The Instruments are sorted highest to lowest starting at the top left
	 * and going left to right then moving to the next row. (Standard English Paragraph Reading)
	 * @param Instruments
	 * @return Sorted 2d array of Instruments
	 */
	public Instrument[][] sortInstruments(Instrument[][] Instruments)
	{
		startTime = System.currentTimeMillis();
		Instrument[] sorterInstruments = instrumentConvertTwoDArrayToOneD(Instruments);
		for (int currentLocationToFill = 0; currentLocationToFill < sorterInstruments.length; currentLocationToFill++)
		{
			Instrument bestInstrument = sorterInstruments[currentLocationToFill];
			int currentLocationToSwap = currentLocationToFill;
			for (int location = currentLocationToFill; location < sorterInstruments.length; location++)
			{
				if ((bestInstrument.compareTo(sorterInstruments[location])) <= -1)
				{
					bestInstrument = sorterInstruments[location];
					currentLocationToSwap = location;
				}
			}
			swapInstruments(sorterInstruments, currentLocationToFill, currentLocationToSwap);
		}
		Instruments = instrumentConvertOneDArrayToTwoD(sorterInstruments, Instruments.length, Instruments[0].length);
		endTime = System.currentTimeMillis();
		sortTime = endTime - startTime;
		
		return Instruments;
	}
	
	public Instrument[] instrumentConvertTwoDArrayToOneD(Instrument[][] twoDArray)
	{
		int counter = 0;
		Instrument[] oneDArray = new Instrument[(twoDArray.length) * (twoDArray[0].length)];
		for (int row = 0; row < twoDArray.length; row++)
		{
			for (int col = 0; col < twoDArray[row].length; col++)
			{
				oneDArray[counter] = twoDArray[row][col];
				counter++;
			}
		}
		
		return oneDArray;
	}
	
	public Instrument[][] instrumentConvertOneDArrayToTwoD(Instrument[] oneDArray, int twoDRows, int twoDColumns)
	{
		int counter = 0;
		Instrument[][] twoDArray = new Instrument[twoDRows][twoDColumns];
		for (int row = 0; row < twoDArray.length; row++)
		{
			for (int col = 0; col < twoDArray[row].length; col++)
			{
				twoDArray[row][col] = oneDArray[counter];
				counter++;
			}
		}

		return twoDArray;
	}
	
	public void swapInstruments(Instrument[] array, int position, int change)
	{
		Instrument temp = array[position];
		array[position] = array[change];
		array[change] = temp;
	}
	
	
}
