import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tong on 3/11/16.
 */
public class Java8Test {

    @Test
    public void test(){
        List<Long> longList = Lists.newArrayList(1l, 2l, 3l, 4l);

        Long list2 = longList.stream().filter(t -> t > 2l).map(t -> t * t).reduce(100l, (a , b) -> a + b);

        System.out.println(list2);
    }

    @Test
    public void testReduce(){
        List<Long> longs = Lists.newArrayList(1l, 2l, 3l, 4l);

        Long ret = longs.stream().reduce(100l, (a, b) -> a + b);

        System.out.println(ret);

    List<ArrayList<Long>> lists = Lists.newArrayList(Lists.newArrayList(1l, 2l, 3l),
            Lists.newArrayList(4l, 5l, 6l));

    List<Long> retList = lists.stream().reduce(new ArrayList<Long>(), (longs1, longs2) -> {
        longs1.addAll(longs2);
        return longs1;
    });

    System.out.println(JSON.toJSONString(retList));
    }
}


