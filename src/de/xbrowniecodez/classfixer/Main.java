package de.xbrowniecodez.classfixer;

import de.xbrowniecodez.classfixer.processor.Processor;
import de.xbrowniecodez.classfixer.utils.Utils;

public class Main {
	public static void main(String args[]) throws Throwable {
		Utils.log("Starting ClassFixer v1.0 by xBrownieCodez");
		new Processor(args[0]);
		Utils.log("Done! Output: " + args[0].replace(".jar", "") + "-Output.jar");
	}


}
