import java.sql.SQLException;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Sub_cheese 
{
	private static String CHEESE_DOWN = "https://cdn.discordapp.com/attachments/1159279122518917141/1159279180551311391/cheese_down.png?ex=653071df&is=651dfcdf&hm=795eaa849ef370af3099b97581ab612a128b7708c7d2858c0600737b7887fb49&";
	public static void sub_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
			String userId = event.getOptions().get(1).getAsMember().getId();
			SQLcmds.checkIfUserExist(userId);	
			
		   event.deferReply().queue();
			OptionMapping option = event.getOption("number");
			int num = option.getAsInt();
			String user = event.getOptions().get(1).getAsMember().getAsMention();  
			
			SQLcmds.subtractCheese(num, userId);
			embed.setColor(0xF7DF47);
		    embed.setImage(CHEESE_DOWN);
			int total = SQLcmds.retrieveCheese(userId);
		    embed.setDescription("You subtracted " + num + " cheese from " + user + "!\n Their new total is: **" + total + "**");
	        event.getHook().sendMessageEmbeds(embed.build()).queue();;    
	
	}
}
