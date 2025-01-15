
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }
    public Console() {}

    public void setController(Controller controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. Alles anschreiben
                    2. Produkt CRUD
                    3. Kunde CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {controller.alleKundenAnschreiben();
                    controller.alleProdukteAnschreiben();
                    break;}

                case 2: {
                    System.out.println("""
                            1. Neues Produkt hinzufugen
                            2. Alle Produkte sehen
                            3. Ein bestimmtes Produkt finden
                            4. Ein Produkt aktualisieren
                            5. Ein Produkt loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createProdukt(); break;}
                        case 2: {controller.alleProdukteAnschreiben(); break;}
                        case 3: {controller.showProdukt(); break;}
                        case 4: {controller.updateProduktValidate(); break;}
                        case 5: {controller.deleteProdukt(); break;}
                        case 0:break;
                    }
                }

                case 3:
                {
                    System.out.println("""
                            1. Neuer Kunde hinzufugen
                            2. Alle Kunden sehen
                            3. Einen bestimmten Kunden finden
                            4. Einen Kunden aktualisieren
                            5. Einen Kunden loschen
                            6. Kunden nach Ort filtrieren
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createCharaktere(); break;}
                        case 2: {controller.alleKundenAnschreiben(); break;}
                        case 3: {controller.showKunde(); break;}
                        case 4: {controller.updateKundeValidate(); break;}
                        case 5: {controller.deleteCharaktere(); break;}
                        case 6: {controller.kundenNachOrtFiltrieren(); break;}
                        case 0:break;
                    }
                }

                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkte> produktRepository = new Repository<>();
        Repository<Charaktere> charaktereRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(charaktereRepository,produktRepository);

        Service service = new Service(charaktereRepository, produktRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Charaktere> kundeRepository, Repository<Produkte> produktRepository) {
        Produkte produkt1 = new Produkte("50kg Dumbbell",400,"Fruhling");
        Produkte produkt2 = new Produkte("25kg Dumbbell",200,"Fruhling");
        Produkte produkt3 = new Produkte("10kg Dumbbell",100,"Sommer");
        Produkte produkt4 = new Produkte("Handtuch",70,"Sommer");
        Produkte produkt5 = new Produkte("Proteindose",150,"Herbst");
        Produkte produkt6 = new Produkte("Carbohydratpaket",200,"Winter");
        Produkte produkt7 = new Produkte("Wasserflasche",100,"Winter");

        produktRepository.addElement(produkt1);
        produktRepository.addElement(produkt2);
        produktRepository.addElement(produkt3);
        produktRepository.addElement(produkt4);
        produktRepository.addElement(produkt5);
        produktRepository.addElement(produkt6);
        produktRepository.addElement(produkt7);

        List<Produkte> listeKunde1 = new ArrayList<>();
        listeKunde1.add(produkt1); listeKunde1.add(produkt3); listeKunde1.add(produkt4);
        Charaktere kunde1 = new Charaktere(1,"Kevin","Lituanien");

        List<Produkte> listeKunde2 = new ArrayList<>();
        listeKunde2.add(produkt2); listeKunde2.add(produkt6);
        Charaktere kunde2 = new Charaktere(2,"Maria","Polen");

        List<Produkte> listeKunde3 = new ArrayList<>();
        listeKunde3.add(produkt3); listeKunde3.add(produkt5);
        Charaktere kunde3 = new Charaktere(3,"Markus","Amerika");
        List<Produkte> listeKunde4 = new ArrayList<>();
        listeKunde3.add(produkt1); listeKunde3.add(produkt5);
        Charaktere kunde4 = new Charaktere(3,"Aurelius","Amerika");

        kundeRepository.addElement(kunde1);
        kundeRepository.addElement(kunde2);
        kundeRepository.addElement(kunde3);
        kundeRepository.addElement(kunde4);
    }
}

