import java.sql.SQLException;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Set_cheese {

	public static void set_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		String userId = event.getOptions().get(0).getAsMember().getId();
		String user = event.getOptions().get(0).getAsMember().getAsMention();
		int number = event.getOptions().get(1).getAsInt();
		SQLcmds.checkIfUserExist(userId);
		SQLcmds.updateCheese(number, userId);
		event.deferReply().queue();
		embed.setColor(0xF7DF47);
		embed.setDescription(user + "'s cheese has been set to " + number);
		event.getHook().sendMessageEmbeds(embed.build()).queue();
	}
	
	
	
	
}
