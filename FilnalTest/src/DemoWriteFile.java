import java.io.IOException;
import java.util.ArrayList;

public class DemoWriteFile {
    public static void main(String[] args) throws IOException {
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        PhoneBook phoneBook1 = new PhoneBook("123");
        PhoneBook phoneBook2 = new PhoneBook("456");
        PhoneBook phoneBook3 = new PhoneBook("456");
        ArrayList<PhoneBook> newList = new ArrayList<>();
        newList.add(phoneBook1);
        newList.add(phoneBook2);
        newList.add(phoneBook3);
        phoneBookManager.writeFile(newList);
    }
}
