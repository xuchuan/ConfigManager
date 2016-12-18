package net.xuchuan.common.configmanager;

public class SystemEnvironmentConfiguration extends AbstractConfiguration {
    public SystemEnvironmentConfiguration() {
        this(null);
    }

    public SystemEnvironmentConfiguration(Configuration baseConfig) {
        super("System Environment", baseConfig);
        doReload();
    }

    protected void doReload() {
        doReloadFromMap(System.getenv());
    }
}