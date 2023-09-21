import java.util.EventListener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Sub_cheese 
{

	
	public static void sub_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed)
	{
	   
		   event.deferReply().queue();
			OptionMapping option = event.getOption("number");
			int num = option.getAsInt();
			String user = event.getOptions().get(1).getAsMember().getAsMention();    
			embed.setColor(0xF7DF47);
		    embed.setDescription("You subtracted " + num + " cheese from " + user + "!");
		    embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1151316885007249538/cheese_down.png");
	        event.getHook().sendMessageEmbeds(embed.build()).queue();;
	   
	   

	   
	    
	    
	    
	    
	    
       // event.getChannel().sendMessageEmbeds(embed.build()).queue();

		//event.reply("You subtracted " + num + " cheese from " + user + "!").queue();
	}

	
   
	
}
