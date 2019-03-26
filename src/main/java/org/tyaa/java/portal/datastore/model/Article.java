/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.datastore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author student
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Entity
@Getter @Setter @NoArgsConstructor
public class Article {
    @Id
    private Long id;
    @Index
    private String title;
    private String content;
    private String image;
    private Date publishedAt;
    @Index
    private Author authorId;

    public Article(String title, String content, String image, Date publishedAt) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.publishedAt = publishedAt;
    }
}