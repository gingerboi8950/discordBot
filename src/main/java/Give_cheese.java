import java.sql.SQLException;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Give_cheese
{

	public static void give_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		String user = event.getOptions().get(1).getAsMember().getAsMention();    
		String AuthorId = event.getMember().getId();
		String userId = event.getOptions().get(1).getAsMember().getId();
		OptionMapping option = event.getOption("number");
		int num = option.getAsInt();
		int total = SQLcmds.retrieveCheese(userId);
		double userIdDouble = Double.parseDouble(userId);
		double authorIdDouble = Double.parseDouble(AuthorId);
		
		SQLcmds.checkIfUserExist(userId);
		SQLcmds.checkIfUserExist(AuthorId);

        event.deferReply().queue();

		int authorCheese = SQLcmds.retrieveCheese(AuthorId);
		if(userIdDouble == authorIdDouble) // Catch for self steal
		{
			embed.setDescription("You cannot donate cheese to yourself.");
			embed.setImage("https://media.discordapp.net/attachments/747447865013436437/1158219221365432350/image.png?width=931&height=931");
		}
		else
		{
			if(authorCheese < num)
			{
				embed.setColor(0xF7DF47);
			    embed.setDescription("You do not have enough cheese!"); 
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.giveCheese(num, userId, AuthorId);
			SQLcmds.updateSharedCheese(AuthorId, num);
			embed.setColor(0xF7DF47);
		    embed.setDescription("You gave " + num + " cheese to " + user + "!\n Their new total is: **" + total + "**"); 
		    embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1151316884629758032/cheese_up.png"); 
		}
		
		}
        event.getHook().sendMessageEmbeds(embed.build()).queue();

	  
	}
	
}
