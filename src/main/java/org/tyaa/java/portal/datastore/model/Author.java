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
//import java.util.Collection;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author student
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Getter @Setter @NoArgsConstructor
public class Author implements Serializable{
    @Id
    private Long id;
    @Index
    private String name;
    private String about;
    private Date startedAt;
    //
    //private Collection<Article> articlesCollection;
    
    public Author(String name, String about, Date startedAt) {
        this.name = name;
        this.about = about;
        this.startedAt = startedAt;
    }
}
