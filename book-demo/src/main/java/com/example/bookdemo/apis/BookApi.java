package com.example.bookdemo.apis;


import com.example.bookdemo.models.Book;
import com.example.bookdemo.service.BookService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@Api(value = "books",tags = {"Book Api"})
public class BookApi {
    private final BookService bookService;

    public BookApi(BookService bookService){this.bookService = bookService;}

    @GetMapping(path = "multi",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getById(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping("qp")
    public ResponseEntity<Book> getByIdQp(@RequestParam(required = false) Integer id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            }
    )
    public ResponseEntity<?> create(@RequestBody Book book) {
        bookService.create(book);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Book book) {
        bookService.update(id, book);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
