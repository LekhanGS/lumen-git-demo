package com.example.webservicedemo.apis;

import com.example.webservicedemo.models.Document;
import com.example.webservicedemo.services.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/documents")
public class DocumentApi {
    private final DocumentService documentService;

    public DocumentApi(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAll() {
        return ResponseEntity.ok(documentService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Document> getById(@PathVariable int id) {
        return ResponseEntity.ok(documentService.getById(id));
    }

    @GetMapping("qp")
    public ResponseEntity<Document> getByIdQp(@RequestParam(required = false) Integer id) {
        return ResponseEntity.ok(documentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Document document) {
        documentService.create(document);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Document document) {
        documentService.update(id, document);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        documentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
