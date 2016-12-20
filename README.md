# GaiaConfig

To provide an easy-to-use and thread safe configuration interface for Java applications.

# Why not Apache Commons Configuration

Apache Commons Configuration allows concurrent accesses from multiple threads by providing some locking mechanisms. It is complicated. Typically we do not change configurations one by one. Instead, we reload the configuration as a whole. So we can have a thread-safe design. That's the purpose of this project.

# Usage

```java
        // Read from system properties
        Config config = new SystemPropertiesConfig();

        // Read properties
        String prop = config.getProperty("prop1");
        int intProp = config.getIntProperty("intProp");
        intProp = config.getIntProperty("intProp", 100); // default value

        // Read from system environments
        config = new SystemEnvironmentConfig();

        // Read from property file
        config = new PropertyFileConfig(new File("conf.prop"));

        // Read from memory
        config = new MapConfig("memory",
                new ValueMapBuilder()
                        .setProperty("prop1", "value1")
                        .setProperty("prop2", "value2")
                        .getValueMap());

        // Update with a ValueMapBuilder and reload
        new ValueMapBuilder(config.getValueMap())
                .setIntProperty("intProp", 1234)
                .setProperty("prop1", "value1")
                .setIntArrayProperty("int[]", new int[]{1, 2, 3, 4});
        config.reload();

        // A typical composite configuration
        config = new MapConfig("hotfix",
                new PropertyFileConfig(new File("conf.prop"),
                        new SystemPropertiesConfig(
                                new SystemEnvironmentConfig())));

        // Reload the configuration when something has changed
        config.reload();

        // Get a snapshot first so that properties are not updated between read operations.
        config = config.clone();
        prop = config.getProperty("prop1");
        intProp = config.getIntProperty("intProp");
```