package net.xuchuan.common.configmanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueMapBuilder {
    private Map<String, String> valueMap;

    public ValueMapBuilder() {
        this(new HashMap<String, String>());
    }

    public ValueMapBuilder(Map<String, String> valueMap) {
        Utils.checkNotNull("valueMap", valueMap);
        this.valueMap = valueMap;
    }

    public ValueMapBuilder setProperty(String key, String value) {
        Utils.checkNotEmptyStringAfterTrim("key", key);
        Utils.checkNotEmptyStringAfterTrim("value", value);
        valueMap.put(key.trim(), value.trim());
        return this;
    }

    public ValueMapBuilder setIntProperty(String key, int value) {
        setProperty(key, Utils.convertIntToString(value));
        return this;
    }

    public ValueMapBuilder setLongProperty(String key, long value) {
        setProperty(key, Utils.convertLongToString(value));
        return this;
    }

    public ValueMapBuilder setFloatProperty(String key, float value) {
        setProperty(key, Utils.convertFloatToString(value));
        return this;
    }

    public ValueMapBuilder setDoubleProperty(String key, double value) {
        setProperty(key, Utils.convertDoubleToString(value));
        return this;
    }

    public ValueMapBuilder setStringArrayProperty(String key, String[] value) {
        setProperty(key, Utils.convertStringArrayToString(value, ","));
        return this;
    }

    public ValueMapBuilder setIntArrayProperty(String key, int[] value) {
        setProperty(key, Utils.convertIntArrayToString(value, ","));
        return this;
    }

    public ValueMapBuilder setLongArrayProperty(String key, long[] value) {
        setProperty(key, Utils.convertLongArrayToString(value, ","));

        return this;
    }

    public ValueMapBuilder setFloatArrayProperty(String key, float[] value) {
        setProperty(key, Utils.convertFloatArrayToString(value, ","));
        return this;
    }

    public ValueMapBuilder setDoubleArrayProperty(String key, double[] value) {
        setProperty(key, Utils.convertDoubleArrayToString(value, ","));
        return this;
    }

    public ValueMapBuilder setStringListProperty(String key, List<String> value) {
        setProperty(key, Utils.convertStringCollectionToString(value, ","));
        return this;
    }

    public ValueMapBuilder setIntegerListProperty(String key, List<Integer> value) {
        setProperty(key, Utils.convertIntegerCollectionToString(value, ","));
        return this;
    }

    public ValueMapBuilder setLongListProperty(String key, List<Long> value) {
        setProperty(key, Utils.convertLongCollectionToString(value, ","));
        return this;
    }

    public ValueMapBuilder setFloatListProperty(String key, List<Float> value) {
        setProperty(key, Utils.convertFloatCollectionToString(value, ","));
        return this;
    }

    public ValueMapBuilder setDoubleListProperty(String key, List<Double> value) {
        setProperty(key, Utils.convertDoubleCollectionToString(value, ","));
        return this;
    }

    public ValueMapBuilder removeProperty(String key) {
        valueMap.remove(key);
        return this;
    }

    public ValueMapBuilder clear() {
        valueMap.clear();
        return this;
    }

    public Map<String, String> getValueMap() {
        return valueMap;
    }
}
