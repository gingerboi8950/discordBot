import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Steal_cheese 
{

	public static void steal_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed) 
	{
        event.deferReply().queue();
		String user = event.getOptions().get(0).getAsMember().getAsMention();    
		int num = 5;
		embed.setColor(0xF7DF47);
	    embed.setDescription("You stole "+ num + " cheese from " + user + "!");
	    embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1151618881547415713/rat_thief.png");
       // event.replyEmbeds(embed.build());
        event.getHook().sendMessageEmbeds(embed.build()).queue();;
	    
	    //event.getChannel().sendMessageEmbeds(embed.build()).queue();

		
	}
	
	
}
