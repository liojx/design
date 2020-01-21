package createMode.singleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: liaosijun
 * @Time: 2020/1/20 16:30
 */
public class SingletonFile {
	private static SingletonFile singletonFile;
	static {
		singletonFile = new SingletonFile();
	}
	public static SingletonFile getSingletonFile(){
		return singletonFile;
	}

	static final String fileName = "d:/Temp/console.log";
	static File f = createFile();

	static File createFile() {
		File file;
		file = new File(fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	static FileOutputStream out;

	static {
		try {
			out = new  FileOutputStream(f,true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void log(String txt) {
		try {
			synchronized (out) {
				out.write(txt.getBytes());
				out.write("\n".getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
