package com.gdpu.controller;

import com.gdpu.common.vo.BookInfoQuery;
import com.gdpu.common.vo.BorrowInfoQuery;
import com.gdpu.common.vo.Result;
import com.gdpu.entity.Book;
import com.gdpu.entity.BookInfo;
import com.gdpu.entity.BorrowInfo;
import com.gdpu.entity.User;
import com.gdpu.service.BookInfoService;
import com.gdpu.service.BorrowInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/borrowinfo")
public class BorrowInfoController {

    private final BorrowInfoService borrowInfoService;

    @Autowired
    public BorrowInfoController(BorrowInfoService borrowInfoService) {
        this.borrowInfoService = borrowInfoService;
    }

    @GetMapping("/list")
    @ResponseBody
    public Result list(BorrowInfoQuery param){
        List<BorrowInfo> borrowInfoList = borrowInfoService.find(param);
        return Result.succeed(borrowInfoList, borrowInfoService.findNum(param));
    }

    //选择要借的book进入确定页面
    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/borrowinfo/borrowinfoadd");
        return mv;
    }

    //选择要借的book进入确定页面
    //用户借书：
    //判断用户押金是否足够，不够不能进行最后确定
    //足够则减去用户的押金，
    @GetMapping("/borrow/{ids}")
    @ResponseBody
    public Result borrow(@PathVariable("ids") String ids,Book param){
        //设置日期格式
        String[] splitIds = ids.split(",");
        Integer[] intIds = new Integer[splitIds.length];
        for (int i = 0; i < splitIds.length; i++) {
            intIds[i] = Integer.parseInt(splitIds[i]);
        }
        // 根据每一个id创建多条 borrow_info
        for (int i =0;i< intIds.length;i++) {
            BorrowInfo borrowInfo = new BorrowInfo();
            //书目id
            borrowInfo.setBookInfo(param.getBookInfo());
            //书本id
            borrowInfo.setBook(intIds[i]);
            //创建日期
            borrowInfo.setCreateTime(new Date());
            borrowInfoService.addBorrowInfo(borrowInfo);
        }
        return Result.succeed();
    }
    //根据 book.id 创建一行 borrow_info
    //将这条borrow_info的id 在对应book里更新
    //borrow_info state默认为0，代表这条记录待管理员审批
    //管理员审批： 同意： state 变为 1 代表正常被借出 拒绝： state变为2
    //同时将管理员id填入handler 时间填入 handle_time

    @GetMapping("/examine")
    @ResponseBody
    public Result Examine(BorrowInfo param){
        //设置日期格式
        if (borrowInfoService.updateBorrowInfo(param) == 1) {
            return Result.succeed();
        } else {
            return Result.fail();
        }
    }

    @DeleteMapping("/delete/{ids}")
    @ResponseBody
//    @AdminLogin
    public Result delete(@PathVariable("ids") String ids) {
        String[] splitIds = ids.split(",");
        Integer[] intIds = new Integer[splitIds.length];
        for (int i = 0; i < splitIds.length; i++) {
            intIds[i] = Integer.parseInt(splitIds[i]);
        }
        if (borrowInfoService.deleteBorrowInfosByIds(intIds) == 1) {
            return Result.succeed();
        } else {
            return Result.fail();
        }
    }

    @GetMapping("/edit/{id}")
//    @AdminLogin
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        BorrowInfo borrowInfo = borrowInfoService.getBorrowInfoById(id);
        mv.addObject("borrowInfo", borrowInfo);
        mv.setViewName("admin/borrowinfo/borrowinfoedit");
        return mv;
    }

    @PostMapping("/update")
    @ResponseBody
//    @AdminLogin
    public Result update(BorrowInfo param) {
        if (borrowInfoService.updateBorrowInfo(param) == 1) {
            return Result.succeed();
        } else {
            return Result.fail();
        }
    }
}
