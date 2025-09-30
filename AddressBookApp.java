import java.util.Scanner;

public class AddressBookApp {
    public static void main(String[] args) {
        AddressBook agenda = new AddressBook("contactos.csv");
        agenda.load();

        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- MENU---");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y salir");
            System.out.print("Selecciona una opcion: ");
            option = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (option) {
                case 1:
                    agenda.list();
                    break;
                case 2:
                    System.out.print("Número telefónico: ");
                    String phone = sc.nextLine();
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    agenda.create(phone, name);
                    break;
                case 3:
                    System.out.print("Número telefónico a eliminar: ");
                    String delPhone = sc.nextLine();
                    agenda.delete(delPhone);
                    break;
                case 4:
                    agenda.save();
                    System.out.println("Contactos guardados. Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 4);

        sc.close();
    }
}
