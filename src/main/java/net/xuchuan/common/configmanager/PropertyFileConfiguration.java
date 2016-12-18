package net.xuchuan.common.configmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileConfiguration extends AbstractConfiguration {
    private File configFile;

    public PropertyFileConfiguration(File configFile) {
        this(configFile, null);
    }

    public PropertyFileConfiguration(File configFile, Configuration baseConfig) {
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
