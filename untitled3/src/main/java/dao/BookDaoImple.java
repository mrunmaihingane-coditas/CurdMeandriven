package dao;

import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImple implements BookDao {
    private static final Configuration CONFIGURATION = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Book.class);
    private static final SessionFactory SESSION_FACTORY = CONFIGURATION.buildSessionFactory();

    @Override
    public void insertBook(Book book) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction =session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();

    }

    @Override
    public List<Book> selectAllTodos() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Book", Book.class);
        List<Book> books = query.getResultList();
     return books;
    }

    @Override
    public boolean deleteTodo(int id) throws SQLException {
        Session session=SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Book book=session.get(Book.class,id);
        if(book!=null){
            session.delete(book);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    @Override
    public int updateTodo(int id,Book updatedBook) throws SQLException {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.get(Book.class, id);
        book.setBookname(updatedBook.getBookname());
        book.setPrice(updatedBook.getPrice());
        book.setAuthername(updatedBook.getAuthername());
        book.setPublisher(updatedBook.getPublisher());
        book.setPublishyear(updatedBook.getPublishyear());
        session.update(book);
        transaction.commit();
        session.close();
        return 1;

    }



}