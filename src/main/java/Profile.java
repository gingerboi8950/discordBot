import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Profile 
{

	public static void profile(SlashCommandInteractionEvent event, EmbedBuilder embed)
	{
		
		event.deferReply().queue();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Date date = new Date();
		int tot_cheese = 0;
		int stolen_cheese = 0;
		int shared_cheese = 0;
		String user = event.getOptions().get(0).getAsMember().getEffectiveName();    
		String avatar = event.getOptions().get(0).getAsUser().getAvatarUrl();
		String title = "Random Title";
		embed.setColor(0xF7DF47);
		embed.setTitle(title);
		embed.setAuthor(user);
		if(avatar != null)
			embed.setThumbnail(avatar);
		else
			embed.setThumbnail("https://cdn.discordapp.com/attachments/747447865013436437/1151526191635906601/pileofcheese.png");
		embed.addField("Stats","Total Cheese: " + tot_cheese +"\nStolen Cheese: " + stolen_cheese + "\nShared Cheese: " + shared_cheese + " ", true);
		embed.setFooter("Date: "+ sdf.format(date), event.getGuild().getIconUrl());
	//	event.replyEmbeds(embed.build()).queue();
        event.getHook().sendMessageEmbeds(embed.build()).queue();
		
		
        
        
		
        //event.getChannel().sendMessageEmbeds(embed.build()).queue();

	}
	
	
}
