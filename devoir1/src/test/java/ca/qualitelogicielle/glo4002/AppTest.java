package ca.qualitelogicielle.glo4002;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import ca.qualitelogicielle.glo4002.Clinic;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    @Test
    public void shouldCreateClinicWithRightTriageSystem() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        assertEquals(test.radioTriage, TriageType.FIFO);
        assertEquals(test.doctorTriage, TriageType.FIFO);

    }
    @Test
    public void shouldHaveAnEmptyTriage() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        assertEquals(test.isClinicEmpty(), true);
    }

    @Test
    public void shouldAcceptNewPatient() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        Patient John = new Patient();
        test.addPatient(John);
        assertEquals(test.isClinicEmpty(), false);
    }
    @Test
    public void shouldPatientHaveMigraineisInDoctorList() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        Patient John = new Patient("John", 119, VisibleSymptom.MIGRAINE);
        test.addPatient(John);
        assertEquals(test.getdoctorListLenght(), 1);
    }
    @Test
    public void shouldPatientHaveMigraineisNotInRadioList() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        Patient John = new Patient("John", 119, VisibleSymptom.MIGRAINE);
        test.addPatient(John);
        assertEquals(test.getradioListLenght(), 0);
    }
    @Test
    public void shouldPatientHaveFluisInDoctorList() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        Patient John = new Patient("John", 119, VisibleSymptom.MIGRAINE);
        Patient Bob = new Patient("Bob", 119, VisibleSymptom.FLU);
        test.addPatient(John);
        test.addPatient(Bob);
        assertEquals(test.getdoctorListLenght(), 2);
    }
    @Test
    public void shouldPatientHaveFluisNotInRadioList() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        Patient John = new Patient("John", 119, VisibleSymptom.MIGRAINE);
        Patient Bob = new Patient("Bob", 119, VisibleSymptom.FLU);
        test.addPatient(John);
        test.addPatient(Bob);
        assertEquals(test.getradioListLenght(), 0);
    }
    @Test
    public void shouldPatientBeSecondisSecondInList() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        Patient John = new Patient("John", 119, VisibleSymptom.MIGRAINE);
        Patient Bob = new Patient("Bob", 119, VisibleSymptom.FLU);
        test.addPatient(John);
        test.addPatient(Bob);
        assertEquals(test.getPatientAtPositionDoctorList(2), Bob);
        assertEquals(test.getradioListLenght(), 0);
    }

    @Test
    public void shouldPatientHaveSprainisInDoctorListAndRadioList() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        Patient Mario = new Patient("Mario", 3, VisibleSymptom.SPRAIN);
        test.addPatient(Mario);
        assertEquals(test.getdoctorListLenght(), 1);
        assertEquals(test.getradioListLenght(), 1);
    }
    @Test
    public void shouldPatientHaveBrokenBoneisInDoctorListAndRadioList() {

        TriageType DoctorTriage = TriageType.FIFO;
        TriageType RadiologieTriage = TriageType.FIFO;
        Clinic test = new Clinic(DoctorTriage, RadiologieTriage);
        Patient Luigi = new Patient("Luigi", 1, VisibleSymptom.BROKEN_BONE);
        test.addPatient(Luigi);
        assertEquals(test.getdoctorListLenght(), 1);
        assertEquals(test.getradioListLenght(), 1);
    }


}
