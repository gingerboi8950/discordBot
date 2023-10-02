
import java.sql.SQLException;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Steal_cheese 
{

	public static void steal_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		
		String user = event.getOptions().get(0).getAsMember().getAsMention();   
		int ranNum = randomNumGen();
		String userId = event.getOptions().get(0).getAsMember().getId();
		String AuthorId = event.getMember().getId();
		int userCheese =  SQLcmds.retrieveCheese(userId);
		System.out.println(userId+"\n"+AuthorId);
		SQLcmds.checkIfUserExist(userId);
		SQLcmds.checkIfUserExist(AuthorId);
		
		double userIdDouble = Double.parseDouble(userId);
		double authorIdDouble = Double.parseDouble(AuthorId);
		double botIDDouble =  Double.parseDouble("1069092582707183656");
		double MahaloIDDouble = Double.parseDouble("236997624870338561");
        event.deferReply().queue();
		embed.setColor(0xF7DF47);
		
		if(userIdDouble == authorIdDouble) // Catch for self steal
		{
			embed.setDescription("Unlike the real world, you cannot steal from yourself.");
			embed.setImage("https://media.discordapp.net/attachments/747447865013436437/1158219221365432350/image.png?width=931&height=931");
		}
		
		else if(userIdDouble == botIDDouble) // Bot Easter Egg
		{
			SQLcmds.updateBotSecret(AuthorId);
			embed.setTitle("Who do you think you are!");
			embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1157006427299250338/rat_bot.png?ex=651709b4&is=6515b834&hm=768bb7d22bb2ebd22dffbe71c1bad817d27b11905da0135c66b5062aa63c8af6&");
			embed.setDescription("Well, I will not be robbed by some **ineffectual**, **privileged**, **effete**, **soft-penis'd**, **debutante**. "
					+ "You want to start a street fight with me bring it on but you will be surprised by how ugly it gets,"
					+ " you don't even know my real name- I'm the **fucking lizard king!**");
		}
		else if(userIdDouble == MahaloIDDouble) // Mahalo Easter Egg
		{
			SQLcmds.mahaloSecret(userId);
			if(userCheese > 0)
			{
				if(userCheese - ranNum < 0)
				{
					SQLcmds.AddCheese(userCheese, AuthorId);
					SQLcmds.subtractCheese(userCheese, userId);
					SQLcmds.updateStolenCheese(AuthorId, userCheese);
					embed.setDescription("You stole "+ userCheese + " cheese from " + user + "!");
				}
				else
				{
					SQLcmds.AddCheese(ranNum, AuthorId);
					SQLcmds.subtractCheese(ranNum, userId);
					SQLcmds.updateStolenCheese(AuthorId, ranNum);

					embed.setDescription("You stole "+ ranNum + " cheese from " + user + "!");
				}
				
				embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1151618881547415713/rat_thief.png");
			}
			else
			{
				embed.setDescription(user + " has no cheese to steal!");
				embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1156453226321809468/shrug_rat.png?ex=6515067f&is=6513b4ff&hm=fe3cf8b7b4668b021a15549546eb51c2948792054a4b686a3af0fb35a0716b9f&");
			}
		}
		
		else // Handles all other steals
		{
			if(userCheese > 0)
			{
				if(userCheese - ranNum < 0)
				{
					SQLcmds.AddCheese(userCheese, AuthorId);
					SQLcmds.subtractCheese(userCheese, userId);
					SQLcmds.updateStolenCheese(AuthorId, userCheese);
					embed.setDescription("You stole "+ userCheese + " cheese from " + user + "!");
				}
				else
				{
					SQLcmds.AddCheese(ranNum, AuthorId);
					SQLcmds.subtractCheese(ranNum, userId);
					SQLcmds.updateStolenCheese(AuthorId, ranNum);

					embed.setDescription("You stole "+ ranNum + " cheese from " + user + "!");
				}
				
				embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1151618881547415713/rat_thief.png");
			}
			else
			{
				embed.setDescription(user + " has no cheese to steal!");
				embed.setImage("https://cdn.discordapp.com/attachments/747447865013436437/1156453226321809468/shrug_rat.png?ex=6515067f&is=6513b4ff&hm=fe3cf8b7b4668b021a15549546eb51c2948792054a4b686a3af0fb35a0716b9f&");
			}
		}
		
		
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
			numArr[i] = rand.nextInt(1000);
		}
		

		num = numArr[index];
		return num;
	}
}
