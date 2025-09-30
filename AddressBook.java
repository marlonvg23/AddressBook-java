import java.io.*;
import java.util.*;

public class AddressBook {
    private HashMap<String, String> contacts; // Teléfono -> Nombre
    private String fileName;

    public AddressBook(String fileName) {
        this.contacts = new HashMap<>();
        this.fileName = fileName;
    }

    // --- Cargar contactos desde archivo ---
    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            contacts.clear();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    contacts.put(data[0], data[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo, se creará uno nuevo al guardar.");
        }
    }

    // --- Guardar contactos en archivo ---
    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos: " + e.getMessage());
        }
    }

    // --- Mostrar contactos ---
    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // --- Crear un nuevo contacto ---
    public void create(String phone, String name) {
        if (contacts.containsKey(phone)) {
            System.out.println("Ya existe un contacto con ese número.");
        } else {
            contacts.put(phone, name);
            System.out.println("Contacto agregado correctamente.");
        }
    }

    // --- Eliminar contacto ---
    public void delete(String phone) {
        if (contacts.remove(phone) != null) {
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("No se encontró un contacto con ese número.");
        }
    }
}
