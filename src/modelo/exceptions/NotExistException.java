/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.exceptions;

/**
 *
 * @author Aluno
 */
public class NotExistException extends Exception {

    /**
     * Creates a new instance of <code>NotExistException</code> without detail
     * message.
     */
    public NotExistException() {
    }

    /**
     * Constructs an instance of <code>NotExistException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotExistException(String msg) {
        super(msg);
    }
}
