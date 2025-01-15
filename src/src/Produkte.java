public class Produkte {
    private String name;
    private double preis;
    private String Herkunftsregion;
    public Produkte(String name, double preis, String Herkunftsregion) {
        this.name = name;
        this.preis = preis;
        this.Herkunftsregion = Herkunftsregion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getHerkunftsregion() {
        return Herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        Herkunftsregion = herkunftsregion;
    }

    @Override
    public String toString() {
        return "Produkte{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                ", Herkunftsregion='" + Herkunftsregion + '\'' +
                '}';
    }

}
