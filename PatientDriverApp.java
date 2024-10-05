package week4;

import java.util.Scanner;

/**
 * Class: CMSC203 
 * Program: Project 2 
 * Instructor: Professor Gary Thai
 * Description: The PatientDriverApp class manages patient and procedure 
 * details, calculates total charges, and shows student information 
 * using simple static methods.
 * Due: 10/04/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class PatientDriverApp {
	
	 /**
     * Displays the details of the given Patient object.
     * @param patient the Patient object.
     */

	public static void displayPatient(Patient patient) {
		System.out.println("Patient Info: ");
		System.out.println(patient.toString());
	}
	/**
     * Displays the details of the given Procedure object.
     * @param procedure the Procedure object.
     */
	public static void displayProcedure(Procedure procedure) {

		System.out.println(procedure.toString());
	}
	
	/**
     * Calculates the total charges for three given Procedure objects by summing 
     * up the charges for each procedure.
     * @param procedure1 the first procedure
     * @param procedure2 the second procedure
     * @param procedure3 the third procedure
     * @return the total charges of the three procedures
     */
	public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
		return procedure1.getCharges() + procedure2.getCharges() + procedure3.getCharges();
	}
	
	/**
     * Displays the details of a student.
     * @param name  the name of the student
     * @param mcId  the MC ID of the student
     * @param date  the due date for a specific task or assignment
     */

	public static void displayStudentName(String name, String mcId, String date) {

		System.out.println("Student Name: " + name);
		System.out.println("MC#: " + mcId);
		System.out.println("Due Date: " + date);
	}
	
	
	/**
	 * The main method collects patient and procedure details, displays them, 
	 * calculates total charges, and shows student information.
	 */
	public static void main(String[] args) {

		String studentName = "Seid Jemal";
		String mcId = "M21163150";
		String dueDate = "10/04/2024";

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter patient's first name: ");
		String firstName = keyboard.nextLine();

		System.out.print("Enter patient's middle name: ");
		String middleName = keyboard.nextLine();

		System.out.print("Enter patient's last name: ");
		String lastName = keyboard.nextLine();

		System.out.print("Enter patient's street address: ");
		String streetAddress = keyboard.nextLine();

		System.out.print("Enter patient's city: ");
		String city = keyboard.nextLine();

		System.out.print("Enter patient's state: ");
		String state = keyboard.nextLine();

		System.out.print("Enter patient's ZIP code: ");
		String zipCode = keyboard.nextLine();

		System.out.print("Enter patient's phone number: ");
		String phoneNumber = keyboard.nextLine();

		System.out.print("Enter emergency contact's name: ");
		String emergencyContactName = keyboard.nextLine();

		System.out.print("Enter emergency contact's phone number: ");
		String emergencyContactPhone = keyboard.nextLine();

		Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zipCode, phoneNumber,
				emergencyContactName, emergencyContactPhone);

		Procedure procedure1 = new Procedure();

		procedure1.setProcedureName("Physical Exam");
		procedure1.setProcedureDate("7/20/2019");
		procedure1.setPractitionerName("Dr. Irvine");
		procedure1.setCharges(3250.0);

		Procedure procedure2 = new Procedure("X-ray", "7/20/2019");

		procedure2.setPractitionerName("Dr. Jamison");
		procedure2.setCharges(5500.43);

		Procedure procedure3 = new Procedure("Blood Test", "7/20/2019", "Dr. Smith", 1400.75);

		displayPatient(patient);
		System.out.println();
		displayProcedure(procedure1);
		System.out.println();
		displayProcedure(procedure2);
		System.out.println();
		displayProcedure(procedure3);
		System.out.println();

		double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
		System.out.printf("Total Charges: $%,.2f\n", totalCharges);

		System.out.println();

		displayStudentName(studentName, mcId, dueDate);
		keyboard.close();
	}

}
