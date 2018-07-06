
import com.IntegerUtil;
import org.junit.Assert;
import org.junit.Test;

public class IntegerUtilTest {

    /*
     *Result
     * '1','2','3','4','5'
     */
    @Test
    public void joinIsNotNullIntegerArray() {
        Integer[] integerArray = {1, 2, 3, 4, 5};
        String joinIsNotNull = IntegerUtil.joinIsNotNull(integerArray, ",", "'");
        Assert.assertNotNull(joinIsNotNull);
    }

}
