package com.jdc.anno2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TYPE
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TypeInfo {
    String value() default "Default Type";
}

// FIELD
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldInfo {
    String value() default "Default Field";
}

// METHOD
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodInfo {
    String value() default "Default Method";
}

// CONSTRUCTOR
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
@interface ConstructorInfo {
    String value() default "Default Constructor";
}

// PARAMETER
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface ParamInfo {
    String value() default "Default Parameter";
}
