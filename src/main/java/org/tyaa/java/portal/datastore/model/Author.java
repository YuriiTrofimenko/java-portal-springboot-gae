/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.datastore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author student
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Author implements Serializable{
    @Id
    private Long id;
    @Index
    private String name;
    private String about;
    private Date startedAt;
    //
    //private Collection<Article> articlesCollection;

    public Author() {
    }

    public Author(Long id) {
        this.id = id;
    }
    
    public Author(String name, String about, Date startedAt) {
        this.name = name;
        this.about = about;
        this.startedAt = startedAt;
    }

    public Author(Long id, String name, String about, Date startedAt) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.startedAt = startedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }
}
