package de.thm.smarthome.global.connection.wsprovider;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * JAX-RS Application class for this example.
 *
 * @author Martin Matula
 */
public class JaxRsApplication extends Application {
    private final Set<Class<?>> classes;

    public JaxRsApplication() {
        HashSet<Class<?>> c = new HashSet<Class<?>>();
        c.add(HelloWorldResource.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
