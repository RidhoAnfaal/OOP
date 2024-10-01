package Jobsheet4;

public class Railway {
    private String name;
    private String railwayClass;
    private Employee machinist;
    private Employee assistant;

    public Railway(String name, String railwayClass, Employee machinist) {
        this.name = name;
        this.railwayClass = railwayClass;
        this.machinist = machinist;
    }

    public Railway(String name, String railwayClass, Employee machinist, Employee assistant) {
        this.name = name;
        this.railwayClass = railwayClass;
        this.machinist = machinist;
        this.assistant = assistant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setRailwayClass(String railwayClass) {
        this.railwayClass = railwayClass;
    }

    public String getRailwayClass() {
        return this.railwayClass;
    }

    public void setMachinist(Employee machinist) {
        this.machinist = machinist;
    }

    public Employee getMachinist() {
        return this.machinist;
    }

    public void setAssistant(Employee assistant) {
        this.assistant = assistant;
    }

    public Employee getAssistant() {
        return this.assistant;
    }

    public String info() {
        String info = "";
        info += "Name: " + this.name + "\n";
        info += "RailWay Class: " + this.railwayClass + "\n";
        info += "Machinist: " + this.machinist.info() + "\n";
        info += "Assistan: " + this.assistant.info() + "\n";
        return info;
    }

}
