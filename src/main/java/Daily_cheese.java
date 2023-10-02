import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.sql.SQLException;
import java.util.Random;

public class Daily_cheese 
{

	public static void daily(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		

		String userId = event.getMember().getId();
		SQLcmds.checkIfUserExist(userId);
		
		event.deferReply().queue();;
		int ranNum = randomNumGen();
		
		SQLcmds.AddCheese(ranNum, userId);
		int total = SQLcmds.retrieveCheese(userId);
		embed.setColor(0xF7DF47);
	    embed.setDescription("You got " + ranNum + " cheese!\nYour new total is **" + total + "**");
	    embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1151316884629758032/cheese_up.png");
        
        event.getHook().sendMessageEmbeds(embed.build()).queue();;
	    

	
	}
	
	public static int randomNumGen()
	{
		Random rand = new Random();
		int[] numArr = new int[100];
		int num;
		int index = rand.nextInt(100);
		for(int i = 0; i < numArr.length; ++i)
		{
			numArr[i] = rand.nextInt(250);
		}
		for(int i = 1; i < numArr.length; i=i*2)
		{
			numArr[i] = rand.nextInt(2500);
		}
		

		num = numArr[index];
		return num;
	}
	
	
	
	
}
