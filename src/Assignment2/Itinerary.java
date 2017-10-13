/**
 * @author Wonguen Cho.
 * Student ID : 109461283, Recitation No.R04
 * 
 * Class Name : Itinerary
 * This class make linked list which contains the information of trips.
 * All of process such as "add", "remove", "print", and "edit" etc.. are executed on this class.  
 *
 *Data Field
 * head - The first node of the linked list
 * cursor - The current indicated node in linked list
 * tail - The last node of the linked list
 * count - The size of current itinerary
 * totalDistance - The total distance of the current itinerary.
 *
 *Constructor  
 * Itinerary - Initialize an empty Itinerary class to use the methods and data in the class.
 *
 *Method 
 *	getCount : 
 *		- return the size of the itinerary
 *	getTotalDistance : 
 *		- return the total distance of all of the trip
 *	getCursorStop : 
 *		- return the information of the cursor.
 *	resetCursorToHead : 
 *		- move the cursor on the head of the itinerary
 *	cursorToTail : 
 *		- move the cursor on the last of the itinerary
 *	cursorForward :
 *		- move the cursor after the cursor's node.
 *	cursorBackward : 
 *		- move the cursor before the node of cursor.
 *	insertBeforeCursor : 
 *		- add new node before a node which cursor indicates.
 *	appendToTail:
 *		- add a new node after tail.
 *	removeCursor
 *		- remove a node on cursor, after remove cursor will move forward.
 *	editInformation
 *		- edit the node's location, activity, and distance on the cursor.
 *	clone
 *		- copy only contents from an itinerary, if copied itinerary's contents changed, orginal itinerary is still same as before. 
 *	insertCursorFromOther
 *		- Insert an trip from the other itinerary to current itinerary's after cursor.
 *	clearItinerary
 *		- Remove all list on current itinerary
 *	isValidLength
 *		- Check the length of string whether this string has valid length or not.
 *
 *
 */
package Assignment2;

public class Itinerary {
	private TripStopNode head;
	private TripStopNode tail;
	private TripStopNode cursor;
	private int count = 0;
	private int totalDistance = 0;
	
	/**
	 * Constructor : Initializes an empty itinerary with no elements -- head, tail and cursor are set to null
	 */
	public Itinerary(){
		head =null;
		tail =null;
		cursor = null;
	}
	
	/**
	 * Get the total number of TripStopNodes in the Itinerary
	 * @return
	 * returns the total number of TripStopNodes in the Itinerary
	 */
	public int getStopsCount(){
		return count;
	}
	
	/**
	 * Returns the sum of distance over all TripStopNodes
	 * @return
	 * the sum of distance over all TripStopNodes
	 */
	public int getTotalDistance(){
		return totalDistance; 
	}
	
	/**
	 * Returns a reference to the TripStop wrapped by the TripStopNode that cursor points to.
	 * if cursor is null, this returns null
	 * @return
	 * a reference to the TripStop wrapped by the TripStopNode that cursor points to.
	 */
	public TripStop getCursorStop(){
		if(cursor==null)
			return null;
		else
			return cursor.getData();
	}
	
	/**
	 * Returns the cursor to the start of the list
	 * Post Condition
	 * if head is not null, the cursor now references the first TripStopNode in this list.
	 * If head is null, the cursor is set to null as well(There are no TripStop object in this list).
	 * <dt><b>Precondition : </b><dd>
	 * cursor have to be not null
	 * @throws NullPointerException
	 *  If cursor is null, throw an exception.
	 */
	public void resetCursorToHead(){
		if(cursor==null)
			throw new NullPointerException();  
		if(head==null)
			cursor=null;
		
		else
			cursor = head;
		
	}
	/**
	 * Returns the cursor to the last of the list
	 * <dt><b>Postcondition</b><dd>
	 * if tail is not null, the cursor now references the last TripStopNode in this list.
	 * If tail is null, the cursor is set to null as well(There are no TripStop object in this list).
	 * <dt><b>Precondition : </b><dd>
	 * cursor is not null.
	 * @throws NullPointerException
	 *  If cursor is null, throw an NullPointerException on the TripPlanner class.
	 */
	public void cursorToTail(){
		if(cursor==null)
			throw new NullPointerException("This itinerary is empty");  
		if(tail==null)
			cursor = null;
		
		else
			cursor = tail;
	}
	
