package org.terzieva.page.command;

import org.springframework.stereotype.Component;
import org.terzieva.page.collection.ExitList;
import org.terzieva.page.domain.Area;
import org.terzieva.page.domain.AreaExit;
import org.terzieva.page.game.Context;
import org.terzieva.page.template.AreaTemplate;

@Component
public class NavigationCommand implements Command {

	@Override
	public String interpret(String input, Context context) {
		
		AreaExit exit = context.exits.getExit(input);
		
		if(exit == null)
			return "Could not move in that direction.";
		else
		{
			context.area = Area.findArea(exit.getToArea().getId());
			context.exits = new ExitList(AreaExit.findAreaExitsByFromArea(context.area).getResultList());
			
			return AreaTemplate.render(context.area,context.exits);
		}
			
	}

}
