package com.NaeimSalib.ContactsApp.user;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contacts, Integer> {

   public Long countById(Integer id);
}
