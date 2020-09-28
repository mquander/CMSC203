import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * Class to create a Management Company
 * @author MQuander
 *
 */
public class ManagementCompany {

	private String name, taxID;
	private double mgmFee;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private ArrayList<Property> propArr;
	private Property prop;
	private Plot mPlot;
	/**
	 * No-arg constructor to create a default Management Company object
	 */
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFee = 0.0;
		mPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		propArr = new ArrayList<Property>(MAX_PROPERTY);
	}
	/**
	 * Constructor takes 3 parameters and creates an object with passed values
	 * @param name Name of the management company
	 * @param taxID Tax ID
	 * @param mgmFee management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		mPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		propArr = new ArrayList<Property>(MAX_PROPERTY);
	}
	/**
	 * Constructor takes 7 parameters and creates an object with passed values
	 * @param name Name of the management company
	 * @param taxID Tax ID
	 * @param mgmFee management fee
	 * @param x Value of X coordinate for the plot
	 * @param y Value of Y coordinate for the plot
	 * @param width Value of the width for the plot
	 * @param depth Value of the depth for the plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		mPlot = new Plot(x, y, width, depth);
		propArr = new ArrayList<Property>(MAX_PROPERTY);
	}
	/**
	 * Method takes Property object, copies it, and tests many conditions 
	 * in relation to the Company's plot
	 * @param pr Property object passed as parameter 
	 * @return index The index of the property in the array
	 */
	public int addProperty(Property pr) {
		prop = new Property(pr);
		propArr.add(prop);
		int returnValue = propArr.indexOf(prop);
		
		if(prop.equals(null)) {
			propArr.remove(prop);
			returnValue = -2;
		}
		else if(propArr.size() > getMAX_PROPERTY()) {
			propArr.remove(prop);
			returnValue = -1;
		}
		else if(!getPlot().encompasses(prop.getPlot())) {
			propArr.remove(prop);
			returnValue = -3;
		}

		if(propArr.size() > 1) {
			for(int i = 0; i < propArr.size()-1; i++) {
				if(propArr.get(i).getPlot().overlaps(prop.getPlot())) {
					propArr.remove(prop);
					returnValue = -4;
				}
			}
		}
		
		return returnValue; 
	}
	/**
	 * Method takes arguments, creates Property object, copies it, and
	 *  tests many conditions in relation to the Company's plot
	 * @param propertyName Name passed from Property object created in Driver
	 * @param city City passed from Property object created in Driver
	 * @param rent Rent amount passed from Property object created in Driver
	 * @param ownerName Owner's name passed from Property object created in Driver
	 * @return index The index of the property in the array
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName) {
		prop = new Property(propertyName, city, rent, ownerName);
		propArr.add(prop);
		int returnValue = propArr.indexOf(prop);
		
		if(prop.equals(null)) {
			propArr.remove(prop);
			returnValue =  -2;
		}
		else if(propArr.size() > getMAX_PROPERTY()) {
			propArr.remove(prop);
			returnValue =  -1;
		}
		else if(!getPlot().encompasses(prop.getPlot())) {
			propArr.remove(prop);
			returnValue =  -3;
		}
		if(propArr.size() > 1) {
			for(int i = 0; i < propArr.size()-1; i++) {
				if(propArr.get(i).getPlot().overlaps(prop.getPlot())) {
					propArr.remove(prop);
					returnValue =  -4;
				}
			}
		}
		
		return returnValue;
			
	}
	/**
	 * Method takes arguments, creates Property object, copies it, and
	 *  tests many conditions in relation to the Company's plot
	 * @param propertyName Name passed from Property object created in Driver
	 * @param city City passed from Property object created in Driver
	 * @param rent Rent amount passed from Property object created in Driver
	 * @param ownerName Owner's name passed from Property object created in Driver
	 * @param x Value of X coordinate for the plot
	 * @param y Value of Y coordinate for the plot
	 * @param width Value of the width for the plot
	 * @param depth Value of the depth for the plot
	 * @return The index of the property in the array
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
		prop = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
		propArr.add(prop);
		int returnValue = propArr.indexOf(prop);;
		
		if(prop.equals(null)) {
			propArr.remove(prop);
			returnValue = -2;
		}
		else if(propArr.size() > getMAX_PROPERTY()) {
			propArr.remove(prop);
			returnValue =  -1;
		}
		else if(!getPlot().encompasses(prop.getPlot())) {
			propArr.remove(prop);
			returnValue =  -3;
		}
		if(propArr.size() > 1) {
			for(int i = 0; i < propArr.size()-1; i++) {
				if(propArr.get(i).getPlot().overlaps(prop.getPlot())) {
					propArr.remove(prop);
					returnValue =  -4;
				}
			}
		}
		
		return returnValue;
	}
	/**
	 * No-arg method that calculates the total rent of all the properties
	 * @return total rent amount
	 */
	public double totalRent() {
		double totalRent = 0.0;
		for(int i= 0; i < propArr.size(); i++) {
			totalRent += propArr.get(i).getRentAmount();
		}
		return totalRent;
	}
	/**
	 * No-arg method to determine the property with the highest rent
	 * @return String of the property info with the highest rent
	 */
	public String maxRentPropInfo() {
		
		return propArr.get(maxPropertyIndex()).toString();
	}
	/**
	 * No-arg method to determine the index of the property with the highest rent
	 * @return index of property with highest rent
	 */
	private int maxPropertyIndex() {
		int index = 0;
		double highestRentAmt = propArr.get(0).getRentAmount();
		for(int i = 1; i < propArr.size(); i++) {
			if(propArr.get(i).getRentAmount() > highestRentAmt) {
				highestRentAmt = propArr.get(i).getRentAmount();
				index++;
			}
		}
		return index;
	}
	/**
	 * No-arg method that calculates total management fee, and displays a list of 
	 * all of the properties and the total management fee
	 * @return String of properties info and total management fee
	 */
	public String toString() {
		double totalMgmtFee = totalRent() * (mgmFee * .01);
		String str = "List of the properties for " + getName() + ", Tax ID: " + taxID +
				"\n__________________________________________________\n"; 
		
		for(int i = 0; i < propArr.size(); i++) {
			str += propArr.get(i).toString();
		}
		DecimalFormat df = new DecimalFormat(".00");
		return str + "__________________________________________________\ntotal management Fee: $" + df.format(totalMgmtFee);
					
	}
	/**
	 * Get method for management company's name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Get method for the maximum amount of properties
	 * @return MAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	/**
	 * Get method for the management company's plot
	 * @return mPlot
	 */
	public Plot getPlot() {
		return mPlot;
	}
}
