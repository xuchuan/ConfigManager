package net.xuchuan.common.gaiaconfig;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public static void checkNotNull(String name, Object value) {
        if (value == null) {
            throw new NullPointerException(name + " should not be null.");
        }
    }

    public static void checkNotEmptyString(String name, String value) {
        if (value == null) {
            throw new NullPointerException(name + " should not be null.");
        }
        if (value.length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }

    public static void checkNotEmptyStringAfterTrim(String name, String value) {
        if (value == null) {
            throw new NullPointerException(name + " should not be null.");
        }
        if (value.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should contain at least one not-space character.");
        }
    }

    public static int parseStringAsInt(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }

    public static long parseStringAsLong(String s) throws NumberFormatException {
        return Long.parseLong(s);
    }

    public static float parseStringAsFloat(String s) throws NumberFormatException {
        return Float.parseFloat(s);
    }

    public static double parseStringAsDouble(String s) throws NumberFormatException {
        return Double.parseDouble(s);
    }

    public static String[] parseStringAsStringArray(String s) {
        if (s.equals("")) {
            return new String[0];
        }
        return s.split(",");
    }

    public static int[] parseStringAsIntArray(String s) throws NumberFormatException {
        String[] values = Utils.parseStringAsStringArray(s);
        int[] ret = new int[values.length];
        for (int i = 0; i < values.length; ++i) {
            ret[i] = Integer.parseInt(values[i]);
        }
        return ret;
    }

    public static long[] parseStringAsLongArray(String s) throws NumberFormatException {
        String[] values = Utils.parseStringAsStringArray(s);
        long[] ret = new long[values.length];
        for (int i = 0; i < values.length; ++i) {
            ret[i] = Long.parseLong(values[i]);
        }
        return ret;
    }

    public static float[] parseStringAsFloatArray(String s) throws NumberFormatException {
        String[] values = Utils.parseStringAsStringArray(s);
        float[] ret = new float[values.length];
        for (int i = 0; i < values.length; ++i) {
            ret[i] = Float.parseFloat(values[i]);
        }
        return ret;
    }

    public static double[] parseStringAsDoubleArray(String s) throws NumberFormatException {
        String[] values = Utils.parseStringAsStringArray(s);
        double[] ret = new double[values.length];
        for (int i = 0; i < values.length; ++i) {
            ret[i] = Double.parseDouble(values[i]);
        }
        return ret;
    }

    public static List<String> parseStringAsStringList(String s) {
        return Arrays.asList(Utils.parseStringAsStringArray(s));
    }

    public static List<Integer> parseStringAsIntegerList(String s) throws NumberFormatException {
        List<Integer> ret = new ArrayList<Integer>();
        for (int value : Utils.parseStringAsIntArray(s)) {
            ret.add(value);
        }
        return ret;
    }

    public static List<Long> parseStringAsLongList(String s) throws NumberFormatException {
        List<Long> ret = new ArrayList<Long>();
        for (long value : Utils.parseStringAsLongArray(s)) {
            ret.add(value);
        }
        return ret;
    }

    public static List<Float> parseStringAsFloatList(String s) throws NumberFormatException {
        List<Float> ret = new ArrayList<Float>();
        for (float value : Utils.parseStringAsFloatArray(s)) {
            ret.add(value);
        }
        return ret;
    }

    public static List<Double> parseStringAsDoubleList(String s) throws NumberFormatException {
        List<Double> ret = new ArrayList<Double>();
        for (double value : Utils.parseStringAsDoubleArray(s)) {
            ret.add(value);
        }
        return ret;
    }

    public static String convertIntToString(int value) {
        return Integer.toString(value);
    }

    public static String convertLongToString(long value) {
        return Long.toString(value);
    }

    public static String convertFloatToString(float value) {
        return Float.toString(value);
    }

    public static String convertDoubleToString(double value) {
        return Double.toString(value);
    }

    public static String convertStringArrayToString(String[] value, String separator) {
        if (value.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static String convertIntArrayToString(int[] value, String separator) {
        if (value.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static String convertLongArrayToString(long[] value, String separator) {
        if (value.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (long v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static String convertFloatArrayToString(float[] value, String separator) {
        if (value.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (float v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static String convertDoubleArrayToString(double[] value, String separator) {
        if (value.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (double v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static String convertStringCollectionToString(Collection<String> value, String separator) {
        if (value.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static String convertIntegerCollectionToString(Collection<Integer> value, String separator) {
        if (value.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static String convertLongCollectionToString(Collection<Long> value, String separator) {
        if (value.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Long v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static String convertFloatCollectionToString(Collection<Float> value, String separator) {
        if (value.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Float v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static String convertDoubleCollectionToString(Collection<Double> value, String separator) {
        if (value.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Double v : value) {
            sb.append(v);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }

    public static void listAll(ClassLoader... classLoaders) throws IOException {
        if (classLoaders.length == 0) {
            classLoaders =
                    new ClassLoader[]{Utils.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        }
        Set<URLClassLoader> classLoaderSet = new HashSet<URLClassLoader>();
        for (ClassLoader classLoader : classLoaders) {
            if (classLoader != null && classLoader instanceof URLClassLoader) {
                classLoaderSet.add((URLClassLoader) classLoader);
            }
        }
        for (URLClassLoader classLoader : classLoaderSet) {
            for (Enumeration<URL> url = classLoader.getResources("com/baidubce"); url.hasMoreElements(); ) {
                System.out.println(url.nextElement().toExternalForm());
            }
        }
    }
}
