import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginException;

import com.amazonaws.util.IOUtils;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDA.Status;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.OnlineStatus;


public class Bot extends ListenerAdapter 
{
  
	private static String[] messages={"with cheese!", "around with recipes.", "with cheesy strategies."};
	private static int currentIndex=0;
	private static ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
	
	public static void main(String[] args) throws LoginException, InterruptedException
	{
				
		
		JDA jda = JDABuilder.createDefault(Important.BOT_TOKEN)
		.addEventListeners(new Bot())
		.addEventListeners(new Cmds())
		.build()
		.awaitReady();
		
		
	//---------Bot Status-------------
		
		

		threadPool.scheduleWithFixedDelay(() -> {
		    jda.getPresence().setActivity(Activity.playing(messages[currentIndex]));
		    currentIndex = (currentIndex + 1) % messages.length;
		}, 0, 30, TimeUnit.SECONDS);
		
		
		//------------ All Commands are used in Test Server ---------------- 
		Guild testGuild = jda.getGuildById(Important.COOPER_VAULT);
		

		
		if(testGuild != null)
			testGuild.upsertCommand("sub_cheese","Subtract cheese from a user.")
				.addOption(OptionType.INTEGER, "number", "The amount of cheese being removed.", true)
				.addOption(OptionType.USER, "user", "Select who you want to remove cheese from.",true)
				.queue();
			
			testGuild.upsertCommand("add_cheese","Add cheese to a user.")
				.addOption(OptionType.INTEGER, "number", "The amount of cheese being removed.", true)
				.addOption(OptionType.USER, "user", "Select who you want to remove cheese from.",true)
				.queue();
			
			testGuild.upsertCommand("give_cheese","Give cheese to a user.")
				.addOption(OptionType.INTEGER, "number", "The amount of cheese being removed.", true)
				.addOption(OptionType.USER, "user", "Select who you want to remove cheese from.",true)
				.queue();
				
			testGuild.upsertCommand("steal_cheese","Steal a random amount of cheese from a user..")
				.addOption(OptionType.USER, "user", "Select who you want to remove cheese from.",true)
				.queue();

			
			testGuild.upsertCommand("help","Displays a list of all commands.").queue();
			
			testGuild.upsertCommand("profile","Displays your user statistics.")
				.addOption(OptionType.USER, "user", "Select who you want to remove cheese from.",true)
				.queue();
			
			testGuild.upsertCommand("daily","Roll for a random number of cheese.").queue();
			
			testGuild.upsertCommand("titles","Lists a list of all titles.").queue();
			
			testGuild.upsertCommand("change_title","Change your title")
				.addOption(OptionType.INTEGER, "title_id", "Select the ID of the title you want.",true)
				.queue();
			
			testGuild.upsertCommand("set_cheese","Set a user's cheese amount.")
				.addOption(OptionType.USER, "user", "Select who you want to set cheese for.", true)
				.addOption(OptionType.INTEGER, "number", "Pick an amount of cheese to set.",true)
				.queue();
		}
	
	
	
	
	
	public void onReady(ReadyEvent event) 
	{
		System.out.println("The Bot is Running!");
	}
	
	
}

