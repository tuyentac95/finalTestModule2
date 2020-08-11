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
                case 4:
                case 5:
                case 6:
                case 7:
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
