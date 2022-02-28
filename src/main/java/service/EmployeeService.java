package service;

import model.*;
import persistance.*;

import java.util.List;

public class EmployeeService {
    private ClientDao clientDao;
    private BookDao bookDao;
    private DvdDao dvdDao;
    private CdDao cdDao;

    public EmployeeService(ClientDao clientDao, BookDao bookDao, DvdDao dvdDao, CdDao cdDao) {
        this.clientDao = clientDao;
        this.bookDao = bookDao;
        this.dvdDao = dvdDao;
        this.cdDao = cdDao;
    }

    public void createClient(String firstName, String lastName) {
        Client client = Client.builder().firstName(firstName).lastName(lastName).build();
        clientDao.save(client);
    }

    public List<Client> findAllClients() {
        return clientDao.findAllClients();
    }

    public void createBook(String title, int nbPages, String type, String author,String genre, String editor, int publicationYear) {
        Book book = Book.builder().title(title).nbPages(nbPages).type(type).genre(genre).author(author)
                .editor(editor).publicationYear(publicationYear).build();
        bookDao.save(book);
    }

    public List<Book> findAllBooks() {
        return bookDao.findAllBooks();
    }


    public void createDvd(String title, int publicationYear, String author, String editor, String genre, int timeLength) {
        Dvd dvd = Dvd.builder().title(title).publicationYear(publicationYear).author(author).editor(editor).genre(genre)
                .timeLength(timeLength).build();
        dvdDao.save(dvd);

    }

    public void createCd(String title, int publicationYear, String author, String editor, String genre, int timeLength) {
        Cd cd = Cd.builder().title(title).publicationYear(publicationYear).author(author).editor(editor).genre(genre)
                .timeLength(timeLength).build();
        cdDao.save(cd);
    }
}
