package com.imgur.common;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 9/30/14
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class Utility {
    public static boolean isNullOrEmpty( String sInputString){
        boolean isNullOrEmpty = true;
        if(sInputString!=null && !"".equalsIgnoreCase(sInputString)) {
            isNullOrEmpty = false;
        }
        return isNullOrEmpty;
    }

    public static boolean sTob(String sInput) {
        boolean bOutput = false;
        if (sInput != null && !"".equalsIgnoreCase(sInput)) {
            if ("true".equalsIgnoreCase(sInput) || "1".equalsIgnoreCase(sInput)
                    || "yes".equalsIgnoreCase(sInput)
                    || "y".equalsIgnoreCase(sInput)
                    || "on".equalsIgnoreCase(sInput)) {
                bOutput = true;
            }
        }

        return bOutput;
    }
}
