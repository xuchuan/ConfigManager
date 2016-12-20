package net.xuchuan.common.gaiaconfig;

import java.util.HashMap;
import java.util.Map;

public class MapConfig extends AbstractConfig {
    private Map<String, String> valueMap;

    public MapConfig(String name) {
        this(name, new HashMap<String, String>(), null);
    }

    public MapConfig(String name, Map<String, String> valueMap) {
        this(name, valueMap, null);
    }

    public MapConfig(String name, Config baseConfig) {
        this(name, new HashMap<String, String>(), baseConfig);
    }

    public MapConfig(String name, Map<String, String> valueMap, Config baseConfig) {
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