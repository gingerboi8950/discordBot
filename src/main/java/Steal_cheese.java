import java.sql.SQLException;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Steal_cheese 
{
	private static String RAT_BOT = "https://cdn.discordapp.com/attachments/1159279122518917141/1159279165858644050/rat_bot.png?ex=653071db&is=651dfcdb&hm=b7bc7e1a58f5e2c5e4890a650892392b5f5e811276fb33dfea4dc2a9719625f8&";
	private static String RAT_THIEF = "https://cdn.discordapp.com/attachments/1159279122518917141/1159279187228631130/rat_thief.png?ex=653071e0&is=651dfce0&hm=327e0a123f6f9e7fe6e0e0f229f72f041c17d168c2c78c2de3213e151843a152&";
	public static void steal_cheese(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		String user = event.getOptions().get(0).getAsMember().getAsMention();   
		int ranNum = randomNumGen();
		String userId = event.getOptions().get(0).getAsMember().getId();
		String AuthorId = event.getMember().getId();
		int userCheese =  SQLcmds.retrieveCheese(userId);
		User username = event.getUser();
		SQLcmds.checkIfUserExist(userId);
		SQLcmds.checkIfUserExist(AuthorId);
		
		//Converted IDs because comparing two strings failed.
		double userIdDouble = Double.parseDouble(userId);
		double authorIdDouble = Double.parseDouble(AuthorId);
		double botIDDouble =  Double.parseDouble("1069092582707183656");
		double MahaloIDDouble = Double.parseDouble("236997624870338561");
		
        event.deferReply(true).queue();
		embed.setColor(0xF7DF47);
		
		if(userIdDouble == authorIdDouble) // Catch for self steal
		{
	        event.getHook().sendMessage("You cannot steal from yourself.").setEphemeral(true).queue();

		}
		
		else if(userIdDouble == botIDDouble) // Bot Easter Egg
		{
			handleBotSteal(event, userIdDouble, botIDDouble, AuthorId, ranNum, username, embed);
		}
		else if(userIdDouble == MahaloIDDouble) // Mahalo Easter Egg
		{
			handleMahaloSteal(event, userIdDouble, MahaloIDDouble, userCheese, AuthorId, userId, user, username, ranNum, embed);
		}
		else // Handles all other steals
		{
			if(userCheese > 0)
			{
				handleNormalSteal(event, userCheese, AuthorId, userId, user, ranNum, embed);
			}
		}			
	}
	
	public static void handleNormalSteal(SlashCommandInteractionEvent event, int userCheese, String AuthorId, String userId, String user, int ranNum, EmbedBuilder embed) throws SQLException
	{
		int stolenAmount = Math.min(userCheese, ranNum);
		if(userCheese > 0)
		{
				SQLcmds.AddCheese(stolenAmount, AuthorId);
				SQLcmds.subtractCheese(stolenAmount, userId);
				SQLcmds.updateStolenCheese(AuthorId, stolenAmount);
				embed.setDescription("You stole "+ stolenAmount + " cheese from " + user + "!");
				embed.setImage(RAT_THIEF);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();

		}
		else
		{
	        event.getHook().sendMessage(user + " has no cheese to steal!").setEphemeral(true).queue();
		}
	}
	
	public static void handleBotSteal(SlashCommandInteractionEvent event, double userIdDouble, double botIDDouble, String AuthorId, int ranNum, User username, EmbedBuilder embed) throws SQLException
	{
			int timesStolen = SQLcmds.retrieveBotSecret(AuthorId);
			if(timesStolen == 1)
			{
				embed.setTitle("Clearly you did not learn your lesson.");
				embed.setDescription("I'll be taking " + ranNum + " cheese from you.");
				SQLcmds.subtractCheese(ranNum, AuthorId);
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
			else
			{
				sendMessage(username,"You just unlocked \"**The Big Cheese**\" title.\n Use `/change_title` to change your title.");
				SQLcmds.updateBotSecret(AuthorId);
				embed.setTitle("Who do you think you are!");
				embed.setImage(RAT_BOT);
				embed.setDescription("Well, I will not be robbed by some **ineffectual**, **privileged**, **effete**, **debutante**. "
						+ "You want to start a street fight with me bring it on but you will be surprised by how ugly it gets.");
		        event.getHook().sendMessageEmbeds(embed.build()).queue();
			}
	}
	
	public static void handleMahaloSteal(SlashCommandInteractionEvent event, double userIdDouble, double MahaloIDDouble, int userCheese, String AuthorId, String userId, String user, User username, int ranNum, EmbedBuilder embed) throws SQLException
	{
		int stolenAmount = Math.min(userCheese, ranNum);
		sendMessage(username,"You just unlocked \"**The Real Mahalofam**\" title.\n Use `/change_title` to change your title.");
		SQLcmds.mahaloSecret(userId);
		if(userCheese > 0)
		{
			SQLcmds.AddCheese(stolenAmount, AuthorId);
			SQLcmds.subtractCheese(stolenAmount, userId);
			SQLcmds.updateStolenCheese(AuthorId, stolenAmount);
			embed.setDescription("You stole "+ stolenAmount + " cheese from " + user + "!");
			embed.setImage(RAT_THIEF);
	        event.getHook().sendMessageEmbeds(embed.build()).queue();

		}
		else
		{
	        event.getHook().sendMessage(user + " has no cheese to steal!").setEphemeral(true).queue();
		}
	}
	
	public static int randomNumGen() //Method for generating a random number.
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
	
	public static void sendMessage(User user, String content) //Method that DMs user.
	{
	    user.openPrivateChannel()
	        .flatMap(channel -> channel.sendMessage(content))
	        .queue();
	}
	
}
