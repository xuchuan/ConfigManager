package net.xuchuan.common.gaiaconfig;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapConfigTest {
    private MapConfig configuration;
    private Map<String, String> valueMap;
    private Config baseConfig;

    @Before
    public void setUp() {
        valueMap = new HashMap<String, String>();
        baseConfig = new MapConfig("base");
        configuration = new MapConfig("test", valueMap, baseConfig);
    }

    @Test
    public void testConstructorString() {
        configuration = new MapConfig("test");
        Assert.assertEquals("test", configuration.getName());
        Assert.assertNotNull(configuration.getValueMap());
        Assert.assertTrue(configuration.getValueMap().isEmpty());
        Assert.assertNull(configuration.getBaseConfig());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorStringMap() {
        new MapConfig("test", (Map<String, String>) null);
    }

    @Test
    public void testConstructorStringMap_NullValueMap() {
        configuration = new MapConfig("test", valueMap);
        Assert.assertEquals("test", configuration.getName());
        Assert.assertSame(valueMap, configuration.getValueMap());
        Assert.assertNull(configuration.getBaseConfig());
    }

    @Test
    public void testConstructorStringConfiguration() {
        configuration = new MapConfig("test", baseConfig);
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
        new MapConfig("test", null, baseConfig);
    }

    @Test
    public void testConstructorStringMapConfiguration_ReloadInConstructor() {
        valueMap.put("k", "v");
        configuration = new MapConfig("test", valueMap, baseConfig);
        Assert.assertEquals("v", configuration.getProperty("k"));
    }

    @Test
    public void testReload() {
        valueMap.put("k", "v");
        configuration.reload();
        Assert.assertEquals("v", configuration.getProperty("k"));
    }
}
