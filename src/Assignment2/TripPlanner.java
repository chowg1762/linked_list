/**
 * @author Wonguen Cho
 * Student ID : 109461283, Recitation No.R04
 * 
 * Class Name : TripPlanner
 * 
 * This class is driver class which actually execute the program. This program was constructed by usng 'Linked List' way.
 * User can make two options of itinerary. Users can add, remove and edit the their trip plan on this class. 
 * This class is related to Itineraray, TripStopNode, TripStop, and EmptyStripngException. This class is a door which
 * enables user to communicate other class. User can choose what he want to execute on this class. 
 * 
 * F) - Cursor Forward 
 * B) - CUrsor Backward
 * I) - Insert Before Cursor 
 * 		-Secondary menu asking for Location, Distance, ACtivity(in that order)
 * A) - Append to tail
 * 		-Secondary menu asking for location, distance, activity.
 * D) - Delete and move cursor forward
 * H) - Cursor to Head
 * T) - Cursor to tail
 * E) - Edit Cursor
 * 		-Secondary menu asking for edits to location, distance, activity.
 * S) - Switch Itinerary
 * O) - Insert cursor from other itinerary before cursor from this itinerary
 * R) - Replace this itinerary with copy of the other itinerary
 * P) - Print current itinerary, including summary
 * C) - Clear current itinerary
 * 
 */
package Assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TripPlanner {
	/**
	 * Derive class
	 * 
	 * Runs the User Interface menu as shown in Required Functions
	 * This method will contain two itinerary objects for cloning
	 * @exception
	 * NullPointerException
	 *	-If the node of itinerary is null, this exception will be executed. 
	 * InputMismatchException
	 *	-If user input the non-numeric value into distance, this exception will be executed.
	 * EmptyStringException
	 *	-If user input the empty sentence on location or activity, this exception will be executed.
	 * IllegalArgumentException
	 * - If user input invalid distance on the distance variable, it will be executed.
	 */
	
	public static void main(String[] args){
		
		Itinerary i1 = new Itinerary();
		Itinerary curItn = i1;
		Itinerary i2 = new Itinerary();
		char operator;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Trip Planner!\n");
		System.out.println("Menu:");
		System.out.println("F - Cursor forward");
		System.out.println("B - Cursor Backward");
		System.out.println("I - Insert Before cursor");
		System.out.println("A - Append to tail");
		System.out.println("D - Delete and ove cursor forward");
		System.out.println("H - Cursor to Head");
		System.out.println("T - Cursor to Tail");
		System.out.println("E - Edit cursor");
		System.out.println("S - Switch Itinerary");
		System.out.println("O - Insert cursor from other itinerary after cursor from this itinery : ");
		System.out.println("R - Repace this Itinerary with a copy of the other itinerary");
		System.out.println("P - Print current itinerary, including summary");
		System.out.println("C - Clear current Itinerary");
		System.out.println("Q - Quit");
		
		
		do{
			
			System.out.println("\nInput your selection : ");
			String selection = input.nextLine();	
			if(selection.length()!=1){
				System.out.println("Selection must be 1 character");
				operator='z';
			}
			
			else{
			operator = selection.toLowerCase().charAt(0);
					
			switch(operator){
				case 'f' : try{
								if(curItn.equals(i1))
									i1.cursorForward();
								else
									i2.cursorForward();
							}
							catch(NullPointerException ex){
								System.out.println("This itinerary is empty");
							}
							break;
				
				case 'b' : try{
								if(curItn.equals(i1))
									i1.cursorBackward();
								else
									i2.cursorBackward();
							}
							catch(NullPointerException ex){
								System.out.println("This itinerary is empty");
							}
						  break;
				
				case 'i' : 	try{
								System.out.print("Enter Location : ");
								//input.nextLine();
								String location = input.nextLine();
								System.out.print("Enter Activity : ");
								String activity = input.nextLine();

								System.out.print("Enter Distance: ");
								int distance = input.nextInt();
								input.nextLine();
								TripStop trip = new TripStop();
								trip.setLocation(location);
								trip.setActivity(activity);
								trip.setDistance(distance);
								if(curItn.isValidLength(location, 21)&&curItn.isValidLength(activity, 26)){
									if(curItn.equals(i1))
										i1.insertBeforeCursor(trip);
									else
										i2.insertBeforeCursor(trip);
									
									System.out.println("\nAdded");
								}
								else
									System.out.println("Your input on locationa or activity is too long");
							}
							catch(InputMismatchException ex){
								input.nextLine();
								System.out.println("You have to insert number in distance!");
							}
							catch(EmptyStringException ex){
									System.out.println("Name or Activity have to be not empty.");
							}
							catch(IllegalArgumentException ex){
								System.out.println("Distance must be bigger than 0");
							}
							
							
						
							break;
				
				case 'a' :  try{
								System.out.print("Enter Location : ");
								String locationT = input.nextLine();
								System.out.print("Enter Activity : ");
								String activityT = input.nextLine();
								System.out.print("Enter Distance: ");
								int distanceT = input.nextInt();
								input.nextLine();
								TripStop tripT = new TripStop();
								tripT.setLocation(locationT);
								tripT.setActivity(activityT);
								tripT.setDistance(distanceT);
								if(curItn.isValidLength(locationT, 21)&&curItn.isValidLength(activityT, 26)){
									if(curItn.equals(i1))
										i1.appendToTail(tripT);
									else
										i2.appendToTail(tripT);
									
									System.out.println("\nAdded");
								}
								else
									System.out.println("Your input on locationa or activity is too long");
								
							}
							catch(InputMismatchException ex){
								input.nextLine();
								System.out.println("You have to insert number in distance!");
							}
							catch(EmptyStringException ex){
								System.out.println("Name or Activity have to be not empty.");
							}
							catch(IllegalArgumentException ex){
								System.out.println("Distance must be bigger than 0");
							}
							
					
							break; 
				case 'd' : 	try{
							if(curItn.equals(i1))
								System.out.println(i1.removeCursor().getLocation()+" was deleted.");
							else
								System.out.println(i2.removeCursor().getLocation()+" was deleted.");
							}
							catch(NullPointerException ex){
								System.out.println("The literary is empty");
							}
							break;
				case 'h' : try{
							if(curItn.equals(i1))
				
								i1.resetCursorToHead();
							else
								i2.resetCursorToHead();
							System.out.println("Cursor is at first of list now");
							}
							catch(NullPointerException ex){
								System.out.println("This itinerary is empty");
							}
							break;
				case 't' : 	try{
							if(curItn.equals(i1))
								i1.cursorToTail();
							else
								i2.cursorToTail();
							System.out.println("Cursor is at last of list now");
							}
							catch(NullPointerException ex){
								System.out.println("This itinerary is empty");
							}
							break;
				case 'e' :  try{
								System.out.print("Edit location, or press enter without typing anything to keep : ");
								String newLocation = input.nextLine();
								
								System.out.print("Edit activity, or press enter without typing anything to keep : ");			
								String newActivity = input.nextLine();
								
								System.out.print("Edit distance, or press enter without typing anything to keep : ");
								int newDistance = input.nextInt();
								input.nextLine();

								if(curItn.isValidLength(newLocation, 21)&&curItn.isValidLength(newActivity, 26)){
									if(curItn.equals(i1))
										i1.editInformation(newLocation, newActivity, newDistance);
									else
										i2.editInformation(newLocation, newActivity, newDistance);
								}
								else
									System.out.println("Your input on locationa or activity is too long");
								
							}
							catch(NullPointerException ex){
								System.out.println("This itinerary is empty");
							}
							catch(InputMismatchException ex){
								input.nextLine();
								System.out.println("You have to insert number in distance!");
							}
							catch(IllegalArgumentException ex){
								System.out.println("Distance must be biggerthan 0");
							}
							break;
				
				case 's' : if(curItn.equals(i1)){
								curItn = i2;
								System.out.println("Itinerary 1 => Itinerary 2");
							}
							else{
								curItn = i1;
								System.out.println("Itinerary 2 => Itinerary 1");
							}
							System.out.println("Itinerary switched");
							break;
				case 'o' : try{
							if(curItn.equals(i1))
								i1.insertCursorFromOther(i2);
							else
								i2.insertCursorFromOther(i1);
							}
							catch(NullPointerException ex){
								System.out.println("This itinerary is empty");
							}
							break;
					
				case 'r' : try{
								if(curItn.equals(i1))
									i1 = i2.clone();
							
								else
									i2 = i1.clone();
							
								System.out.println("Itinerary copied");
							}
							catch(NullPointerException ex){
								System.out.println("Coppied itinerary is empty");
							}		
							break;
							
				case 'p' : if(curItn.equals(i1)){
								System.out.println("Itinerary 1");
								i1.printItinerary();
							}
							else{
								System.out.println("Itinerary 2");
								i2.printItinerary();	
							}
						   break;
				case 'c' :try{ 
							if(curItn.equals(i1))
								i1.clearItinerary();
							else
								i2.clearItinerary();
						}
						catch(NullPointerException ex){
							System.out.println("This itinerary is already empty");
						}
						break;
				default : System.out.println("Your selection is wrong");
				
				}
			}
		}while(operator!='q');
		
	}

}
