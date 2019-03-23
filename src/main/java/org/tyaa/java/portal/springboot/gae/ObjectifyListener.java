/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae;

import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.tyaa.java.portal.datastore.model.Article;
import org.tyaa.java.portal.datastore.model.Author;

/**
 *
 * @author yurii
 */
@WebListener
public class ObjectifyListener implements ServletContextListener{
    
    @Override
        public void contextInitialized(ServletContextEvent sce) {
            
            if (System.getenv("SPRING_PROFILES_ACTIVE") == null) {
                // local without memcache (gradle bootRun)
                System.out.println("ObjectifyService.init - 1");
                ObjectifyService.init(new ObjectifyFactory(
                        DatastoreOptions.newBuilder()
                                .setHost("http://localhost:8484")
                                .setProjectId("spring-gae-datastore")
                                .build()
                                .getService()
                ));
            }
            else {
                // on appengine
                ObjectifyService.init(new ObjectifyFactory(
                        DatastoreOptions.getDefaultInstance().getService()
                ));
            }
            System.out.println("ObjectifyService.init - 2");
            ObjectifyService.register(Article.class);
            System.out.println("ObjectifyService.init - 3");
            ObjectifyService.register(Author.class);
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {

        }
}
