package com.klst.edoc.api;

/**
 * BG-6 , BG-9 CONTACT
 * <p>
 * A group (BG) of business terms (BT) providing contact information relevant for the business partner,
 * a legal entity or person.
 * 
 * @see ContactInfoFactory#createContactInfo(String, String, String)
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for BGs, BTs, rules and request IDs
 */
public interface ContactInfo extends ContactInfoFactory {

	// use factory to set props

	/**
	 * optional contact point 
	 * <p>
	 * A contact point for a legal entity or person.
	 * Such as person name, contact identification, department or office identification.
	 * 
	 * @return null or contact point
	 */
	public String getContactPoint();
	
	/**
	 * optional contact telephone number
	 * <p>
	 * A phone number for the contact point.
	 * 
	 * @return null or contact phone number
	 */
	public String getContactTelephone();
	
	/**
	 * optional contact email address
	 * <p>
	 * An e-mail address for the contact point.
	 * 
	 * @return null or contact email address
	 */
	public String getContactEmail();

	/**
	 * optional contact code specifying the type of contact
	 * <p>
	 * To be chosen from the entries in UNTDID 3139
	 * 
	 * @param code - example buyer contact code 'LB' == Place of delivery contact : Department/employee to be contacted at the place of delivery.
	 */
	public void setContactType(String code);
	public String getContactType();
	
}
