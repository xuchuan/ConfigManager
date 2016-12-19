package net.xuchuan.common.configmanager;

import java.util.HashMap;
import java.util.Map;

public class MapConfiguration extends AbstractConfiguration {
    private Map<String, String> valueMap;

    public MapConfiguration(String name) {
        this(name, new HashMap<String, String>(), null);
    }

    public MapConfiguration(String name, Map<String, String> valueMap) {
        this(name, valueMap, null);
    }

    public MapConfiguration(String name, Configuration baseConfig) {
        this(name, new HashMap<String, String>(), baseConfig);
    }

    public MapConfiguration(String name, Map<String, String> valueMap, Configuration baseConfig) {
        super(name, baseConfig);
        Utils.checkNotNull("valueMap", valueMap);
        this.valueMap = valueMap;
        doReload();
    }

    protected void doReload() {
        doReloadFromMap(valueMap);
    }

    public Map<String, String> getValueMap() {
        return valueMap;
    }
}