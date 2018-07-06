
import com.DateUtil;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest1 {

    /*
     *Result
     * 'Fri Jan 19 08:40:50 BRST 2018','Fri Jan 19 08:40:50 BRST 2018'
     */
    @Test
    public void joinIsNotNullDateArray() {
        Date[] dateArray = {new Date(), new Date()};
        String joinIsNotNull = DateUtil.joinIsNotNull(dateArray, ",", "'");
        Assert.assertNotNull(joinIsNotNull);
    }
}
