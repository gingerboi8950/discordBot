import java.sql.SQLException;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Add_cheese {
	private static String CHEESE_UP = "https://cdn.discordapp.com/attachments/747447865013436437/1151316884629758032/cheese_up.png";
	public static void add_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		String userId = event.getOptions().get(1).getAsMember().getId();
		SQLcmds.checkIfUserExist(userId);
		event.deferReply().queue();
		OptionMapping option = event.getOption("number");
		int num = option.getAsInt();
		SQLcmds.AddCheese(num, userId);
		String user = event.getOptions().get(1).getAsMember().getAsMention();
		embed.setColor(0xF7DF47);
		embed.setImage(CHEESE_UP);
		int total = SQLcmds.retrieveCheese(userId);
		embed.setDescription("You added " + num + " cheese to " + user + "!\n Their new total is: **" + total + "**");
		event.getHook().sendMessageEmbeds(embed.build()).queue();
	}

}
