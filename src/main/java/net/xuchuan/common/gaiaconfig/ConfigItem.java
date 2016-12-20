package net.xuchuan.common.gaiaconfig;

import java.util.Date;

public class ConfigItem {
    private String key;
    private String value;
    private String source;
    private Date lastUpdateTime;

    public ConfigItem(String key, String value, String source, Date lastUpdateTime) {
        Utils.checkNotEmptyStringAfterTrim("key", key);
        Utils.checkNotNull("key", key);
        Utils.checkNotEmptyStringAfterTrim("source", source);
        Utils.checkNotNull("lastUpdateTime", lastUpdateTime);
        this.key = key.trim();
        this.value = value.trim();
        this.source = source.trim();
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