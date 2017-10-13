/**
 *  @author Wonguen Cho
 * Student ID : 109461283, Recitation No.R04
 *
 * Class Name : TripStop
 * 
 * Three data of the program such as location, activity, and distance are accessed and mutated by this class.
 * Through the mutator and accessor methods of this class, user can add, edit, and print of the each trip's information.
 * 
 * data field
 * 	location
 * 		-Save the location information of trip
 * 	distance
 * 		-Save the distance information of trip
 * 	activity  
 * 		-Save the activity information of trip.
 * Constructor 
 * 	TripStop(no parameter)
 * 		- Just initialize the three data fields.(String variables have null string, distance will be 0.) 
 * 	TripStop
 * 		- This constructor can set the three data fields.
 *
 *Method 
 *	setLocation
 *		-This method is for setting the location value
 *	setDistance
 *		-This method is for setting the distance value
 *	setActivity
 *		-This method is for setting activity value
 *	getLocation
 *		-This method is for getting location value.
 *	getDistance
 *		-This method is for getting distance value.
 *	getActivity
 *		-This method is for getting activity value. 
 */

package Assignment2;

public class TripStop {
	private String location;
	private int distance;
	private String activity;
	
	/**
	 * This constructor just initialize the three data fields.
	 */
	public TripStop(){		
		location=null;
		distance =0;
		activity =null;
	}
	
	/**
	 * This constructor can set the three data fields.
	 * @param location
	 * set the location data field
	 * @param distance
	 * set the distance data field
	 * @param activity
	 * set the activity data field
	 * @throws
	 * if distance is smaller than 0, it will throw an exception
	 */
	public TripStop(String location, int distance, String activity){
		if(distance<0)
			throw new IllegalArgumentException("Distance must be bigger than 0");
		this.location = location;
		this.distance = distance;
		this.activity = activity;
	}
	
	/**
	 * This method is for setting the location value
	 * @param location
	 * the parameter value will be inserted into location data feild.
	 */
	public void setLocation(String location){
		this.location = location;
	}
	
	/**
	 * This method is for setting the distance value
	 * @param distance
	 * the parameter will be inserted into distance data field.
	 * Precondition
	 * Distance have to be larger than 0.
	 * @throws 
	 * IllegalArgumentException - if distance is <0, it will throw an exception.
	 */
	public void setDistance(int distance){
		if(distance<0)
			throw new IllegalArgumentException();
		this.distance = distance;
	}
	
	/**
	 * This method is for setting activity value
	 * @param activity
	 * this parameter will be inserted into activity data field.
	 */
	public void setActivity(String activity){
		this.activity = activity;
	}
	
	/**
	 * This method is for getting location value.
	 * @return
	 * location value will be returned.
	 */
	public String getLocation(){
		return location;
	}
	
	/**
	 * This method is for getting distance value.
	 * @return
	 * distance value will be returned.
	 */
	public int getDistance(){
		return distance;
	}
	
	/**
	 * This method is for getting activity value. 
	 * @return
	 * activity value will be returned.
	 */
	public String getActivity(){
		return activity;
	}
}
