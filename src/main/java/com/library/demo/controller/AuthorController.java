package com.library.demo.controller;

import com.library.demo.model.Author;
import com.library.demo.repository.AuthorRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;


@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;


    @RequestMapping(value = "/addAuthorView", method = RequestMethod.GET)
    public String addAuthor(ModelMap map) {
        map.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/addAuthor")
    public String saveAuthor(@Valid @ModelAttribute("author") Author author, @RequestParam("picture") MultipartFile multipartFile) throws IOException {
        String picName = System.currentTimeMillis() + "-" + multipartFile.getOriginalFilename();
        File file = new File("D:\\AuthorBook\\author\\" + picName);
        multipartFile.transferTo(file);
        author.setPicUrl(picName);
        authorRepository.save(author);
        return "redirect:/viewAllAuthors";
    }


    @GetMapping("/viewAllAuthors")
    public String getAllAuthors(ModelMap map) {
        map.addAttribute("authors", authorRepository.findAll());
        return "viewAllAuthors";

    }

    @RequestMapping(value = "authorImage", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("fileName") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream("D:\\AuthorBook\\author\\" + fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(inputStream, response.getOutputStream());
    }


}
