package cg;

/**
* Settings applying for the installation on current desktop computer
*/
class MachineSettings  {
	static String browser="firefox";
	static String serverurl="http://ba"; //not used yet in basic distibution
	static String userDir = System.getProperties().getProperty("user.dir");
	static String userDirS = userDir+"/";
	/** 
	 * List of jar files with api documentation - local or remote.
	 * Connects file name of jar file, it placement and url of api 
	 * key is basename of jar file without the jar suffix.
	 */ 
	static String[] jarList = [
		"rt=https://docs.oracle.com/javase/8/docs/api/,/opt/jdk1.8.0_202/jre/lib"
		,"nashorn=https://docs.oracle.com/javase/8/docs/jdk/api/nashorn/,/opt/jdk1.8.0_202/jre/lib/ext"
		,"jedit=file:///usr/local/share/jEdit/5.5.0/doc/api/,/usr/local/share/jEdit/5.5.0"
		,"jsoup-1.14.3=https://jsoup.org/apidocs/,/home/bvirk/.jedit/jars"
		,"bsh-2.0b4=http://www.beanshell.org/javadoc/,/opt/jdk1.8.0_202/jre/lib/ext"
		,"TxtConv=file:///home/bvirk/documents/devel/java/TxtConv/api/,/home/bvirk/documents/devel/java/TxtConv/build/jar"
		,"cg=file:///home/bvirk/documents/devel/groovy/gapi/,/home/bvirk/documents/devel/groovy/jar"
		]
}
