import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        Stack<String> stack = new Stack<String>();
        StringBuffer res = new StringBuffer();
        int i = 0;
        while (i < path.length()) {
            StringBuffer cur = new StringBuffer();
            int index = i;
            while (i < path.length() && path.charAt(i) != '/') {
                cur.append(path.charAt(i));
                i++;
            }
            if (index != i) {
                if (cur.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }else if (!cur.toString().equals(".")) {
                    stack.push(cur.toString());
                }
            }
            i++;
        }
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, "/");
        }
        return res.toString();
    }
}
