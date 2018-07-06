
import com.StringUtil;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

import org.junit.Test;

public class StringUtilTest {

    /*
     *Result
     * 'A','B','C','D','E'
     */
    @Test
    public void joinIsNotNullStringArray() {
        String[] stringArray = {"A", "B", "C", "D", "E"};
        String joinIsNotNull = StringUtil.joinIsNotNull(stringArray, ",", "'", "'");
        Assert.assertNotNull(joinIsNotNull);
    }

    /*
     *Result
     * 'A','B','C','D'
     */
    @Test
    public void joinIsNotEmptyNullStringList() {
        List<String> stringList = Arrays.asList("A", "B", "C", "D");
        String joinIsNotNull = StringUtil.joinIsNotEmptyNull(stringList, ",", "'", "'");
        Assert.assertNotNull(joinIsNotNull);
    }

}
