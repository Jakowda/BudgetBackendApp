package pl.jakowicki.budgetapp.budget;

public enum BudgetState {
    OPEN("Otwarty"), CLOSED("Zamknięty");

    private final String name;

    private BudgetState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
