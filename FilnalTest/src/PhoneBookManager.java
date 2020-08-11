import java.io.*;
import java.util.ArrayList;

public class PhoneBookManager {
    private ArrayList<PhoneBook> phoneBookList;
    private String path ="FilnalTest\\data\\contacts.csv";
    private String header = "Số điện thoại,Nhóm,Họ tên,Giới tính, Ngày sinh,Địa chỉ,Email";;
    private File file;

    public PhoneBookManager() {
        this.file = new File(path);
        this.phoneBookList = new ArrayList<>();
    }

    public void setPhoneBookList(ArrayList<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    public void displayList() {
        System.out.println(header);
        for (PhoneBook phoneBook : phoneBookList) {
            System.out.println(phoneBook.getPhoneNumber()
                    + ", " + phoneBook.getGroup()
                    + ", " + phoneBook.getName()
                    + ", " + phoneBook.getGender()
                    + ", " + phoneBook.getAddress()
                    + ", " + phoneBook.getDateOfBirth()
                    + ", " + phoneBook.getEmail());
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
        bufferedWriter.write(header + "\n");
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
        bufferedReader.readLine();
        ArrayList<PhoneBook> newList = new ArrayList<>();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");
            PhoneBook newPhoneBook = new PhoneBook(info[0]);
            newPhoneBook.setGroup(info[1]);
            newPhoneBook.setName(info[2]);
            newPhoneBook.setGender(info[3]);
            newPhoneBook.setAddress(info[4]);
            newPhoneBook.setDateOfBirth(info[5]);
            newPhoneBook.setEmail(info[6]);
            newList.add(newPhoneBook);
        }
        return newList;
    }
}