	/**
	 * Moves the cursor to select the next TripStopNode in this list. If cursor == tail, throw an exception
	 * <dt><b>Precondition : </b><dd>
	 * if cursor == tail throw an exception
	 * @throws NullPointerException
	 * If cursor or head is null, throw an exception to TripPlanner class.
	 */
	public void cursorForward(){
		if(cursor==null)
			throw new NullPointerException("This itinerary is empty");  
		if(cursor==tail){
			System.out.println("Cursor already at end of list");
		}
		else{
			cursor = cursor.getNext();
			System.out.println("Cursor Moved Front");
		}
	}
	
	/**
	 * Moves the cursor to select previous TripStopNode in this list
	 * <dt><b>Precondition : </b><dd>
	 * cursor and head have to be not null. 
	 * @throws NullPointerException
	 * If cursor or head is null, throw an exception to TripPlanner class.
	 */
	public void cursorBackward(){
		if(cursor==null)
			throw new NullPointerException("This itinerary is empty");  
		if(cursor==head){
			System.out.println("Cursor already at first of list");
		}
		else{
			cursor = cursor.getPrev();
			System.out.println("Cursor Moved Back");
		}
	}
	
	/**
	 *Inserts the indicated TripStop before the cursor 
	 * @param newStop
	 * The tripStop object to be wrapped and inserted into the list before the cursor
	 * <dt><b>Precondition : </b><dd>
	 * newStop is not null
	 * 
	 * <dt><b>Postcondition</b><dd>
	 * newStop has been wrapped in a new TripStopNode object
	 * if cursor was previously not null, the newly created TripStopNode has been inserted into
	 * the list before the cursor.
	 * If cursor was previously null, the newly created TripStopNode has been set as the new head of the list(as well as the tail)
	 * The cursor now references the newly created TripStopNode
	 * 
	 * @throws IllegalArgumentException
	 * thrown if newStop is null
	 * @throws EmptyStringException
	 * thrown if location or activity is empty.
	 */
	public void insertBeforeCursor(TripStop newStop){
		if(newStop.getActivity().equals("")||newStop.getLocation().equals(""))
			throw new EmptyStringException();
		TripStopNode newNode = new TripStopNode(newStop);
		if(newStop==null)
			throw new IllegalArgumentException();
		if(cursor==null){
			head = newNode;
			cursor = head;
			tail=head;
		}
		else{
			if(cursor==head){
				head = newNode;
				newNode.setNext(cursor);
				cursor.setPrev(newNode);
				
			}
			else{
				newNode.setPrev(cursor.getPrev());
				cursor.getPrev().setNext(newNode);
				cursor.setPrev(newNode);
				newNode.setNext(cursor);
			}
		}
		count++;
		totalDistance += newStop.getDistance();
	}
	
	/**
	 * Inserts the indicated TripStop after the tail of the list
	 * @param
	 * newStop - The TripStop object to be wrapped and inserted into the list after the tail of the list
	 * <dt><b>Precondition : </b><dd>
	 * newStop is not null
	 * 
	 *
	 * <dt><b>Postcondition</b><dd>
	 * newStop has been wrapped in a new TripStopNode object
	 * If tail was previously not null, the newly created TripStopNode has been inserted into the list after tail.
	 * If tail was previously null, the newly created TripStopNode has been set as the new head of the list.
	 * The tail now references the newly created TripStopNode
	 * 
	 * @throws IllegalArgumentException  
	 * Thrown if newStop is null
	 * @throws EmptyStringException
	 * thrown if location or activity is empty.
     *
	 */
	public void appendToTail(TripStop newStop){
		if(newStop.getActivity().equals("")||newStop.getLocation().equals(""))
			throw new EmptyStringException();
		if(newStop==null)
			throw new IllegalArgumentException();
		TripStopNode newTrip = new TripStopNode(newStop);
		if(tail==null){
			head = newTrip;
			tail=head;
			cursor = head;
		}
		else{
			tail.setNext(newTrip);
			newTrip.setPrev(tail);
			tail = newTrip;
		}
		
		count++;
		totalDistance += newStop.getDistance();
	}
	
