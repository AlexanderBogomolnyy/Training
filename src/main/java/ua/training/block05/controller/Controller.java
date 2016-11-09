package ua.training.block05.controller;

import ua.training.block05.model.MetaData;
import ua.training.block05.view.View;

/**
 * <p> The controller class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.11.2016.
 */
public class Controller {

    /**
     * Meta data analyzer instance
     */
    private MetaData metaData;

    /**
     * Application view
     */
    private View view;

    public Controller(MetaData metaData, View view) {
        this.metaData = metaData;
        this.view = view;
    }

    /**
     * Controller executive method
     */
    public void execute() {
        view.printlnMessage(View.INTRODUCTION);
        view.printlnMessage(View.CONSTRUCTORS);
        view.printlnMessage(metaData.getConstructors());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.CLASS_MODIFIERS);
        view.printlnMessage(metaData.getClassModifiers());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.METHODS_WITH_ANNOTATIONS_AND_PARAMETERS);
        view.printlnMessage(metaData.getMethodsWithAnnotationAndParameters());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.CLASS_AND_PACKAGE_NAME);
        view.printlnMessage(metaData.getClassNameWithPackageName());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.METHODS_WITH_ACCESS_MODIFIERS_AND_PARAMETERS);
        view.printlnMessage(metaData.getMethodsWithAccessModifiersAndParameters());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.SUPER_CLASS_NAME);
        view.printlnMessage(metaData.getSuperclassName());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.FIELDS_WITH_PARAMETERS_AND_ACCESS_MODIFIERS);
        view.printlnMessage(metaData.getFieldsWithTypeAndAccessModifiers());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.CLASS_ANNOTATIONS);
        view.printlnMessage(metaData.getClassAnnotations());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.CLASS_INTERFACES);
        view.printlnMessage(metaData.getInterfaces());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.FIELDS_WITH_PARAMETERS_AND_ANNOTATIONS);
        view.printlnMessage(metaData.getFieldsWithTypeAndAnnotations());
        view.printlnMessage(View.DIVIDER);
        view.printlnMessage(View.INVOKE_ANNOTATED);
        try {
            view.printlnMessage(metaData.invokeRunAnnotated());
        } catch (Exception e) {
            view.printlnMessage(e.getMessage());
        }
    }

}
