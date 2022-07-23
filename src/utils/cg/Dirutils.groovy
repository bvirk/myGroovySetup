package cg;

/**
 * Utility concerning directory and file paths
 */
class Dirutils {
	
	/**
	* As the unix counterpart with a second modified second option
	* to remove any extension
	
	* @param pathName
	* @param withOutExtension desides if suffix is removed
	* @return filename without path and without suffix on withOutExtension being truth 
	*/
	static String basename(String pathName,boolean withOutExtension) {
		String bwe = pathName.replaceAll('^.+/','');
		return withOutExtension	? bwe.replaceAll(/\.[^\.]+$/,''): bwe
	}
}

