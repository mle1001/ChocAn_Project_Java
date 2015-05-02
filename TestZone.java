/**
 * Main unit tests should be Insert. Update. Find. Delete. List of Members and List of Providers. 
 */
import java.util.List;
import junit.framework.TestCase;


public class TestZone extends TestCase{
	
	private Directory directory;
	List <User> results;
	
	public void testInsert(){
		directory = new Directory();
		
		directory.addUser("John", "Doe", "PO Box test st", "Test", "OR", "11111", "Member");
		assertTrue(true);
	}

	public void testUpDate(){
		directory = new Directory();
		
		directory.updateEntry("123666994", "John update", "Doe update", "PO Box test st", "Test", "OR", "11111", "Member");
		assertTrue(true);
	}
	
	public void testFind(){
		directory = new Directory();
		
		directory.getByID("123666994");
		assertTrue(true);
	}
	
	public void testDelete(){
		directory = new Directory();
		
		directory.DeleteUser("123666994");
		assertTrue(true);
	}
	
	public void testGetAllProviders(){
		directory = new Directory();
		
		directory.getAllProviders();
		assertTrue(true);
	}
	
	public void testGetAllMembers(){
		directory = new Directory();
		
		directory.getAllMembers();
		assertTrue(true);
	}
	
	
}
