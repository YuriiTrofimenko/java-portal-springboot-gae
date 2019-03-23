/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.dao;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.VoidWork;
import static com.googlecode.objectify.ObjectifyService.ofy;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yurii
 */
public abstract class AbstractDAO<T> {
    
    public void create(T entity) {
	
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                ofy().save().entity(entity).now();
            }
        });
    }
    
    public List<T> read() {
	
        List<T> entities = new ArrayList<>();
        @SuppressWarnings("unchecked")
        Class<T> entityType =
            ((Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0]);
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                List<T> entitiesResult =
                    ofy().load().type(entityType).list();
                if (entitiesResult != null) {
                    entities.addAll(entitiesResult);
                }
            }
        });
        return entities;
    }
}
