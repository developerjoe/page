package org.terzieva.page.collection;

import java.util.ArrayList;
import java.util.List;

import org.terzieva.page.domain.AreaExit;
import org.terzieva.page.traversal.Direction;

public class ExitList extends ArrayList<AreaExit> {

	private static final long serialVersionUID = 1L;
	
	public ExitList(List<AreaExit> exits)
	{
		this.addAll(exits);
	}
	
	public AreaExit getExit(String direction)
	{
		Direction enumD = Direction.fromString(direction);
		
		if(enumD == null) return null;
		
		for (AreaExit exit : this)
			if(enumD == exit.getDirection())
				return exit;
		
		return null;
	}
	
}
