package com.jdc.anno2;

@TypeInfo("This is a Test Class")
public class TestClass {

    @FieldInfo("This is a name field")
    private String name;

    @ConstructorInfo("Main Constructor")
    public TestClass(@ParamInfo("Constructor Parameter") String name) {
        this.name = name;
    }

    @MethodInfo("Getter Method")
    public String getName(@ParamInfo("Method Parameter") String value, int count) {
        return value + " " + name + "Count : " + count;
    }
}