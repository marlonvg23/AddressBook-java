# AddressBook-java
Este proyecto implementa una agenda telefonica en java que permite almacenar contactos de forma sencilla. Los contactos se almacenaran en un archivo de texto. Al igual que la aplicacion incluye un menu interactivo con distintas opciones para Listar contactos, crear nuevo contacto, eliminar contacto, guardar y salir.
Clase AddressBook
•	Utiliza un HashMap<String, String> para almacenar los contactos en memoria.
	Clave - Número de teléfono
	Valor - Nombre del contacto
•	Métodos principales:
 load() - carga los contactos desde el archivo CSV.
 save() - guarda los contactos en el archivo CSV.
 list() - muestra todos los contactos en pantalla.
 create(String phone, String name) - agrega un nuevo contacto.
 delete(String phone) - elimina un contacto existente.

