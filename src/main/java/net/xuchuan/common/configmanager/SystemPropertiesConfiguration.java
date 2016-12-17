package net.xuchuan.common.configmanager;

public class SystemPropertiesConfiguration extends AbstractConfiguration {
    public SystemPropertiesConfiguration() {
        this(null);
    }

    public SystemPropertiesConfiguration(Configuration baseConfig) {
        super("System properties", baseConfig);
    }

    protected void doReload() {
        doReloadFromProperties(System.getProperties());
    }
}