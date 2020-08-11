import java.io.IOException;
import java.util.ArrayList;

public class DemoReadFile {


    public static void main(String[] args) throws IOException {
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        ArrayList<PhoneBook> newList = phoneBookManager.readFile();
        phoneBookManager.setPhoneBookList(newList);
        phoneBookManager.displayList();
    }
}
