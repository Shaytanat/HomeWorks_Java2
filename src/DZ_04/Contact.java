package DZ_04;

import java.util.*;

public class Contact {
    private static HashMap<String, String> contacts = new HashMap<>();

    public void newContact(String sname, String phone) {
        contacts.put(sname, phone);
    }

    public List<String> getPhone(String name) {
        ArrayList<String> phones = new ArrayList<>();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(name)) {
                phones.add(entry.getKey());
            }
        }
        return phones;
    }

    public static void main(String[] args) {

        Contact phonebook = new Contact();
        phonebook.newContact("9058888888", "Петров");
        phonebook.newContact("9057777777", "Сидоров");
        phonebook.newContact("9056666666", "Моргунов");
        phonebook.newContact("9055555555", "Вицын");
        phonebook.newContact("9053333333", "Петров");
        phonebook.newContact("9054444444", "Никулин");


        Collection<String> values = contacts.values();

        Scanner request = new Scanner(System.in);
        System.out.println("Введите фамилию из указанных: " + values);
        String string = request.nextLine();

        System.out.println(phonebook.getPhone(string));

    }

}
