package org.terzieva.page.template;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.terzieva.page.domain.Area;
import org.terzieva.page.domain.AreaExit;
import org.terzieva.page.traversal.Direction;

public class AreaTemplate {

	public static String render(Area area, List<AreaExit> exits)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n").append(StringUtils.rightPad(area.getName(), 50)).append(" Exits: ( ");
		
		for (AreaExit exit : exits)
			builder.append(Direction.getShorthand(exit.getDirection())).append(" ");
		
		builder.append(")\n\n")
		.append(area.getDescription());
		
		return builder.toString();
	}
	
}
