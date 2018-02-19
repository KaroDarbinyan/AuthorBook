package com.library.demo.controller;

import com.library.demo.model.Book;
import com.library.demo.repository.AuthorRepository;
import com.library.demo.repository.BookRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;


    @RequestMapping(value = "/add_book", method = RequestMethod.GET)
    public String addAuthor(ModelMap map) {
        map.addAttribute("authors", authorRepository.findAll());
        map.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String saveAuthor(@Valid @ModelAttribute("book") Book book, @RequestParam("picture") MultipartFile multipartFile) throws IOException {
        String picName = System.currentTimeMillis() + "-" + multipartFile.getOriginalFilename();
        File file = new File("D:\\AuthorBook\\book\\" + picName);
        multipartFile.transferTo(file);
        book.setPicUrl(picName);
        bookRepository.save(book);
        return "redirect:/viewAllBooks";
    }

    @GetMapping("/viewAllBooks")
    public String getAllBooks(ModelMap map) {
        map.addAttribute("books", bookRepository.findAll());
        return "viewAllBooks";
    }

    @RequestMapping(value = "bookImage", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("fileName") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream("D:\\AuthorBook\\book\\" + fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
}
