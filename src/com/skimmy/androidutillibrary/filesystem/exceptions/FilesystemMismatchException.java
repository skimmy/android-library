package com.skimmy.androidutillibrary.filesystem.exceptions;

public class FilesystemMismatchException extends Exception {

	/**
	 *  Exception used by the {@link AndroidFileHelper} methods
	 */
	private static final long serialVersionUID = -7696584457996758791L;
	
	public FilesystemMismatchException(String msg) {
		super(msg);
	}
}
