import java.io.*;
import java.util.ArrayList;

public class PhoneBookManager {
    private ArrayList<PhoneBook> phoneBookList;
    private String path ="";
    private File file;

    public PhoneBookManager() {
        this.file = new File(path);
        this.phoneBookList = new ArrayList<>();
    }

    public void displayList() {
        for (PhoneBook phoneBook : phoneBookList) {
            System.out.println(phoneBook);
        }
    }

    public void addPhoneBook(PhoneBook phoneBook) {
        phoneBookList.add(phoneBook);
    }

    public void removePhoneBook(PhoneBook phoneBook) {
        phoneBookList.remove(phoneBook);
    }

    public int searchPhoneBook(String numberPhone) {
        for (PhoneBook phoneBook : phoneBookList) {
            if (phoneBook.getPhoneNumber().equals(numberPhone)) {
                return phoneBookList.indexOf(phoneBook);
            }
        }
        return -1;
    }

    public void writeFile(ArrayList<PhoneBook> phoneBooks) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (PhoneBook phoneBook : phoneBooks) {
            String[] info = phoneBook.infoToString();
            bufferedWriter.write(info[0]);
            for (int i=1; i < info.length; i++) {
                bufferedWriter.write("," + info[i]);
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.close();
    }

    public ArrayList<PhoneBook> readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList<PhoneBook> newList = new ArrayList<>();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");
            PhoneBook newPhoneBook = new PhoneBook(info[0]);
            newPhoneBook.setGroup(info[1]);
            newPhoneBook.setName(info[2]);
            newPhoneBook.setGender(info[3]);
            newPhoneBook.setAddress(info[4]);
            newPhoneBook.setAddress(info[5]);
            newPhoneBook.setEmail(info[6]);
            newList.add(newPhoneBook);
        }
        return newList;
    }
}
