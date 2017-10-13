/**
 * @author Wonguen Cho
 * Student ID : 109461283, Recitation No.R04
 *
 * Class Name : TripStopNode
 * 
 * This class makes a 'Node' which the class Itinerary makes links with each other. 
 * In this class, the nodes can make relation with prior node and post node.
 * Thus, for this class, Itinerary has a list of trip which has linked each other. 
 * 
 * Data Field
 * data
 * 	- An information which the node has contain.(The node's value)
 * next
 * 	-The reference of next node. A node can make a relationship with next node by using this variable.
 * prev
 *  - The reference of previous node. A node can make a relationship with previous node. 
 *
 *Constructor  
 *	TripStopNode
 *		-This constructor initialize the data of node by getting information from TripPlanner class. 
 *		-the value of next and previous are initialized as null. 
 *
 *Method 
 *	getData
 *		-Get the data of node which contains location, activity, and distance.
 *	setData
 *		-Sets the data private field to the one passed as a parameter
 *	getNext
 *		-returns the reference to the next member variable of the list node.
 *	setNext
 *		-Updates the next member variable with a new TripStopNode reference.	
 *	getPrev
 *		-Gets the reference to the prev member variable of the list node
 *	setPrev
 *		-Updates the prev member variable with a new TripStopNode reference
 */
package Assignment2;
public class TripStopNode {
	private TripStop data;
	private TripStopNode next = null;
	private TripStopNode prev = null;
	
	
	/**
	 * Default constructor 
	 * @param initData
	 * The data to be wrapped by this TripStopNode. This parameter should not be null, since we should never have a TripStopNode with null data
	 * Precondition
	 * initData is not null
	 * Postcondition
	 * This TripStopNode has been initialized to wrap the indicated TripStop, and prev and next have been set to null.
	 * @throws
	 * IllegalArgumentException
	 * thrown if initData is null
	 */
	public TripStopNode(TripStop initData){
		data = initData;
		next = null;
		prev = null;
	}
	
	/**
	 * @return 
	 * the referens to the data member variable of the list node.
	 */
	public TripStop getData(){
		return data;
	}
	
	/**
	 * Sets the data private field to the one passed as a parameter
	 * @param newData
	 * newData - Reference to a new TripStop object to update the data member variable. 
	 * This parameter must not be null, since we should never a TripStopNode with null data
	 * Precondition
	 * newData is not null
	 * @throws
	 * IllegalArgumentException - Thrown if new Data is null.
	 */
	public void setData(TripStop newData){
		data = newData;
	}
	
	/**
	 * returns the reference to the next member variable of the list node. Can be null, means there's no next TripStopNode.
	 * @return
	 * The reference of next node. 
	 */
	public TripStopNode getNext(){
		return next; 
	}
	
	/**
	 * Updates the next member variable with a new TripStopNode reference.
	 * @param newNext
	 * Reference to a new TripStopNode object to update the next member variable. This parameter may be null, since it is okay to have no next TripStopNode
	 */
	public void setNext(TripStopNode newNext){
		next = newNext;
	}
	
	/**
	 * Gets the reference to the prev member variable of the list node
	 * @return
	 * the reference of the prev member variable. Note that this return value can be null, meaning that there is no previous TripStopNode in the list(this means
	 * we've reached the head of the list)
	 */
	public TripStopNode getPrev(){
		return prev;
	}
	
	/**
	 * Updates the prev member variable with a new TripStopNode reference
	 * @param newPrev
	 * Reference to a new TripStopNode object To update the prev member variable.
	 * This parameter may be null, since it is okay to have no previous TripStopNode(This means we've reached the head of the list)
	 */
	public void setPrev(TripStopNode newPrev){
		prev = newPrev;
	}
}
