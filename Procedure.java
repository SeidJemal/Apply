package week4;


/**
 * Class: CMSC203 
 * Program: Project 2 
 * Instructor: Professor Gary Thai
 * Description: The Procedure class represents a medical procedure 
 * performed on a patient.It provides constructors, accessors, mutators, 
 * and a method to display procedure information in a formatted string. 
 * Due: 10/04/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */


public class Procedure {
	
	// Fields representing the details of the procedure
	
	private String procedureName;
	private String procedureDate;
	private String practitionerName;
	private double Charges;

	/**
     * No-argument constructor that initializes an empty Procedure object.
     */
	public Procedure() {
	}
	
	
	 /**
     * Constructor that initializes the procedure with its name and date.
     *
     * @param pName the name of the procedure
     * @param pDate the date when the procedure was performed
     */
	
	

	public Procedure(String pName, String pDate) {
		procedureName = pName;
		procedureDate = pDate;
	}
	
	 /**
     * Constructor that initializes all attributes of the procedure, including name, date, 
     * practitioner, and charges.
     *
     * @param pName      the name of the procedure
     * @param pDate      the date when the procedure was performed
     * @param prName     the name of the practitioner who performed the procedure
     * @param pCharges   the charges associated with the procedure
     */

	public Procedure(String pName, String pDate, String prName, double pCharges) {
		procedureName = pName;
		procedureDate = pDate;
		practitionerName = prName;
		Charges = pCharges;
	}
	 // Getter methods for all attributes
    /**
     * Gets the name of the procedure.
     * @return the procedure name
     */
	public String getProcedureName() {
		return procedureName;
	}
	
	/**
     * Gets the date of the procedure.
     * @return the procedure date
     */

	public String getProcedureDate() {
		return procedureDate;
	}
	/**
     * Gets the name of the practitioner.
     * @return the practitioner's name
     */
	public String getPractitionerName() {
		return practitionerName;
	}
	/**
     * Gets the charges for the procedure.
     * @return the procedure charges
     */

	public double getCharges() {
		return Charges;
	}
	
	// Setter methods for all attributes
    /**
     * Sets the name of the procedure.
     * @param pName the new name of the procedure
     */

	public void setProcedureName(String pName) {
		procedureName = pName;
	}
	/**
     * Sets the date of the procedure.
     * @param pDate the new date of the procedure
     */

	public void setProcedureDate(String pDate) {
		procedureDate = pDate;
	}
	 
	/**
     * Sets the name of the practitioner who performed the procedure.
     * @param prName the new practitioner's name
     */

	public void setPractitionerName(String prName) {
		practitionerName = prName;
	}
	
	/**
     * Sets the charges for the procedure.
     * @param pCharges the new charges for the procedure
     */

	public void setCharges(double pCharges) {
		Charges = pCharges;
	}
	
	/**
     * @return a formatted string representing the procedure's details
     */
    @Override

	public String toString() {
		return "\tProcedure: " + procedureName + "\n" + "\tProcedureDate= " + procedureDate + "\n" + "\tPractitioner= "
				+ practitionerName + "\n" + "\tCharges=" + Charges;
	}
}
