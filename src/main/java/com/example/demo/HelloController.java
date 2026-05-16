package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    Map<Long, article> store = new HashMap<>();
    long seq = 1;

        @PostMapping("/article")
        public article create(@RequestBody article article) {
            article.id = seq++;
            store.put(article.id, article);
            return article;
        }

        @GetMapping("/article/{id}")
        public ResponseEntity<article> get(@PathVariable Long id) {

            article article = store.get(id);

            if (article == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return ResponseEntity.ok(article);
        }

        @PutMapping("/article/{id}")
        public article update(@PathVariable Long id, @RequestBody article req) {
            article article = store.get(id);
            if (article == null) {
                return null;
            }
            article.description = req.description;
            return article;
        }

        @DeleteMapping("/article/{id}")
        public String delete(@PathVariable Long id) {
            store.remove(id);
            return "deleted";
        }
}
