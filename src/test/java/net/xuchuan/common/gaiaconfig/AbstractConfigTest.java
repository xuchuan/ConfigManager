package net.xuchuan.common.gaiaconfig;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractConfigTest {
    private AbstractConfig configuration;
    private Map<String, String> valueMap;
    private Map<String, String> baseMap;

    @Before
    public void setUp() {
        valueMap = new ConcurrentHashMap<String, String>();
        valueMap.put("String", "abc");
        valueMap.put("int", "1234");
        valueMap.put("long", "12345678900");
        valueMap.put("float", "0.1");
        valueMap.put("double", "0.1");
        valueMap.put("String[]", "a0,b1,c2");
        valueMap.put("int[]", "0,1,2,3,4");
        valueMap.put("long[]", "0,1,2,3,4,12345678900");
        valueMap.put("float[]", "0.1,1.2,2.3,3.4,4.5");
        valueMap.put("double[]", "0.1,1.2,2.3,3.4,4.5");
        valueMap.put("List<String>", "a0,b1,c2");
        valueMap.put("List<Integer>", "0,1,2,3,4");
        valueMap.put("List<Long>", "0,1,2,3,4,12345678900");
        valueMap.put("List<Float>", "0.1,1.2,2.3,3.4,4.5");
        valueMap.put("List<Double>", "0.1,1.2,2.3,3.4,4.5");
        baseMap = new HashMap<String, String>();
        baseMap.put("base", "baseValue");
        baseMap.put("String", "");
        configuration = new MapConfig("test", valueMap,
                new MapConfig("base", baseMap));
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals("test", configuration.getName());
        Assert.assertNotNull(configuration.getBaseConfig());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_NullName() {
        new MapConfig(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_EmptyName() {
        new MapConfig("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_WhiteSpaceName() {
        new MapConfig(" \t");
    }

    @Test
    public void testConstructor_NullBaseConfig() {
        configuration = new MapConfig("test");
        Assert.assertNull(configuration.getBaseConfig());
    }

    @Test
    public void testGetProperty() {
        Assert.assertEquals("abc", configuration.getProperty("String"));
    }

    @Test
    public void testGetProperty_FromBaseConfig() {
        Assert.assertEquals("baseValue", configuration.getProperty("base"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetProperty_NullKey() {
        configuration.getProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetProperty_InvalidKey() {
        configuration.getProperty("invalid");
    }

    @Test
    public void testGetPropertyWithDefault() {
        Assert.assertEquals("abc", configuration.getProperty("String", ""));
    }

    @Test(expected = NullPointerException.class)
    public void testGetPropertyWithDefault_NullKey() {
        configuration.getProperty(null);
    }

    @Test
    public void testGetPropertyWithDefault_InvalidKey() {
        Assert.assertEquals("", configuration.getProperty("invalid", ""));
    }

    @Test
    public void testGetIntProperty() {
        Assert.assertEquals(1234, configuration.getIntProperty("int"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntProperty_NullKey() {
        configuration.getIntProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetIntProperty_InvalidKey() {
        configuration.getIntProperty("invalid");
    }

    @Test
    public void testGetIntPropertyWithDefault() {
        Assert.assertEquals(1234, configuration.getIntProperty("int", 0));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntPropertyWithDefault_NullKey() {
        configuration.getIntProperty(null);
    }

    @Test
    public void testGetIntPropertyWithDefault_InvalidKey() {
        Assert.assertEquals(0, configuration.getIntProperty("invalid", 0));
    }

    @Test
    public void testGetLongProperty() {
        Assert.assertEquals(12345678900L, configuration.getLongProperty("long"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongProperty_NullKey() {
        configuration.getLongProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetLongProperty_InvalidKey() {
        configuration.getLongProperty("invalid");
    }

    @Test
    public void testGetLongPropertyWithDefault() {
        Assert.assertEquals(12345678900L, configuration.getLongProperty("long", 0));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongPropertyWithDefault_NullKey() {
        configuration.getLongProperty(null);
    }

    @Test
    public void testGetLongPropertyWithDefault_InvalidKey() {
        Assert.assertEquals(0, configuration.getLongProperty("invalid", 0));
    }

    @Test
    public void testGetFloatProperty() {
        Assert.assertEquals(0.1f, configuration.getFloatProperty("float"), 1e-8f);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatProperty_NullKey() {
        configuration.getFloatProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetFloatProperty_InvalidKey() {
        configuration.getFloatProperty("invalid");
    }

    @Test
    public void testGetFloatPropertyWithDefault() {
        Assert.assertEquals(0.1f, configuration.getFloatProperty("float", 0), 1e-8f);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatPropertyWithDefault_NullKey() {
        configuration.getFloatProperty(null);
    }

    @Test
    public void testGetFloatPropertyWithDefaultInvalidKey() {
        Assert.assertEquals(0, configuration.getFloatProperty("invalid", 0), 1e-8f);
    }

    @Test
    public void testGetDoubleProperty() {
        Assert.assertEquals(0.1, configuration.getDoubleProperty("double"), 1e-8);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoubleProperty_NullKey() {
        configuration.getDoubleProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetDoubleProperty_InvalidKey() {
        configuration.getDoubleProperty("invalid");
    }

    @Test
    public void testGetDoublePropertyWithDefault() {
        Assert.assertEquals(0.1, configuration.getDoubleProperty("double", 0), 1e-8);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoublePropertyWithDefault_NullKey() {
        configuration.getDoubleProperty(null);
    }

    @Test
    public void testGetDoublePropertyWithDefault_InvalidKey() {
        Assert.assertEquals(0, configuration.getDoubleProperty("invalid", 0), 1e-8);
    }

    @Test
    public void testGetStringArrayProperty() {
        Assert.assertArrayEquals(new String[]{"a0", "b1", "c2"}, configuration.getStringArrayProperty("String[]"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetStringArrayProperty_NullKey() {
        configuration.getStringArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetStringArrayProperty_InvalidKey() {
        configuration.getStringArrayProperty("invalid");
    }

    @Test
    public void testGetStringArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new String[]{"a0", "b1", "c2"},
                configuration.getStringArrayProperty("String[]", new String[0]));
    }

    @Test(expected = NullPointerException.class)
    public void testGetStringArrayPropertyWithDefault_NullKey() {
        configuration.getStringArrayProperty(null);
    }

    @Test
    public void testGetStringArrayPropertyWithDefault_InvalidKey() {
        Assert.assertArrayEquals(new String[0], configuration.getStringArrayProperty("invalid", new String[0]));
    }

    @Test
    public void testGetIntArrayProperty() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4}, configuration.getIntArrayProperty("int[]"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntArrayProperty_NullKey() {
        configuration.getIntArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetIntArrayProperty_InvalidKey() {
        configuration.getIntArrayProperty("invalid");
    }

    @Test
    public void testGetIntArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4}, configuration.getIntArrayProperty("int[]", new int[0]));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntArrayPropertyWithDefault_NullKey() {
        configuration.getIntArrayProperty(null);
    }

    @Test
    public void testGetIntArrayPropertyWithDefault_InvalidKey() {
        Assert.assertArrayEquals(new int[0], configuration.getIntArrayProperty("invalid", new int[0]));
    }

    @Test
    public void testGetLongArrayProperty() {
        Assert.assertArrayEquals(new long[]{0, 1, 2, 3, 4, 12345678900L}, configuration.getLongArrayProperty("long[]"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongArrayProperty_NullKey() {
        configuration.getLongArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetLongArrayProperty_InvalidKey() {
        configuration.getLongArrayProperty("invalid");
    }

    @Test
    public void testGetLongArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new long[]{0, 1, 2, 3, 4, 12345678900L},
                configuration.getLongArrayProperty("long[]", new long[0]));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongArrayPropertyWithDefault_NullKey() {
        configuration.getLongArrayProperty(null);
    }

    @Test
    public void testGetLongArrayPropertyWithDefault_InvalidKey() {
        Assert.assertArrayEquals(new long[0], configuration.getLongArrayProperty("invalid", new long[0]));
    }

    @Test
    public void testGetFloatArrayProperty() {
        Assert.assertArrayEquals(new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f},
                configuration.getFloatArrayProperty("float[]"), 1e-8f);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatArrayProperty_NullKey() {
        configuration.getFloatArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetFloatArrayProperty_InvalidKey() {
        configuration.getFloatArrayProperty("invalid");
    }

    @Test
    public void testGetFloatArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f},
                configuration.getFloatArrayProperty("float[]", new float[0]), 1e-8f);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatArrayPropertyWithDefault_NullKey() {
        configuration.getFloatArrayProperty(null);
    }

    @Test
    public void testGetFloatArrayPropertyWithDefault_InvalidKey() {
        Assert.assertArrayEquals(new float[0], configuration.getFloatArrayProperty("invalid", new float[0]), 1e-8f);
    }

    @Test
    public void testGetDoubleArrayProperty() {
        Assert.assertArrayEquals(new double[]{0.1, 1.2, 2.3, 3.4, 4.5},
                configuration.getDoubleArrayProperty("double[]"), 1e-8);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoubleArrayProperty_NullKey() {
        configuration.getDoubleArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetDoubleArrayProperty_InvalidKey() {
        configuration.getDoubleArrayProperty("invalid");
    }

    @Test
    public void testGetDoubleArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new double[]{0.1, 1.2, 2.3, 3.4, 4.5},
                configuration.getDoubleArrayProperty("double[]", new double[0]), 1e-8);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoubleArrayPropertyWithDefault_NullKey() {
        configuration.getDoubleArrayProperty(null);
    }

    @Test
    public void testGetDoubleArrayPropertyWithDefault_InvalidKey() {
        Assert.assertArrayEquals(new double[0], configuration.getDoubleArrayProperty("invalid", new double[0]), 1e-8);
    }

    @Test
    public void testGetStringListProperty() {
        Assert.assertEquals(Arrays.asList(new String[]{"a0", "b1", "c2"}),
                configuration.getStringListProperty("List<String>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetStringListProperty_NullKey() {
        configuration.getStringListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetStringListProperty_InvalidKey() {
        configuration.getStringListProperty("invalid");
    }

    @Test
    public void testGetStringListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new String[]{"a0", "b1", "c2"}),
                configuration.getStringListProperty("List<String>", new ArrayList<String>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetStringListPropertyWithDefault_NullKey() {
        configuration.getStringListProperty(null);
    }

    @Test
    public void testGetStringListPropertyWithDefault_InvalidKey() {
        Assert.assertEquals(new ArrayList<String>(),
                configuration.getStringListProperty("invalid", new ArrayList<String>()));
    }

    @Test
    public void testGetIntegerListProperty() {
        Assert.assertEquals(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}),
                configuration.getIntegerListProperty("List<Integer>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntegerListProperty_NullKey() {
        configuration.getIntegerListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetIntegerListProperty_InvalidKey() {
        configuration.getIntegerListProperty("invalid");
    }

    @Test
    public void testGetIntegerListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}),
                configuration.getIntegerListProperty("List<Integer>", new ArrayList<Integer>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntegerListPropertyWithDefault_NullKey() {
        configuration.getIntegerListProperty(null);
    }

    @Test
    public void testGetIntegerListPropertyWithDefault_InvalidKey() {
        Assert.assertEquals(new ArrayList<Integer>(),
                configuration.getIntegerListProperty("invalid", new ArrayList<Integer>()));
    }

    @Test
    public void testGetLongListProperty() {
        Assert.assertEquals(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 4L, 12345678900L}),
                configuration.getLongListProperty("List<Long>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongListProperty_NullKey() {
        configuration.getLongListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetLongListProperty_InvalidKey() {
        configuration.getLongListProperty("invalid");
    }

    @Test
    public void testGetLongListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 4L, 12345678900L}),
                configuration.getLongListProperty("List<Long>", new ArrayList<Long>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongListPropertyWithDefault_NullKey() {
        configuration.getLongListProperty(null);
    }

    @Test
    public void testGetLongListPropertyWithDefault_InvalidKey() {
        Assert.assertEquals(new ArrayList<Long>(), configuration.getLongListProperty("invalid", new ArrayList<Long>()));
    }

    @Test
    public void testGetFloatListProperty() {
        Assert.assertEquals(Arrays.asList(new Float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f}),
                configuration.getFloatListProperty("List<Float>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatListProperty_NullKey() {
        configuration.getFloatListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetFloatListProperty_InvalidKey() {
        configuration.getFloatListProperty("invalid");
    }

    @Test
    public void testGetFloatListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new Float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f}),
                configuration.getFloatListProperty("List<Float>", new ArrayList<Float>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatListPropertyWithDefault_NullKey() {
        configuration.getFloatListProperty(null);
    }

    @Test
    public void testGetFloatListPropertyWithDefault_InvalidKey() {
        Assert.assertEquals(new ArrayList<Float>(),
                configuration.getFloatListProperty("invalid", new ArrayList<Float>()));
    }

    @Test
    public void testGetDoubleListProperty() {
        Assert.assertEquals(Arrays.asList(new Double[]{0.1, 1.2, 2.3, 3.4, 4.5}),
                configuration.getDoubleListProperty("List<Double>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoubleListProperty_NullKey() {
        configuration.getDoubleListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetDoubleListProperty_InvalidKey() {
        configuration.getDoubleListProperty("invalid");
    }

    @Test
    public void testGetDoubleListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new Double[]{0.1, 1.2, 2.3, 3.4, 4.5}),
                configuration.getDoubleListProperty("List<Double>", new ArrayList<Double>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoubleListPropertyWithDefault_NullKey() {
        configuration.getDoubleListProperty(null);
    }

    @Test
    public void testGetDoubleListPropertyWithDefault_InvalidKey() {
        Assert.assertEquals(new ArrayList<Double>(),
                configuration.getDoubleListProperty("invalid", new ArrayList<Double>()));
    }

    @Test
    public void testGetKeySet() {
        Assert.assertThat(configuration.getKeySet(),
                Matchers.containsInAnyOrder("String", "int", "long", "float", "double", "String[]", "int[]", "long[]",
                        "float[]", "double[]", "List<String>", "List<Integer>", "List<Long>", "List<Float>",
                        "List<Double>", "base"));
    }

    @Test
    public void testGetItemMap() {
        Assert.assertThat(configuration.getItemMap().keySet(),
                Matchers.containsInAnyOrder("String", "int", "long", "float", "double", "String[]", "int[]", "long[]",
                        "float[]", "double[]", "List<String>", "List<Integer>", "List<Long>", "List<Float>",
                        "List<Double>", "base"));
    }

    @Test
    public void testReload() {
        valueMap.put("int", "0");
        valueMap.remove("String");
        configuration.reload();
        Assert.assertEquals(0, configuration.getIntProperty("int"));
        Assert.assertEquals("", configuration.getProperty("String"));
    }

    @Test
    public void testReload_MultipleThreads() throws InterruptedException {
        List<Runnable> taskList = new ArrayList<Runnable>();
        for (int i = 0; i < 1000; ++i) {
            final int index = i;
            taskList.add(new Runnable() {
                public void run() {
                    long hash = 0;
                    for (int k = 0; k < 100; ++k) {
                        for (int i = 0; i < 100; ++i) {
                            valueMap.put("key_" + i, "value_" + index);
                        }
                        configuration.reload();
                        for (int i = 0; i < 100; ++i) {
                            hash |= configuration.getProperty("key_" + i).hashCode();
                        }
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                        }
                    }
                    if (hash == 0) {
                        throw new RuntimeException("Unexpected");
                    }
                }
            });
        }
        TestUtils.assertConcurrent("reload_MultipleThreads", taskList, 10);
    }

    @Test
    public void testClone() {
        Config config = this.configuration.clone();
        valueMap.put("int", "0");
        configuration.reload();
        Assert.assertNotEquals(0, config.getIntProperty("int"));
    }
}
