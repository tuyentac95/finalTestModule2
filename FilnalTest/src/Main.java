import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        ArrayList<PhoneBook> phoneBookList = phoneBookManager.readFile();
        phoneBookManager.setPhoneBookList(phoneBookList);

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    phoneBookManager.displayList();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Nhập số điện thoại: ");
                    String newNumberPhone = scanner.nextLine();
                    System.out.println("Nhập nhóm:  ");
                    String newGroup = scanner.nextLine();
                    System.out.println("Nhập họ tên: ");
                    String newName = scanner.nextLine();
                    System.out.println("Nhập giới tính: ");
                    String newGender = scanner.nextLine();
                    System.out.println("Nhập địa chỉ: ");
                    String newAddress = scanner.nextLine();
                    System.out.println("Nhập ngày sinh: ");
                    String newDateOfBirth = scanner.nextLine();
                    System.out.println("Nhập email: ");
                    String newEmail = scanner.nextLine();

                    PhoneBook phoneBook = new PhoneBook(newNumberPhone,newGroup,newName,newGender,newAddress,newDateOfBirth,newEmail);
                    phoneBookList.add(phoneBook);
                    phoneBookManager.writeFile(phoneBookList);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Nhập số điện thoại: ");
                    String updatePhone = scanner.nextLine();
                    boolean checkPhone = false;
                    int index = -1;
                    while (!checkPhone && updatePhone != "\n") {
                        System.out.println("Không tìm được danh bạ của số điện thoại trên.");
                        System.out.println("Nhập lại số điện thoại");
                        updatePhone = scanner.nextLine();
                        for (PhoneBook phoneBook1 : phoneBookList) {
                            if (updatePhone.equals(phoneBook1.getPhoneNumber())) {
                                checkPhone = true;
                                index = phoneBookList.indexOf(phoneBook1);
                                break;
                            }
                        }
                    }
                    if (updatePhone == "\n") {
                        choice = -1;
                    } else {
                        System.out.println("Nhập nhóm:  ");
                        String updateGroup = scanner.nextLine();
                        System.out.println("Nhập họ tên: ");
                        String updateName = scanner.nextLine();
                        System.out.println("Nhập giới tính: ");
                        String updateGender = scanner.nextLine();
                        System.out.println("Nhập địa chỉ: ");
                        String updateAddress = scanner.nextLine();
                        System.out.println("Nhập ngày sinh: ");
                        String updateDateOfBirth = scanner.nextLine();
                        System.out.println("Nhập email: ");
                        String updateEmail = scanner.nextLine();

                        PhoneBook updatePhoneBook = phoneBookList.get(index);
                        updatePhoneBook.setGroup(updateGroup);
                        updatePhoneBook.setName(updateName);
                        updatePhoneBook.setGender(updateGender);
                        updatePhoneBook.setAddress(updateGender);
                        updatePhoneBook.setDateOfBirth(updateDateOfBirth);
                        updatePhoneBook.setEmail(updateEmail);
                        phoneBookList.set(index,updatePhoneBook);
                        phoneBookManager.writeFile(phoneBookList);
                    }
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Nhập số điện thoại muốn xóa: ");
                    String removeNumber = scanner.nextLine();

                    boolean checkPhonenum = false;
                    int newindex = -1;
                    while (!checkPhonenum && removeNumber != "\n") {
                        System.out.println("Không tìm được danh bạ của số điện thoại trên.");
                        System.out.println("Nhập lại số điện thoại");
                        removeNumber = scanner.nextLine();
                        for (PhoneBook phoneBook1 : phoneBookList) {
                            if (removeNumber.equals(phoneBook1.getPhoneNumber())) {
                                checkPhonenum = true;
                                newindex = phoneBookList.indexOf(phoneBook1);
                                break;
                            }
                        }
                    }
                    if (removeNumber == "\n") {
                        choice = -1;
                    } else {
                        phoneBookList.remove(newindex);
                        phoneBookManager.writeFile(phoneBookList);
                    }
                    break;
                case 5:
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.println("Thao tác này xóa bộ nhớ đang có! Đồng ý? (Y/N");
                    String confirm = scanner.nextLine();
                    if (confirm.equals("Y")) {
                        phoneBookList = phoneBookManager.readFile();
                    }
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println("Thao tác này xóa file đang có! Đồng ý? (Y/N");
                    String newConfirm = scanner.nextLine();
                    if (newConfirm.equals("Y")) {
                        phoneBookManager.writeFile(phoneBookList);
                    }
                    break;
                case 8:
                    choice = -1;
                    break;
            }

        }
    }

    private static void showMenu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chưc năng");
    }
}
