/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package library_management_system;

/**
 *
 * @author eru
 */
public class login_invalid extends Exception {

    /**
     * Creates a new instance of <code>login_invalid</code> without detail
     * message.
     */
    public login_invalid() {
    }

    /**
     * Constructs an instance of <code>login_invalid</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public login_invalid(String msg) {
        super(msg);
    }
}
