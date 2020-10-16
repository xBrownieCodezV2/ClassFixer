package de.xbrowniecodez.classfixer.methods;

import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import de.xbrowniecodez.classfixer.utils.Utils;

public class ClassFolders {
	public void process(ZipFile zip, ZipEntry zipEntry, ZipOutputStream out) throws Throwable {
		if (zipEntry.isDirectory() && zipEntry.getName().endsWith(".class/")) {
			ZipEntry newEntry = new ZipEntry(zipEntry.getName().replace(".class/", ".class"));
			newEntry.setTime(System.currentTimeMillis());
			out.putNextEntry(newEntry);
			Utils.writeToFile(out, zip.getInputStream(zipEntry));
		}
	}
}
