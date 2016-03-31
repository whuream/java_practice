import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by tong on 3/31/16.
 */
public class dd {
    @Test
    public void test1(){
        System.out.println(Lists.newArrayList(Iterators.transform(Arrays.asList(1, 2, 3).iterator(),
                new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer input) {
                        return input * input;
                    }
                })));

        System.out.println(Lists.newArrayList(Iterators.filter(Arrays.asList(1, 2, 3).iterator(),
                new Predicate<Integer>() {
                    @Override
                    public boolean apply(Integer input) {
                        return input > 2;
                    }
                })));
    }
}


