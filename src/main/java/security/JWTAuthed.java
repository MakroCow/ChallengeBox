package security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * Annotation, die die APIs absichert
 * wenn die Annotation an eine Endpunkt Implemntierung angefügt wird, wird auf gültigen jwt getestet
 */
@javax.ws.rs.NameBinding
@Retention(RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface JWTAuthed {
}
