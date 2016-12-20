package net.xuchuan.common.gaiaconfig;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public abstract class AbstractConfig implements Config {
    protected Config baseConfig;
    protected String name;
    protected volatile Map<String, ConfigItem> itemMap = new HashMap<String, ConfigItem>();

    public AbstractConfig(String name, Config baseConfig) {
        Utils.checkNotEmptyStringAfterTrim("name", name);
        this.name = name;
        this.baseConfig = baseConfig;
    }

    public String getProperty(String key) {
        Utils.checkNotNull("key", key);
        ConfigItem item = this.itemMap.get(key);
        if (item == null) {
            if (baseConfig == null) {
                throw new NoSuchPropertyException(key);
            }
            return baseConfig.getProperty(key);
        }
        return item.getValue();
    }

    public String getProperty(String key, String defaultValue) {
        Utils.checkNotNull("key", key);
        ConfigItem item = this.itemMap.get(key);
        if (item == null) {
            if (baseConfig == null) {
                return defaultValue;
            }
            return baseConfig.getProperty(key, defaultValue);
        }
        return item.getValue();
    }

    public int getIntProperty(String key) {
        return Utils.parseStringAsInt(this.getProperty(key));
    }

    public int getIntProperty(String key, int defaultValue) {
        try {
            return Utils.parseStringAsInt(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public long getLongProperty(String key) {
        return Utils.parseStringAsLong(this.getProperty(key));
    }

    public long getLongProperty(String key, long defaultValue) {
        try {
            return Utils.parseStringAsLong(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public float getFloatProperty(String key) {
        return Utils.parseStringAsFloat(this.getProperty(key));
    }

    public float getFloatProperty(String key, float defaultValue) {
        try {
            return Utils.parseStringAsFloat(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public double getDoubleProperty(String key) {
        return Utils.parseStringAsDouble(this.getProperty(key));
    }

    public double getDoubleProperty(String key, double defaultValue) {
        try {
            return Utils.parseStringAsDouble(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public String[] getStringArrayProperty(String key) {
        return Utils.parseStringAsStringArray(this.getProperty(key));
    }

    public String[] getStringArrayProperty(String key, String[] defaultValue) {
        try {
            return Utils.parseStringAsStringArray(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public int[] getIntArrayProperty(String key) {
        return Utils.parseStringAsIntArray(this.getProperty(key));
    }

    public int[] getIntArrayProperty(String key, int[] defaultValue) {
        try {
            return Utils.parseStringAsIntArray(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public long[] getLongArrayProperty(String key) {

        return Utils.parseStringAsLongArray(this.getProperty(key));
    }

    public long[] getLongArrayProperty(String key, long[] defaultValue) {
        try {
            return Utils.parseStringAsLongArray(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public float[] getFloatArrayProperty(String key) {
        return Utils.parseStringAsFloatArray(this.getProperty(key));
    }

    public float[] getFloatArrayProperty(String key, float[] defaultValue) {
        try {
            return Utils.parseStringAsFloatArray(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public double[] getDoubleArrayProperty(String key) {
        return Utils.parseStringAsDoubleArray(this.getProperty(key));
    }

    public double[] getDoubleArrayProperty(String key, double[] defaultValue) {
        try {
            return Utils.parseStringAsDoubleArray(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public List<String> getStringListProperty(String key) {
        return Utils.parseStringAsStringList(this.getProperty(key));
    }

    public List<String> getStringListProperty(String key, List<String> defaultValue) {
        try {
            return Utils.parseStringAsStringList(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public List<Integer> getIntegerListProperty(String key) {

        return Utils.parseStringAsIntegerList(this.getProperty(key));
    }

    public List<Integer> getIntegerListProperty(String key, List<Integer> defaultValue) {
        try {
            return Utils.parseStringAsIntegerList(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public List<Long> getLongListProperty(String key) {
        return Utils.parseStringAsLongList(this.getProperty(key));
    }

    public List<Long> getLongListProperty(String key, List<Long> defaultValue) {
        try {
            return Utils.parseStringAsLongList(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public List<Float> getFloatListProperty(String key) {
        return Utils.parseStringAsFloatList(this.getProperty(key));
    }

    public List<Float> getFloatListProperty(String key, List<Float> defaultValue) {
        try {
            return Utils.parseStringAsFloatList(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public List<Double> getDoubleListProperty(String key) {
        return Utils.parseStringAsDoubleList(this.getProperty(key));
    }

    public List<Double> getDoubleListProperty(String key, List<Double> defaultValue) {
        try {
            return Utils.parseStringAsDoubleList(this.getProperty(key));
        } catch (NoSuchPropertyException e) {
            return defaultValue;
        }
    }

    public Set<String> getKeySet() {
        if (this.baseConfig == null) {
            return new HashSet<String>(this.itemMap.keySet());
        }
        Set<String> keySet = this.baseConfig.getKeySet();
        keySet.addAll(this.itemMap.keySet());
        return keySet;
    }

    public Config getBaseConfig() {
        return baseConfig;
    }

    public String getName() {
        return name;
    }

    public Map<String, ConfigItem> getItemMap() {
        if (this.baseConfig == null) {
            return new HashMap<String, ConfigItem>(this.itemMap);
        }
        Map<String, ConfigItem> itemMap = this.baseConfig.getItemMap();
        itemMap.putAll(this.itemMap);
        return itemMap;
    }

    public void reload() {
        if (baseConfig != null) {
            baseConfig.reload();
        }
        doReload();
    }

    public Config clone() {
        try {
            AbstractConfig newConfig = (AbstractConfig) super.clone();
            if (baseConfig != null) {
                newConfig.baseConfig = baseConfig.clone(); // base config MUST be cloned after self clone
            }
            return newConfig;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract void doReload();

    protected void doReloadFromMap(Map<String, String> valueMap) {
        Map<String, ConfigItem> oldItemMap = itemMap;
        Map<String, ConfigItem> newItemMap = new HashMap<String, ConfigItem>();
        boolean valueChanged = false;
        for (Map.Entry<String, String> entry : valueMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            ConfigItem item = oldItemMap.get(key);
            if (item == null || !item.getValue().equals(value)) {
                newItemMap.put(key, new ConfigItem(key, value, name, new Date()));
                valueChanged = true;
            } else {
                newItemMap.put(key, item);
            }
        }
        if (valueChanged || newItemMap.size() != oldItemMap.size()) {
            itemMap = newItemMap;
        }
    }

    protected void doReloadFromProperties(Properties properties) {
        Map<String, ConfigItem> oldItemMap = itemMap;
        Map<String, ConfigItem> newItemMap = new HashMap<String, ConfigItem>();
        boolean valueChanged = false;
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            ConfigItem item = oldItemMap.get(key);
            if (item == null || !item.getValue().equals(value)) {
                newItemMap.put(key, new ConfigItem(key, value, name, new Date()));
                valueChanged = true;
            } else {
                newItemMap.put(key, item);
            }
        }
        if (valueChanged || newItemMap.size() != oldItemMap.size()) {
            itemMap = newItemMap;
        }
    }
}