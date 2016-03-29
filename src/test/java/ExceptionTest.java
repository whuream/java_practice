import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tong on 3/18/16.
 */
public class ExceptionTest {

    @Test
    public void test(){
        Integer a = null;

        Exception ec = null;

        try{
            Long b = a.longValue();
        } catch (Exception e){

            e.printStackTrace();

            ec = e;

        }

        System.out.println(ec.toString());



    }

    @Test
    public void test2() throws NoSuchMethodException {
        List list = new List<Integer>(){

            @Override
            public int size() {
                return 100;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Integer get(int index) {
                return index;
            }

            @Override
            public Integer set(int index, Integer element) {
                return null;
            }

            @Override
            public void add(int index, Integer element) {

            }

            @Override
            public Integer remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Integer> listIterator() {
                return new ListIterator<Integer>() {
                    int current = -1;

                    @Override
                    public boolean hasNext() {
                        return current + 1 < size();
                    }

                    @Override
                    public Integer next() {
                        current += 1;
                        return current;
                    }

                    @Override
                    public boolean hasPrevious() {
                        return false;
                    }

                    @Override
                    public Integer previous() {
                        return null;
                    }

                    @Override
                    public int nextIndex() {
                        return 0;
                    }

                    @Override
                    public int previousIndex() {
                        return 0;
                    }

                    @Override
                    public void remove() {

                    }

                    @Override
                    public void set(Integer integer) {

                    }

                    @Override
                    public void add(Integer integer) {

                    }
                };
            }

            @Override
            public ListIterator<Integer> listIterator(int index) {
                return null;
            }

            @Override
            public List<Integer> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        Collection collection = new Collection<Integer>(){
            @Override
            public int size() {
                return 100;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    int current=-1;
                    @Override
                    public boolean hasNext() {
                        return current + 1 < size();
                    }

                    @Override
                    public Integer next() {
                        current += 1;
                        return current;
                    }
                };
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        List<Integer> list1 = new ArrayList<>(list);

        System.out.println(list1);

        System.out.println(list.get(29));


        Object a = Array.newInstance(Integer.class, 100);

        Method[] methods = a.getClass().getMethods();

        Class c = a.getClass();

        Method method = Array.class.getMethod("get", Object.class, int.class);


        System.out.println(JSON.toJSONString(a));

        JSON.toJSONString("\u0001\u0080\u0002");
    }
    public static String getDate(){
        TimeZone timeZone = TimeZone.getTimeZone("GMT-8");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat.setTimeZone(timeZone);
        System.out.println(simpleDateFormat.format(new Date()));
        return simpleDateFormat.format(new Date());
    }

    public static Pair<Long, Long> getTimeRange(){

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Long begin = calendar.getTimeInMillis();

        calendar.add(Calendar.DATE, -1);

        Long end = calendar.getTimeInMillis();

        return Pair.of(begin, end);
    }

    public static class FingerPrintConstant {

        public final static String REQUEST = "music.request";

        public final static String RESULT = "music.result";

        public final static String TIMEZONE = "GMT-8";

        public final static String TIME_FORMAT = "yyyyMMdd";

        public static String formatDate(Long milli){
            TimeZone timeZone = TimeZone.getTimeZone(TIMEZONE);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
            simpleDateFormat.setTimeZone(timeZone);

            return simpleDateFormat.format(new Date(milli));
        }
    }


    @Test
    public void test10(){
        Pair<Long, Long> range = getTimeRange();

        String f = FingerPrintConstant.formatDate(range.getLeft());

        System.out.println(f);

        System.out.println(JSON.toJSONString(getTimeRange()));

        Set<Long> set = Sets.newHashSet(1l);
        set.add(2l);
    }

    public void array(List<Long> a){
        a.clear();
        a.add(12l);
    }

    @Test
    public void test11(){
        String s = "12\n34\n56\n\n\n";

        List<String> strings = Arrays.asList(s.split("\n"));

        Long a = Long.valueOf(" 12 ".trim());

        System.out.println(strings);
        System.out.println(a);

        List<Long> b = new ArrayList<>();
        b.add(11l);

        array(b);

        System.out.println(JSON.toJSONString(b));
    }

    @Test
    public void test12(){
        Pair<Long, Long> pair = Pair.of(1l, 2l);


    }

    @Test
    public void test13(){

    }
}
