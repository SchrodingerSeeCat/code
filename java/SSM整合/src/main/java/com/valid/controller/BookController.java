package com.valid.controller;

import com.valid.pojo.Books;
import com.valid.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/book")
@Controller
public class BookController {
    // controller 调 service层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    // 查询全部的书籍，并且返回给前端JSON字符串
    @GetMapping("/allBook")
    public String list(Model model) {
        model.addAttribute("list", bookService.queryAll());
        return "allBook";
    }

    // 跳转到增加书籍的页面
    @GetMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    // 添加书籍的请求
    @PostMapping("addBook")
    public String addBook(Books books) {
        System.out.println("addBook: " + books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
}
