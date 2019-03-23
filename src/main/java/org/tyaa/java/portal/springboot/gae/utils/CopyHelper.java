/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.utils;

import java.lang.reflect.Field;

/**
 *
 * @author yurii
 */
public class CopyHelper {

    public static <T> void copy(T _from, T _to)
            throws IllegalArgumentException, IllegalAccessException {

        Class<T> _clazz = (Class<T>) _from.getClass();
        Field[] fields = _clazz.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);
            field.set(_to, field.get(_from));
        }
    }
}
