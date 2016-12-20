package net.xuchuan.common.gaiaconfig;

import java.lang.reflect.Field;

public class FieldOperator {
    private Object object;
    private Field field;

    public FieldOperator(Object object, Field field) {
        field.setAccessible(true);
        this.object = object;
        this.field = field;
        if (field.getType() != String.class
                && field.getType() != int.class
                && field.getType() != long.class
                && field.getType() != float.class
                && field.getType() != double.class
                && field.getType() != String[].class
                && field.getType() != int[].class
                && field.getType() != long[].class
                && field.getType() != float[].class
                && field.getType() != double[].class) {
            throw new IllegalArgumentException("Unsupported field type: " + field.getType().getCanonicalName());
        }
    }

    public void setValue(String value) {
        try {
            if (field.getType() == String.class) {
                field.set(object, value);
            } else if (field.getType() == int.class) {
                field.set(object, Utils.parseStringAsInt(value));
            } else if (field.getType() == long.class) {
                field.set(object, Utils.parseStringAsLong(value));
            } else if (field.getType() == float.class) {
                field.set(object, Utils.parseStringAsFloat(value));
            } else if (field.getType() == double.class) {
                field.set(object, Utils.parseStringAsDouble(value));
            } else if (field.getType() == String[].class) {
                field.set(object, Utils.parseStringAsStringArray(value));
            } else if (field.getType() == int[].class) {
                field.set(object, Utils.parseStringAsIntArray(value));
            } else if (field.getType() == long[].class) {
                field.set(object, Utils.parseStringAsLongArray(value));
            } else if (field.getType() == float[].class) {
                field.set(object, Utils.parseStringAsFloatArray(value));
            } else if (field.getType() == double[].class) {
                field.set(object, Utils.parseStringAsDoubleArray(value));
            } else {
                throw new RuntimeException("should not reach here.");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("should not reach here.");
        }
    }
}
