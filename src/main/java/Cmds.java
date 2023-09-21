import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Cmds extends ListenerAdapter 
{
	@Override
	public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event)
	{
	    EmbedBuilder embed = new EmbedBuilder();
		
		if(event.getName().equals("sub_cheese"))
			Sub_cheese.sub_cheese(event, embed);
		
		if(event.getName().equals("add_cheese"))
			Add_cheese.add_cheese(event, embed);
		
		if(event.getName().equals("daily"))
			Daily_cheese.daily(event, embed);
		
		if(event.getName().equals("give_cheese"))
			Give_cheese.give_cheese(event, embed);
		
		if(event.getName().equals("steal_cheese"))
			Steal_cheese.steal_cheese(event, embed);
		
		if(event.getName().equals("help"))
			Help.help(event, embed);
		
		if(event.getName().equals("profile"))
			Profile.profile(event, embed);
		
		
		
	}
	
	
	
	
}
