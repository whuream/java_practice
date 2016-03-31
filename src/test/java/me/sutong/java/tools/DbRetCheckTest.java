package me.sutong.java.tools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tong on 3/31/16.
 */
public class DbRetCheckTest {

    @Test
    public void testDbRetException() throws Exception {
        Long dbRet = 1l;

        DbRetCheck.dbRetException(dbRet, 2l, DbRetCheck.CompareTypeEnum.EQUAL);
    }
}