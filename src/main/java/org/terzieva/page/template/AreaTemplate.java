package org.terzieva.page.template;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.terzieva.page.domain.Area;
import org.terzieva.page.domain.AreaExit;
import org.terzieva.page.domain.Player;
import org.terzieva.page.traversal.Direction;

public class AreaTemplate {

	public static String render(Area area, List<AreaExit> exits, List<Player> players)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n").append(StringUtils.rightPad(area.getName(), 50)).append(" Exits: ( ");
		
		for (AreaExit exit : exits)
			builder.append(Direction.getShorthand(exit.getDirection())).append(" ");
		
		builder.append(")\n\n");
		
		Matcher m = Pattern.compile("(.{1,100}(\\W|$))").matcher(area.getDescription());
		while (m.find()) {
		    builder.append(m.group()).append("\n");
		}
		
		builder.append("\n");
		
		for (Player player : players) {
			builder.append(player.getEmail()).append(" is here.");
		}
		
		return builder.toString();
	}
	
}
