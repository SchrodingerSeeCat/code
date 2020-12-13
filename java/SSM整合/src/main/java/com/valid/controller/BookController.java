package com.valid.controller;

import com.valid.pojo.Books;
import com.valid.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    // 跳转到修改页面
    @GetMapping("/toUpdate")
    public String toUpdatePaper(int id, Model model) {
        Books books = bookService.queryById(id);
        model.addAttribute("QBooks", books);
        return "updateBook";
    }
    // 修改书籍
    @PostMapping("/updateBook")
    public String updateBook(Books books) {
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    // 删除书籍
    @GetMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    // 查询书籍
    @PostMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = bookService.queryBookByName(queryBookName);

        // 如果查询不到书籍返回全部书籍
        if (books == null) {
            return "redirect:/book/allBook";
        }
        List<Books> list = new ArrayList<>();
        list.add(books);
        model.addAttribute("list", list);
        return "allBook";
    }
}
