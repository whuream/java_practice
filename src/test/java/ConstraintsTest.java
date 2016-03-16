import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.ream.www.maventest.constraints.ElementMin;
import com.ream.www.maventest.constraints.ElementNotNull;
import com.ream.www.maventest.constraints.SecondsFuture;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.List;
import java.util.Set;

/**
 * Created by tong on 3/9/16.
 */
public class ConstraintsTest {

    public static class Store{

        @ElementMin(value = 10)
        @ElementNotNull
        public List<Long> prices = Lists.newArrayList(100l, 1l, 2l);

        @ElementNotNull
        public List<String> name = Lists.newArrayList("car", "", null);

        @SecondsFuture
        public Long shipTime = 1l;
    }

    @Test
    public void test(){
        System.out.println(Joiner.on("\n").join(Iterators.transform(
                Validation.buildDefaultValidatorFactory().getValidator().validate(new Store()).iterator(),
                new Function<ConstraintViolation<Store>, String>() {
                    @Override
                    public String apply(ConstraintViolation<Store> input) {
                        return String.format("%s %s %s",
                                input.getPropertyPath(), JSON.toJSON(input.getInvalidValue()), input.getMessage());
                    }
                })));

    }

}