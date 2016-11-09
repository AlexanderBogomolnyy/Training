package ua.training.block05.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * <p> This class provides methods for extracting meta information about set
 * class in text format.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 08.11.2016.
 */
public class MetaData {

    /**
     * Class for analyzing
     */
    private Class clazz;

    public MetaData(Class clazz) {
        this.clazz = clazz;
    }

    /**
     * This method searches the constructors in analyzing class
     *
     * @return - string array of constructors with their parameters
     */
    public String[] getConstructors() {
        Constructor[] constructors = clazz.getConstructors();
        String[] result = new String[constructors.length];
        for(int i = 0; i < constructors.length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(clazz.getSimpleName()).append("(");
            if (constructors[i].getParameters().length != 0) {
                for (Parameter parameter : constructors[i].getParameters()) {
                    builder.append(parameter.getParameterizedType().getTypeName()).append(" ").append(parameter.getName()).append(", ");
                }
                builder.delete(builder.length() - 2, builder.length());
            }
            builder.append(")");
            result[i] = builder.toString();
        }
        return result;
    }

    /**
     * This method searches the class modifiers
     *
     * @return - string array of class modifiers
     */
    public String[] getClassModifiers() {
        return Modifier.toString(clazz.getModifiers()).split(" ");
    }

    /**
     * This method searches the method with their annotation and parameters
     *
     * @return - string array of class methods with their annotations and parameters
     */
    public String[] getMethodsWithAnnotationAndParameters() {
        Method[] methods = clazz.getMethods();
        String[] result = new String[methods.length];
        for (int i = 0; i < methods.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (Annotation annotation : methods[i].getDeclaredAnnotations()) {
                builder.append("@").append(annotation.annotationType().getSimpleName()).append(" ");
            }
            builder.append(methods[i].getReturnType().getSimpleName()).append(" ").append(methods[i].getName()).append("(");
            for(Parameter parameter : methods[i].getParameters()) {
                builder.append(parameter.getParameterizedType().getTypeName()).append(", ");
            }
            if(methods[i].getParameters().length != 0) {
                builder.delete(builder.length() - 2, builder.length());
            }
            builder.append(")");
            result[i] = builder.toString();
        }
        return result;
    }

    /**
     * This method searches the analyzing class simple name and package name.
     *
     * @return - string with class simple name and package name
     */
    public String getClassNameWithPackageName() {
        StringBuilder builder = new StringBuilder();
        builder.append("Package: ").append(clazz.getPackage().getName()).append(";\n");
        builder.append("Class name: ").append(clazz.getSimpleName()).append(";");
        return builder.toString();
    }

    /**
     * This method searches the method with their access modifiers and parameters
     *
     * @return - string array of class methods with their annotations and parameters
     */
    public String[] getMethodsWithAccessModifiersAndParameters() {
        Method[] methods = clazz.getMethods();
        String[] result = new String[methods.length];
        for (int i = 0; i < methods.length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(Modifier.toString(methods[i].getModifiers())).append(" ");
            builder.append(methods[i].getReturnType().getSimpleName()).append(" ").append(methods[i].getName()).append("(");
            for(Parameter parameter : methods[i].getParameters()) {
                builder.append(parameter.getParameterizedType().getTypeName()).append(", ");
            }
            if(methods[i].getParameters().length != 0) {
                builder.delete(builder.length() - 2, builder.length());
            }
            builder.append(")");
            result[i] = builder.toString();
        }
        return result;
    }

    /**
     * This method searches the superclass full name
     *
     * @return - superclass full name
     */
    public String getSuperclassName() {
        return clazz.getSuperclass().getName();
    }

    /**
     * This method searches the fields name with their access modifiers and type
     *
     * @return - string array of class fields
     */
    public String[] getFieldsWithTypeAndAccessModifiers() {
        Field[] publicFields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
        Field[] fields = new Field[publicFields.length + declaredFields.length];
        System.arraycopy(publicFields,0,fields,0,publicFields.length);
        System.arraycopy(declaredFields,0,fields,publicFields.length,declaredFields.length);
        String[] result = new String[fields.length];
        for(int i = 0; i < fields.length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(Modifier.toString(fields[i].getModifiers())).append(" ");
            builder.append(fields[i].getType().getName()).append(" ");
            builder.append(fields[i].getName());
            result[i] = builder.toString();
        }
        return result;
    }

    /**
     * This method searches the class annotations
     *
     * @return - string array of class annotations
     */
    public String[] getClassAnnotations() {
        Annotation[] annotations = clazz.getAnnotations();
        String[] result = new String[annotations.length];
        for(int i =0; i < annotations.length; i++) {
            result[i] = annotations[i].annotationType().getName();
        }
        return result;
    }

    /**
     * This method searches the class interfaces
     *
     * @return - string array of class interfaces
     */
    public String[] getInterfaces() {
        Class<?>[] interfaces = clazz.getInterfaces();
        String[] result = new String[interfaces.length];
        for(int i = 0; i < interfaces.length; i++) {
            result[i] = interfaces[i].getName();
        }
        return result;
    }

    /**
     * This method searches the fields name with their annotations and type
     *
     * @return - string array of class fields
     */
    public String[] getFieldsWithTypeAndAnnotations() {
        Field[] publicFields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
        Field[] fields = new Field[publicFields.length + declaredFields.length];
        System.arraycopy(publicFields,0,fields,0,publicFields.length);
        System.arraycopy(declaredFields,0,fields,publicFields.length,declaredFields.length);
        String[] result = new String[fields.length];
        for(int i = 0; i < fields.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (Annotation annotation: fields[i].getAnnotations()) {
                builder.append("@").append(annotation.annotationType().getSimpleName()).append(" ");
            }
            builder.append(fields[i].getType().getName()).append(" ");
            builder.append(fields[i].getName());
            result[i] = builder.toString();
        }
        return result;
    }

    /**
     * This method invokes all methods marked by @Run annotation.
     *
     * @return - string array of annotated method invocation results
     * @throws Exception - reflection exceptions
     */
    public String[] invokeRunAnnotated() throws Exception {
        ArrayList<String> result = new ArrayList<>();
        Object instance = clazz.newInstance();
        for (Method method : clazz.getMethods()) {
            Run cool = method.getAnnotation(Run.class);
            if (cool != null) {
            if (cool.enable()) {
                result.add("Method: " + method.getName() + ". Call by @" + Run.class.getSimpleName() + ". Result: " + method.invoke(instance));
            } else {
                result.add("Method: " + method.getName() + ". Annotated by @" + Run.class.getSimpleName() + ", but have not been called.");
                }
            }
        }
        String[] stringResult = new String[result.size()];
        return result.toArray(stringResult);
    }

 }
