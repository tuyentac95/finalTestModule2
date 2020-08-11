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
