package com.skimmy.androidutillibrary.filesystem;

import java.io.File;

import com.skimmy.androidutillibrary.filesystem.exceptions.FilesystemMismatchException;

import android.os.Environment;

/**
 * 
 * This class contains utility methods to access the file-system of the device.
 * The most frequent operations (like opening a file, creating a directory, ...)
 * are performed by some of the class methods.
 * 
 * @author Michele Schimd 
 *
 */
public class AndroidFileHelper {

	/**
	 * Same as {@link #getOrCreateDirectory(String, boolean)} with the external
	 * memory flag set to <code>true</code>.
	 * 
	 * @param name
	 *            The name of the directory to be created
	 * @return The {@link File} descriptor for the requested directory
	 * @throws FilesystemMismatchException
	 *             If the requested name corresponds to a file
	 * 
	 * @see #getOrCreateDirectory(String, boolean)
	 */
	public static File getOrCreateDirectory(String name)
			throws FilesystemMismatchException {
		return getOrCreateDirectory(name, true);
	}

	/**
	 * Returns a directory with the given name and, possibly, located on the
	 * external storage (a.k.a. memory card) depending on the value of the
	 * proper flag. If the directory doesn't exist, then it is created if a file
	 * (not directory) with the same name at the same location exists, then a
	 * {@link FilesystemMismatchException} is thrown.
	 * 
	 * @param name
	 *            The name of the directory to be created/opened
	 * @param sdCard
	 *            if <code>true</code> a first attempt to access the memory card
	 *            is performed
	 * @return The {@link File} descriptor for the requested directory
	 * @throws FilesystemMismatchException
	 *             If the name of the requsted directory is indeed a file
	 * 
	 * @see #getOrCreateDirectory(String)
	 */
	public static File getOrCreateDirectory(String name, boolean sdCard)
			throws FilesystemMismatchException {
		File directory = null;
		File sdCardDir = Environment.getExternalStorageDirectory();
		// First try the SD Card directory if flag is set
		if (sdCard && sdCardDir != null && sdCardDir.exists()) {
			directory = new File(sdCardDir, name);
		} else {
			// there is no SD card available
			directory = new File(name);
		}

		// if the directory does not exist create it
		if (!directory.exists()) {
			directory.mkdir();
		}
		// if the directory exists, but it is indeed file throw a
		// FilesystemMismatchException with proper message
		if (!directory.isDirectory()) {
			throw new FilesystemMismatchException(
					"Requested directory is indeed a file");
		}
		return directory;
	}
}
