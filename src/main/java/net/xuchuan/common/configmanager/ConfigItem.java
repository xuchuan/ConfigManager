package net.xuchuan.common.configmanager;

import java.util.Date;

public class ConfigItem {
    private String key;
    private String value;
    private String source;
    private Date lastUpdateTime;

    public ConfigItem(String key, String value, String source, Date lastUpdateTime) {
        this.key = key;
        this.value = value;
        this.source = source;
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getSource() {
        return source;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }
}