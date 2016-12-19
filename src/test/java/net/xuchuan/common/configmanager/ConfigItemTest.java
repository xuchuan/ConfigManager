package net.xuchuan.common.configmanager;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ConfigItemTest {
    @Test
    public void testConstructor() {
        Date now = new Date();
        ConfigItem configItem = new ConfigItem("k", "v", "s", now);
        Assert.assertEquals("k", configItem.getKey());
        Assert.assertEquals("v", configItem.getValue());
        Assert.assertEquals("s", configItem.getSource());
        Assert.assertEquals(now, configItem.getLastUpdateTime());
    }

    @Test
    public void testConstructor_LeadingAndTrailingSpaces() {
        ConfigItem configItem = new ConfigItem(" \t\r\nk \t\r\n", " \t\r\nv \t\r\n", " \t\r\ns \t\r\n", new Date());
        Assert.assertEquals("k", configItem.getKey());
        Assert.assertEquals("v", configItem.getValue());
        Assert.assertEquals("s", configItem.getSource());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_NullKey() {
        new ConfigItem(null, "v", "s", new Date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_EmptyKey() {
        new ConfigItem("", "v", "s", new Date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_WhiteSpaceKey() {
        new ConfigItem(" \t\r\n", "v", "s", new Date());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_NullValue() {
        new ConfigItem(null, "v", "s", new Date());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_NullSource() {
        new ConfigItem("k", "v", null, new Date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_EmptySource() {
        new ConfigItem("k", "v", "", new Date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_WhiteSpaceSource() {
        new ConfigItem("k", "v", " \t\r\n", new Date());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_NullDate() {
        new ConfigItem("k", "v", "s", null);
    }
}
