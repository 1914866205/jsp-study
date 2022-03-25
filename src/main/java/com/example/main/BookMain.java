package com.example.main;

import com.example.dao.BookDao;
import com.example.demo.JDBCConnection;
import com.example.domain.bean.Book;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @ClassName BookMain
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/3/25 12:37
 * @Version 1.0
 **/
public class BookMain {
    public static void main(String[] args) throws SQLException {
        BookDao bookDao = new BookDao(new JDBCConnection());
        int id;
        String name;
        String author;
        double money;
        Book book;
        while (true) {
            System.out.println("Enter your choice\n" +
                    "1 - list all books\n" +
                    "2 - find book by its id\n" +
                    "3 - update a book\n" +
                    "4 - add a new book\n" +
                    "5 - delete an book by id\n" +
                    "6 - end program");
            Scanner sc = new Scanner(System.in);
            int result = sc.nextInt();
            switch (result) {
                case 1:
                    System.out.println(bookDao.allBooks());
                    break;
                case 2:
                    System.out.println("请输入要查询的书的id");
                    id = sc.nextInt();
                    System.out.println(bookDao.findBookById(id));
                    break;
                case 3:
                    System.out.println("请输入要更新的书的信息：id 书名 价格 作者");
                    Scanner scanner1 = new Scanner(System.in);
                    Scanner scanner2 = new Scanner(System.in);
                    Scanner scanner3 = new Scanner(System.in);
                    Scanner scanner4 = new Scanner(System.in);
                    id = scanner1.nextInt();
                    name = scanner2.nextLine();
                    money = scanner3.nextDouble();
                    author = scanner4.nextLine();
                    book = new Book(id, name, author, money);
                    System.out.println(bookDao.updateBook(book));
                    break;
                case 4:
                    System.out.println("请输入要添加的书的信息：id 书名 价格 作者");
                    Scanner scanner5 = new Scanner(System.in);
                    Scanner scanner6 = new Scanner(System.in);
                    Scanner scanner7 = new Scanner(System.in);
                    Scanner scanner8 = new Scanner(System.in);
                    id = scanner5.nextInt();
                    name = scanner6.nextLine();
                    money = scanner7.nextDouble();
                    author = scanner8.nextLine();
                    book = new Book(id, name, author, money);
                    System.out.println(bookDao.insertBook(book));
                    break;
                case 5:
                    System.out.println("请输入要删除的书的id");
                    id = sc.nextInt();
                    System.out.println(bookDao.deleteBookById(id));
                    break;
                case 6:
                    System.out.println("结束程序");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
    }
}
