package array.model;

public class Instrument
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
}
