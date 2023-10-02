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
        		"**/Sub_cheese**: Subtract an amount of cheese from user. "
        		+ "\n**/Add_cheese**: Add an amount of cheese to user."
        		+ "\n**/Set_cheese**: Set a user's cheese amount.",true);
        embed.addField("Game", 
        		"**/Give_cheese**: Give some of your cheese to another user. "
        		+ "\n**/Steal_cheese**: Attempt to steal another user's cheese."
        		+ "\n**/Daily**: Every 24hrs roll for some cheese."
        		+ "\n**/Profile**: Displays your profile and some random statistics."
        		+ "\n**/Titles**: Displays the list of titles."
        		+ "\n**/Change_title**: Change your current title."
        		, true);

        event.getHook().sendMessageEmbeds(embed.build()).queue();;
        

	}
	
	
}
