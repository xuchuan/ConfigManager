# ConfigManager

To provide an easy-to-use and thread safe configuration interface for Java applications.

# Why not Apache Commons Configuration

Apache Commons Configuration allows concurrent accesses from multiple threads by providing some locking mechanisms. It is complex. Typically we do not change configurations one by one. Instead, we reload the configuration as a whole. So we can have a thread-safe design. That's the purpose of this project.

# Usage

```java
        // Read from system properties
        Configuration config = new SystemPropertiesConfiguration();

        // Read properties
        String prop = config.getProperty("prop1");
        int intProp = config.getIntProperty("intProp");
        intProp = config.getIntProperty("intProp", 100); // default value

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

        // Get a snapshot first so that properties are not updated between read operations.
        config = config.clone();
        prop = config.getProperty("prop1");
        intProp = config.getIntProperty("intProp");
```