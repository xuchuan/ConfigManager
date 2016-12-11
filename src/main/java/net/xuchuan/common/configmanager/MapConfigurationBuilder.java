package net.xuchuan.common.configmanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapConfigurationBuilder {
    private String name;
    private Map<String, String> valueMap;

    public MapConfigurationBuilder(String name) {
        this(name, new HashMap<String, String>());
    }

    public MapConfigurationBuilder(String name, Map<String, String> valueMap) {
        this.name = name;
        this.valueMap = valueMap;
    }

    public MapConfigurationBuilder setProperty(String key, String value) {
        this.valueMap.put(key, value);
        return this;
    }

    public MapConfigurationBuilder setIntProperty(String key, int value) {
        this.valueMap.put(key, Utils.convertIntToString(value));
        return this;
    }

    public MapConfigurationBuilder setLongProperty(String key, long value) {
        this.valueMap.put(key, Utils.convertLongToString(value));
        return this;
    }

    public MapConfigurationBuilder setFloatProperty(String key, float value) {
        this.valueMap.put(key, Utils.convertFloatToString(value));
        return this;
    }

    public MapConfigurationBuilder setDoubleProperty(String key, double value) {
        this.valueMap.put(key, Utils.convertDoubleToString(value));
        return this;
    }

    public MapConfigurationBuilder setStringArrayProperty(String key, String[] value) {
        this.valueMap.put(key, Utils.convertStringArrayToString(value, ","));
        return this;
    }

    public MapConfigurationBuilder setIntArrayProperty(String key, int[] value) {
        this.valueMap.put(key, Utils.convertIntArrayToString(value, ","));
        return this;
    }

    public MapConfigurationBuilder setLongArrayProperty(String key, long[] value) {
        this.valueMap.put(key, Utils.convertLongArrayToString(value, ","));

        return this;
    }

    public MapConfigurationBuilder setFloatArrayProperty(String key, float[] value) {
        this.valueMap.put(key, Utils.convertFloatArrayToString(value, ","));
        return this;
    }

    public MapConfigurationBuilder setDoubleArrayProperty(String key, double[] value) {
        this.valueMap.put(key, Utils.convertDoubleArrayToString(value, ","));
        return this;
    }

    public MapConfigurationBuilder setStringListProperty(String key, List<String> value) {
        this.valueMap.put(key, Utils.convertStringCollectionToString(value, ","));
        return this;
    }

    public MapConfigurationBuilder setIntegerListProperty(String key, List<Integer> value) {
        this.valueMap.put(key, Utils.convertIntegerCollectionToString(value, ","));
        return this;
    }

    public MapConfigurationBuilder setLongListProperty(String key, List<Long> value) {
        this.valueMap.put(key, Utils.convertLongCollectionToString(value, ","));
        return this;
    }

    public MapConfigurationBuilder setFloatListProperty(String key, List<Float> value) {
        this.valueMap.put(key, Utils.convertFloatCollectionToString(value, ","));
        return this;
    }

    public MapConfigurationBuilder setDoubleListProperty(String key, List<Double> value) {
        this.valueMap.put(key, Utils.convertDoubleCollectionToString(value, ","));
        return this;
    }

    public MapConfigurationBuilder removeProperty(String key) {
        this.valueMap.remove(key);
        return this;
    }

    public MapConfigurationBuilder clear() {
        this.valueMap.clear();
        return this;
    }

    public MapConfiguration build() {
        return new MapConfiguration(name, this.valueMap);
    }
}
