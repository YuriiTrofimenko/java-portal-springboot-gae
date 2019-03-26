/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.service;

import org.tyaa.java.portal.datastore.model.Author;
import org.tyaa.java.portal.datastore.model.JsonHttpResponse;

/**
 *
 * @author yurii
 */
public interface IAuthorService {
    JsonHttpResponse create(Author author);
    JsonHttpResponse read();
    JsonHttpResponse read(Long id) throws Exception;
    JsonHttpResponse read(String name) throws Exception;
    JsonHttpResponse update(Author author);
    JsonHttpResponse delete(Long id);
}
