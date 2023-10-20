import java.sql.SQLException;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Give_cheese
{
	private static String CHEESE_UP = "https://cdn.discordapp.com/attachments/747447865013436437/1151316884629758032/cheese_up.png";
	public static void give_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		String user = event.getOptions().get(1).getAsMember().getAsMention();    
		String AuthorId = event.getMember().getId();
		String userId = event.getOptions().get(1).getAsMember().getId();
		OptionMapping option = event.getOption("number");
		int num = option.getAsInt();
		int total = SQLcmds.retrieveCheese(userId);
		
		//Converted IDs because comparing two strings failed.
		double userIdDouble = Double.parseDouble(userId);
		double authorIdDouble = Double.parseDouble(AuthorId);
		
		SQLcmds.checkIfUserExist(userId);
		SQLcmds.checkIfUserExist(AuthorId);

        event.deferReply(true).queue();

		int authorCheese = SQLcmds.retrieveCheese(AuthorId);
		if(userIdDouble == authorIdDouble) // Catch for self steal
		{
	        event.getHook().sendMessage("You cannot donate cheese to yourself.").setEphemeral(true).queue();
		}
		else
		{
			if(authorCheese < num)
			{
		        event.getHook().sendMessage("You do not have enough cheese!").setEphemeral(true).queue();
			}
			else
			{
			SQLcmds.giveCheese(num, userId, AuthorId);
			SQLcmds.updateSharedCheese(AuthorId, num);
			embed.setColor(0xF7DF47);
		    embed.setDescription("You gave " + num + " cheese to " + user + "!\n Their new total is: **" + total + "**"); 
		    embed.setImage(CHEESE_UP); 
		    event.getHook().sendMessageEmbeds(embed.build()).queue();
		}
		
		}
	  
	}
	
}
