package org.terzieva.page.traversal;

public enum Direction {

	NORTH, SOUTH, EAST, WEST, NORTHWEST, NORTHEAST, SOUTHWEST, SOUTHEAST;
	
	public static String getShorthand(Direction direction)
	{
		if(NORTH == direction) return "N";
		if(SOUTH == direction) return "S";
		if(EAST == direction) return "E";
		if(WEST == direction) return "W";
		if(NORTHWEST == direction) return "NW";
		if(NORTHEAST == direction) return "NE";
		if(SOUTHWEST == direction) return "SW";
		if(SOUTHEAST == direction) return "SE";
		return "";
	}
	
	public static Direction fromString(String direction)
	{
		Direction enumD = null;
		
		if(direction.equalsIgnoreCase("n") || 
				direction.equalsIgnoreCase("north"))
			enumD = Direction.NORTH;
		else if(direction.equalsIgnoreCase("s") || 
				direction.equalsIgnoreCase("south"))
			enumD = Direction.SOUTH;
		else if(direction.equalsIgnoreCase("e") || 
				direction.equalsIgnoreCase("east"))
			enumD = Direction.EAST;
		else if(direction.equalsIgnoreCase("w") || 
				direction.equalsIgnoreCase("west"))
			enumD = Direction.WEST;
		else if(direction.equalsIgnoreCase("nw") || 
				direction.equalsIgnoreCase("northwest"))
			enumD = Direction.NORTHWEST;
		else if(direction.equalsIgnoreCase("sw") || 
				direction.equalsIgnoreCase("southwest"))
			enumD = Direction.SOUTHWEST;
		else if(direction.equalsIgnoreCase("ne") || 
				direction.equalsIgnoreCase("northeast"))
			enumD = Direction.NORTHEAST;
		else if(direction.equalsIgnoreCase("se") || 
				direction.equalsIgnoreCase("southeast"))
			enumD = Direction.SOUTHEAST;
		
		return enumD;
	}
	
}
