package com.klst.edoc.api;

/*

Code Type = Identifier + VersionID of the schema/list
used for Product Classification Class Code

 */
public interface IdentifierExt extends Identifier {

	public void setVersionIdentifier(String versionID);
	public String getVersionIdentifier();

}
