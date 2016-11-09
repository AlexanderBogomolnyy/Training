package ua.training.block05.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> This annotation designed for field marking.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 08.11.2016.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMarker {
}
