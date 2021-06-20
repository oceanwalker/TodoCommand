import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextUtilTest {
    private static final String TEST_PATH = "test.txt";

    /**
     * 运行前先清空文件内容
     */
    @Before
    public void removeContent() {
        TextUtil.remove(TEST_PATH);
    }

    /**
     * 清空文件内容
     */
    @Test
    public void shouldRemoveContent() {
        String expected = "";
        String actual = TextUtil.read(TEST_PATH);
        assertEquals(expected, actual);

        TextUtil.appendLine(TEST_PATH, "<item1>");
        expected = "<item1>";
        actual = TextUtil.read(TEST_PATH);
        assertEquals(expected, actual);

        TextUtil.remove(TEST_PATH);
        expected = "";
        actual = TextUtil.read(TEST_PATH);
        assertEquals(expected, actual);
    }

    /**
     * 读取文本内容到字符串
     */
    @Test
    public void shouldReadContext() {
        String expected = "<item1>\n<item2>";
        TextUtil.appendLine(TEST_PATH, "<item1>");
        TextUtil.appendLine(TEST_PATH, "<item2>");
        String actual = TextUtil.read(TEST_PATH);
        assertEquals(expected, actual);
    }

    /**
     * 读取文件内容到列表
     */
    @Test
    public void shouldReadContextToList() {
        TextUtil.appendLine(TEST_PATH, "<item1>");
        TextUtil.appendLine(TEST_PATH, "<item2>");
        assertEquals(2, TextUtil.readAsList(TEST_PATH).size());
    }

    /**
     * 追加一行
     */
    @Test
    public void shouldAppendLine() {
        String expected = "";
        String actual = TextUtil.read(TEST_PATH);
        assertEquals(expected, actual);
        TextUtil.appendLine(TEST_PATH, "<item1>");
        expected = "<item1>";
        actual = TextUtil.read(TEST_PATH);
        assertEquals(expected, actual);
        TextUtil.appendLine(TEST_PATH, "<item2>");
        expected = "<item1>\n<item2>";
        actual = TextUtil.read(TEST_PATH);
        assertEquals(expected, actual);
    }

    /**
     * 覆写文件
     */
    @Test
    public void shouldCoverFile() {
        String expected = "test";
        TextUtil.cover(TEST_PATH, "test");
        String actual = TextUtil.read(TEST_PATH);
        assertEquals(expected, actual);
    }
}