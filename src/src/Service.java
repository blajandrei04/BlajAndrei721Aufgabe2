
import java.util.ArrayList;
import java.util.List;

public class Service {
    /**
     * Constructs a two Service objects with the specified repository.
     *
     * @param charaktererepository the charakter repository
     * @param produktRepository the produkt repoistory
     */
    private Repository<Charaktere> charaktereRepository;
    private Repository<Produkte> produktRepository;
    public Service(Repository<Charaktere> charaktereRepository, Repository<Produkte> produktRepository) {
        this.charaktereRepository = charaktereRepository;
        this.produktRepository = produktRepository;
    }

    /**
     * @return all Charakters from the repo
     *
     */
    public List<Charaktere> alleCharaktereZuruckgeben() {
        return charaktereRepository.getAllElements();
    }

    /**
     *
     * @return all Products from the repo
     */
    public List<Produkte> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }

    /**
     * Adds a product to the repo
     * @param name
     * @param preis
     * @param herkunftsregion
     */
    public void addProdukt(String name,int preis, String herkunftsregion){
        produktRepository.addElement(new Produkte(name,preis,herkunftsregion));
    }

    /**
     * Retrieves Product from his id
     * @param name
     * @return
     */
    public Produkte getProdukt(String name){
        int id = -1;
        for (Produkte p : produktRepository.getAllElements()) {
            if (p.getName().equals(name))
            {id = produktRepository.getAllElements().indexOf(p); break;}
        }
        return produktRepository.getElement(id);
    }

    /**
     * Updates the values of a product
     * @param produkt
     */
    public void updateProdukt(Produkte produkt){
        for (Produkte p : produktRepository.getAllElements()){
            if (p.getName().equals(produkt.getName())){
                int index = produktRepository.getAllElements().indexOf(p);
                p.setPreis(produkt.getPreis());
                p.setHerkunftsregion(produkt.getHerkunftsregion());
                produktRepository.updateElement(index,produkt);
                break;
            }
        }
    }

    /**
     * Deletes a product by its name
     * @param name
     */
    public void deleteProdukt(String name){
        for (Produkte p : produktRepository.getAllElements()){
            if (p.getName().equals(name)){
                produktRepository.remove(p);
                break;
            }
        }
    }

    /**
     * Adds a charakter to the repo
     * @param name
     * @param ort
     */
    public void addCharakter(String name, String ort){
        int id = -1;
        for (Charaktere k : charaktereRepository.getAllElements()){
            if (id < k.getId())
                id = k.getId();
        }
        id += 1;
        charaktereRepository.addElement(new Charaktere(id,name,ort));
    }

    /**
     *
     * @param id
     * @return retrieves a Charakter by its id
     */
    public Charaktere getKunde(int id){
        for (Charaktere p : charaktereRepository.getAllElements()) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("Kein Charakter gefunden");
    }

    /**
     * Updates the values of a charakter
     * @param charaktere
     */
    public void updateCharakter(Charaktere charaktere){
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == charaktere.getId()){
                int index = charaktereRepository.getAllElements().indexOf(p);
                p.setName(charaktere.getName());
                p.setHerkunftsort(charaktere.getHerkunftsort());
                charaktereRepository.updateElement(index,p);
                break;
            }
        }
    }

    /**
     * Deletes a charakter by its id
     * @param id
     */
    public void deleteCharakter(int id){
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == id){
                charaktereRepository.remove(p);
                break;
            }
        }
    }

    /**
     *
     * @param ort
     * @return a list of filteres charakter by the HerkunftsOrt
     */
    public List<Charaktere> filterNachOrt(String ort){
        List<Charaktere> charaktereList = new ArrayList<>();
        charaktereList = charaktereRepository.getAllElements().stream().filter(kunde -> ort.equals(kunde.getHerkunftsort())).toList();
        return charaktereList;
    }

}
