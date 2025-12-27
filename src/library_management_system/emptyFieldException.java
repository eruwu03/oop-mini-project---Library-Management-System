/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package library_management_system;

/**
 *
 * @author nrnjm
 */
public class emptyFieldException extends Exception {

    /**
     * Creates a new instance of <code>emptyField</code> without detail message.
     */
    public emptyFieldException() {
    }

   
    public emptyFieldException(String message) {
        super(message);
    }
}
