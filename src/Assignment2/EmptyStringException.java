/**
 * 
 * @author Wonguen Cho
 * Student ID : 109461283, Recitation no.R04.
 * 
 * Class Name : EmptyStringException
 * 
 * This class is dealing with exception which derived from IllegalArgumentException to catch empty string.
 * When the value of string of location or activity is empty, this exception will be executed.
 * The reason why I made this exception to distinguished IllegalArgumentException which is executed when distance is negative number.
 * 
 * Constructor
 * EmptyStringException(no parameter)
 * 	-It is used for declaring an exception without any parameters.
 * EmptyStringException
 * 	-It is used to declare an exception with a parameter. 
 *  -When this exception is operated, the value of parameter will be shown.
 * 	
 */
package Assignment2;

public class EmptyStringException extends IllegalArgumentException{
	/**
	 * It is used for declaring an exception without any parameters.
	 */
	EmptyStringException(){
		super();
	}
	/**
	 * It is used to declare an exception with a parameter. 
	 * When this exception is operated, the value of parameter will be shown.
	 * @param message
	 */
	EmptyStringException(String message){
		super(message);
	}
}