package net.xuchuan.common.configmanager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapConfigurationTest {
    private MapConfiguration configuration;
    private Map<String, String> valueMap;
    private Configuration baseConfig;

    @Before
    public void setUp() {
        valueMap = new HashMap<String, String>();
        baseConfig = new MapConfiguration("base");
        configuration = new MapConfiguration("test", valueMap, baseConfig);
    }

    @Test
    public void testConstructorString() {
        configuration = new MapConfiguration("test");
        Assert.assertEquals("test", configuration.getName());
        Assert.assertNotNull(configuration.getValueMap());
        Assert.assertTrue(configuration.getValueMap().isEmpty());
        Assert.assertNull(configuration.getBaseConfig());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorStringMap() {
        new MapConfiguration("test", (Map<String, String>) null);
    }

    @Test
    public void testConstructorStringMap_NullValueMap() {
        configuration = new MapConfiguration("test", valueMap);
        Assert.assertEquals("test", configuration.getName());
        Assert.assertSame(valueMap, configuration.getValueMap());
        Assert.assertNull(configuration.getBaseConfig());
    }

    @Test
    public void testConstructorStringConfiguration() {
        configuration = new MapConfiguration("test", baseConfig);
        Assert.assertEquals("test", configuration.getName());
        Assert.assertNotNull(configuration.getValueMap());
        Assert.assertTrue(configuration.getValueMap().isEmpty());
        Assert.assertSame(baseConfig, configuration.getBaseConfig());
    }

    @Test
    public void testConstructorStringMapConfiguration() {
        Assert.assertEquals("test", configuration.getName());
        Assert.assertSame(valueMap, configuration.getValueMap());
        Assert.assertSame(baseConfig, configuration.getBaseConfig());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorStringMapConfiguration_NullValueMap() {
        new MapConfiguration("test", null, baseConfig);
    }

    @Test
    public void testConstructorStringMapConfiguration_ReloadInConstructor() {
        valueMap.put("k", "v");
        configuration = new MapConfiguration("test", valueMap, baseConfig);
        Assert.assertEquals("v", configuration.getProperty("k"));
    }

    @Test
    public void testReload() {
        valueMap.put("k", "v");
        configuration.reload();
        Assert.assertEquals("v", configuration.getProperty("k"));
    }
}
