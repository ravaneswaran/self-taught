package rave.code.neo4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rave.code.neo4j.nodes.Author;
import rave.code.neo4j.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @PutMapping
    public Author updateAuthor(@RequestBody Author author)  {
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/author/{authorId}")
    public void deleteAuthor(@PathVariable String authorId){
        authorService.deleteAuthor(authorId);
    }

}
