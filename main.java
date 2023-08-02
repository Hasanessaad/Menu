import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main( String args[] ) {
        List<Client> clients = new ArrayList<>();
        Scanner myInput = new Scanner(System.in);
        int option;
        boolean exit = false;

        do {
            System.out.println("1-Cadastrar");
            System.out.println("2-Listar");
            System.out.println("3-Search");
            System.out.println("4-Sair");
            option = myInput.nextInt();

            switch (option) {
                case 1:
                    System.out.println("}-CADASTRAR-{");
                    System.out.println("name: ");
                    myInput.nextLine();
                    String name = myInput.nextLine();
                    System.out.println("AGE: ");
                    int age = myInput.nextInt();

                    System.out.println("how many addresses do you wish to have : ");
                    int x = myInput.nextInt();
                    List<Address> addresses = new ArrayList<>();
                    for (int i = 0; i < x; i++) {
                        System.out.println("Address: ");
                        myInput.nextLine();
                        String street = myInput.nextLine();
                        System.out.println("street number: ");
                        int numb = myInput.nextInt();
                        addresses.add(new Address(street, numb));
                    }
                    clients.add(new Client(name, age, addresses));
                    break;
                case 2:
                    System.out.println("}-LISTAR-{");
                    for (Client client : clients) {
                        System.out.println("Nome: " + client.getName());
                        System.out.println("Idade: " + client.getAge());

                        List<Address> addresses1 = client.getAddresses();
                        for (int i = 0; i < addresses1.size(); i++) {
                            Address addresses2 = addresses1.get(i);
                            System.out.println("Endereço: " + (i + 1) + ":");
                            System.out.println("  Rua: " + addresses2.getStreet());
                            System.out.println("  Número: " + addresses2.getNumb());
                        }
                    }
                        break;
                        case 3:
                            System.out.print("Enter the name to search for: ");
                            myInput.nextLine();
                            String searchName = myInput.nextLine();
                            boolean found = false;

                            for (Client client : clients) {
                                if (client.getName().equalsIgnoreCase(searchName)) {
                                    System.out.println("}-CLIENTE ENCONTRADO-{");
                                    System.out.println("Nome: " + client.getName());
                                    System.out.println("Idade: " + client.getAge());

                                    List<Address> addresses1 = client.getAddresses();
                                    for (int i = 0; i < addresses1.size(); i++) {
                                        Address addresses2 = addresses1.get(i);
                                        System.out.println("Endereço " + (i + 1) + ":");
                                        System.out.println("  Rua: " + addresses2.getStreet());
                                        System.out.println("  Número: " + addresses2.getNumb());
                                    }

                                    found = true;
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("}-CLIENTE NÃO ENCONTRADO-{");
                            }
                            break;
                        case 4:
                            System.out.printf("Closing system...");
                            exit = true;
                            break;
                        default:
                            System.out.printf("Error");
                            break;
                    }

            }while (exit != true) ;
        }
    }


