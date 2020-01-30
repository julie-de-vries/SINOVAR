/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir;

/**
 *
 * @author Peuillon
 */
public class Agenda {

    private final Patient patient;
    private final String jour;
    private final String heure;

    public Agenda(Patient p, String jour, String heure) {
        this.heure = heure;
        this.jour = jour;
        this.patient = p;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public String getJour() {
        return this.jour;
    }

    public String getHeure() {
        return this.heure;
    }
            
}
