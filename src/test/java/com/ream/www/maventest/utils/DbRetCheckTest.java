package com.ream.www.maventest.utils;

import junit.framework.TestCase;

/**
 * Created by tong on 3/9/16.
 */
public class DbRetCheckTest extends TestCase {

    public void testDbRetException(){
        Long dbRet = 1l;

        DbRetCheck.dbRetException(dbRet, 2l, DbRetCheck.CompareTypeEnum.EQUAL);
    }
}
