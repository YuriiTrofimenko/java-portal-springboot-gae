package org.tyaa.java.portal.springboot.gae.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tyaa.java.portal.model.Author;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    
        List<Author> authors;

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
        }

	@GetMapping("")
	public List<Author> getAllAuthors() {
                
		return authors;
	}
        
        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        public Author getAuthor(@PathVariable("id") int id) {
		
		return authors.get(id);
	}
}
