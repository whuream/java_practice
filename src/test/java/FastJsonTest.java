import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tong on 3/16/16.
 */
public class FastJsonTest {

    public static class C1{
        public Integer integer = 10;
    }

    public static class C2<T extends C1>{

    }

    public static void w(List<? extends C1> list){

    }

    @Test
    public void test(){
        List<?> list = new ArrayList<>();
        Method[] allMethods = FastJsonTest.class.getDeclaredMethods();

        for(Method method: allMethods){
            if(method.getName().equals("w")){
                Type[] types = method.getGenericParameterTypes();
            }
        }
    }


    @Test
    public void test4(){
        Type type = mapType(new TypeToken<C2<C1>>(){}, C1.class);
        ParameterizedType parameterizedType = (ParameterizedType)type;
        System.out.println(type);
    }

    static <K, V> Type mapType(TypeToken<K> k, Class<V> v) {
        return new TypeToken<Map<K, V>>() {}
                .where(new TypeParameter<K>() {}, k)
                .where(new TypeParameter<V>() {}, v).getType();
    }

    @Test
    public void test5(){
        List<C1> c1s = Lists.newArrayList(new C1());

        String string = JSON.toJSONString(c1s);

        System.out.println(string);

        Object object = JSON.parseObject(string, List.class);

        System.out.print(1);
    }
}
