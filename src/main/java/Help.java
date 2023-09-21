import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class Help 
{
    
	public static void help(SlashCommandInteractionEvent event, EmbedBuilder embed)
	{
        event.deferReply().queue();
        embed.setTitle("Commands");
        embed.setColor(0xF7DF47);
        embed.addField("Moderation",
        		"**Sub_cheese**: Subtract an amount of cheese from user. "
        		+ "\n**Add_cheese**: Add an amount of cheese to user.",true);
        embed.addField("Game", 
        		"**Give_cheese**: Give some of your cheese to another user. "
        		+ "\n**Steal_cheese**: Attempt to steal another user's cheese."
        		+ "\n**Daily**: Every 24hrs roll for some cheese."
        		+ "\n**Profile**: Shows your profile and some random statistics."
        		, true);
      /*  embed.setDescription(
        		"`Moderation:` "
        		+ "\n**Sub_cheese**: Subtract an amount of cheese from user. "
        		+ "\n**Add_cheese**: Add an amount of cheese to user.\n"
        		+ "\n`Game`:"
        		+ "\n**Give_cheese**: Give an amount of your cheese to another user."
        		+ "\n**Steal_cheese**: Attempt to steal some of another user's cheese. "
        		+ "\n**Daily**: Every 24hrs roll for some cheese. "
        		+ "\n**Profile**: Shows your profile and some random statistics. \n");
        		*/
        //event.replyEmbeds(embed.build()).queue();

        event.getHook().sendMessageEmbeds(embed.build()).queue();;
        
        //event.getChannel().sendMessageEmbeds(embed.build()).queue();


	}
	
	
}
