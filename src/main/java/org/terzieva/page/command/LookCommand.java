package org.terzieva.page.command;

import org.springframework.stereotype.Component;
import org.terzieva.page.game.Context;
import org.terzieva.page.template.AreaTemplate;

@Component
public class LookCommand implements Command {

	@Override
	public String interpret(String input, Context context) {
		return AreaTemplate.render(context.player.getCurrentArea(),context.exits);
	}

}
