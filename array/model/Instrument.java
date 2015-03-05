package array.model;

public class Instrument implements Comparable
{
	private String name;
	private double noiseLevel;
	private boolean isAWoodwind;

	
	public Instrument(String name, double noiseLevel, boolean isAWoodwind)
	{
		this.name = name;
		this.noiseLevel = noiseLevel;
		this.isAWoodwind = isAWoodwind;
	}
	
	public String getName()
	{
		return name;
	}
	public double getNoiseLevel()
	{
		return noiseLevel;
	}
	public boolean isAWoodwind()
	{
		return isAWoodwind;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setNoiseLevel(double noiseLevel)
	{
		this.noiseLevel = noiseLevel;
	}
	public void setAWoodwind(boolean isAWoodwind)
	{
		this.isAWoodwind = isAWoodwind;
	}

	@Override
	public String toString()
	{
		String instrumentInfo = "";
		
		instrumentInfo += "Hi I am a instrument object. My name is " + name;
		instrumentInfo += ". I have a noise level of: " + noiseLevel;
		if(isAWoodwind)
		{
			instrumentInfo += ". I am a woodwind.";
		}
		else
		{
			instrumentInfo += ". I am not a woodwind.";
		}
		
		return instrumentInfo;
	}
	
	/**
	 * Instruments that are woodwinds are higher than non-woodwinds.
	 * and Instruments of higher noise level are higher.
	 * Being a woodwind is more important than noise level.
	 */
	public int compareTo(Object comparedInstrument)
	{
		int compareValue = 0;
		if(((this.isAWoodwind) && ((Instrument) comparedInstrument).isAWoodwind()) || (!(this.isAWoodwind) && !((Instrument) comparedInstrument).isAWoodwind()))
		{
			if(this.noiseLevel < ((Instrument) comparedInstrument).getNoiseLevel())
			{
				compareValue = -1;
			}
			else if(this.noiseLevel > ((Instrument) comparedInstrument).getNoiseLevel())
			{
				compareValue = 1;
			}
		}
		else if((this.isAWoodwind) && !((Instrument) comparedInstrument).isAWoodwind())
		{
			compareValue = 1;
		}
		else if(!(this.isAWoodwind) && ((Instrument) comparedInstrument).isAWoodwind())
		{
			compareValue = -1;
		}

		
		return compareValue;
	}
	
}
