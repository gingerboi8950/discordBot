import java.sql.SQLException;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Titles {

	
	public static void PrintTitles(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{	
		
			event.deferReply().queue();
			String title = SQLcmds.printTitles();
			String cost = SQLcmds.printCost();
			String id = SQLcmds.printID();
			embed.setColor(0xF7DF47);
			embed.addField("ID", id, true);
			embed.addField("Titles", title, true);
			embed.addField("Cost", cost +"\nGive away 1500 cheese.\nSteal 1500 cheese.\n?????????\n?????????", true);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();
		
		
	}
	
	
}
