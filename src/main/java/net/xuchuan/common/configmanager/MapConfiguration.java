package net.xuchuan.common.configmanager;

import java.util.HashMap;
import java.util.Map;

public class MapConfiguration extends AbstractConfiguration {
    private Map<String, String> valueMap;

    public MapConfiguration(String name, Map<String, String> valueMap) {
        this(name, valueMap, null);
    }

    public MapConfiguration(String name, Map<String, String> valueMap, Configuration baseConfig) {
        super(name, baseConfig);
        this.valueMap = valueMap;
        doReload();
    }

    public MapConfigurationBuilder getBuilder() {
        Map<String, String> valueMap = new HashMap<String, String>();
        for (Map.Entry<String, ConfigItem> entry : this.itemMap.entrySet()) {
            valueMap.put(entry.getKey(), entry.getValue().getValue());
        }
        return new MapConfigurationBuilder(name, valueMap);
    }

    protected void doReload() {
        doReloadFromMap(valueMap);
    }
}
