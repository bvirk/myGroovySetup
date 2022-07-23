package cg;

/**
 * Exposes documentaion for classes formed as the api javadoc
 */
class Jimport {

	/**
	 * Retrives the javadoc api url of one of  the jarfiles listet in MachineSettings.jarList

	 * @param jarKey is the name of a jar file without the jar suffix
	 * @return url of javadoc api
	 */
	static String japiUrl(String jarKey) {
		for (String line : MachineSettings.jarList) {
			String[] kv = line.split("=");
			if (jarKey.equals(kv[0]))
				return kv[1].split(",")[0];
		}
		null;
	}

	/**
	 * Exposes the filenames in MachineSettings.jarList
	 * 
	 * @return list of filenames of jar files with full path.
	 */
	static def jars() {
		//List arr = new ArrayList()
		def arr =  []
		for (String line : MachineSettings.jarList) {
			String[] kv = line.split("=");
			arr << kv[1].split(",")[1]+"/"+kv[0]+".jar";
		}
		return arr;
	}

	/** 
	 * Search for class in jar file. 
	 * @param className is the base name without package 
	 * @param jarfile to search for a class
	 * @return list of package names having a given short class name
	 */
	static def jimportJar(String className,String jarfile) {
		def classes = []
		if (!new File(jarfile).exists()) {
			// statMes(jarfile+ " not found");
			return classes
		}
		String[] cmds = ["jar","-tf",jarfile]
		Process proc = Runtime.getRuntime().exec cmds 
		BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()))
		def line
		while ((line = br.readLine()) != null) {
			if (line.matches(".+/"+className+"\\.class"))
				classes << Dirutils.basename(jarfile,true)+": "+line
		}
		br.close();
		int retval;
		try {
			proc.waitFor();
		} catch (InterruptedException e ) {
			retval=127;
		}	
		if (retval == 0)
			retval = proc.exitValue();
		if (retval == 127)
			classes << "scriptNotFound: "
		classes
	} 

	/**
	 * Search for a class in all jar files listet in in MachineSettings.jarList 
	 * @param className is the base name without package 
	 * @return jar basename withoput jar suffix prefixed list of package names having a given short class name
	 */
	static def jimport(String className) {
		def allClasses = []
		for (String jar : jars())
			allClasses.addAll(jimportJar(className,jar))
		return allClasses
	}

}

