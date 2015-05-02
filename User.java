
public class User {
	
	private String idChocAn;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String type;
	//Empty constructor 
	public User(){
		
	}
	//constructor
	public User(String id, String first, String last, String theStreet, String theCity, String theState, String zip, String theType){
		setIdChocAn( id );
		setFirstName( first );
		setLastName( last );
		setTheStreet( theStreet );
		setTheCity( theCity );
		setTheState( theState );
		setTheZip( zip );
		setTheType( theType );

	}
	//Set then get to return 
	public void setIdChocAn(String id) {
		idChocAn = id;
	}
	public String getIdChocAn(){
		return idChocAn;
	}
	public void setFirstName(String first){
		firstName = first;
	}
	public String getfirstName(){
		return firstName;
	}
	public void setLastName(String last){
		lastName = last;
	}
	public String getlastName(){
		return lastName;
	}
	public void setTheStreet(String theStreet){
		street = theStreet;
	}
	public String getTheStreet(){
		return street;
	}
	public void setTheCity(String theCity){
		city = theCity;
	}
	public String getTheCity(){
		return city;
	}
	public void setTheState(String theState){
		state = theState;
	}
	public  String getTheState(){
		return state;
	}
	public void setTheZip(String zip){
		zipcode = zip;
	}
	public String getTheZip(){
		return zipcode;
	}
	public void setTheType(String theType){
		type = theType;
	}
	public String getTheType(){
		return type;
	}
	
}
