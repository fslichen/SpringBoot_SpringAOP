package evolution.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service// Application's intrinsic @ComponentScan scans this annotation, which makes AnyService autowirable.
public class AnyService {
	// Extract the property value under application.properties. If the property is not found, use 'World' as the default value.
	@Value("${name:World}")
	private String name;

	public String anyMethod() {
		return "Hello " + this.name;
	}
	
	public String anotherMethod(String name) {
		return "Hello " + name;
	}
}