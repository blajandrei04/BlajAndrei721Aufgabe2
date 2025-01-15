
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Service {
    private Repository<Charaktere> charaktereRepository;
    private Repository<Produkte> produktRepository;
    public Service(Repository<Charaktere> charaktereRepository, Repository<Produkte> produktRepository) {
        this.charaktereRepository = charaktereRepository;
        this.produktRepository = produktRepository;
    }
    public List<Charaktere> alleCharaktereZuruckgeben() {
        return charaktereRepository.getAllElements();
    }
    public List<Produkte> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }
    public void addProdukt(String name,int preis, String herkunftsregion){
        produktRepository.addElement(new Produkte(name,preis,herkunftsregion));
    }
    public Produkte getProdukt(String name){
        int id = -1;
        for (Produkte p : produktRepository.getAllElements()) {
            if (p.getName().equals(name))
            {id = produktRepository.getAllElements().indexOf(p); break;}
        }
        return produktRepository.getElement(id);
    }
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
    public void deleteProdukt(String name){
        for (Produkte p : produktRepository.getAllElements()){
            if (p.getName().equals(name)){
                produktRepository.remove(p);
                break;
            }
        }
    }
    public void addCharakter(String name, String ort){
        int id = -1;
        for (Charaktere k : charaktereRepository.getAllElements()){
            if (id < k.getId())
                id = k.getId();
        }
        id += 1;
        charaktereRepository.addElement(new Charaktere(id,name,ort));
    }
    public Charaktere getKunde(int id){
        for (Charaktere p : charaktereRepository.getAllElements()) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("Kein Charakter gefunden");
    }
    public void updateCharakter(Charaktere kunde){
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == kunde.getId()){
                int index = charaktereRepository.getAllElements().indexOf(p);
                p.setName(kunde.getName());
                p.setHerkunftsort(kunde.getHerkunftsort());
                charaktereRepository.updateElement(index,p);
                break;
            }
        }
    }
    public void deleteKunde(int id){
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == id){
                charaktereRepository.remove(p);
                break;
            }
        }
    }
    public List<Charaktere> filterNachOrt(String ort){
        List<Charaktere> charaktereList = new ArrayList<>();
        charaktereList = charaktereRepository.getAllElements().stream().filter(kunde -> ort.equals(kunde.getHerkunftsort())).toList();
        return charaktereList;
    }

}
