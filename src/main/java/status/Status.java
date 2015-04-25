package status;

public interface Status {

	final String[][] OFF = {{"http://localhost:8080/api/rest/cruiseControl/on", "turnon"},
								{"http://localhost:8080/api/rest/cruiseControl", "self"}};
	
	final String[][] ON = {{"http://localhost:8080/api/rest/cruiseControl/on", "self"},
							{"http://localhost:8080/api/rest/cruiseControl", "turnoff"},
							{"http://localhost:8080/api/rest/cruiseControl/control", "setspeed"}
							};
	
	final String[][] CONTROL ={{"http://localhost:8080/api/rest/cruiseControl/control", "self"},
								{"http://localhost:8080/api/rest/cruiseControl/on", "pause"},
								{"http://localhost:8080/api/rest/cruiseControl", "turnoff"},
								{"http://localhost:8080/api/rest/cruiseControl/inc", "increase"},
								{"http://localhost:8080/api/rest/cruiseControl/dec", "decrease"}
								};
	}
	
	



