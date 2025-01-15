import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }
    public void alleProdukteAnschreiben(){
        for (Produkte produkt: service.alleProdukteZuruckgeben())
            System.out.println(produkt);
    }
    public void alleKundenAnschreiben(){
        for (Charaktere charaktere: service.alleCharaktereZuruckgeben())
            System.out.println(charaktere);
    }
    public void createProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Herkunftsregion:");
        String herkunftsRegion = sc.nextLine();
        service.addProdukt(name, preis, herkunftsRegion);
    }
    public void showProdukt(){
        System.out.println("Gebe den Namen des Produktes ein: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Produkte produkt = service.getProdukt(name);
        System.out.println(produkt);
    }
    public void updateProduktValidate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geandert werden soll: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Herkunftsregion:");
        String herkunftsRegion = sc.nextLine();
        service.updateProdukt(new Produkte(name, preis, herkunftsRegion));
    }
    public void deleteProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geloescht werden soll: ");
        String name = sc.nextLine();
        service.deleteProdukt(name);
    }
    public void createCharaktere(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Ort: ");
        String ort = sc.nextLine();
        service.addCharakter(name,ort);
    }
    public void showKunde(){
        for (Charaktere kunde: service.alleCharaktereZuruckgeben())
            System.out.println(kunde);
        System.out.println("ID des Kundes:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(service.getKunde(id));
    }
    public void updateKundeValidate(){
        Scanner sc = new Scanner(System.in);

        System.out.println("ID des Charakter: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Neuer Name: ");
        String name = sc.nextLine();
        System.out.println("Neuer Ort: ");
        String ort = sc.nextLine();

        Charaktere charaktere = new Charaktere(id,name,ort);
        service.updateCharakter(charaktere);
    }
    public void deleteCharaktere(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID der Charakter: ");
        int id = sc.nextInt();
        sc.nextLine();
        service.deleteCharakter(id);
    }
    public void kundenNachOrtFiltrieren(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ort: ");
        String ort = sc.nextLine();
        for (Charaktere charaktere: service.filterNachOrt(ort))
            System.out.println(charaktere);
    }



}
