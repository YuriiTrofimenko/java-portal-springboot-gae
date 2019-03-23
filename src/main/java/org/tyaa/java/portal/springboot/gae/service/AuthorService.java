/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tyaa.java.portal.datastore.model.Author;
import org.tyaa.java.portal.datastore.model.JsonHttpResponse;
import org.tyaa.java.portal.springboot.gae.dao.AuthorDataStoreDAO;
import org.tyaa.java.portal.springboot.gae.utils.ErrorsGetter;

/**
 *
 * @author yurii
 */
@Service
public class AuthorService implements IAuthorService {
    
    @Autowired
    private AuthorDataStoreDAO authorDAO;

    @Override
    public JsonHttpResponse create(Author author) {
        
        try {
            authorDAO.create(author);
            return new JsonHttpResponse(
                    JsonHttpResponse.createdStatus
                    , "The author was added successfully"
            );
        } catch (Exception ex) {
            return new JsonHttpResponse(
                    JsonHttpResponse.errorStatus
                    , ErrorsGetter.printException(ex));
        }
    }

    @Override
    public JsonHttpResponse read() {
        
        try {
            return new JsonHttpResponse(
                    JsonHttpResponse.fetchedStatus
                    , "The authors list was fetched successfully"
                    , authorDAO.read()
            );
        } catch (Exception ex) {
            return new JsonHttpResponse(
                    JsonHttpResponse.errorStatus
                    , ErrorsGetter.printException(ex));
        }
    }

    @Override
    public JsonHttpResponse read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JsonHttpResponse read(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JsonHttpResponse update(Author author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JsonHttpResponse delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
