package service;

import model.*;
import persistance.*;

import java.util.List;

public class EmployeeService {
    private ClientDao clientDao;
    private BookDao bookDao;
    private DvdDao dvdDao;
    private CdDao cdDao;
    private DocumentDao documentDao;

    public EmployeeService(ClientDao clientDao, BookDao bookDao, DvdDao dvdDao, CdDao cdDao, DocumentDao documentDao ) {
        this.clientDao = clientDao;
        this.bookDao = bookDao;
        this.dvdDao = dvdDao;
        this.cdDao = cdDao;
        this.documentDao = documentDao;
    }

    public void createClient(String firstName, String lastName) {
        Client client = Client.builder().firstName(firstName).lastName(lastName).build();
        clientDao.save(client);
    }

    public List<Client> findAllClients() {
        return clientDao.findAllClients();
    }

    public void createBook(String title, int nbPages, String type, String author, String genre, String editor, int publicationYear) {
        Book book = Book.builder().title(title).nbPages(nbPages).type(type).genre(genre).author(author)
                .editor(editor).publicationYear(publicationYear).documentType("Book").build();
        bookDao.save(book);
    }

    public void createDvd(String title, int publicationYear, String author, String editor, String genre, int timeLength) {
        Dvd dvd = Dvd.builder().title(title).publicationYear(publicationYear).author(author).editor(editor).genre(genre)
                .timeLength(timeLength).documentType("Dvd").build();
        dvdDao.save(dvd);

    }

    public void createCd(String title, int publicationYear, String author, String editor, String genre, int timeLength) {
        Cd cd = Cd.builder().title(title).publicationYear(publicationYear).author(author).editor(editor).genre(genre)
                .timeLength(timeLength).documentType("Cd").build();
        cdDao.save(cd);
    }

    public List<Document> findAllBooks() {
        return bookDao.findAllBooks();
    }

    public List<Document> findAllDvds() {
        return dvdDao.findAllDvds();
    }

    public List<Document> findAllCds() {
        return cdDao.findAllCds();
    }

    public List<Document> findAllDocuments() {
        return documentDao.findAllDocuments();
    }

    public List<Document> findBooksByTitle(String title) {
        return bookDao.findBooksByTitle(title);
    }

    public List<Document> findBookByAuthor(String author) {
        return bookDao.findBookByAuthor(author);
    }

    public List<Document> findBookByYear(int year) {
        return bookDao.findBooksByYear(year);
    }

    public List<Document> findBooksByType(String genre) {
        return bookDao.findBooksByType(genre);
    }

    public Document findDocumentById(long i) {
        return documentDao.findDocumentById(i);
    }

    public Client findClientById(long i) {
        return clientDao.findClientById(i);
    }
}
