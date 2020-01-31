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
public enum Code {
    ENREGISTREMENT(3),
    NUMERISATION(5);
    private int cout;
    
    Code(int cout){
        this.cout = cout;
    }
    public int coutExam(){
        return this.cout;
    }
}
