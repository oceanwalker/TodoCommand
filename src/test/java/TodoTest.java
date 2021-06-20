import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TodoTest {
    /**
     * 运行每个用例之前清空数据
     */
    @Before
    public void removeTodoList() {
        Todo.removeAllData();
    }

    /**
     * 添加一个Todo项
     */
    @Test
    public void shouldAddTodo() {
        String actual = Todo.add("<item>");
        validateAdd(actual);
    }

    private void validateAdd(String actual) {
        String expected = "\n\n" +
                Todo.getLastIndex() + ". <item>" +
                "\n\n" +
                "Item " + Todo.getLastIndex() + " added";
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        List<String> todoFileList = TextUtil.readAsList(Todo.TODO_LIST_PATH);
        Assert.assertEquals(1, todoFileList.size());
    }

    /**
     * 完成Todo项
     */
    @Test
    public void shouldComplete() {
        Todo.add("<item>");
        final int completeIndex = 1;
        String actual = Todo.complete(completeIndex);
        validateComplete(actual);
    }

    private void validateComplete(String actual) {
        String expected = "\n\n" +
                "Item " + 1 + " done.";
        Assert.assertEquals(expected, actual);
        String completeContent = TextUtil.read(Todo.TODO_COMPLETED_PATH);
        Assert.assertEquals("[1]", completeContent);
    }

    /**
     * 查看未完成Todo列表
     */
    @Test
    public void shouldListInCompleted() {
        prepareForList();
        String actual = Todo.listIncomplete();

        validateListInCompleted(actual);
    }

    private void validateListInCompleted(String actual) {
        String expected = "\n\n" +
                "1. <item1>\n" +
                "2. <item2>\n" +
                "\n\n" +
                "Total: 2 items";

        Assert.assertEquals(expected, actual);
    }

    /**
     * 查看所有的Todo项
     */
    @Test
    public void shouldListAll() {
        prepareForList();
        String actual = Todo.listAll();
        validateListAll(actual);
    }

    private void prepareForList() {
        Todo.add("<item1>");
        Todo.add("<item2>");
        Todo.add("<item3>");
        Todo.complete(3);
    }

    private void validateListAll(String actual) {
        String expected = "\n\n" +
                "1. <item1>\n" +
                "2. <item2>\n" +
                "3. [Done] <item3>\n" +
                "\n\n" +
                "Total: 3 items, 1 item done";
        Assert.assertEquals(expected, actual);
    }

    /**
     * 添加Todo项
     */
    @Test
    public void shouldAddCommand() {
        String input = "todo add <item>";
        String actual = Todo.command(input);
        validateAdd(actual);
    }

    /**
     * 完成Todo项
     */
    @Test
    public void shouldCompleteCommand() {
        String input = "todo add <item>";
        Todo.command(input);
        final int index = 1;
        input = "todo done " + index;
        String actual = Todo.command(input);
        validateComplete(actual);
    }

    /**
     * 查看未完成列表
     */
    @Test
    public void shouldListCommand() {
        prepareForList();

        String input = "todo list";
        String actual = Todo.command(input);
        validateListInCompleted(actual);
    }

    /**
     * 查看所有列表
     */
    @Test
    public void shouldListAllCommand() {
        prepareForList();

        String input = "todo list --all";
        String actual = Todo.command(input);
        validateListAll(actual);
    }
}