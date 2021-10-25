package manager;

import model.Phonebook;

import java.util.List;

public class PhoneBookManager {
    List<Phonebook> phonebookList;

    public PhoneBookManager(List<Phonebook> phonebookList) {
        this.phonebookList = phonebookList;
    }

    public List<Phonebook> getPhonebookList() {
        return phonebookList;
    }

    public void setPhonebookList(List<Phonebook> phonebookList) {
        this.phonebookList = phonebookList;
    }

    public Phonebook findPhoneBookByPhoneNumber(String phoneNumber) {
        Phonebook phonebook = null;
        for (int i = 0; i < phonebookList.size(); i++) {
            if (phoneNumber.equals(phonebookList.get(i).getPhoneNumber())) {
                phonebook = phonebookList.get(i);
                break;
            }
        }
        return phonebook;
    }

    public void addNewPhoneBook(Phonebook phonebook) {
        phonebookList.add(phonebook);
    }

    public Phonebook deletePhoneBook(String phoneNumber) {
        Phonebook deletedPhonebook = findPhoneBookByPhoneNumber(phoneNumber);
        phonebookList.remove(deletedPhonebook);
        return deletedPhonebook;
    }

    public void updatePhoneBook(String phoneNumber, String newGroup, String newName, String newDateOfBirth, String newGender, String newAddress, String newEmail) {
        Phonebook updatePhonebook = findPhoneBookByPhoneNumber(phoneNumber);
        updatePhonebook.setGroup(newGroup);
        updatePhonebook.setName(newName);
        updatePhonebook.setGender(newGender);
        updatePhonebook.setAddress(newAddress);
        updatePhonebook.setDateOfBirth(newDateOfBirth);
        updatePhonebook.setEmail(newEmail);
    }


}

