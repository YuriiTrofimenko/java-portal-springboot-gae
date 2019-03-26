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
        
        authorDAO.create(author);
        return new JsonHttpResponse(
                JsonHttpResponse.createdStatus
                , "The author created successfully"
        );
    }

    @Override
    public JsonHttpResponse read() {
        
        return new JsonHttpResponse(
                JsonHttpResponse.fetchedStatus
                , "The authors list fetched successfully"
                , authorDAO.read()
        );
    }

    @Override
    public JsonHttpResponse read(Long _id) throws Exception {
        
        Author author =
                authorDAO.read(_id);
        String status =
                (author != null && author.getId() != null)
                ? JsonHttpResponse.fetchedStatus
                : JsonHttpResponse.warningStatus;
        String message =
                (author != null && author.getId() != null)
                ? "The author fetched successfully"
                : "Not found";
        return new JsonHttpResponse(
                status
                , message
                , author
        );
    }

    @Override
    public JsonHttpResponse read(String _name) throws Exception {
        
            Author author =
                    authorDAO.read(_name);
            String status =
                    (author != null && author.getId() != null)
                    ? JsonHttpResponse.fetchedStatus
                    : JsonHttpResponse.warningStatus;
            String message =
                    (author != null && author.getId() != null)
                    ? "The author fetched successfully"
                    : "Not found";
            return new JsonHttpResponse(
                    status
                    , message
                    , author
            );
    }

    @Override
    public JsonHttpResponse update(Author author) {
        
        authorDAO.update(author);
        return new JsonHttpResponse(
                JsonHttpResponse.updatedStatus
                , "The author updated successfully"
        );
    }

    @Override
    public JsonHttpResponse delete(Long _id) {
        
        authorDAO.delete(_id);
        return new JsonHttpResponse(
                JsonHttpResponse.deletedStatus
                , "The author deleted successfully"
        );
    }
    
}
