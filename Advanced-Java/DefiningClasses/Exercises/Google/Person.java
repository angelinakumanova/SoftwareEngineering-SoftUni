package DefiningClasses.Exercises.Google;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons = new ArrayList<>();
    private List<Parent> parents = new ArrayList<>();
    private List<Child> children = new ArrayList<>();
    private Car car;

    public Person(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private String getPokemons() {
        StringBuilder pokemons = new StringBuilder();
        for (Pokemon pokemon : this.pokemons) {
            pokemons.append(pokemon).append("\n");
        }
        return pokemons.toString();
    }
    private String getParents() {
        StringBuilder parents = new StringBuilder();
        for (Parent parent : this.parents) {
            parents.append(parent).append("\n");
        }
        return parents.toString();
    }
    private String getChildren() {
        StringBuilder children = new StringBuilder();
        for (Child child : this.children) {
            children.append(child).append("\n");
        }
        return children.toString();
    }
    public String getInfo() {
        String company = this.company == null ? "Company:\n" : String.format("Company:%n" + "%s\n", this.company);
        String pokemons = this.pokemons == null ? "Pokemon:\n" : "Pokemon:\n" + getPokemons();
        String parents = this.parents == null ? "Parents:" : "Parents:\n" + getParents();
        String children = this.children == null ? "Children:" : "Children:\n" + getChildren();
        String car = this.car == null ? "Car:\n" : String.format("Car:%n" + "%s%n", this.car);
        return this.name + "\n" + company + car + pokemons + parents + children;
    }
}
