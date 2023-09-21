import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import java.util.Random;

public class Daily_cheese 
{

	public static void daily(SlashCommandInteractionEvent event, EmbedBuilder embed)
	{
		event.deferReply().queue();;
		int ranNum = randomNumGen();
		embed.setColor(0xF7DF47);
	    embed.setDescription("You won " + ranNum + " cheese!");
	    embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1151316884629758032/cheese_up.png");
        
      //  event.replyEmbeds(embed.build()).queue();
        event.getHook().sendMessageEmbeds(embed.build()).queue();;
	    
	    //event.getChannel().sendMessageEmbeds(embed.build()).queue();

	
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
