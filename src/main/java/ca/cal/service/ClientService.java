package ca.cal.service;
import ca.cal.model.*;
import ca.cal.persistance.*;

import java.time.LocalDateTime;

public class ClientService {
    private DocumentDao documentDao;
    private BorrowDao borrowDao;

    public ClientService(DocumentDao documentDao, BorrowDao borrowDao) {
        this.documentDao = documentDao;
        this.borrowDao = borrowDao;
    }

    public void createBorrow(Client client, Document document) {
        Borrow borrow;
        if(document instanceof Book){
            borrow = Borrow.builder().cLient(client).borrowedDocument(document).borrowDate(LocalDateTime.now()).
                    returnDate(LocalDateTime.now().plusWeeks(3)).build();
        }else if(document instanceof Dvd){
            borrow = Borrow.builder().cLient(client).borrowedDocument(document).borrowDate(LocalDateTime.now()).
                    returnDate(LocalDateTime.now().plusWeeks(1)).build();
        }else if(document instanceof Cd){
            borrow = Borrow.builder().cLient(client).borrowedDocument(document).borrowDate(LocalDateTime.now()).
                    returnDate(LocalDateTime.now().plusWeeks(2)).build();
        }else{
            throw new IllegalArgumentException("Failed to identify instance");
        }
        borrowDao.save(borrow);
    }
}
