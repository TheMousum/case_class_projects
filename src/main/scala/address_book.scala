import scala.collection.mutable.Map

// Contact class representing individual contacts with name, phone number, and email
case class Contact(name: String, phoneNumber: String, email: String)

// AddressBook class with methods to add contacts, view all contacts, search, and remove contacts
class AddressBook {
  private val contacts: Map[String, Contact] = Map()

  // Method to add a new contact
  def addContact(name: String, phoneNumber: String, email: String): Unit = {
    contacts += (name.toLowerCase -> Contact(name, phoneNumber, email))
    println(s"Contact '$name' added successfully.")
  }

  // Method to view all contacts
  def viewAllContacts(): Unit = {
    println("All contacts:")
    contacts.values.foreach(contact => println(s"Name: ${contact.name}, Phone: ${contact.phoneNumber}, Email: ${contact.email}"))
  }

  // Method to search for a contact by name
  def searchContact(name: String): Unit = {
    val lowerCaseName = name.toLowerCase
    if (contacts.contains(lowerCaseName)) {
      val contact = contacts(lowerCaseName)
      println(s"Contact found - Name: ${contact.name}, Phone: ${contact.phoneNumber}, Email: ${contact.email}")
    } else {
      println(s"No contact found with name '$name'.")
    }
  }

  // Method to remove a contact by name
  def removeContact(name: String): Unit = {
    val lowerCaseName = name.toLowerCase
    if (contacts.contains(lowerCaseName)) {
      contacts -= lowerCaseName
      println(s"Contact '$name' removed successfully.")
    } else {
      println(s"No contact found with name '$name'.")
    }
  }
}

// Main object to run the program
object Main {
  def main(args: Array[String]): Unit = {
    val addressBook = new AddressBook()

    addressBook.addContact("John Doe", "1234567890", "john.doe@example.com")
    addressBook.addContact("Alice Smith", "9876543210", "alice.smith@example.com")
    addressBook.addContact("Bob Johnson", "5551112233", "bob.johnson@example.com")

    addressBook.viewAllContacts()

    println("Search contact by name 'Alice Smith':")
    addressBook.searchContact("Alice Smith")

    println("Remove contact by name 'Bob Johnson':")
    addressBook.removeContact("Bob Johnson")

    addressBook.viewAllContacts()
  }
}
