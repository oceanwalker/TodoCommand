import java.util.*;

/**
 * @author Eagle
 */
public class Todo {

    public static final String TODO_LIST_PATH = "src\\main\\resources\\todoList.txt";
    public static final String TODO_COMPLETED_PATH = "src\\main\\resources\\complete.txt";
    private static Integer nextIndex = 1;
    private static final String COMMA = ",";
    public static final String ONE_LINE = "\n";
    public static final String TWO_LINE = "\n\n";
    private static List<String> todoList = new ArrayList<>();
    private static Set<Integer> completeList = new TreeSet<>();
    private static final String TIP_COMMAND_ERROR = "command unknown";
    private static final String TIP_PARAM_ERROR = "param input illegal";
    private static final String ADD_COMMAND = "add";
    private static final String DONE_COMMAND = "done";
    private static final String LIST_COMMAND = "list";
    private static final String LIST_ALL_COMMAND = "--all";
    private static final String TODO_PARAM = "todo";
    private static final int LEGAL_THREE_PARAM_COUNT = 3;
    private static final int LEGAL_TWO_PARAM_COUNT = 2;

    static {
        load();
    }

    /**
     * 添加一个Todo项
     *
     * @param item Todo项目
     * @return 结果
     */
    public static String add(String item) {
        todoList.add(item);
        nextIndex++;
        TextUtil.appendLine(TODO_LIST_PATH, item);
        return getAddResult(item);
    }

    private static String getAddResult(String todo) {
        int lastIndex = nextIndex - 1;
        return TWO_LINE +
                lastIndex + ". " + todo +
                TWO_LINE +
                "Item " + lastIndex + " added";
    }

    /**
     * 根据序号完成Todo项
     *
     * @param index 序号
     * @return 结果
     */
    public static String complete(Integer index) {
        completeList.add(index);
        TextUtil.cover(TODO_COMPLETED_PATH, completeList.toString());
        return getCompleteResult(index);
    }

    private static String getCompleteResult(Integer completeIndex) {
        return TWO_LINE +
                "Item " + completeIndex + " done.";
    }

    /**
     * 列出所有Todo项
     *
     * @return 运行结果
     */
    public static String listIncomplete() {
        StringBuilder result = new StringBuilder();
        result.append(TWO_LINE);
        for (Integer index = 1; index < nextIndex; index++) {
            if (completeList.contains(index)) {
                continue;
            }
            result.append(index).append(". ").append(todoList.get(index - 1));
            result.append(ONE_LINE);
        }
        result.append(TWO_LINE);
        result.append(String.format("Total: %s items", getInCompletedCount()));
        return result.toString();
    }

    /**
     * 列出所有未完成Todo项
     *
     * @return 运行结果
     */
    public static String listAll() {
        StringBuilder result = new StringBuilder();
        result.append(TWO_LINE);
        for (Integer index = 1; index < nextIndex; index++) {
            result.append(index).append(". ");
            result.append(completeList.contains(index) ? "[Done] " : "");
            result.append(todoList.get(index - 1));
            result.append(ONE_LINE);
        }
        result.append(TWO_LINE);
        result.append(String.format("Total: %s items, %s item done",
                todoList.size(), getCompletedCount()));
        return result.toString();
    }

    private static Integer getCompletedCount() {
        return completeList.size();
    }

    private static Integer getInCompletedCount() {
        return todoList.size() - completeList.size();
    }

    /**
     * 从文件中载入数据到内存
     */
    public static void load() {
        todoList = TextUtil.readAsList(TODO_LIST_PATH);
        nextIndex = todoList.size() + 1;
        String completeStr = TextUtil.read(TODO_COMPLETED_PATH);
        completeList = new TreeSet<>();
        if (completeStr.length() == 0) {
            return;
        }
        completeStr = completeStr.substring(1, completeStr.length() - 1);
        for (String completeIndex : completeStr.split(COMMA)) {
            completeList.add(Integer.valueOf(completeIndex.trim()));
        }
    }

    /**
     * 清除所有数据
     */
    public static void removeAllData() {
        nextIndex = 1;
        completeList = new TreeSet<>();
        todoList = new ArrayList<>();
        TextUtil.remove(TODO_LIST_PATH);
        TextUtil.remove(TODO_COMPLETED_PATH);
    }

    /**
     * 根据命令行运行程序
     *
     * @param command 命令
     * @return 运行结果
     */
    public static String command(String command) {
        try {
            final String[] params = command.split("\\s");
            final boolean isThreeParam = params.length == LEGAL_THREE_PARAM_COUNT;
            final boolean isTwoParam = params.length == LEGAL_TWO_PARAM_COUNT;
            final boolean paramCountLegal = (isThreeParam || isTwoParam);
            if (!paramCountLegal) {
                throw new Exception(TIP_PARAM_ERROR);
            }
            String title = params[0];
            if (!title.equals(TODO_PARAM)) {
                throw new Exception(TIP_COMMAND_ERROR);
            }
            String action = params[1];
            //两个参数
            if (isTwoParam) {
                if (!action.equals(LIST_COMMAND)) {
                    throw new Exception(TIP_COMMAND_ERROR);
                }
                return listIncomplete();
            }
            //以下是三个参数处理
            String item = params[2];
            if (action.equals(ADD_COMMAND)) {
                return add(item);
            }
            if (action.equals(DONE_COMMAND)) {
                Integer index = Integer.parseInt(item);
                return complete(index);
            }
            if (action.equals(LIST_COMMAND) && item.equals(LIST_ALL_COMMAND)) {
                return listAll();
            }
            throw new Exception(TIP_COMMAND_ERROR);
        } catch (NumberFormatException e) {
            return TIP_PARAM_ERROR;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回上一个处理完的序号
     *
     * @return 处理完的序号
     */
    public static Integer getLastIndex() {
        return nextIndex - 1;
    }
}
