package org.terzieva.page.command;

import java.util.List;

import org.springframework.stereotype.Component;
import org.terzieva.page.domain.Player;
import org.terzieva.page.game.Context;
import org.terzieva.page.template.AreaTemplate;

@Component
public class LookCommand implements Command {

	@Override
	public String interpret(String input, Context context) {
		
		List<Player> players = Player.findNearbyOnlinePlayers(context.player).getResultList();
		
		return AreaTemplate.render(context.player.getCurrentArea(),context.exits,players);
	}

}
