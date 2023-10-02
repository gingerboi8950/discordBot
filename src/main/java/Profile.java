import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Profile 
{

	public static void profile(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		
		event.deferReply().queue();
		String user = event.getOptions().get(0).getAsMember().getEffectiveName(); 
		String userId = event.getOptions().get(0).getAsMember().getId();
		SQLcmds.checkIfUserExist(userId);
		int tot_cheese = SQLcmds.retrieveCheese(userId);
		int stolen_cheese =  SQLcmds.retrieveStolenCheese(userId);
		int shared_cheese = SQLcmds.retrieveSharedCheese(userId);
		String avatar = event.getOptions().get(0).getAsUser().getAvatarUrl();
		String title = SQLcmds.retrieveTitle(userId);
		embed.setColor(0xF7DF47);
		embed.setTitle(title);
		embed.setAuthor(user);
		if(avatar != null)
			embed.setThumbnail(avatar);
		else
			embed.setThumbnail("https://cdn.discordapp.com/attachments/747447865013436437/1151526191635906601/pileofcheese.png");
		embed.addField("Stats","Total Cheese: " + tot_cheese +"\nStolen Cheese: " + stolen_cheese + "\nShared Cheese: " + shared_cheese + " ", true);
        event.getHook().sendMessageEmbeds(embed.build()).queue();
		
		
       
       
		

	}
	
	
}
