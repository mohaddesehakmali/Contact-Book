import service.PhoneBookService;
import util.InputUtil;

public class Main {

    public static void main(String[] args) {

        PhoneBookService service = new PhoneBookService();

        while (true) {
            System.out.println("\n===== PHONEBOOK MENU =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("0. Exit");

            int choice = InputUtil.getInt("Choose an option: ");

            switch (choice) {
                case 1:
                    String name = InputUtil.getString("Name: ");
                    String phone = InputUtil.getString("Phone: ");
                    String email = InputUtil.getString("Email: ");
                    service.addContact(name, phone, email);
                    break;

                case 2:
                    service.listAllContacts();
                    break;

                case 3:
                    String search = InputUtil.getString("Enter name to search: ");
                    service.searchByName(search);
                    break;

                case 4:
                    int updateId = InputUtil.getInt("Enter ID to update: ");
                    String newName = InputUtil.getString("New Name: ");
                    String newPhone = InputUtil.getString("New Phone: ");
                    String newEmail = InputUtil.getString("New Email: ");
                    service.updateContact(updateId, newName, newPhone, newEmail);
                    break;

                case 5:
                    int deleteId = InputUtil.getInt("Enter ID to delete: ");
                    service.deleteContact(deleteId);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}