import java.sql.SQLException;
import java.util.EventListener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Sub_cheese 
{

	
	public static void sub_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
			String userId = event.getOptions().get(1).getAsMember().getId();
			SQLcmds.checkIfUserExist(userId);	
			
		   event.deferReply().queue();
			OptionMapping option = event.getOption("number");
			int num = option.getAsInt();
			String user = event.getOptions().get(1).getAsMember().getAsMention();  
			
			SQLcmds.subtractCheese(num, userId);
			embed.setColor(0xF7DF47);
		    embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1151316885007249538/cheese_down.png");
			int total = SQLcmds.retrieveCheese(userId);
		    embed.setDescription("You subtracted " + num + " cheese from " + user + "!\n Their new total is: **" + total + "**");
	        event.getHook().sendMessageEmbeds(embed.build()).queue();;    
	
	}

	
   
	
}
