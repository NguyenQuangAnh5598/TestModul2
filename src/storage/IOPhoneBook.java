package storage;

import model.Phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOPhoneBook {
    private static IOPhoneBook ioPhoneBook;

    public IOPhoneBook() {
    }

    public static IOPhoneBook getInstance() {
        if (ioPhoneBook == null) {
            ioPhoneBook = new IOPhoneBook();
        }
        return ioPhoneBook;
    }

    public List<Phonebook> readFile(String fileRead) throws IOException, ClassNotFoundException {
        File file = new File(fileRead);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Phonebook> studenTransciptList = (List<Phonebook>) object;
            objectInputStream.close();
            fileInputStream.close();
            return studenTransciptList;
        } else return new ArrayList<>();
    }

    public void writeFile(List<Phonebook> studenTransciptList,String fileWrite) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileWrite);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studenTransciptList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
