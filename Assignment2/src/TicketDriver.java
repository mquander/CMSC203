import java.util.Scanner;
/** This class contains the main method which runs 
 * the program taking input data from the user which 
 * will be used to generate and display the notice*/
public class TicketDriver {

	public static void main(String[] args) {
		/** Display header */
		System.out.println("Ticket Manager\n\n");
		Scanner input = new Scanner(System.in);
		String repeat;
		do {
			/**  Prompt user for offender's name */
			System.out.print("Enter the offenders name: ");
			String name = input.nextLine();
			
			/** Prompt user for offender's speed and validate input*/
			System.out.print("Enter the speed: ");
			int speed = input.nextInt();
			while(speed < 0) {
				System.out.print("Please re-enter a speed greater than 0: ");
				speed = input.nextInt();
			}
		
			/**Prompt user for speed limit and validate input*/
			System.out.print("Enter the speed limit (>0,<=80): ");
			int speedLimit = input.nextInt();
			while(speedLimit <= 0 || speedLimit > 80) {
				System.out.print("Please re-enter the speed limit between 0 and 80: ");
				speedLimit = input.nextInt();
			}
			input.nextLine(); // clear keyboard buffer
			
			/**Create Ticket object with user input passed to constructor*/
			Ticket ticket = new Ticket(name, speed, speedLimit);
			
			/**Prompt user for whether or not speeding occurred in a school zone*/
			System.out.print("Was this in a school zone? (Y/N): ");
			String c = input.nextLine();
			if(c.charAt(0) == 'y' || c.charAt(0) == 'Y')
				ticket.setSchoolZone(true);
			
			/**Prompt user for whether or not speeding occurred in a work zone*/
			System.out.print("Was this in a work zone? (Y/N): ");
			String w = input.nextLine();
			if(w.charAt(0) == 'y' || w.charAt(0) == 'Y')
				ticket.setWorkZone(true);
			
			/**Display sub-header*/
			System.out.println("\n\nDepartment of Motor Vehicles\nAutomated Traffic Enforcement");
			ticket.setName(name); //set name
			ticket.setSpeed(speed); // set speed
			ticket.setSpeedLimit(speedLimit); // set speed limit
			System.out.println();
			System.out.println(ticket.printNotice()); // display ticket notice
			System.out.print("\nWould you like to enter another ticket? (Y/N): ");
			repeat = input.nextLine();
			
		}while(repeat.charAt(0) == 'y' || repeat.charAt(0) == 'Y');
			
		input.close();
		System.out.println("\nExiting the Ticket Manager");
	}

}
