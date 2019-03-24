package org.tyaa.java.portal.springboot.gae.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tyaa.java.portal.datastore.model.Author;
import org.tyaa.java.portal.datastore.model.JsonHttpResponse;
import org.tyaa.java.portal.springboot.gae.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    //1
    /*List<Author> authors;

    public AuthorController() {

        authors = new ArrayList<>();

        Author author = new Author();
        author.setName("A1");
        author.setAbout("A1 - About");
        author.setStartedAt(new Date());

        Author author2 = new Author();
        author2.setName("A2");
        author2.setAbout("A2 - About");
        author2.setStartedAt(new Date());

        authors.add(author);
        authors.add(author2);
    }*/
    
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public JsonHttpResponse getAllAuthors() {
    //public List<Author> getAllAuthors() {

        //1
        //return authors;
        
        //2
        /*List<Author> authors = new ArrayList<>();
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                List<Author> authorsResult =
                    ofy().load().type(Author.class).list();
                if (authorsResult != null) {
                    authors.addAll(authorsResult);
                }
            }
        });
        return authors;*/
        
        //3
        return authorService.read();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //public Author getAuthor(@PathVariable("id") Long _id) {
    public JsonHttpResponse getAuthor(@PathVariable("id") Long _id) {
        //1
        //return authors.get(id);
        
        //3
        return authorService.read(_id);
    }
    
    @PostMapping("/create")
    public JsonHttpResponse create(@RequestBody Author _author) {
        return authorService.create(_author);
    }
}