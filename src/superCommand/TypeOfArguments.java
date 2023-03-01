package superCommand;

public enum TypeOfArguments {
    INTEGER("Integer"),
    LONG("Long"),
    FLOAT("float"),
    STRING("String"),
    DOUBLE("double"),
    BOOLEAN("boolean");

    private String tittle;

    TypeOfArguments(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }
}
