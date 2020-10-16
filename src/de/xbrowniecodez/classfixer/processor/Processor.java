package de.xbrowniecodez.classfixer.processor;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import de.xbrowniecodez.classfixer.methods.ClassFolders;
import de.xbrowniecodez.classfixer.utils.Utils;

public class Processor {
	public Processor(String input) throws Throwable {
			Utils.log("Processing...");
			File file = new File(input);
			ZipFile zip = new ZipFile(file);
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(input.replace(".jar", "") + "-Output.jar"));
			Enumeration<? extends ZipEntry> entries2 = zip.entries();
			while (entries2.hasMoreElements()) {
				ZipEntry zipEntry = entries2.nextElement();
				ClassFolders classFolder = new ClassFolders();
				classFolder.process(zip, zipEntry, out);
			}
			zip.close();
			out.close();
		
	}

}
