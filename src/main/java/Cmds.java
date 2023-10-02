import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Cmds extends ListenerAdapter 
{
	
	
	
	@Override
	public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event)
	{
		
		//-------------------SQL Stuff---------------------------
	
	            // Load the MySQL JDBC driver
	            try 
	            {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e3) 
	            {
					e3.printStackTrace();
				}
		
		//-------------------------------------------------
		
	    EmbedBuilder embed = new EmbedBuilder();
		
		if(event.getName().equals("sub_cheese"))
			try 
			{
				Sub_cheese.sub_cheese(event, embed);
			} 
			catch (SQLException e2) 
			{
				e2.printStackTrace();
			}
		
		if(event.getName().equals("add_cheese"))
			try 
			{
				Add_cheese.add_cheese(event, embed);
			} 
			catch (SQLException e2) 
			{
				e2.printStackTrace();
			}
		
		if(event.getName().equals("daily"))
			try 
			{
				Daily_cheese.daily(event, embed);
			} 
			catch (SQLException e2) 
			{
				e2.printStackTrace();
			}
		
		if(event.getName().equals("give_cheese"))
			try
			{
				Give_cheese.give_cheese(event, embed);
			} 
			catch (SQLException e2)
			{
				e2.printStackTrace();
			}
		
		if(event.getName().equals("steal_cheese"))
			try
			{
				Steal_cheese.steal_cheese(event, embed);
			} 
			catch (SQLException e2)
			{
				e2.printStackTrace();
			}
		
		if(event.getName().equals("help"))
			Help.help(event, embed);
		
		if(event.getName().equals("profile"))
		{
			try 
			{
				Profile.profile(event, embed);
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		if(event.getName().equals("titles"))
		{
			try 
			{
				Titles.PrintTitles(event, embed);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
		if(event.getName().equals("change_title"))
		{
			try 
			{
				Change_title.change_title(event, embed);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		if(event.getName().equals("set_cheese"))
		{
			try 
			{
				Set_cheese.set_cheese(event, embed);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
