package service;

import model.Book;
import model.Client;
import model.Document;
import persistance.BookDao;
import persistance.ClientDao;

import java.util.List;

public class EmployeeService {
    private ClientDao clientDao;
    private BookDao bookDao;


    public EmployeeService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void createClient(String firstName, String lastName) {
        Client client = Client.builder().firstName(firstName).lastName(lastName).build();
        clientDao.save(client);
    }

    public List<Client> findAllClients() {
        return clientDao.findAllClients();
    }

    public void createBook(String title, int nbPages, String type, String author, String editor, int publicationYear) {
        Book book = Book.builder().title(title).nbPages(nbPages).type(type).author(author)
                .editor(editor).publicationYear(publicationYear).build();
        bookDao.save(book);
    }
}
