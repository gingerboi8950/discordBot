import java.sql.SQLException;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Change_title 
{

	public static void change_title(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		String userId = event.getMember().getId();
		int userCheese = SQLcmds.retrieveCheese(userId);
		int titleID = event.getOptions().get(0).getAsInt();
		int cheeseCost = SQLcmds.retrieveTitleCost(titleID);
		int stolenCheese = SQLcmds.retrieveStolenCheese(userId);
		int sharedCheese = SQLcmds.retrieveSharedCheese(userId);
		int Mahalo = SQLcmds.retrieveMahaloSecret(userId);
		int RatSteal = SQLcmds.retrieveBotSecret(userId);
		

		
		if(titleID == 100)
		{
			if(cheeseCost > userCheese)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
		}
		
		else if(titleID == 101)
		{
			if(cheeseCost > userCheese)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
		}
		
		else if(titleID == 102)
		{
			if(cheeseCost > userCheese)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
		}
		
		else if(titleID == 103)
		{
			if(cheeseCost > userCheese)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
		}
		
		else if(titleID == 104)
		{
			if(cheeseCost > userCheese)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
		}
		
		else if(titleID == 105)
		{
			if(cheeseCost > userCheese)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
		}
		
		else if(titleID == 106)
		{
			if(cheeseCost > sharedCheese)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			
		}
		
		else if(titleID == 107)
		{
			if(cheeseCost > stolenCheese)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
		}
		
		else if(Mahalo != 1)
		{
			if(cheeseCost > userCheese)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
		}
		
		else if(titleID == 109)
		{
			if(RatSteal != 1)
			{
				event.deferReply().queue();
				embed.setDescription("You do not meet that title's requirements.");
				embed.setColor(0xF7DF47);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
			SQLcmds.changeTitle(userId, titleID);
			event.deferReply().queue();
			embed.setDescription("Your title has been updated");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
		}
		//Catches an invalid ID number.
		else
		{
			event.deferReply().queue();
			embed.setDescription("Not a valid title ID number.");
			embed.setColor(0xF7DF47);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
		}
		
		
		
		

		
		
	}
	
}
