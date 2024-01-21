package ch.laeub.week9.annotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class AnnotationParser {

    public static String toString(Object object) {
        if(object == null) return null;

        Class<?> objectClass = object.getClass();   // Get class of the object
        Annotation[] annotations = objectClass.getAnnotations();    // Grab all of the class level annotations

        for(Annotation annotation : annotations) {
            if(annotation.annotationType().equals(ToString.class)) {
                System.out.println("ToString annotation on class level found!");
            }
        }

        return "";
    }

}