	/**
	 * Removes the TripStopNode referenced by cursor and returns the TripStop inside.
	 * <dt><b>Precondition : </b><dd>
	 * cursor != null
	 * <dt><b>Postcondition</b><dd>
	 * The TripStopNode referenced by cursor has been removed from the list.
	 * All other TripStopNodes in the list exist in the same order as before.
	 * The cursor now references the previous TripStopNode
	 * @exception
	 * if the cursor was originally the head, the cursor will now reference the current head.
	 * @return
	 * The TripStop that was removed
	 * @throws NullPointerException 
	 * Thrown if cursor is null.
	 * @return
	 * A node information which is deleted.
	 */
	public TripStop removeCursor(){
		if(cursor==null)
			throw new NullPointerException();
		TripStop deletedNode = cursor.getData();
		TripStopNode temp;
		if(cursor==head){
			if(head==tail){
				head=null;
				tail=null;
				cursor=null;
			}
			else{
				head = cursor.getNext();
				head.setPrev(null);
				cursor.setNext(null);
				cursor = head;
			}
		}
		else if(cursor == tail){
			tail = cursor.getPrev();
			cursor.setPrev(null);
			tail.setNext(null);
			cursor = tail;
		}
		else{
			
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			temp = cursor;
			cursor = cursor.getPrev();
			temp.setNext(null);
			temp.setPrev(null);
		}
		
		count--;
		totalDistance -= deletedNode.getDistance();
		return deletedNode;
		
	}
	/**
	 * Print all of trips on current itinerary. 
	 * In the bottom of the itinerary, there will be sum of the information which indicates 
	 * total number of trips and distance.  
	 */
	public void printItinerary(){
		TripStopNode temp = head;
		int beforeCursor =0;
		int afterCursor = 0;
		boolean isAfterCursor = false;
		if(tail==null){
			System.out.println("This trip has no stop");
		}else{
			while(temp!=tail.getNext()){
				TripStop currentNode = temp.getData();
				if(temp==cursor){
					System.out.print(">");
				}
				else{
					System.out.print(" ");
				}
				System.out.printf("%-21s%-26s%6d",
						currentNode.getLocation(), currentNode.getActivity(), currentNode.getDistance());
				System.out.println(" miles");
				if(temp==cursor){
					isAfterCursor = true;
				}
				
				if(isAfterCursor){
					afterCursor++;
					if(temp==cursor){
						afterCursor-=1;
					}
				}
				else
					beforeCursor++;
				temp = temp.getNext();
			}
		}
	
		System.out.println("Summary : This Trip has "+count+" stops, totaling "+totalDistance
				+" miles. There are "+beforeCursor+" stops before the cursor and "+afterCursor+" stops after the cursor.");
	}
	
