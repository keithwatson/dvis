package com.datavisualisation;

public class Server {

	private static String serverRoot;


	public static String getServerRoot() {
		return serverRoot;
	}


	public static String getTemplatesDirectory() {
		return serverRoot + "templates/";
	}


	public static void setServerRoot(String serverRoot) {
		Server.serverRoot = serverRoot;
	}

}
