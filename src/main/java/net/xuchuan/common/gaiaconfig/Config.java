package net.xuchuan.common.gaiaconfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Config extends Cloneable {
    String getProperty(String key);

    String getProperty(String key, String defaultValue);

    int getIntProperty(String key);

    int getIntProperty(String key, int defaultValue);

    long getLongProperty(String key);

    long getLongProperty(String key, long defaultValue);

    float getFloatProperty(String key);

    float getFloatProperty(String key, float defaultValue);

    double getDoubleProperty(String key);

    double getDoubleProperty(String key, double defaultValue);

    String[] getStringArrayProperty(String key);

    String[] getStringArrayProperty(String key, String[] defaultValue);

    int[] getIntArrayProperty(String key);

    int[] getIntArrayProperty(String key, int[] defaultValue);

    long[] getLongArrayProperty(String key);

    long[] getLongArrayProperty(String key, long[] defaultValue);

    float[] getFloatArrayProperty(String key);

    float[] getFloatArrayProperty(String key, float[] defaultValue);

    double[] getDoubleArrayProperty(String key);

    double[] getDoubleArrayProperty(String key, double[] defaultValue);

    List<String> getStringListProperty(String key);

    List<String> getStringListProperty(String key, List<String> defaultValue);

    List<Integer> getIntegerListProperty(String key);

    List<Integer> getIntegerListProperty(String key, List<Integer> defaultValue);

    List<Long> getLongListProperty(String key);

    List<Long> getLongListProperty(String key, List<Long> defaultValue);

    List<Float> getFloatListProperty(String key);

    List<Float> getFloatListProperty(String key, List<Float> defaultValue);

    List<Double> getDoubleListProperty(String key);

    List<Double> getDoubleListProperty(String key, List<Double> defaultValue);

    Set<String> getKeySet();

    Map<String, ConfigItem> getItemMap();

    void reload();

    Config clone();
}