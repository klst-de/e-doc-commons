package com.klst.edoc.api;

/*

IdentifierExt = Identifier + VersionID of the schema/list and idName
used for Product Classification Class Code

 */
public interface IdentifierExt extends Identifier {

	/**
	 * identification scheme identifier, f.i. "EN" (EAN)
	 * @param id - the identification scheme shall be chosen from the entries in UNTDID 7143
	 */
	@Override
	public void setSchemeIdentifier(String id);

	/**
	 * idText is the description for the SchemeIdentifier
	 * <p>
	 * example: content (aka Product Classification Class Code) is 4047247110051.
	 * This is a code in the SchemeId UNTDID 7143 "EN". The idText for "EN" is
	 * International Article Numbering Association (EAN):
	 *  Number assigned to a manufacturer's product according to the International Article Numbering Association.
	 * 
	 * @param idText
	 */
	public void setIdText(String idText);
	public String getIdText();

	public void setVersionIdentifier(String versionID);
	public String getVersionIdentifier();

}
