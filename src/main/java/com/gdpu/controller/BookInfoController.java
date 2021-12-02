package com.gdpu.controller;

import com.gdpu.annotation.AdminLogin;
import com.gdpu.common.vo.BookInfoQuery;
import com.gdpu.common.vo.BookQuery;
import com.gdpu.common.vo.Result;
import com.gdpu.entity.Book;
import com.gdpu.entity.BookInfo;
import com.gdpu.entity.User;
import com.gdpu.mapper.BookMapper;
import com.gdpu.service.BookInfoService;
import com.gdpu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/bookinfo")
public class BookInfoController {

    private final BookInfoService bookInfoService;

    @Autowired
    public BookInfoController(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    @GetMapping("/list")
    @ResponseBody
//    @AdminLogin
    public Result list(BookInfoQuery param){
        List<BookInfo> bookinfo = bookInfoService.find(param);
        return Result.succeed(bookinfo, bookInfoService.findNum(param));
    }

    @GetMapping("/add")
//    @AdminLogin
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/bookinfo/bookinfoadd");
        return mv;
    }

    @PostMapping("/addbookinfo")
//    @AdminLogin
    public Result add(BookInfo param) {
        int result = bookInfoService.addBookInfo(param);
        if (result == -1) {
            return Result.fail("书目已存在");
        } else {
            return Result.succeed();
        }
    }

    @DeleteMapping("/delete/{ids}")
    @ResponseBody
    public Result delete(@PathVariable("ids") String ids){
        String[] splitIds = ids.split(",");
        Integer[] intIds = new Integer[splitIds.length];
        for (int i = 0; i < splitIds.length; i++) {
            intIds[i] = Integer.parseInt(splitIds[i]);
        }
        if (bookInfoService.deleteBookInfosByIds(intIds)==1) {
            return Result.succeed();
        }else {
            return Result.fail();
        }
    }

    @GetMapping("/edit/{id}")
//    @AdminLogin
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        BookInfo bookInfo = bookInfoService.getBookInfoById(id);
        mv.addObject(bookInfo);
        mv.setViewName("admin/bookinfo/bookinfoedit");
        return mv;
    }

    @PostMapping("/update")
    @ResponseBody
//    @AdminLogin
    public Result update(BookInfo param) {
        if (bookInfoService.updateBookInfo(param) == 1) {
            return Result.succeed();
        } else {
            return Result.fail();
        }
    }

}
