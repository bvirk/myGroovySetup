package cg;
/**
* Settings applying for the installation on current desktop computer
*/

/**
 * Print utility that spawns arrays, lists and Associative Arrays in addtion to simple types and ToString() 
 * equipped objects.
 */
class Print {
	/**
	 * Object that keeps track of indention during print of something inside other things
	 */
	static class Spacer {

		String prefix="";
		
		/**
		 * prefixes line with indentation
		 * @param line to be printet
		 * @return line prefixed indention
		 */
		String apply(String line) {
			return prefix+line;
		}
		
		/**
		 * prefixes line with indentation - adjusting indentation
		 * @param line to be printet
		 * @param applyAfter increases indentation by 4 spaces on true or reduces indentation by 4 spaces on false
 		 * @return line prefixed indention
		 */
		String apply(String line, boolean applyAfter) {
			if (applyAfter) {
				line  = prefix+line;
				prefix += "    ";
			} else 
				line = (prefix = prefix.substring(4))+line;
			return line;
		}
	}
	/**
	*  Print things, showing decomposition using curly braces
	*
	* @param thing to print at a line
	*/ 
	static def p(def thing) {
		if (thing.getClass().isArray() || thing instanceof AbstractCollection || thing instanceof AbstractMap )
			p thing, new Print.Spacer()
		else
			println thing
	}

	/**
	* Print things, showing decomposition using curly braces
	*
	* @param thing to be printed
	* @param spacer to control indention of recursion
	*/
	static void p(def thing,Print.Spacer spacer) {
		if (thing.getClass().isArray() || thing instanceof AbstractCollection || thing instanceof AbstractMap) {
			println spacer.apply("{"+thing.getClass().getName(),true)
			if ( thing instanceof AbstractMap)
				for (Object k :thing.keySet())
					p k == null ? null : k.toString()+"="+thing.get(k).toString(),spacer
			else
				for (Object line : thing)
					p line == null ? null : line,spacer
			
			println spacer.apply("}",false)
		} else 
				println spacer.apply(""+thing)
	}

}
