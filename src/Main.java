import model.Contact;
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
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    service.listAllContacts();
                    break;

                case 3:
                    String keyword = InputUtil.getString("Enter name to search: ");
                    Contact found = service.searchByName(keyword);

                    if (found != null) {
                        System.out.println("Contact found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    int updateId = InputUtil.getInt("Enter ID to update: ");
                    String newName = InputUtil.getString("New Name: ");
                    String newPhone = InputUtil.getString("New Phone: ");
                    String newEmail = InputUtil.getString("New Email: ");

                    boolean updated = service.updateContact(updateId, newName, newPhone, newEmail);

                    if (updated) {
                        System.out.println("Contact updated successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5:
                    int deleteId = InputUtil.getInt("Enter ID to delete: ");
                    boolean deleted = service.deleteContact(deleteId);

                    if (deleted) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
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