	/**
	 * This method change the location, activity, and distance information if new location string has empty value it doesn't change anything.
	 * @param newLocation, newActivity, newDistance
	 * these parameter changes the information of location, activity, distance.
	 * <dt><b>Precondition : </b><dd>
	 * cursor have to be not null.
	 * Distance must be larger or equal than -1
	 * <dt><b>Postcondition : </b><dd>
	 * The location, activity, and distance on the cursor will be edited if input exists. 
	 * @throw NullPointerException
	 * if cursor is null throw the exception
	 * @throws IllegalArgumentException
	 * Thrown if user insert distance lower than -1.
	 */
	public void editInformation(String newLocation, String newActivity, int newDistance){
		if(cursor==null)
			throw new NullPointerException();
		if(newDistance<-1){
			throw new IllegalArgumentException();
		}
		if(!newLocation.equals(""))
			cursor.getData().setLocation(newLocation);
		
		if(!newActivity.equals(""))
			cursor.getData().setActivity(newActivity);
		
		if(newDistance!=-1){
			totalDistance-=cursor.getData().getDistance();
			cursor.getData().setDistance(newDistance);
			if(newDistance>=0){
				totalDistance+=newDistance;
			}
		}
		
		System.out.println("Edits applied");
		
	}
	
	
	/**
	 * Copy one itinerary to other Itinerary. 
	 * <dt><b>Precondition : </b><dd>
	 * Head have to be not null.
	 * <dt><b>Postcondition : </b><dd>
	 * an itinerary which has same content is copied from the other. 
	 * However, although this copied itinerary's contents are changed, the orginal's are stil same.
	 * @return
	 *  new Itinerary which has same contents from original one.
	 * @throws NullPointerException
	 *  if original copied itinerary is empty throw an exception
	 */
	
	public Itinerary clone(){
		if(head==null)
			throw new NullPointerException();
		
		Itinerary trip2 = new Itinerary();
		TripStopNode temp = head;
		
		while(temp!=tail.getNext()){
			TripStop tempTrip = new TripStop();
		
			tempTrip.setLocation(temp.getData().getLocation());
			tempTrip.setActivity(temp.getData().getActivity());
			tempTrip.setDistance(temp.getData().getDistance());
		
		
			trip2.appendToTail(tempTrip);
			
			if(temp==cursor){
				trip2.cursor = trip2.tail;
			}
			temp = temp.getNext();
			
		}
		
		return trip2;
	}
	/**
	 * A trip plan on the other itinerary's cursor is added after current node's cursor.
	 * <dt><b>Precondition : </b><dd>
	 * cursor have to be not null.
	 * <dt><b>Postcondition : </b><dd>
	 * Current itinerary's size and total distance will be changed. 
	 * 
	 * @param other
	 * Itinerary which is not current itinerary.
	 * 
	 * @throws NullPointerException
	 * Thrown if cursor is null.
	 */
	public void insertCursorFromOther(Itinerary other){
		if(cursor==null)
			throw new NullPointerException();
		
		TripStopNode otherCursor = new TripStopNode(other.cursor.getData());
		if(cursor==tail){
			tail.setNext(otherCursor);
			otherCursor.setPrev(tail);
			tail = otherCursor;
		}
		else{
			cursor.getNext().setPrev(otherCursor);
			otherCursor.setNext(cursor.getNext());
			cursor.setNext(otherCursor);
			otherCursor.setPrev(cursor);
		}
		count++;
		totalDistance += otherCursor.getData().getDistance();
		System.out.println("Trip from the other itinerary is copied to after the cursor on current itinerary.");
	}
	
	/**
	 * Current itinerary's contents will be all removed after executing this method.
	 * 
	 * <dt><b>Postcondition : </b><dd>
	 * Itineraries contents will be cleared.
	 * 
	 * @throws NullPointerException
	 * Thrown if head is null.
	 */
	public void clearItinerary(){
		if(head==null)
			throw new NullPointerException();
		TripStopNode temp = head;
		this.resetCursorToHead();
		
		while(temp!=tail){
			temp=temp.getNext();
			this.removeCursor();
			
		}
		
		if(temp==tail){
			tail.setPrev(null);
			tail = null;
		}
		
		System.out.println("Itinerary was cleared");
	}
	/**
	 * It checks the length of string whether it has valid length or not.
	 * @param s
	 * a string which is checked.
	 * @param length
	 * a maximum length of string
	 * @return
	 * If the length is invalid, it returns false. 
	 * In the contrast, if the string has valid length, it will return true.
	 */
	public boolean isValidLength(String checkedLength, int length){
		if(checkedLength.length()>length)
			return false;
		else
			return true;
	}
	
}
