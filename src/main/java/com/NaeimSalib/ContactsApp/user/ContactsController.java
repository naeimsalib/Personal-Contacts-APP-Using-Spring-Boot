package com.NaeimSalib.ContactsApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ContactsController {
    @Autowired private ContactService services;

    @GetMapping("/contacts")
    public String showUsersList(Model model){
        List<Contacts> listContacts = services.listAll();
        model.addAttribute("listContacts", listContacts);

        return "contacts";
    }

    @GetMapping("/contacts/new")
    public String showNewContactForm(Model model){
        model.addAttribute("contactsForm", new Contacts());
        model.addAttribute("pageTitle", "Add New Contacts");
        return "contacts_form";
    }

    @PostMapping("/contacts/save")
    public String addNewUser(Contacts contacts, RedirectAttributes ra){
        services.save(contacts);
        ra.addFlashAttribute("message", "Contact has Been Saved Successfully");
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try{
            Contacts contact = services.get(id);
            model.addAttribute("contactsForm", contact);
            model.addAttribute("pageTitle", "Edit Contact (ID: " + id + ")");
            return "contacts_form";
        }catch (ContactNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/contacts";
        }
    }

    @GetMapping("/contacts/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try{
            services.delete(id);
            return "contacts_form";
        }catch (ContactNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/contacts";
        }
    }
}
