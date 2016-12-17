package net.xuchuan.common.configmanager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws Exception {
        // Read from system properties
        Configuration config = new SystemPropertiesConfiguration();

        // Read from system environments
        config = new SystemEnvironmentConfiguration();

        // Read from property file
        config = new PropertyFileConfiguration(new File("conf.prop"));

        // Read from memory
        Map<String, String> map = new HashMap<String, String>();
        map.put("prop1", "value1");
        map.put("prop2", "value2");
        config = new MapConfiguration("memory", map);

        // Read from memory with a MapConfigurationBuilder
        config = new MapConfigurationBuilder("memory")
                .setIntProperty("intProp", 1234)
                .setProperty("prop1", "value1")
                .setIntArrayProperty("int[]", new int[]{1, 2, 3, 4})
                .build();

        // A typical composite configuration
        config = new MapConfiguration("hotfix", map,
                new PropertyFileConfiguration(new File("conf.prop"),
                        new SystemPropertiesConfiguration(
                                new SystemEnvironmentConfiguration())));

        // Reload the configuration when something has changed
        config.reload();

        // Read properties
        String prop = config.getProperty("prop1");
        int intProp = config.getIntProperty("intProp");
        intProp = config.getIntProperty("intProp", 100); // default value

        // Get a snapshot first so that all configuration properties are consistent
        config = config.clone();
        prop = config.getProperty("prop1");
        intProp = config.getIntProperty("intProp");
    }
}
