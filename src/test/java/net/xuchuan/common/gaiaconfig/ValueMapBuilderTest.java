package net.xuchuan.common.gaiaconfig;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValueMapBuilderTest {
    private ValueMapBuilder valueMapBuilder;

    @Before
    public void setUp() {
        valueMapBuilder = new ValueMapBuilder();
    }

    @Test
    public void testDefaultConstructor() {
        Assert.assertNotNull(valueMapBuilder.getValueMap());
        Assert.assertTrue(valueMapBuilder.getValueMap().isEmpty());
    }

    @Test
    public void testConstructorMap() {
        Map<String, String> valueMap = new HashMap<String, String>();
        valueMapBuilder = new ValueMapBuilder(valueMap);
        Assert.assertSame(valueMap, valueMapBuilder.getValueMap());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorMap_NullMap() {
        new ValueMapBuilder(null);
    }

    @Test
    public void testSetProperty() {
        valueMapBuilder.setProperty("k", "v");
        Assert.assertEquals("v", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetProperty_Trim() {
        valueMapBuilder.setProperty(" \t\r\nk \t\r\n", " \t\r\nv \t\r\n");
        Assert.assertEquals("v", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetProperty_NullKey() {
        valueMapBuilder.setProperty(null, "v");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetProperty_EmptyKey() {
        valueMapBuilder.setProperty("", "v");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetProperty_WhiteSpaceKey() {
        valueMapBuilder.setProperty(" \t\r\n", "v");
    }

    @Test(expected = NullPointerException.class)
    public void testSetProperty_NullValue() {
        valueMapBuilder.setProperty("k", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetProperty_EmptyValue() {
        valueMapBuilder.setProperty("k", "");
        Assert.assertEquals("", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetProperty_WhiteSpaceValue() {
        valueMapBuilder.setProperty("k", " \t\r\n");
        Assert.assertEquals("", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetIntProperty() {
        valueMapBuilder.setIntProperty("k", 1234);
        Assert.assertEquals("1234", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetIntProperty_TrimKey() {
        valueMapBuilder.setIntProperty(" \t\r\nk \t\r\n", 1234);
        Assert.assertEquals("1234", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetIntProperty_NullKey() {
        valueMapBuilder.setIntProperty(null, 1234);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIntProperty_EmptyKey() {
        valueMapBuilder.setIntProperty("", 1234);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIntProperty_WhiteSpaceKey() {
        valueMapBuilder.setIntProperty(" \t\r\n", 1234);
    }

    @Test
    public void testSetLongProperty() {
        valueMapBuilder.setLongProperty("k", 12345678900L);
        Assert.assertEquals("12345678900", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetLongProperty_TrimKey() {
        valueMapBuilder.setLongProperty(" \t\r\nk \t\r\n", 12345678900L);
        Assert.assertEquals("12345678900", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetLongProperty_NullKey() {
        valueMapBuilder.setLongProperty(null, 12345678900L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLongProperty_EmptyKey() {
        valueMapBuilder.setLongProperty("", 12345678900L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLongProperty_WhiteSpaceKey() {
        valueMapBuilder.setLongProperty(" \t\r\n", 12345678900L);
    }

    @Test
    public void testSetFloatProperty() {
        valueMapBuilder.setFloatProperty("k", 0.1f);
        Assert.assertEquals("0.1", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetFloatProperty_TrimKey() {
        valueMapBuilder.setFloatProperty(" \t\r\nk \t\r\n", 0.1f);
        Assert.assertEquals("0.1", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetFloatProperty_NullKey() {
        valueMapBuilder.setFloatProperty(null, 0.1f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFloatProperty_EmptyKey() {
        valueMapBuilder.setFloatProperty("", 0.1f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFloatProperty_WhiteSpaceKey() {
        valueMapBuilder.setFloatProperty(" \t\r\n", 0.1f);
    }

    @Test
    public void testSetDoubleProperty() {
        valueMapBuilder.setDoubleProperty("k", 0.1);
        Assert.assertEquals("0.1", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetDoubleProperty_TrimKey() {
        valueMapBuilder.setDoubleProperty(" \t\r\nk \t\r\n", 0.1);
        Assert.assertEquals("0.1", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetDoubleProperty_NullKey() {
        valueMapBuilder.setDoubleProperty(null, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDoubleProperty_EmptyKey() {
        valueMapBuilder.setDoubleProperty("", 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDoubleProperty_WhiteSpaceKey() {
        valueMapBuilder.setDoubleProperty(" \t\r\n", 0.1);
    }

    @Test
    public void testSetStringArrayProperty() {
        valueMapBuilder.setStringArrayProperty("k", new String[]{"a0", "b1", "c2"});
        Assert.assertEquals("a0,b1,c2", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetStringArrayProperty_TrimKey() {
        valueMapBuilder.setStringArrayProperty(" \t\r\nk \t\r\n", new String[]{"a0", "b1", "c2"});
        Assert.assertEquals("a0,b1,c2", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetStringArrayProperty_NullKey() {
        valueMapBuilder.setStringArrayProperty(null, new String[]{"a0", "b1", "c2"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetStringArrayProperty_EmptyKey() {
        valueMapBuilder.setStringArrayProperty("", new String[]{"a0", "b1", "c2"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetStringArrayProperty_WhiteSpaceKey() {
        valueMapBuilder.setStringArrayProperty(" \t\r\n", new String[]{"a0", "b1", "c2"});
    }

    @Test
    public void testSetIntArrayProperty() {
        valueMapBuilder.setIntArrayProperty("k", new int[]{0, 1, 2, 3, 4});
        Assert.assertEquals("0,1,2,3,4", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetIntArrayProperty_TrimKey() {
        valueMapBuilder.setIntArrayProperty(" \t\r\nk \t\r\n", new int[]{0, 1, 2, 3, 4});
        Assert.assertEquals("0,1,2,3,4", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetIntArrayProperty_NullKey() {
        valueMapBuilder.setIntArrayProperty(null, new int[]{0, 1, 2, 3, 4});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIntArrayProperty_EmptyKey() {
        valueMapBuilder.setIntArrayProperty("", new int[]{0, 1, 2, 3, 4});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIntArrayProperty_WhiteSpaceKey() {
        valueMapBuilder.setIntArrayProperty(" \t\r\n", new int[]{0, 1, 2, 3, 4});
    }

    @Test
    public void testSetLongArrayProperty() {
        valueMapBuilder.setLongArrayProperty("k", new long[]{0, 1, 2, 3, 4, 12345678900L});
        Assert.assertEquals("0,1,2,3,4,12345678900", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetLongArrayProperty_TrimKey() {
        valueMapBuilder.setLongArrayProperty(" \t\r\nk \t\r\n", new long[]{0, 1, 2, 3, 4, 12345678900L});
        Assert.assertEquals("0,1,2,3,4,12345678900", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetLongArrayProperty_NullKey() {
        valueMapBuilder.setLongArrayProperty(null, new long[]{0, 1, 2, 3, 4, 12345678900L});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLongArrayProperty_EmptyKey() {
        valueMapBuilder.setLongArrayProperty("", new long[]{0, 1, 2, 3, 4, 12345678900L});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLongArrayProperty_WhiteSpaceKey() {
        valueMapBuilder.setLongArrayProperty(" \t\r\n", new long[]{0, 1, 2, 3, 4, 12345678900L});
    }

    @Test
    public void testSetFloatArrayProperty() {
        valueMapBuilder.setFloatArrayProperty("k", new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f});
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetFloatArrayProperty_TrimKey() {
        valueMapBuilder.setFloatArrayProperty(" \t\r\nk \t\r\n", new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f});
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetFloatArrayProperty_NullKey() {
        valueMapBuilder.setFloatArrayProperty(null, new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFloatArrayProperty_EmptyKey() {
        valueMapBuilder.setFloatArrayProperty("", new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFloatArrayProperty_WhiteSpaceKey() {
        valueMapBuilder.setFloatArrayProperty(" \t\r\n", new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f});
    }

    @Test
    public void testSetDoubleArrayProperty() {
        valueMapBuilder.setDoubleArrayProperty("k", new double[]{0.1, 1.2, 2.3, 3.4, 4.5});
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetDoubleArrayProperty_TrimKey() {
        valueMapBuilder.setDoubleArrayProperty(" \t\r\nk \t\r\n", new double[]{0.1, 1.2, 2.3, 3.4, 4.5});
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetDoubleArrayProperty_NullKey() {
        valueMapBuilder.setDoubleArrayProperty(null, new double[]{0.1, 1.2, 2.3, 3.4, 4.5});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDoubleArrayProperty_EmptyKey() {
        valueMapBuilder.setDoubleArrayProperty("", new double[]{0.1, 1.2, 2.3, 3.4, 4.5});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDoubleArrayProperty_WhiteSpaceKey() {
        valueMapBuilder.setDoubleArrayProperty(" \t\r\n", new double[]{0.1, 1.2, 2.3, 3.4, 4.5});
    }

    @Test
    public void testSetStringListProperty() {
        valueMapBuilder.setStringListProperty("k", Arrays.asList("a0", "b1", "c2"));
        Assert.assertEquals("a0,b1,c2", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetStringListProperty_TrimKey() {
        valueMapBuilder.setStringListProperty(" \t\r\nk \t\r\n", Arrays.asList("a0", "b1", "c2"));
        Assert.assertEquals("a0,b1,c2", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetStringListProperty_NullKey() {
        valueMapBuilder.setStringListProperty(null, Arrays.asList("a0", "b1", "c2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetStringListProperty_EmptyKey() {
        valueMapBuilder.setStringListProperty("", Arrays.asList("a0", "b1", "c2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetStringListProperty_WhiteSpaceKey() {
        valueMapBuilder.setStringListProperty(" \t\r\n", Arrays.asList("a0", "b1", "c2"));
    }

    @Test
    public void testSetIntListProperty() {
        valueMapBuilder.setIntegerListProperty("k", Arrays.asList(0, 1, 2, 3, 4));
        Assert.assertEquals("0,1,2,3,4", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetIntListProperty_TrimKey() {
        valueMapBuilder.setIntegerListProperty(" \t\r\nk \t\r\n", Arrays.asList(0, 1, 2, 3, 4));
        Assert.assertEquals("0,1,2,3,4", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetIntListProperty_NullKey() {
        valueMapBuilder.setIntegerListProperty(null, Arrays.asList(0, 1, 2, 3, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIntListProperty_EmptyKey() {
        valueMapBuilder.setIntegerListProperty("", Arrays.asList(0, 1, 2, 3, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIntListProperty_WhiteSpaceKey() {
        valueMapBuilder.setIntegerListProperty(" \t\r\n", Arrays.asList(0, 1, 2, 3, 4));
    }

    @Test
    public void testSetLongListProperty() {
        valueMapBuilder.setLongListProperty("k", Arrays.asList(0L, 1L, 2L, 3L, 4L, 12345678900L));
        Assert.assertEquals("0,1,2,3,4,12345678900", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetLongListProperty_TrimKey() {
        valueMapBuilder
                .setLongListProperty(" \t\r\nk \t\r\n", Arrays.asList(0L, 1L, 2L, 3L, 4L, 12345678900L));
        Assert.assertEquals("0,1,2,3,4,12345678900", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetLongListProperty_NullKey() {
        valueMapBuilder.setLongListProperty(null, Arrays.asList(0L, 1L, 2L, 3L, 4L, 12345678900L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLongListProperty_EmptyKey() {
        valueMapBuilder.setLongListProperty("", Arrays.asList(0L, 1L, 2L, 3L, 4L, 12345678900L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLongListProperty_WhiteSpaceKey() {
        valueMapBuilder.setLongListProperty(" \t\r\n", Arrays.asList(0L, 1L, 2L, 3L, 4L, 12345678900L));
    }

    @Test
    public void testSetFloatListProperty() {
        valueMapBuilder.setFloatListProperty("k", Arrays.asList(0.1f, 1.2f, 2.3f, 3.4f, 4.5f));
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetFloatListProperty_TrimKey() {
        valueMapBuilder
                .setFloatListProperty(" \t\r\nk \t\r\n", Arrays.asList(0.1f, 1.2f, 2.3f, 3.4f, 4.5f));
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetFloatListProperty_NullKey() {
        valueMapBuilder.setFloatListProperty(null, Arrays.asList(0.1f, 1.2f, 2.3f, 3.4f, 4.5f));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFloatListProperty_EmptyKey() {
        valueMapBuilder.setFloatListProperty("", Arrays.asList(0.1f, 1.2f, 2.3f, 3.4f, 4.5f));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFloatListProperty_WhiteSpaceKey() {
        valueMapBuilder.setFloatListProperty(" \t\r\n", Arrays.asList(0.1f, 1.2f, 2.3f, 3.4f, 4.5f));
    }

    @Test
    public void testSetDoubleListProperty() {
        valueMapBuilder.setDoubleListProperty("k", Arrays.asList(0.1, 1.2, 2.3, 3.4, 4.5));
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testSetDoubleListProperty_TrimKey() {
        valueMapBuilder.setDoubleListProperty(" \t\r\nk \t\r\n", Arrays.asList(0.1, 1.2, 2.3, 3.4, 4.5));
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMapBuilder.getValueMap().get("k"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetDoubleListProperty_NullKey() {
        valueMapBuilder.setDoubleListProperty(null, Arrays.asList(0.1, 1.2, 2.3, 3.4, 4.5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDoubleListProperty_EmptyKey() {
        valueMapBuilder.setDoubleListProperty("", Arrays.asList(0.1, 1.2, 2.3, 3.4, 4.5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDoubleListProperty_WhiteSpaceKey() {
        valueMapBuilder.setDoubleListProperty(" \t\r\n", Arrays.asList(0.1, 1.2, 2.3, 3.4, 4.5));
    }

    @Test
    public void testRemoveProperty() {
        valueMapBuilder.setProperty("k", "v");
        Assert.assertEquals("v", valueMapBuilder.getValueMap().get("k"));
        valueMapBuilder.removeProperty("k");
        Assert.assertNull(valueMapBuilder.getValueMap().get("k"));
    }

    @Test
    public void testRemoveProperty_RemoveFromEmptyMap() {
        valueMapBuilder.removeProperty("k");
    }

    @Test
    public void testClear() {
        for (int i = 0; i < 100; ++i) {
            valueMapBuilder.setIntProperty("k" + i, i);
        }
        Assert.assertEquals(100, valueMapBuilder.getValueMap().size());
        valueMapBuilder.clear();
        Assert.assertEquals(0, valueMapBuilder.getValueMap().size());
    }

    @Test
    public void testFluent() {
        Map<String, String> valueMap = valueMapBuilder
                .setProperty("kk", "vv")
                .clear()
                .setProperty("test", "test")
                .setProperty("k", "v")
                .setIntProperty("int", 1234)
                .setLongProperty("long", 12345678900L)
                .setFloatProperty("float", 0.1f)
                .setDoubleProperty("double", 0.1)
                .setStringArrayProperty("String[]", new String[]{"a0", "b1", "c2"})
                .setIntArrayProperty("int[]", new int[]{0, 1, 2, 3, 4})
                .setLongArrayProperty("long[]", new long[]{0, 1, 2, 3, 4, 12345678900L})
                .setFloatArrayProperty("float[]", new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f})
                .setDoubleArrayProperty("double[]", new double[]{0.1, 1.2, 2.3, 3.4, 4.5})
                .setStringListProperty("List<String>", Arrays.asList("a0", "b1", "c2"))
                .setIntegerListProperty("List<Integer>", Arrays.asList(0, 1, 2, 3, 4))
                .setLongListProperty("List<Long>", Arrays.asList(0L, 1L, 2L, 3L, 4L, 12345678900L))
                .setFloatListProperty("List<Float>", Arrays.asList(0.1f, 1.2f, 2.3f, 3.4f, 4.5f))
                .setDoubleListProperty("List<Double>", Arrays.asList(0.1, 1.2, 2.3, 3.4, 4.5))
                .removeProperty("test")
                .getValueMap();
        Assert.assertNull(valueMap.get("test"));
        Assert.assertNull(valueMap.get("kk"));
        Assert.assertEquals("v", valueMap.get("k"));
        Assert.assertEquals("1234", valueMap.get("int"));
        Assert.assertEquals("12345678900", valueMap.get("long"));
        Assert.assertEquals("0.1", valueMap.get("float"));
        Assert.assertEquals("0.1", valueMap.get("double"));
        Assert.assertEquals("a0,b1,c2", valueMap.get("String[]"));
        Assert.assertEquals("0,1,2,3,4", valueMap.get("int[]"));
        Assert.assertEquals("0,1,2,3,4,12345678900", valueMap.get("long[]"));
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMap.get("float[]"));
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMap.get("double[]"));
        Assert.assertEquals("a0,b1,c2", valueMap.get("List<String>"));
        Assert.assertEquals("0,1,2,3,4", valueMap.get("List<Integer>"));
        Assert.assertEquals("0,1,2,3,4,12345678900", valueMap.get("List<Long>"));
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMap.get("List<Float>"));
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5", valueMap.get("List<Double>"));
    }
}
