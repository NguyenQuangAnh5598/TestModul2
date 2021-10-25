package view;

import manager.PhoneBookManager;
import model.Phonebook;
import storage.IOPhoneBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Phonebook> phonebookList = new ArrayList<>();
    static PhoneBookManager phoneBookManager = new PhoneBookManager(phonebookList);
    static IOPhoneBook ioPhoneBook = IOPhoneBook.getInstance();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("~~~~~QUẢN LÝ DANH BẠ~~~~~");
            System.out.println("Chọn chức năng :");
            System.out.println("0. Thoát");
            System.out.println("1. In danh sách");
            System.out.println("2. Thêm mới danh bạ");
            System.out.println("3. Cập nhật danh bạ");
            System.out.println("4. Xóa danh bạ");
            System.out.println("5. Tìm kiếm danh bạ");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");

            System.out.println("Chọn chức năng");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printPhoneBookList();
                    break;
                case 2:
                    addNewPhoneBook();
                    break;
                case 3:
                    updatePhoneBookByPhoneNumber();
                    break;
                case 4:
                    deletePhoneBookByPhoneNumber();
                    break;
                case 5:
                    findPhoneBookByPhoneNumber();
                    break;
                case 6:
                    readFile();
                    break;
                case 7:
                    writeFile();
                    break;
            }
        } while (choice != 0);


    }

    public static void printPhoneBookList() {
        for (int i = 0; i < phonebookList.size(); i++) {
            System.out.println(phonebookList.get(i));
        }
    }

    public static void findPhoneBookByPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại bạn muốn tìm");
        String phoneNumber = scanner.nextLine();
        int count = 0;
        while (count == 0) {
            for (int i = 0; i < phonebookList.size(); i++) {
                if (phoneNumber.equals(phonebookList.get(i).getPhoneNumber())) {
                    System.out.println(phonebookList.get(i));
                    count = 1;
                    break;
                }
                System.out.println("Không có số liên lạc cần tìm, Nhập lại đi");
                phoneNumber = scanner.nextLine();
            }
        }
    }

    public static void addNewPhoneBook() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập tên nhóm : ");
        String groud = scanner.nextLine();
        System.out.println("Nhập tên người bạn muốn thêm :");
        String name = scan.nextLine();
        System.out.println("Nhập Ngày Tháng Năm sinh :");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập giới tính : ");
        String gender = scan.nextLine();
        System.out.println("Nhập số điện thoại : ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập địa chỉ : ");
        String address = scan.nextLine();
        System.out.println("Nhập Email : ");
        String email = scanner.nextLine();

        Phonebook phonebook = new Phonebook(groud, name, dateOfBirth, gender, phoneNumber, address, email);
        phoneBookManager.addNewPhoneBook(phonebook);
    }

    public static void deletePhoneBookByPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại của người bạn muốn xóa danh bạ :");
        String phoneNumber = scanner.nextLine();
        int count = 0;
        while (count == 0) {
            for (int i = 0; i < phonebookList.size(); i++) {
                if (phoneNumber.equals(phonebookList.get(i).getPhoneNumber())) {
                    Phonebook deletedPhoneBook = phoneBookManager.deletePhoneBook(phoneNumber);
                    System.out.println("Đã xóa số liên lạc : " + deletedPhoneBook);
                    count = 1;
                    break;
                }
            }
            System.out.println("Không có số liên lạc cần tìm, Nhập lại đi");
            phoneNumber = scanner.nextLine();
        }
    }

    public static void updatePhoneBookByPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập số điện thoại của người mà bạn muốn sửa thông tin : ");
        String phoneNumber = scan.nextLine();

        int count = 0;
        while (count == 0) {
            for (int i = 0; i < phonebookList.size(); i++) {
                if (phoneNumber.equals(phonebookList.get(i).getPhoneNumber())) {
                    count = 1;
                    break;
                }
            }
            System.out.println("Không có số liên lạc cần tìm, Nhập lại đi");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("Nhập tên nhóm mới : ");
        String newGroud = scanner.nextLine();
        System.out.println("Nhập tên mới :");
        String newName = scan.nextLine();
        System.out.println("Nhập Ngày Tháng Năm sinh mới :");
        String newDateOfBirth = scanner.nextLine();
        System.out.println("Nhập giới tính mới : ");
        String newGender = scan.nextLine();
        System.out.println("Nhập địa chỉ mới : ");
        String newAddress = scan.nextLine();
        System.out.println("Nhập Email mới : ");
        String newEmail = scanner.nextLine();

        phoneBookManager.updatePhoneBook(phoneNumber, newGroud, newName, newGender, newAddress, newDateOfBirth, newEmail);
    }

    public static void readFile() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên file bạn muốn đọc vào đây");
        String fileRead = scanner.nextLine();
        ioPhoneBook.readFile(fileRead);
    }

    public static void writeFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên file bạn muốn ghi vào đây");
        String fileWrite = scanner.nextLine();
        ioPhoneBook.writeFile(phonebookList, fileWrite);
    }
}
