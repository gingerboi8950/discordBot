import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Give_cheese
{

	public static void give_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed)
	{
        event.deferReply().queue();
		OptionMapping option = event.getOption("number");
		int num = option.getAsInt();
		String user = event.getOptions().get(1).getAsMember().getAsMention();    
		embed.setColor(0xF7DF47);
	    embed.setDescription("You gave " + num + " cheese to " + user + "!"); 
	    embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1151316884629758032/cheese_up.png"); 
	   // event.replyEmbeds(embed.build()).queue();
        event.getHook().sendMessageEmbeds(embed.build()).queue();;
	    
	    //event.getChannel().sendMessageEmbeds(embed.build()).queue();

	//	event.reply("You gave " + num + " cheese to " + user + "!").queue();
	}
	
}
