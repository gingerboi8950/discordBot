import java.sql.SQLException;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Change_title 
{

	public static void change_title(SlashCommandInteractionEvent event, EmbedBuilder embed) throws SQLException
	{
		String userId = event.getMember().getId();
		int userCheese = SQLcmds.retrieveCheese(userId);
		int titleID = event.getOptions().get(0).getAsInt();
		int cheeseCost = SQLcmds.retrieveTitleCost(titleID);
		int stolenCheese = SQLcmds.retrieveStolenCheese(userId);
		int sharedCheese = SQLcmds.retrieveSharedCheese(userId);
		int Mahalo = SQLcmds.retrieveMahaloSecret(userId);
		int RatSteal = SQLcmds.retrieveBotSecret(userId);
		
        event.deferReply(true).queue();
		if (titleID >= 100 && titleID <= 109) 
        {
			if (isValidTitle(titleID, userCheese, cheeseCost, sharedCheese, stolenCheese, Mahalo, RatSteal)) 
			{
	            SQLcmds.changeTitle(userId, titleID);
	            embed.setDescription("Your title has been updated");
	            embed.setColor(0xF7DF47);
	            event.getHook().sendMessageEmbeds(embed.build()).queue();
	        } 
			else 
	        {
	            event.getHook().sendMessage("You do not meet that title's requirements.").setEphemeral(true).queue();
	        }
        }
		else
		{
            event.getHook().sendMessage("Not a valid title ID.").setEphemeral(true).queue();

		}
			
    }

    private static boolean isValidTitle(int titleID, int userCheese, int cheeseCost, int sharedCheese, int stolenCheese, int Mahalo, int RatSteal)
    {
        if (titleID >= 100 && titleID <= 109) 
        {
            if (titleID == 100 || titleID == 101 || titleID == 102 || titleID == 103 || titleID == 104 || titleID == 105) 
            {
                return cheeseCost <= userCheese;
            } 
            else if (titleID == 106) 
            {
                return cheeseCost <= sharedCheese;
            } 
            else if (titleID == 107) 
            {
                return cheeseCost <= stolenCheese;
            } 
            else if (titleID == 109) 
            {
                return RatSteal == 1;
            }
        } 
        else 
        {
            return false; // Invalid title ID
        }
        return true; // Default case
    }
}
	

