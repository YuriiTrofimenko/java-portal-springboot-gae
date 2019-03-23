/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.utils;

/**
 *
 * @author yurii
 */
public class ErrorsGetter {

    public static String printException(Exception _ex) {

        String errorString = "";
        if (_ex.getMessage() == null) {

            String errorTrace = "";
            for (StackTraceElement el : _ex.getStackTrace()) {
                errorTrace += el.toString();
            }
            if (errorTrace.equals("")) {
                //printException(_ex, _out, _gson);

            } else {
                errorString = errorTrace;
            }
        } else {

            errorString = _ex.getMessage();
            //rd = new RespData("unknown_exception");
        }
        return errorString;
    }
}
