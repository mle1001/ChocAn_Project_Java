
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;



public class Directory{

			//Data Base URL 
			static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/chocan";
			static final String USERNAME = "root";
			static final String PASSWORD =  "myparent9";
			
			
				//Manage Connection 
				private Connection connection = null;
				private PreparedStatement selectAllProviders = null;
				private PreparedStatement selectAllMembers = null;
				private PreparedStatement selectProviderById = null;
				private PreparedStatement selectMemberById = null;
				private PreparedStatement selectById= null;
				private PreparedStatement insertNewUser = null;
				private PreparedStatement deleteUser = null;
				@SuppressWarnings("unused")
				private PreparedStatement updateEntry = null;
				
			public Directory(){
				try
				{
					
					connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
					//Create query that selects all Providers from ChocAn
					selectAllProviders = connection.prepareStatement("SELECT * FROM ChocAn_Data.ChocAn WHERE type = 'Provider'");
					//Create query that selects all Members from ChocAn
					selectAllMembers = connection.prepareStatement("SELECT * FROM ChocAn_Data.ChocAn WHERE type = 'Member'");
					//Create query that selects Provider by id
					selectProviderById = connection.prepareStatement("SELECT * FROM ChocAn_Data.ChocAn WHERE type = 'Provider' AND idChocAn = ?");
					//Create query that selects Member by id
					selectMemberById = connection.prepareStatement("SELECT * FROM ChocAn_Data.ChocAn WHERE type = 'Member' AND idChocAn = ?");
					//SelectAll
					selectById = connection.prepareStatement("SELECT * FROM ChocAn_Data.ChocAn WHERE idChocAn = ?");
					//Create query that inserts a new ChocAn user
					insertNewUser = connection.prepareStatement("INSERT INTO ChocAn_Data.ChocAn" + "(firstName, lastName, street, city, state, zipcode, type)" + "VALUES (?,?,?,?,?,?,?)");
					//delete ChocAn User 
					deleteUser = connection.prepareStatement("DELETE FROM ChocAn_Data.ChocAn WHERE idChocAn = ?");
					//UpdateEntry
					updateEntry = connection.prepareStatement("UPDATE ChocAn_Data.ChocAn SET firstName = ?, lastName = ?, street = ?, city = ?, state = ?, zipcode = ?, type = ? WHERE idChocAn = ''");
					
				}
				catch( SQLException sqlException ){
					
					sqlException.printStackTrace();
					System.exit(1);
				}
					
			}
			//Select All Providers 
			public List<User> getAllProviders(){
				
				List<User> results = null;
				ResultSet resultSet = null;
				
				try{
					//Execute query containing matching request
					resultSet = selectAllProviders.executeQuery();
					results = new ArrayList <User>();
					while(resultSet.next()){
						results.add(new User(
						    resultSet.getString("idChocAn"),
							resultSet.getString("firstName"),
							resultSet.getString("lastName"),
							resultSet.getString("Street"),
							resultSet.getString("city"),
							resultSet.getString("State"),
							resultSet.getString("zipcode"),
							resultSet.getString("type")));
						
							
					}
				}
				catch( SQLException sqlException ){
					
					sqlException.printStackTrace();
				}
				finally{
					
					try{
						resultSet.close();
					}
					catch( SQLException sqlException ){
						
						sqlException.printStackTrace();
						
					}
				}
				return results;	
			}
			//Select All Members 
			public List<User> getAllMembers(){
				
				List<User> results = null;
				ResultSet resultSet = null;
				
				try{
					//Execute query containing matching request
					resultSet = selectAllMembers.executeQuery();
					results = new ArrayList <User>();
					while(resultSet.next()){
						results.add(new User(
						    resultSet.getString("idChocAn"),
							resultSet.getString("firstName"),
							resultSet.getString("lastName"),
							resultSet.getString("Street"),
							resultSet.getString("city"),
							resultSet.getString("State"),
							resultSet.getString("zipcode"),
							resultSet.getString("type")));
							
					}
				}
				catch( SQLException sqlException ){
					
					sqlException.printStackTrace();
				}
				finally{
					
					try{
						resultSet.close();
					}
					catch( SQLException sqlException ){
						
						sqlException.printStackTrace();
					}
				}
				return results;	
			}
			//Select Provider By Id 
			public List<User> getProviderByID(String ID){
				
				List<User> results = null;
				ResultSet resultSet = null;
				
				try{
					selectProviderById.setString(1,ID);
					//Execute query containing matching request
					resultSet = selectProviderById.executeQuery();
					results = new ArrayList<User>();
					
					while(resultSet.next()){
						results.add(new User(
						    resultSet.getString("idChocAn"),
							resultSet.getString("firstName"),
							resultSet.getString("lastName"),
							resultSet.getString("Street"),
							resultSet.getString("city"),
							resultSet.getString("State"),
							resultSet.getString("zipcode"),
							resultSet.getString("type")));
							
					}
				}
				catch( SQLException sqlException ){
					
					sqlException.printStackTrace();
				}
				finally{
					
					try{
						resultSet.close();
					}
					catch( SQLException sqlException ){
						
						sqlException.printStackTrace();
					}
				}
				return results;	
			}
			//Select Member By Id 
			public List<User> getMemberByID(String ID){
				
				List<User> results = null;
				ResultSet resultSet = null;
				
				try{
					selectMemberById.setString(1,ID);
					//Execute query containing matching request
					resultSet = selectMemberById.executeQuery();
					results = new ArrayList<User>();
					
					while(resultSet.next()){
						results.add(new User(
						    resultSet.getString("idChocAn"),
							resultSet.getString("firstName"),
							resultSet.getString("lastName"),
							resultSet.getString("Street"),
							resultSet.getString("city"),
							resultSet.getString("State"),
							resultSet.getString("zipcode"),
							resultSet.getString("type")));
							
					}
				}
				catch( SQLException sqlException ){
					
					sqlException.printStackTrace();
				}
				finally{
					
					try{
						resultSet.close();
					}
					catch( SQLException sqlException ){
						
						sqlException.printStackTrace();
					}
				}
				return results;	
			}
			//Find by ID 
			public List<User> getByID(String ID){
				
				List<User> results = null;
				ResultSet resultSet = null;
				
				try{
					selectById.setString(1,ID);
					//Execute query containing matching request
					resultSet = selectById.executeQuery();
					results = new ArrayList<User>();
					
					while(resultSet.next()){
						results.add(new User(
						    resultSet.getString("idChocAn"),
							resultSet.getString("firstName"),
							resultSet.getString("lastName"),
							resultSet.getString("Street"),
							resultSet.getString("city"),
							resultSet.getString("State"),
							resultSet.getString("zipcode"),
							resultSet.getString("type")));
							
					}
				}
				catch( SQLException sqlException ){
					
					sqlException.printStackTrace();
				}
				finally{
					
					try{
						resultSet.close();
					}
					catch( SQLException sqlException ){
						
						sqlException.printStackTrace();
					}
				}
				return results;	
			}
			//Add a user 
			
