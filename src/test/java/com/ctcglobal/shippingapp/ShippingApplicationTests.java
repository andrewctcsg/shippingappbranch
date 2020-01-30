package com.ctcglobal.shippingapp;

import com.ctcglobal.bookstoreapp.model.Book;
import com.ctcglobal.bookstoreapp.repo.BookRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShippingApplicationTests {
	@Autowired
	private BookRepository bookRepository;
	@Before
	public void setUp() throws Exception {
		Book book1 = new Book("Of mice and men", 15);
		Book book2 = new Book("The picture of dorian gray", 17);
		Book book3 = new Book("All creatures great and small", 10);

		assertNull(book1.getId());
		assertNull(book2.getId());
		assertNull(book3.getId());//null before save

		this.bookRepository.save(book1);
		this.bookRepository.save(book2);
		this.bookRepository.save(book3);

		assertNotNull(book1.getId());
		assertNotNull(book2.getId());
		assertNotNull(book3.getId());
	}

	@Test
	void ContextLoads() {
		/*Test data retrieval*/
		/*Book bookA = bookRepository.findByName("The picture of dorian gray");
		assertNotNull(bookA);
		assertEquals(17, bookA.getCost());
		*//*Get all products, list should only have three*//*
		Iterable<Book> books = bookRepository.findAll();
		int count = 0;
		for(Book p : books){
			count++;
		}
		assertEquals(count, 3);*/
	}

}

