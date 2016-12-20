package net.xuchuan.common.gaiaconfig;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class UtilsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCheck_NotNull() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("test should not be null");
        Utils.checkNotNull("test", null);
    }

    @Test
    public void testCheckNot_NotNull() {
        Utils.checkNotNull("test", "");
    }

    @Test
    public void testCheckNotEmptyString_NullValue() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("test should not be null");
        Utils.checkNotEmptyString("test", null);
    }

    @Test
    public void testCheckNotEmptyString_EmptyString() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("test should not be empty");
        Utils.checkNotEmptyString("test", "");
    }

    @Test
    public void testCheckNotEmptyString_WhiteSpace() {
        Utils.checkNotEmptyString("test", " \t\r\n");
    }

    @Test
    public void testCheckNotEmptyString_NotEmpty() {
        Utils.checkNotEmptyString("test", "test");
    }

    @Test
    public void testCheckNotEmptyStringAfterTrim_NullValue() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("test should not be null");
        Utils.checkNotEmptyStringAfterTrim("test", null);
    }

    @Test
    public void testCheckNotEmptyStringAfterTrim_EmptyString() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("test should contain");
        Utils.checkNotEmptyStringAfterTrim("test", "");
    }

    @Test
    public void testCheckNotEmptyStringAfterTrim_WhiteSpace() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("test should contain");
        Utils.checkNotEmptyStringAfterTrim("test", " \t\r\n");
    }

    @Test
    public void testCheckNotEmptyStringAfterTrim_NotEmpty() {
        Utils.checkNotEmptyStringAfterTrim("test", "test");
    }

    @Test
    public void testParseStringAsInt() {
        for (String s : new String[]{"1234", "+1", "-1"}) {
            Assert.assertEquals(Integer.parseInt(s), Utils.parseStringAsInt(s));
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsInt_Invalid() {
        Utils.parseStringAsInt("invalid");
    }

    @Test
    public void testParseStringAsLong() {
        for (String s : new String[]{"12345678900", "+1", "-1"}) {
            Assert.assertEquals(Long.parseLong(s), Utils.parseStringAsLong(s));
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsLong_Invalid() {
        Utils.parseStringAsLong("invalid");
    }

    @Test
    public void testParseStringAsFloat() {
        for (String s : new String[]{"123456789.00", "+1.0", "-1.0"}) {
            Assert.assertEquals(Float.parseFloat(s), Utils.parseStringAsFloat(s), 1e-8f);
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsFloat_Invalid() {
        Utils.parseStringAsFloat("invalid");
    }

    @Test
    public void testParseStringAsDouble() {
        for (String s : new String[]{"123456789.00", "+1.0", "-1.0"}) {
            Assert.assertEquals(Double.parseDouble(s), Utils.parseStringAsDouble(s), 1e-8);
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsDouble_Invalid() {
        Utils.parseStringAsDouble("invalid");
    }

    @Test
    public void testParseStringAsStringArray() {
        Assert.assertArrayEquals(new String[]{"a0", "b1", "c2"}, Utils.parseStringAsStringArray("a0,b1,c2"));
    }

    @Test
    public void testParseStringAsStringArray_EmptyString() {
        Assert.assertArrayEquals(new String[0], Utils.parseStringAsStringArray(""));
    }

    @Test
    public void testParseStringAsIntArray() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4}, Utils.parseStringAsIntArray("0,1,2,3,4"));
    }

    @Test
    public void testParseStringAsIntArray_EmptyString() {
        Assert.assertArrayEquals(new int[0], Utils.parseStringAsIntArray(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsIntArray_Invalid() {
        Utils.parseStringAsIntArray("0,1,2,3,4a");
    }

    @Test
    public void testParseStringAsLongArray() {
        Assert.assertArrayEquals(new long[]{0, 1, 2, 3, 4, 12345678900L},
                Utils.parseStringAsLongArray("0,1,2,3,4,12345678900"));
    }

    @Test
    public void testParseStringAsLongArray_EmptyString() {
        Assert.assertArrayEquals(new long[0], Utils.parseStringAsLongArray(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsLongArray_Invalid() {
        Utils.parseStringAsLongArray("0,1,2,3,4a");
    }

    @Test
    public void testParseStringAsFloatArray() {
        Assert.assertArrayEquals(new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f},
                Utils.parseStringAsFloatArray("0.1,1.2,2.3,3.4,4.5"), 1e-8f);
    }

    @Test
    public void testParseStringAsFloatArray_EmptyString() {
        Assert.assertArrayEquals(new float[0], Utils.parseStringAsFloatArray(""), 1e-8f);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsFloatArray_Invalid() {
        Utils.parseStringAsFloatArray("0.1,1.2,2.3,3.4,4.5a");
    }

    @Test
    public void testParseStringAsDoubleArray() {
        Assert.assertArrayEquals(new double[]{0.1, 1.2, 2.3, 3.4, 4.5},
                Utils.parseStringAsDoubleArray("0.1,1.2,2.3,3.4,4.5"), 1e-8);
    }

    @Test
    public void testParseStringAsDoubleArray_EmptyString() {
        Assert.assertArrayEquals(new double[0], Utils.parseStringAsDoubleArray(""), 1e-8);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsDoubleArray_Invalid() {
        Utils.parseStringAsDoubleArray("0.1,1.2,2.3,3.4,4.5a");
    }

    @Test
    public void testParseStringAsStringList() {
        Assert.assertEquals(Arrays.asList(new String[]{"a0", "b1", "c2"}), Utils.parseStringAsStringList("a0,b1,c2"));
    }

    @Test
    public void testParseStringAsStringList_EmptyString() {
        Assert.assertEquals(new ArrayList<String>(), Utils.parseStringAsStringList(""));
    }

    @Test
    public void testParseStringAsIntegerList() {
        Assert.assertEquals(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}), Utils.parseStringAsIntegerList("0,1,2,3,4"));
    }

    @Test
    public void testParseStringAsIntegerList_EmptyString() {
        Assert.assertEquals(new ArrayList<Integer>(), Utils.parseStringAsIntegerList(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsIntegerList_Invalid() {
        Utils.parseStringAsIntegerList("0,1,2,3,4a");
    }

    @Test
    public void testParseStringAsLongList() {
        Assert.assertEquals(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 4L, 12345678900L}),
                Utils.parseStringAsLongList("0,1,2,3,4,12345678900"));
    }

    @Test
    public void testParseStringAsLongList_EmptyString() {
        Assert.assertEquals(new ArrayList<Long>(), Utils.parseStringAsLongList(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsLongList_Invalid() {
        Utils.parseStringAsLongList("0,1,2,3,4a");
    }

    @Test
    public void testParseStringAsFloatList() {
        Assert.assertEquals(Arrays.asList(new Float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f}),
                Utils.parseStringAsFloatList("0.1,1.2,2.3,3.4,4.5"));
    }

    @Test
    public void testParseStringAsFloatList_EmptyString() {
        Assert.assertEquals(new ArrayList<Float>(), Utils.parseStringAsFloatList(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsFloatList_Invalid() {
        Utils.parseStringAsFloatList("0.1,1.2,2.3,3.4,4.5a");
    }

    @Test
    public void testParseStringAsDoubleList() {
        Assert.assertEquals(Arrays.asList(new Double[]{0.1, 1.2, 2.3, 3.4, 4.5}),
                Utils.parseStringAsDoubleList("0.1,1.2,2.3,3.4,4.5"));
    }

    @Test
    public void testParseStringAsDoubleList_EmptyString() {
        Assert.assertEquals(new ArrayList<Double>(), Utils.parseStringAsDoubleList(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringAsDoubleList_Invalid() {
        Utils.parseStringAsDoubleList("0.1,1.2,2.3,3.4,4.5a");
    }

    @Test
    public void testConvertIntToString() {
        for (int i : new int[]{1234, +1, -1}) {
            Assert.assertEquals(Integer.toString(i), Utils.convertIntToString(i));
        }
    }

    @Test
    public void testConvertLongToString() {
        for (long l : new long[]{12345678900L, +1, -1}) {
            Assert.assertEquals(Long.toString(l), Utils.convertLongToString(l));
        }
    }

    @Test
    public void testConvertFloatToString() {
        for (float f : new float[]{12345678900.0f, +1.0f, -1.0f}) {
            Assert.assertEquals(Float.toString(f), Utils.convertFloatToString(f));
        }
    }

    @Test
    public void testConvertDoubleToString() {
        for (double d : new double[]{12345678900.0, +1.0, -1.0}) {
            Assert.assertEquals(Double.toString(d), Utils.convertDoubleToString(d));
        }
    }

    @Test
    public void testConvertStringArrayToString() {
        Assert.assertEquals("a0,b1,c2", Utils.convertStringArrayToString(new String[]{"a0", "b1", "c2"}, ","));
    }

    @Test
    public void testConvertStringArrayToString_LongSeparator() {
        Assert.assertEquals("a0+++b1+++c2", Utils.convertStringArrayToString(new String[]{"a0", "b1", "c2"}, "+++"));
    }

    @Test
    public void testConvertStringArrayToString_EmptyArray() {
        Assert.assertEquals("", Utils.convertStringArrayToString(new String[]{}, ","));
    }

    @Test
    public void testConvertIntArrayToString() {
        Assert.assertEquals("0,1,2,3,4", Utils.convertIntArrayToString(new int[]{0, 1, 2, 3, 4}, ","));
    }

    @Test
    public void testConvertIntArrayToString_LongSeparator() {
        Assert.assertEquals("0+++1+++2+++3+++4", Utils.convertIntArrayToString(new int[]{0, 1, 2, 3, 4}, "+++"));
    }

    @Test
    public void testConvertIntArrayToString_EmptyArray() {
        Assert.assertEquals("", Utils.convertIntArrayToString(new int[]{}, ","));
    }

    @Test
    public void testConvertLongArrayToString() {
        Assert.assertEquals("0,1,2,3,4,12345678900",
                Utils.convertLongArrayToString(new long[]{0, 1, 2, 3, 4, 12345678900L}, ","));
    }

    @Test
    public void testConvertLongArrayToString_LongSeparator() {
        Assert.assertEquals("0+++1+++2+++3+++4+++12345678900",
                Utils.convertLongArrayToString(new long[]{0, 1, 2, 3, 4, 12345678900L}, "+++"));
    }

    @Test
    public void testConvertLongArrayToString_EmptyArray() {
        Assert.assertEquals("", Utils.convertLongArrayToString(new long[]{}, ","));
    }

    @Test
    public void testConvertFloatArrayToString() {
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5",
                Utils.convertFloatArrayToString(new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f}, ","));
    }

    @Test
    public void testConvertFloatArrayToString_LongSeparator() {
        Assert.assertEquals("0.1+++1.2+++2.3+++3.4+++4.5",
                Utils.convertFloatArrayToString(new float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f}, "+++"));
    }

    @Test
    public void testConvertFloatArrayToString_EmptyArray() {
        Assert.assertEquals("", Utils.convertFloatArrayToString(new float[]{}, ","));
    }

    @Test
    public void testConvertDoubleArrayToString() {
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5",
                Utils.convertDoubleArrayToString(new double[]{0.1, 1.2, 2.3, 3.4, 4.5}, ","));
    }

    @Test
    public void testConvertDoubleArrayToString_LongSeparator() {
        Assert.assertEquals("0.1+++1.2+++2.3+++3.4+++4.5",
                Utils.convertDoubleArrayToString(new double[]{0.1, 1.2, 2.3, 3.4, 4.5}, "+++"));
    }

    @Test
    public void testConvertDoubleArrayToString_EmptyArray() {
        Assert.assertEquals("", Utils.convertDoubleArrayToString(new double[]{}, ","));
    }

    @Test
    public void testConvertStringCollectionToString() {
        Assert.assertEquals("a0,b1,c2",
                Utils.convertStringCollectionToString(Arrays.asList(new String[]{"a0", "b1", "c2"}), ","));
    }

    @Test
    public void testConvertStringCollectionToString_LongSeparator() {
        Assert.assertEquals("a0+++b1+++c2",
                Utils.convertStringCollectionToString(Arrays.asList(new String[]{"a0", "b1", "c2"}), "+++"));
    }

    @Test
    public void testConvertStringCollectionToString_EmptyArray() {
        Assert.assertEquals("", Utils.convertStringCollectionToString(Arrays.asList(new String[]{}), ","));
    }

    @Test
    public void testConvertIntegerCollectionToString() {
        Assert.assertEquals("0,1,2,3,4",
                Utils.convertIntegerCollectionToString(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}), ","));
    }

    @Test
    public void testConvertIntegerCollectionToString_LongSeparator() {
        Assert.assertEquals("0+++1+++2+++3+++4",
                Utils.convertIntegerCollectionToString(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}), "+++"));
    }

    @Test
    public void testConvertIntegerCollectionToString_EmptyCollection() {
        Assert.assertEquals("", Utils.convertIntegerCollectionToString(Arrays.asList(new Integer[]{}), ","));
    }

    @Test
    public void testConvertLongCollectionToString() {
        Assert.assertEquals("0,1,2,3,4,12345678900",
                Utils.convertLongCollectionToString(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 4L, 12345678900L}), ","));
    }

    @Test
    public void testConvertLongCollectionToString_LongSeparator() {
        Assert.assertEquals("0+++1+++2+++3+++4+++12345678900",
                Utils.convertLongCollectionToString(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 4L, 12345678900L}),
                        "+++"));
    }

    @Test
    public void testConvertLongCollectionToString_EmptyCollection() {
        Assert.assertEquals("", Utils.convertLongCollectionToString(Arrays.asList(new Long[]{}), ","));
    }

    @Test
    public void testConvertFloatCollectionToString() {
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5",
                Utils.convertFloatCollectionToString(Arrays.asList(new Float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f}), ","));
    }

    @Test
    public void testConvertFloatCollectionToString_LongSeparator() {
        Assert.assertEquals("0.1+++1.2+++2.3+++3.4+++4.5",
                Utils.convertFloatCollectionToString(Arrays.asList(new Float[]{0.1f, 1.2f, 2.3f, 3.4f, 4.5f}), "+++"));
    }

    @Test
    public void testConvertFloatCollectionToString_EmptyCollection() {
        Assert.assertEquals("", Utils.convertFloatCollectionToString(Arrays.asList(new Float[]{}), ","));
    }

    @Test
    public void testConvertDoubleCollectionToString() {
        Assert.assertEquals("0.1,1.2,2.3,3.4,4.5",
                Utils.convertDoubleCollectionToString(Arrays.asList(new Double[]{0.1, 1.2, 2.3, 3.4, 4.5}), ","));
    }

    @Test
    public void testConvertDoubleCollectionToString_LongSeparator() {
        Assert.assertEquals("0.1+++1.2+++2.3+++3.4+++4.5",
                Utils.convertDoubleCollectionToString(Arrays.asList(new Double[]{0.1, 1.2, 2.3, 3.4, 4.5}), "+++"));
    }

    @Test
    public void testConvertDoubleCollectionToString_EmptyCollection() {
        Assert.assertEquals("", Utils.convertDoubleCollectionToString(Arrays.asList(new Double[]{}), ","));
    }

    @Test
    public void testList() throws IOException {
        Utils.listAll();
    }
}
