package net.xuchuan.common.configmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileConfiguration extends AbstractConfiguration {
    private File configFile;

    public PropertyFileConfiguration(File configFile) {
        this(null, configFile);
    }

    public PropertyFileConfiguration(Configuration baseConfig, File configFile) {
        super(baseConfig, configFile.getPath() + File.separator + configFile.getName());
        Utils.checkNotNull("configFile", configFile);
        this.configFile = configFile;
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
