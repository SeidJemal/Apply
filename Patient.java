package week4;

/**
 * Class: CMSC203 
 * Program: Project 2 
 * Instructor: Professor Gary Thai
 * Description: The Patient class represents a patient with basic information.
 * It provides constructors, accessors, mutators, and helper methods to build
 * the patient's information. 
 * Due: 10/04/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class Patient {

	// Fields to store patient's basic information
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String emergencyContactName;
	private String emergencyContactPhone;

	/**
	 * No-argument constructor that creates an empty Patient object.
	 */
	public Patient() {
	}

	/**
	 * Constructor that initializes the patient's first name, middle name, and last
	 * name.
	 *
	 * @param pFName the first name of the patient
	 * @param pMName the middle name of the patient
	 * @param pLName the last name of the patient
	 */

	public Patient(String pFName, String pMName, String pLName) {
		firstName = pFName;
		middleName = pMName;
		lastName = pLName;
	}

	/**
	 * Constructor that initializes all attributes of the patient.
	 *
	 * @param pFName    the first name of the patient
	 * @param pMName    the middle name of the patient
	 * @param pLName    the last name of the patient
	 * @param pStAdd    the street address of the patient
	 * @param pCity     the city of the patient
	 * @param pState    the state of the patient
	 * @param pZip      the zipcode of the patient
	 * @param pPhNumber the phone number of the patient
	 * @param pECName   the patient's emergency contact name
	 * @param pECPhone  the patient's emergency contact phone number
	 */
	public Patient(String pFName, String pMName, String pLName, String pStAdd, String pCity, String pState, String pZip,
			String pPhNumber, String pECName, String pECPhone) {
		firstName = pFName;
		middleName = pMName;
		lastName = pLName;
		streetAddress = pStAdd;
		city = pCity;
		state = pState;
		zipCode = pZip;
		phoneNumber = pPhNumber;
		emergencyContactName = pECName;
		emergencyContactPhone = pECPhone;
	}

	// Getter methods

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	// Setter methods
	public void setFirstName(String pFName) {
		firstName = pFName;
	}

	public void setMiddleName(String pMName) {
		middleName = pMName;
	}

	public void setLastName(String pLName) {
		lastName = pLName;
	}

	public void setStreetAddress(String pStAdd) {
		streetAddress = pStAdd;
	}

	public void setCity(String pCity) {
		city = pCity;
	}

	public void setState(String pState) {
		state = pState;
	}

	public void setZipCode(String pZip) {
		zipCode = pZip;
	}

	public void setPhoneNumber(String pPhNumber) {
		phoneNumber = pPhNumber;
	}

	public void setEmergencyContactName(String pECName) {
		emergencyContactName = pECName;
	}

	public void setEmergencyContactPhone(String pECPhone) {
		emergencyContactPhone = pECPhone;
	}

	/**
	 * @return the full name of the patient
	 */
	public String buildFullName() {
		return firstName + " " + middleName + " " + lastName;
	}

	/**
	 * @return the full address of the patient
	 */

	public String buildAddress() {
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}

	/**
	 * @return the emergency contact information
	 */
	public String buildEmergencyContact() {
		return emergencyContactName + " " + emergencyContactPhone;
	}

	/**
	 * @return a string that includes the full name, address, phone number, and
	 *         emergency contact information
	 */
	@Override

	public String toString() {
		return " Full Name: " + buildFullName() + "\n" + " Address: " + buildAddress() + "\n" + " Phone: " + phoneNumber
				+ "\n" + " Emergency Contact: " + buildEmergencyContact();
	}
}