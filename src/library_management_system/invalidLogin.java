/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package library_management_system;

/**
 *
 * @author eru
 */
public class invalidLogin extends Exception {

    /**
     * Creates a new instance of <code>invalidLogin</code> without detail
     * message.
     */
    public invalidLogin() {
    }

    /**
     * Constructs an instance of <code>invalidLogin</code> with the specified
     * detail message.
     *
     * @param message the detail message.
     */
    public invalidLogin(String message) {
        super(message);
    }
}
