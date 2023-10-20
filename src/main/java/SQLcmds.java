import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLcmds 
{
    public static void updateBotSecret(String userId) throws SQLException
    {
    	String UpdateStealBotCommand = "UPDATE `player` SET `stealbot`='1' WHERE playerId =" + userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
		connection.prepareStatement(UpdateStealBotCommand).execute(UpdateStealBotCommand);
        connection.close();
    }
    
    public static int retrieveBotSecret(String userId) throws SQLException
    {
    	String RetrieveStealBotCommand = "SELECT `stealbot` FROM player WHERE playerId =" + userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
		 ResultSet resultSet = connection.prepareStatement(RetrieveStealBotCommand).executeQuery(RetrieveStealBotCommand);
			int userCheese = 0;
			
			while (resultSet.next()) 
	        {
				userCheese = resultSet.getInt("stealbot");
	        }
			connection.close();
			return userCheese;
    }
    
    public static void mahaloSecret(String userId) throws SQLException
    {
    	String UpdateMahaloCommand = "UPDATE `player` SET `mahalofam`='1' WHERE playerId =" + userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
		connection.prepareStatement(UpdateMahaloCommand).execute(UpdateMahaloCommand);
        connection.close();
    }
    
    public static int retrieveMahaloSecret(String userId) throws SQLException
    {
    	String RetrieveMahaloCommand = "SELECT `mahalofam` FROM player WHERE playerId =" + userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
		 ResultSet resultSet = connection.prepareStatement(RetrieveMahaloCommand).executeQuery(RetrieveMahaloCommand);
			int userCheese = 0;
			
			while (resultSet.next()) 
	        {
				userCheese = resultSet.getInt("mahalofam");
	        }
			connection.close();
			return userCheese;
    }
    
	public static void changeTitle(String userId, int titleId) throws SQLException 
	{
		String ChangeTitleCommand = "UPDATE `player` SET `titleId`= '" + titleId + "' WHERE playerId =" + userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
		connection.prepareStatement(ChangeTitleCommand).execute(ChangeTitleCommand);
        connection.close();
	}
	
	public static void updateStolenCheese(String userId, int stolenCheese) throws SQLException
	{
		String command = "SELECT stolencheese FROM player WHERE playerId ="+ userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        ResultSet resultSet = connection.prepareStatement(command).executeQuery(command);
		int userCheese = 0;
		
		while (resultSet.next()) 
        {
			userCheese = resultSet.getInt("stolencheese");
        }
		stolenCheese  += userCheese;
		String UpdateStolenCheeseCommand = "UPDATE `player` SET `stolencheese`= '" + stolenCheese + "' WHERE playerId =" + userId;
		connection.prepareStatement(UpdateStolenCheeseCommand).execute(UpdateStolenCheeseCommand);
        connection.close();

	}
	
	public static void updateSharedCheese(String userId, int sharedCheese) throws SQLException
	{
		String Retrievecommand = "SELECT sharedcheese FROM player WHERE playerId ="+ userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        ResultSet resultSet = connection.prepareStatement(Retrievecommand).executeQuery(Retrievecommand);
		int userCheese = 0;
		
		while (resultSet.next()) 
        {
			userCheese = resultSet.getInt("sharedcheese");
        }
		sharedCheese  += userCheese;
		String UpdateSharedCheeseCommand = "UPDATE `player` SET `sharedcheese`= '" + sharedCheese + "' WHERE playerId =" + userId;
		connection.prepareStatement(UpdateSharedCheeseCommand).execute(UpdateSharedCheeseCommand);
        connection.close();
	}
	
	public static int retrieveStolenCheese(String userId) throws SQLException
	{
		
		String command = "SELECT stolencheese FROM player WHERE playerId ="+ userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        ResultSet resultSet = connection.prepareStatement(command).executeQuery(command);
		int userCheese = 0;
		
		while (resultSet.next()) 
        {
			userCheese = resultSet.getInt("stolencheese");
        }
        connection.close();
        return userCheese;
		}
	
	public static int retrieveSharedCheese(String userId) throws SQLException
	{
		
		String command = "SELECT sharedcheese FROM player WHERE playerId ="+ userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        ResultSet resultSet = connection.prepareStatement(command).executeQuery(command);
		int userCheese = 0;
		
		while (resultSet.next()) 
        {
			userCheese = resultSet.getInt("sharedcheese");
        }
        connection.close();
        return userCheese;
		}
	
	
	public static String retrieveTitle(String userId) throws SQLException
	{
        String test = "SELECT title.title FROM `player`LEFT JOIN title ON player.titleId = title.titleId WHERE playerId ="+userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        ResultSet resultSet = connection.prepareStatement(test).executeQuery(test);
        String title = "";
      
        while (resultSet.next()) 
        {
             title = title + "\n" + resultSet.getString("title"); //Column name is in parenthesis
        }
        connection.close();
        return title;
	}
	
	
	public static int retrieveTitleCost(int titleId) throws SQLException
	{
		
		String command = "SELECT cost FROM title WHERE titleId =" + titleId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        ResultSet resultSet = connection.prepareStatement(command).executeQuery(command);
		int titleCost = 0;
		
		while (resultSet.next()) 
        {
			titleCost = resultSet.getInt("cost");
        }
        connection.close();
        return titleCost;
		}
	
	
	public static void subtractCheese(int numToSub,String userId) throws SQLException
	{
		String retrieveCommand = "SELECT cheese FROM player WHERE playerId = " + userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        connection.prepareStatement(retrieveCommand).execute(retrieveCommand);
        ResultSet resultSet = connection.prepareStatement(retrieveCommand).executeQuery(retrieveCommand);
		//Get the user's current cheese from database
        int userCheese = 0;
		while (resultSet.next()) 
        {
			userCheese = resultSet.getInt("cheese");
        }
        //Subtract the cheese
		userCheese -= numToSub;
        //Update the database's cheese #
        String updateCommand = "UPDATE `player` SET `cheese`= " + userCheese + " WHERE playerId = " + userId;
        connection.prepareStatement(updateCommand).execute(updateCommand);
        
        connection.close();
	}
	
	
	public static void AddCheese(int numToAdd,String userId) throws SQLException
	{
		String retrieveCommand = "SELECT cheese FROM player WHERE playerId = " + userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        connection.prepareStatement(retrieveCommand).execute(retrieveCommand);
        ResultSet resultSet = connection.prepareStatement(retrieveCommand).executeQuery(retrieveCommand);
		//Get the user's current cheese from database
        int userCheese = 0;
		while (resultSet.next()) 
        {
			userCheese = resultSet.getInt("cheese");
        }
        //Add the cheese
		userCheese += numToAdd;
        //Update the database's cheese #
        String updateCommand = "UPDATE `player` SET `cheese`= " + userCheese + " WHERE playerId = " + userId;
        connection.prepareStatement(updateCommand).execute(updateCommand);
        
        connection.close();
	}
	
	
	public static void updateCheese(int numUpdate, String userId) throws SQLException
	{
		//Update the user's current cheese from database
		String UpdateCommand = "UPDATE `player` SET `cheese`='" + numUpdate + "' WHERE playerId =  " + userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        connection.prepareStatement(UpdateCommand).execute(UpdateCommand);
        connection.close();

	}
	
	
	public static void giveCheese(int numToGive,String userId, String authorId) throws SQLException
	{
		//Get the user's current cheese from database
		String retrieveCommand = "SELECT cheese FROM player WHERE playerId = " + userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        connection.prepareStatement(retrieveCommand).execute(retrieveCommand);
        ResultSet resultSet = connection.prepareStatement(retrieveCommand).executeQuery(retrieveCommand);
        
        int userCheese = 0;
		while (resultSet.next()) 
        {
			userCheese = resultSet.getInt("cheese");
        }
        
		//Add the user cheese
		userCheese += numToGive;
		
		//Get the A's current cheese from database
		String retrieveAuthor = "SELECT cheese FROM player WHERE playerId = " + authorId;
		connection.prepareStatement(retrieveAuthor).execute(retrieveAuthor);
	    ResultSet resultAuthor = connection.prepareStatement(retrieveAuthor).executeQuery(retrieveAuthor);
        
	    int AuthorCheese = 0;
		while (resultAuthor.next()) 
        {
			AuthorCheese = resultAuthor.getInt("cheese");
        }
	    
		//Sub the author cheese 
		AuthorCheese -= numToGive;
		
		//Update the Author's cheese #
		String updateAuthor = "UPDATE `player` SET `cheese`= " + AuthorCheese + " WHERE playerId = " + authorId;
        connection.prepareStatement(updateAuthor).execute(updateAuthor);
		
        //Update the user's cheese #
        String updateUser = "UPDATE `player` SET `cheese`= " + userCheese + " WHERE playerId = " + userId;
        connection.prepareStatement(updateUser).execute(updateUser);
        
        
        connection.close();
	}
	
	public static int retrieveCheese(String userId) throws SQLException
	{
		
		String command = "SELECT cheese FROM player WHERE playerId ="+ userId;
		Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
        ResultSet resultSet = connection.prepareStatement(command).executeQuery(command);
		int userCheese = 0;
		
		while (resultSet.next()) 
        {
			userCheese = resultSet.getInt("cheese");
        }
        connection.close();
        return userCheese;
		}

	
	public static void checkIfUserExist(String userId) throws SQLException
	{
	String command = "INSERT IGNORE INTO player (playerId) SELECT DISTINCT '"+ userId +"' WHERE NOT EXISTS (SELECT 1 FROM player WHERE playerId = '"+userId+"')";	
	Connection connection = DriverManager.getConnection(Important.DB_URL,Important.DB_USERNAME,Important.DB_PASSWORD);
    connection.prepareStatement(command).execute(command);
    connection.close();

	}
	
	
	
}
