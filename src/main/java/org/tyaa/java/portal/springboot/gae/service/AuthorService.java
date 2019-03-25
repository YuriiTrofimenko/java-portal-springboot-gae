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
                    , "The author created successfully"
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
                    , "The authors list fetched successfully"
                    , authorDAO.read()
            );
        } catch (Exception ex) {
            return new JsonHttpResponse(
                    JsonHttpResponse.errorStatus
                    , ErrorsGetter.printException(ex));
        }
    }

    @Override
    public JsonHttpResponse read(Long _id) {
        try {
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
        } catch (Exception ex) {
            return new JsonHttpResponse(
                    JsonHttpResponse.errorStatus
                    , ErrorsGetter.printException(ex));
        }
    }

    @Override
    public JsonHttpResponse read(String _name) {
        try {
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
        } catch (Exception ex) {
            return new JsonHttpResponse(
                    JsonHttpResponse.errorStatus
                    , ErrorsGetter.printException(ex));
        }
    }

    @Override
    public JsonHttpResponse update(Author author) {
        try {
            authorDAO.update(author);
            return new JsonHttpResponse(
                    JsonHttpResponse.updatedStatus
                    , "The author updated successfully"
            );
        } catch (Exception ex) {
            return new JsonHttpResponse(
                    JsonHttpResponse.errorStatus
                    , ErrorsGetter.printException(ex));
        }
    }

    @Override
    public JsonHttpResponse delete(Long _id) {
        try {
            authorDAO.delete(_id);
            return new JsonHttpResponse(
                    JsonHttpResponse.deletedStatus
                    , "The author deleted successfully"
            );
        } catch (Exception ex) {
            return new JsonHttpResponse(
                    JsonHttpResponse.errorStatus
                    , ErrorsGetter.printException(ex));
        }
    }
    
}
