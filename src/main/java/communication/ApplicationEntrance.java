package communication;


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class ApplicationEntrance extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> returnValue = new HashSet<Class<?>>();
		returnValue.add(RequestHandler.class);
		return returnValue;
	}
}