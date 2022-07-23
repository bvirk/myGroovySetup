package cg;

/**
 * Console input for choice selecting among lines by keying a number
 */
class ConsoleInput {
	/**
	 * Selected string of line
	 * @param list of lines
	 * @return chosen string
	 */
	static String strOfInput(List choices) {
		int ret = numOfInput(choices); 
		return ret > 0 ? choices.get(ret-1) : null;
	}

	/**
	 * number of selected string of line
	 * @param list of lines
	 * @return number keyed for selecting a line
	 */
	static int numOfInput(List choices) {
		int ret
		do {
			int numch = 1;
			Print.p '\n0: escape'
			for (def sel : choices) 
				Print.p numch++ +": "+sel
			String line = System.console().readLine();
			ret = line.matches("\\d+") 
				? Integer.parseInt(line)
				: -1;
		} while (ret < 0 || ret > choices.size());
		return ret;
	}

}


