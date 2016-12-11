package net.xuchuan.common.configmanager;

public class SystemEnvironmentConfiguration extends AbstractConfiguration {
    public SystemEnvironmentConfiguration() {
        this(null);
    }

    public SystemEnvironmentConfiguration(Configuration baseConfig) {
        super(baseConfig, "System Environment");
    }

    protected void doReload() {
        doReloadFromMap(System.getenv());
    }
}