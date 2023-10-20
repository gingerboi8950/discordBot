import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Titles {
	public static void PrintTitles(SlashCommandInteractionEvent event, EmbedBuilder embed) 
	{			
			event.deferReply().queue();
			embed.setColor(0xF7DF47);
			embed.addField("ID   Title", "`100` Rat King\n`101`"
					+ " Cheese Connoisseur\n`102`"
					+ " Cheese Hoarder\n`103` "
					+ "I have enough to feed my kids\n`104` "
					+ "Peasant\n`105` "
					+ "Cheddar Knight\n`106` "
					+ "Cheddar Fiend\n`107` "
					+ "The Real Mahalofam\n`108` "
					+ "The Big Cheese\n"
					+ "Change titles  using: `/change_title`", false);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();	
	}

}
