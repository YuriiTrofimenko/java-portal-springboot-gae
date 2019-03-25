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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.tyaa.java.portal.springboot.gae.utils.CopyHelper;
import org.tyaa.java.portal.springboot.gae.utils.ErrorsGetter;

/**
 *
 * @author yurii
 */
public abstract class AbstractDAO<T> {
    
    protected static Logger log;
    private Class<T> entityType;

    public AbstractDAO() {
        
        log =
            Logger.getLogger(CopyHelper.class.getName());
        
        entityType =
            ((Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0]);
    }
    
    
    public void create(T _entity) {
	
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                ofy().save().entity(_entity).now();
            }
        });
    }
    
    public void update(T _entity) {
	
        create(_entity);
    }
    
    public List<T> read() {
	
        List<T> entities = new ArrayList<>();
        
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
    
    public T read(Long _id) {
            
        T entity = null;
        
        try {
            T finalEntity = entityType.newInstance();
            ObjectifyService.run(new VoidWork() {
                @Override
                public void vrun() {
                    T entityResult =
                        ofy().load().type(entityType).id(_id).now();
                    if (entityResult != null) {
                        CopyHelper.copy(entityResult, finalEntity);
                    }
                }
            });
            entity = finalEntity;
        } catch (Exception ex) {
            log.log(Level.SEVERE, ErrorsGetter.printException(ex));
        }
        return entity;
    }
    
    public void delete(Long _id) {
		
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                ofy().delete().type(entityType).id(_id).now();
            }
        });
    }
}
