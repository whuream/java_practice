package com.ream.www.maventest;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Created by tong on 1/9/16.
 */
@SupportedAnnotationTypes({"com.ream.www.maventest.PrintMe"})
public class AnnotationProcessor extends AbstractProcessor{
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        Messager messager = processingEnv.getMessager();

        for(TypeElement te: annotations){
            for(Element e: roundEnv.getElementsAnnotatedWith(te)){
                messager.printMessage(Diagnostic.Kind.NOTE, e.toString());
            }
        }

        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion(){
        return SourceVersion.latestSupported();
    }
}
