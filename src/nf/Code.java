/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author Peuillon
 */
public enum Code {
    enregistrement(3),
    numerisation(5);
    private int cout;
    
    Code(int cout){
        this.cout = cout;
    }
    public int coutExam(){
        return this.cout;
    }
}
