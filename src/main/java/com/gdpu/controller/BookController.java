package com.gdpu.controller;

import com.gdpu.annotation.AdminLogin;
import com.gdpu.common.vo.BookQuery;
import com.gdpu.common.vo.Result;
import com.gdpu.entity.Book;
import com.gdpu.entity.User;
import com.gdpu.mapper.BookMapper;
import com.gdpu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    @ResponseBody
//    @AdminLogin
    public Result list(BookQuery param){
        List<Book> books = bookService.find(param);
        return Result.succeed(books, bookService.findNum(param));
    }

    @GetMapping("/edit/{id}")
//    @AdminLogin
    public ModelAndView edit(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        Book book = bookService.getBookById(id);
        mv.addObject("book", book);
        mv.setViewName("admin/book/bookedit");
        return mv;
    }

    @PostMapping("/update")
    @ResponseBody
//    @AdminLogin
    public Result update(Book param) {
        if (bookService.updateBook(param) == 1) {
            return Result.succeed();
        } else {
            return Result.fail();
        }
    }
}
