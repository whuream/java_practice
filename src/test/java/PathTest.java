import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tong on 2/19/16.
 */
public class PathTest {
    @Test
    public void test(){
        Path path = Paths.get("././Content/a/b/c.txt/");

        System.out.println(path.normalize());

        System.out.println(path.getNameCount());

        System.out.println(path.getRoot());

        System.out.println(path.isAbsolute());

        System.out.println(path.toAbsolutePath());

        System.out.println(path.getName(1));

        System.out.println(path.getParent());

        System.out.println(path.resolve("test/a"));

        System.out.println(path.getFileName());

        Short s = null;

        System.out.println(path.toString().endsWith(".txt"));

//        Long a = Long.valueOf(s);


    }
}
