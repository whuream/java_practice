package com.ream.www.maventest.util;

/**
 * Created by tong on 3/9/16.
 */
public class DbRetCheck {

    private static class DatabaseException extends RuntimeException{
        private static final long serialVersionUID = -8768685827964066080L;

        DatabaseException(String msg){
            super(msg);
        }
    }

    public static <T extends Comparable<T>> void dbRetException(T ret, T expected, CompareTypeEnum compareTypeEnum){
        Boolean checkStatus = false;

        if(compareTypeEnum.equals(CompareTypeEnum.EQUAL)){
            checkStatus = ret.equals(expected);
        }else if (compareTypeEnum.equals(CompareTypeEnum.GREATER)){
            checkStatus = ret.compareTo(expected) == 1;
        }else if (compareTypeEnum.equals(CompareTypeEnum.LESS)){
            checkStatus = ret.compareTo(expected) == -1;
        }else if(compareTypeEnum.equals(CompareTypeEnum.GREATER_EQUAL)){
            checkStatus = ret.compareTo(expected) > -1;
        }else if(compareTypeEnum.equals(CompareTypeEnum.LESS_EQUAL)){
            checkStatus = ret.compareTo(expected) < 1;
        }

        String msg = String.format("db operation failed, ret = %s, expected %s %s", ret.toString(),
                compareTypeEnum.getValue(), expected.toString());

        if(!checkStatus){
            throw new DatabaseException(msg);
        }

    }

    public enum CompareTypeEnum {

        EQUAL("="),
        GREATER(">"),
        LESS("<"),
        GREATER_EQUAL(">="),
        LESS_EQUAL("<=")
        ;

        CompareTypeEnum(String value){
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
