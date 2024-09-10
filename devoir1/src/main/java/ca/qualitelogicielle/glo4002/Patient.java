package ca.qualitelogicielle.glo4002;

import java.util.function.Predicate;

public class Patient {
    public VisibleSymptom symptom;
    public int gravity;

    public Patient(String name, int gravity, VisibleSymptom disease){
        symptom = disease;
        this.gravity = gravity;
    }
    public Patient(){}

}
