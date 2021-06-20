import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eagle
 */
public class TextUtil {
    public static String read(String filePath) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = in.readLine()) != null) {
                result.append(str).append("\n");
            }
            in.close();
        } catch (IOException ignored) {
        }
        return result.toString().trim();
    }

    public static void appendLine(String filePath, String line) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
            out.newLine();
            out.write(line);
            out.flush();
            out.close();
        } catch (IOException ignored) {
        }
    }

    public static void remove(String filePath) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.close();
        } catch (IOException ignored) {
        }
    }

    public static List<String> readAsList(String filePath) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            StringBuffer sb;
            while (in.ready()) {
                sb = new StringBuffer(in.readLine());
                if (sb.length() == 0) {
                    continue;
                }
                result.add(sb.toString());
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void cover(String filePath, String content) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.write(content);
            out.close();
        } catch (IOException ignored) {
        }
    }
}
