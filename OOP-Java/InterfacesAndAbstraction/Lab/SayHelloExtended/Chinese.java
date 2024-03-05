package InterfacesAndAbstraction.Lab.SayHelloExtended;

public class Chinese extends BasePerson {

    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Ni hao";
    }
}
