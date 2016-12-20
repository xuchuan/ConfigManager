package net.xuchuan.common.gaiaconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileConfig extends AbstractConfig {
    private File configFile;

    public PropertyFileConfig(File configFile) {
        this(configFile, null);
    }

    public PropertyFileConfig(File configFile, Config baseConfig) {
        super(configFile.getPath() + File.separator + configFile.getName(), baseConfig);
        Utils.checkNotNull("configFile", configFile);
        this.configFile = configFile;
        doReload();
    }

    protected void doReload() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(configFile));
        } catch (IOException e) {
            throw new RuntimeException("Fail to load from " + name, e);
        }
        doReloadFromProperties(properties);
    }
}
