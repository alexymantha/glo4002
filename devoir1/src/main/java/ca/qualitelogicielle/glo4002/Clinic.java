package ca.qualitelogicielle.glo4002;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    TriageType doctorTriage;
    TriageType radioTriage;
    private List<Patient> radioList;
    private List<Patient> doctorList;

    public Clinic(TriageType doctor, TriageType radio) {
        doctorTriage = doctor;
        radioTriage = radio;
        radioList = new ArrayList<>();
        doctorList = new ArrayList<>();
    }

    public boolean isClinicEmpty() {
        return radioList.isEmpty() && doctorList.isEmpty();
    }

    public void addPatient(Patient newPatient) {
        if (newPatient.symptom != VisibleSymptom.CORONAVIRUS) {
            if (doctorTriage == TriageType.FIFO) {
                doctorList.add(newPatient);
            } else if (doctorTriage == TriageType.GRAVITY) {
                if (newPatient.gravity <= 5) {
                    doctorList.add(newPatient);
                } else if (newPatient.gravity > 5) {
                    doctorList.add(0, newPatient);
                }
            }

            if (radioTriage == TriageType.FIFO) {
                if (newPatient.symptom == VisibleSymptom.SPRAIN
                        || newPatient.symptom == VisibleSymptom.BROKEN_BONE) {
                    radioList.add(newPatient);
                }
            } else if (radioTriage == TriageType.GRAVITY) {
                if (newPatient.symptom == VisibleSymptom.SPRAIN
                        || newPatient.symptom == VisibleSymptom.BROKEN_BONE) {
                    if (newPatient.gravity <= 5) {
                        radioList.add(newPatient);
                    } else if (newPatient.gravity > 5) {
                        radioList.add(0, newPatient);
                    }
                }
            }
        }
    }

    public int getdoctorListLenght() {
        return doctorList.size();
    }

    public int getradioListLenght() {
        return radioList.size();
    }

    public Patient getPatientAtPositionDoctorList(int i) {
        return doctorList.get(i - 1);
    }

    public Patient getPatientAtPositionRadioList(int i) {
        return radioList.get(i - 1);
    }
}
