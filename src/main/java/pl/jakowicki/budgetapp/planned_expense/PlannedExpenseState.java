package pl.jakowicki.budgetapp.planned_expense;

import org.springframework.stereotype.Component;

public enum PlannedExpenseState {

    OPEN("Otwarty"), CLOSE("Zamknięty");

    private final String name;

    PlannedExpenseState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
