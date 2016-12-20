package net.xuchuan.common.gaiaconfig;

public class SystemEnvConfig extends AbstractConfig {
    public SystemEnvConfig() {
        this(null);
    }

    public SystemEnvConfig(Config baseConfig) {
        super("System Environment", baseConfig);
        doReload();
    }

    protected void doReload() {
        doReloadFromMap(System.getenv());
    }
}