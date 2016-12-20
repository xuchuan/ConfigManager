package net.xuchuan.common.gaiaconfig;

public class SystemPropertiesConfig extends AbstractConfig {
    public SystemPropertiesConfig() {
        this(null);
    }

    public SystemPropertiesConfig(Config baseConfig) {
        super("System properties", baseConfig);
        doReload();
    }

    protected void doReload() {
        doReloadFromProperties(System.getProperties());
    }
}