package DragonCharacteristics;

public enum DragonCharacter {
    EVIL("evil"),
    GOOD("good"),
    CHAOTIC_EVIL("chaotic evil"),
    FICKLE("fickle");

    private String tittle;

    private DragonCharacter(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }
}