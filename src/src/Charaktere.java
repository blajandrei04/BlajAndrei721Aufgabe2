import java.util.ArrayList;
import java.util.List;

public class Charaktere {
    private int id;
    private String name;
    private String Herkunftsort;
    private List<Produkte> Produkte;
    public Charaktere(int id, String name, String Herkunftsort) {
        this.id = id;
        this.name = name;
        this.Herkunftsort = Herkunftsort;
        Produkte = new ArrayList<Produkte>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsort() {
        return Herkunftsort;
    }

    public void setHerkunftsort(String herkunftsort) {
        Herkunftsort = herkunftsort;
    }

    public List<Produkte> getProdukte() {
        return Produkte;
    }

    public void setProdukte(List<Produkte> produkte) {
        Produkte = produkte;
    }

    @Override
    public String toString() {
        return "Charaktere{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Herkunftsort='" + Herkunftsort + '\'' +
                ", Produkte=" + Produkte +
                '}';
    }

}
