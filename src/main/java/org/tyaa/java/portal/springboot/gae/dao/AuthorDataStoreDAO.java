/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.dao;

import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.VoidWork;
import org.springframework.stereotype.Repository;
import org.tyaa.java.portal.datastore.model.Author;
import org.tyaa.java.portal.springboot.gae.utils.CopyHelper;

/**
 *
 * @author yurii
 */
@Repository
public class AuthorDataStoreDAO extends AbstractDAO<Author>{
    
    public Author read(String _name) throws Exception {
            
        Author authorEntity = null;
        
            Author finalAuthorEntity = new Author();
            ObjectifyService.run(new VoidWork() {
                @Override
                public void vrun() {
                    Author authorEntityResult =
                        ofy().load().type(Author.class)
                            .filter("name", _name)
                            .first()
                            .now();
                    if (authorEntityResult != null) {
                        CopyHelper.copy(authorEntityResult, finalAuthorEntity);
                    }
                }
            });
            /*if (true) {
                throw new Exception("test ex");
            }*/
            authorEntity = finalAuthorEntity;
            
        return authorEntity;
    }
}
