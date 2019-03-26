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
    
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public JsonHttpResponse getAll() {
    
        return authorService.read();
    }

    @GetMapping(value = "/{id}")
    public JsonHttpResponse get(@PathVariable("id") Long _id) throws Exception {
        
        return authorService.read(_id);
    }
    
    @GetMapping(value = "/get-by-name/{name}")
    public JsonHttpResponse getByName(@PathVariable("name") String _name) throws Exception {
        
        return authorService.read(_name);
    }
    
    @PostMapping("/create")
    public JsonHttpResponse create(@RequestBody Author _author) {
        return authorService.create(_author);
    }
    
    @PostMapping("/update")
    public JsonHttpResponse update(@RequestBody Author _author) {
        return authorService.update(_author);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public JsonHttpResponse delete(@PathVariable("id") Long _id) {
        
        return authorService.delete(_id);
    }
}