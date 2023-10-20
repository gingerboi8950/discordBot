import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import java.sql.SQLException;
import net.dv8tion.jda.api.EmbedBuilder;


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
		embed.setThumbnail(avatar);
		embed.addField("Stats","Total Cheese: " + tot_cheese +"\nStolen Cheese: " + stolen_cheese + "\nShared Cheese: " + shared_cheese + " ", true);
        event.getHook().sendMessageEmbeds(embed.build()).queue();
	}
	
	
}