			public int CheckDuplicate(String fN, String lN){
				List<User> result = null;
				ResultSet rs = null;
				int  i = 0;
				try{
					
					
					Statement stmt = connection.createStatement();
					String check = "SELECT chocan.firstName, chocan.lastName FROM ChocAn_Data.ChocAn WHERE firstName = '" + (fN) + "' AND lastName = '" + (lN) + "'";
					
					rs = stmt.executeQuery(check);
					while(rs.next()){
						 i++;
					}
					}catch( SQLException err ){
						
					System.out.println(err.getMessage() );
					
				}
				return i;
			}
			public int addUser(String fName, String lName, String aStreet, String aCity, String aState, String aZip, String aType){
				int result = 0;
				try{
					
					insertNewUser.setString(1, fName);
					insertNewUser.setString(2, lName);
					insertNewUser.setString(3, aStreet);
					insertNewUser.setString(4, aCity);
					insertNewUser.setString(5, aState);
					insertNewUser.setString(6, aZip);
					insertNewUser.setString(7, aType);
					
					result = insertNewUser.executeUpdate();
				}
				catch( SQLException sqlException ){
					
					sqlException.printStackTrace();
				}
				return result;
			}
			
	
			
			public int DeleteUser(String ID){
				int result = 0;
				try{
					deleteUser.setString(1,ID);
					
					result = deleteUser.executeUpdate();
					
					
				}
				catch( SQLException sqlException ){
					
					sqlException.printStackTrace();
				}
				return result;
				}
			
			public void updateEntry(String id, String fName, String lName, String aStreet, String aCity, String aState, String aZip, String aType){
				
				try{
						
				Statement stmt= connection.createStatement();	
				String sql1 = "Update ChocAn_Data.chocan set firstName='" + (fName)+ "', lastName='" + (lName)+ "', street='" + (aStreet)+ "', city='" + (aCity)+ "', state='" + (aState)+ "', zipcode='" + (aZip)+ "',type='" + (aType)+ "' WHERE idChocAn = '" + (id) + "'";
					
					stmt.executeUpdate(sql1);
					
				}
				catch( SQLException err ){
					
					System.out.println(err.getMessage() );
				}
				
			
			}
			
}

			
