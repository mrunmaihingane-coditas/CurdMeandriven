package web;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import dao.BookDaoImple;

public class App  {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("BOOK MANAGEMENT SYSTEM");

        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Book book = new Book();
        BookDaoImple bookDaoImple = new BookDaoImple();

        boolean flag = true;
        while (flag) {
            System.out.println("\nENTER 1: INSERT");
            System.out.println("ENTER 2: UPDATE");
            System.out.println("ENTER 3: DELETE");
            System.out.println("ENTER 4: SHOW");
            System.out.println("ENTER 0: EXIT");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter bid, price, Authername, Publisher, Publishyear");
                    book.setBid(Integer.parseInt(br.readLine()));
                    book.setBookname(br.readLine());
                    book.setPrice(Integer.parseInt(br.readLine()));
                    book.setAuthername(br.readLine());
                    book.setPublisher(br.readLine());
                    book.setPublishyear(Integer.parseInt(br.readLine()));
                    bookDaoImple.insertBook(book);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    //TODO: Implement update
                    System.out.println("Enter the id of the book to update:");
                    int id = Integer.parseInt(br.readLine());
                    System.out.println("Enter the updated details of the book:");
                    Book updatedBook = new Book();
                    updatedBook.setBookname(br.readLine());
                    updatedBook.setPrice(Integer.parseInt(br.readLine()));
                    updatedBook.setAuthername(br.readLine());
                    updatedBook.setPublisher(br.readLine());
                    updatedBook.setPublishyear(Integer.parseInt(br.readLine()));
                    int result = bookDaoImple.updateTodo(id, updatedBook);
                    if (result == 1) {
                        System.out.println("Book updated successfully!");
                    } else {
                        System.out.println("Book update failed.");
                    }
                    break;
                case 3:
                    //TODO: Implement delete
                    System.out.println("ENTER ID TO DELETE");
                    bookDaoImple.deleteTodo(Integer.parseInt(br.readLine()));
                    break;
                case 4:
                    //TODO: Implement show
                    List<Book> bookList = bookDaoImple.selectAllTodos();
                    for (Book book1 : bookList) {
                        System.out.println("Book ID: " + book1.getBid());
                        System.out.println("Book Name: " + book1.getBookname());
                        System.out.println("Author Name: " + book1.getAuthername());
                        System.out.println("Publisher: " + book1.getPublisher());
                        System.out.println("Publish Year: " + book1.getPublishyear());
                        System.out.println("Price: " + book1.getPrice());
                    }
                    break;
                case 0:
                    flag = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
