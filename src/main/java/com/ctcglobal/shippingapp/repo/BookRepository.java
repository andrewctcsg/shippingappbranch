package com.ctcglobal.shippingapp.repo;

import com.ctcglobal.bookstoreapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findByName(String name);
}
