package de.xbrowniecodez.classfixer.utils;

import java.io.InputStream;
import java.util.zip.ZipOutputStream;

public class Utils {
	public static void writeToFile(ZipOutputStream outputStream, InputStream inputStream) throws Throwable {
		byte[] buffer = new byte[4096];
		try {
			while (inputStream.available() > 0) {
				int data = inputStream.read(buffer);
				outputStream.write(buffer, 0, data);
			}
		} finally {
			inputStream.close();
			outputStream.closeEntry();
		}
	}

	public static void log(String string) {
		System.out.print("[ClassFixer] "+string + "\n");
	}

}
