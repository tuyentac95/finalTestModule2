import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoReadFile {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
//        PhoneBookManager phoneBookManager = new PhoneBookManager();
//        ArrayList<PhoneBook> newList = phoneBookManager.readFile();
//        phoneBookManager.setPhoneBookList(newList);
//        phoneBookManager.displayList();

        String test = scanner.nextLine();
        System.out.println("<" + test + ">");
    }
}
