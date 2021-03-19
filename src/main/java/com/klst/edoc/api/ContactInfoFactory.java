package com.klst.edoc.api;

/**
 * abstract-factory, aka Kit for 
 * BG-6 SELLER CONTACT ,
 * BG-9 BUYER CONTACT 
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */
public interface ContactInfoFactory {
	
	/**
	 * creates business group (BG) CONTACT
	 * 
	 * @param contactName - a contact point for a legal entity or person.
	 * @param contactTel - a phone number for the contact point.
	 * @param contactMail - an e-mail address for the contact point.
	 * 
	 * @see ContactInfo
	 */
	public ContactInfo createContactInfo(String contactName, String contactTel, String contactMail);
	
}
