package net.xuchuan.common.configmanager;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AbstractConfigurationTest {
    private AbstractConfiguration configuration;

    @Before
    public void setUp() {
        Map<String, String> valueMap = new HashMap<String, String>();
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
        this.configuration = new MapConfiguration("test", valueMap);
    }

    @Test
    public void testGetProperty() {
        Assert.assertEquals("abc", configuration.getProperty("String"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetPropertyNullKey() {
        configuration.getProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetPropertyInvalidKey() {
        configuration.getProperty("invalid");
    }

    @Test
    public void testGetPropertyWithDefault() {
        Assert.assertEquals("abc", configuration.getProperty("String", ""));
    }

    @Test(expected = NullPointerException.class)
    public void testGetPropertyWithDefaultNullKey() {
        configuration.getProperty(null);
    }

    @Test
    public void testGetPropertyWithDefaultInvalidKey() {
        Assert.assertEquals("", configuration.getProperty("invalid", ""));
    }

    @Test
    public void testGetIntProperty() {
        Assert.assertEquals(1234, configuration.getIntProperty("int"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntPropertyNullKey() {
        configuration.getIntProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetIntPropertyInvalidKey() {
        configuration.getIntProperty("invalid");
    }

    @Test
    public void testGetLongProperty() {
        Assert.assertEquals(12345678900L, configuration.getLongProperty("long"));
    }

    @Test
    public void testGetIntPropertyWithDefault() {
        Assert.assertEquals(1234, configuration.getIntProperty("int", 0));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntPropertyWithDefaultNullKey() {
        configuration.getIntProperty(null);
    }

    @Test
    public void testGetIntPropertyWithDefaultInvalidKey() {
        Assert.assertEquals(0, configuration.getIntProperty("invalid", 0));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongPropertyNullKey() {
        configuration.getLongProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetLongPropertyInvalidKey() {
        configuration.getLongProperty("invalid");
    }

    @Test
    public void testGetLongPropertyWithDefault() {
        Assert.assertEquals(12345678900L, configuration.getLongProperty("long", 0));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongPropertyWithDefaultNullKey() {
        configuration.getLongProperty(null);
    }

    @Test
    public void testGetLongPropertyWithDefaultInvalidKey() {
        Assert.assertEquals(0, configuration.getLongProperty("invalid", 0));
    }

    @Test
    public void testGetFloatProperty() {
        Assert.assertEquals(0.1f, configuration.getFloatProperty("float"), 1e-8f);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatPropertyNullKey() {
        configuration.getFloatProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetFloatPropertyInvalidKey() {
        configuration.getFloatProperty("invalid");
    }

    @Test
    public void testGetFloatPropertyWithDefault() {
        Assert.assertEquals(0.1f, configuration.getFloatProperty("float", 0), 1e-8f);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatPropertyWithDefaultNullKey() {
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
    public void testGetDoublePropertyNullKey() {
        configuration.getDoubleProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetDoublePropertyInvalidKey() {
        configuration.getDoubleProperty("invalid");
    }

    @Test
    public void testGetDoublePropertyWithDefault() {
        Assert.assertEquals(0.1, configuration.getDoubleProperty("double", 0), 1e-8);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoublePropertyWithDefaultNullKey() {
        configuration.getDoubleProperty(null);
    }

    @Test
    public void testGetDoublePropertyWithDefaultInvalidKey() {
        Assert.assertEquals(0, configuration.getDoubleProperty("invalid", 0), 1e-8);
    }

    @Test
    public void testGetStringArrayProperty() {
        Assert.assertArrayEquals(new String[]{"a0", "b1", "c2"}, configuration.getStringArrayProperty("String[]"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetStringArrayPropertyNullKey() {
        configuration.getStringArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetStringArrayPropertyInvalidKey() {
        configuration.getStringArrayProperty("invalid");
    }

    @Test
    public void testGetStringArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new String[]{"a0", "b1", "c2"},
                configuration.getStringArrayProperty("String[]", new String[0]));
    }

    @Test(expected = NullPointerException.class)
    public void testGetStringArrayPropertyWithDefaultNullKey() {
        configuration.getStringArrayProperty(null);
    }

    @Test
    public void testGetStringArrayPropertyWithDefaultInvalidKey() {
        Assert.assertArrayEquals(new String[0], configuration.getStringArrayProperty("invalid", new String[0]));
    }

    @Test
    public void testGetIntArrayProperty() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4}, configuration.getIntArrayProperty("int[]"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntArrayPropertyNullKey() {
        configuration.getIntArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetIntArrayPropertyInvalidKey() {
        configuration.getIntArrayProperty("invalid");
    }

    @Test
    public void testGetIntArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4}, configuration.getIntArrayProperty("int[]", new int[0]));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntArrayPropertyWithDefaultNullKey() {
        configuration.getIntArrayProperty(null);
    }

    @Test
    public void testGetIntArrayPropertyWithDefaultInvalidKey() {
        Assert.assertArrayEquals(new int[0], configuration.getIntArrayProperty("invalid", new int[0]));
    }

    @Test
    public void testGetLongArrayProperty() {
        Assert.assertArrayEquals(new long[]{0, 1, 2, 3, 4, 12345678900L}, configuration.getLongArrayProperty("long[]"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongArrayPropertyNullKey() {
        configuration.getLongArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetLongArrayPropertyInvalidKey() {
        configuration.getLongArrayProperty("invalid");
    }

    @Test
    public void testGetLongArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new long[]{0, 1, 2, 3, 4, 12345678900L},
                configuration.getLongArrayProperty("long[]", new long[0]));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongArrayPropertyWithDefaultNullKey() {
        configuration.getLongArrayProperty(null);
    }

    @Test
    public void testGetLongArrayPropertyWithDefaultInvalidKey() {
        Assert.assertArrayEquals(new long[0], configuration.getLongArrayProperty("invalid", new long[0]));
    }

    @Test
    public void testGetFloatArrayProperty() {
        Assert.assertArrayEquals(new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f},
                configuration.getFloatArrayProperty("float[]"), 1e-8f);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatArrayPropertyNullKey() {
        configuration.getFloatArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetFloatArrayPropertyInvalidKey() {
        configuration.getFloatArrayProperty("invalid");
    }

    @Test
    public void testGetFloatArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f},
                configuration.getFloatArrayProperty("float[]", new float[0]), 1e-8f);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatArrayPropertyWithDefaultNullKey() {
        configuration.getFloatArrayProperty(null);
    }

    @Test
    public void testGetFloatArrayPropertyWithDefaultInvalidKey() {
        Assert.assertArrayEquals(new float[0], configuration.getFloatArrayProperty("invalid", new float[0]), 1e-8f);
    }

    @Test
    public void testGetDoubleArrayProperty() {
        Assert.assertArrayEquals(new double[]{0.1, 1.2, 2.3, 3.4, 4.5},
                configuration.getDoubleArrayProperty("double[]"), 1e-8);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoubleArrayPropertyNullKey() {
        configuration.getDoubleArrayProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetDoubleArrayPropertyInvalidKey() {
        configuration.getDoubleArrayProperty("invalid");
    }

    @Test
    public void testGetDoubleArrayPropertyWithDefault() {
        Assert.assertArrayEquals(new double[]{0.1, 1.2, 2.3, 3.4, 4.5},
                configuration.getDoubleArrayProperty("double[]", new double[0]), 1e-8);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoubleArrayPropertyWithDefaultNullKey() {
        configuration.getDoubleArrayProperty(null);
    }

    @Test
    public void testGetDoubleArrayPropertyWithDefaultInvalidKey() {
        Assert.assertArrayEquals(new double[0], configuration.getDoubleArrayProperty("invalid", new double[0]), 1e-8);
    }

    @Test
    public void testGetStringListProperty() {
        Assert.assertEquals(Arrays.asList(new String[]{"a0", "b1", "c2"}),
                configuration.getStringListProperty("List<String>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetStringListPropertyNullKey() {
        configuration.getStringListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetStringListPropertyInvalidKey() {
        configuration.getStringListProperty("invalid");
    }

    @Test
    public void testGetStringListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new String[]{"a0", "b1", "c2"}),
                configuration.getStringListProperty("List<String>", new ArrayList<String>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetStringListPropertyWithDefaultNullKey() {
        configuration.getStringListProperty(null);
    }

    @Test
    public void testGetStringListPropertyWithDefaultInvalidKey() {
        Assert.assertEquals(new ArrayList<String>(),
                configuration.getStringListProperty("invalid", new ArrayList<String>()));
    }

    @Test
    public void testGetIntegerListProperty() {
        Assert.assertEquals(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}),
                configuration.getIntegerListProperty("List<Integer>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntegerListPropertyNullKey() {
        configuration.getIntegerListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetIntegerListPropertyInvalidKey() {
        configuration.getIntegerListProperty("invalid");
    }

    @Test
    public void testGetIntegerListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}),
                configuration.getIntegerListProperty("List<Integer>", new ArrayList<Integer>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntegerListPropertyWithDefaultNullKey() {
        configuration.getIntegerListProperty(null);
    }

    @Test
    public void testGetIntegerListPropertyWithDefaultInvalidKey() {
        Assert.assertEquals(new ArrayList<Integer>(),
                configuration.getIntegerListProperty("invalid", new ArrayList<Integer>()));
    }

    @Test
    public void testGetLongListProperty() {
        Assert.assertEquals(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 4L, 12345678900L}),
                configuration.getLongListProperty("List<Long>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongListPropertyNullKey() {
        configuration.getLongListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetLongListPropertyInvalidKey() {
        configuration.getLongListProperty("invalid");
    }

    @Test
    public void testGetLongListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 4L, 12345678900L}),
                configuration.getLongListProperty("List<Long>", new ArrayList<Long>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongListPropertyWithDefaultNullKey() {
        configuration.getLongListProperty(null);
    }

    @Test
    public void testGetLongListPropertyWithDefaultInvalidKey() {
        Assert.assertEquals(new ArrayList<Long>(), configuration.getLongListProperty("invalid", new ArrayList<Long>()));
    }

    @Test
    public void testGetFloatListProperty() {
        Assert.assertEquals(Arrays.asList(new Float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f}),
                configuration.getFloatListProperty("List<Float>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatListPropertyNullKey() {
        configuration.getFloatListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetFloatListPropertyInvalidKey() {
        configuration.getFloatListProperty("invalid");
    }

    @Test
    public void testGetFloatListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new Float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f}),
                configuration.getFloatListProperty("List<Float>", new ArrayList<Float>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetFloatListPropertyWithDefaultNullKey() {
        configuration.getFloatListProperty(null);
    }

    @Test
    public void testGetFloatListPropertyWithDefaultInvalidKey() {
        Assert.assertEquals(new ArrayList<Float>(),
                configuration.getFloatListProperty("invalid", new ArrayList<Float>()));
    }

    @Test
    public void testGetDoubleListProperty() {
        Assert.assertEquals(Arrays.asList(new Double[]{0.1, 1.2, 2.3, 3.4, 4.5}),
                configuration.getDoubleListProperty("List<Double>"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoubleListPropertyNullKey() {
        configuration.getDoubleListProperty(null);
    }

    @Test(expected = NoSuchPropertyException.class)
    public void testGetDoubleListPropertyInvalidKey() {
        configuration.getDoubleListProperty("invalid");
    }

    @Test
    public void testGetDoubleListPropertyWithDefault() {
        Assert.assertEquals(Arrays.asList(new Double[]{0.1, 1.2, 2.3, 3.4, 4.5}),
                configuration.getDoubleListProperty("List<Double>", new ArrayList<Double>()));
    }

    @Test(expected = NullPointerException.class)
    public void testGetDoubleListPropertyWithDefaultNullKey() {
        configuration.getDoubleListProperty(null);
    }

    @Test
    public void testGetDoubleListPropertyWithDefaultInvalidKey() {
        Assert.assertEquals(new ArrayList<Double>(),
                configuration.getDoubleListProperty("invalid", new ArrayList<Double>()));
    }

    @Test
    public void testListPropertyKeys() {
        Assert.assertThat(configuration.getKeySet(),
                Matchers.containsInAnyOrder("String", "int", "long", "float", "double", "String[]", "int[]", "long[]",
                        "float[]", "double[]", "List<String>", "List<Integer>", "List<Long>", "List<Float>",
                        "List<Double>"));
    }

    @Test
    public void testGetEntryList() {
        Assert.assertThat(configuration.getItemMap().keySet(),
                Matchers.containsInAnyOrder("String", "int", "long", "float", "double", "String[]", "int[]", "long[]",
                        "float[]", "double[]", "List<String>", "List<Integer>", "List<Long>", "List<Float>",
                        "List<Double>"));
    }
}
