package com.NaeimSalib.ContactsApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired private ContactRepository repo;

    public List<Contacts> listAll(){

        return (List<Contacts>) repo.findAll();
    }

    public void save(Contacts contacts) {

        repo.save(contacts);
    }
    public Contacts get(Integer id) throws ContactNotFoundException {
       Optional<Contacts> result = repo.findById(id);
       if(result.isPresent()){
           return result.get();
       }
        throw new ContactNotFoundException("Contact was not found with ID: " + id);
    }

    public void delete(Integer id) throws ContactNotFoundException {
        Long count = repo.countById(id);

        if(count == null || count == 0){
            throw new ContactNotFoundException("Contact was not found with ID: " + id);
        }

        repo.deleteById(id);
    }

}


