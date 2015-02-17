import java.util.*;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        if(n==0) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        List<Integer> tmp = grayCode(n-1);
        int addNumber = 1 << (n-1);
        List<Integer> result = new ArrayList<Integer>(tmp);
        for(int i=tmp.size()-1;i>=0;i--) {
            result.add(addNumber + tmp.get(i));
        }
        return result;
    }
}
