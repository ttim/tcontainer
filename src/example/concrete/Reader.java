package example.concrete;

import example.spec.IReader;

/**
 * Date: Apr 1, 2010
 * Time: 3:10:15 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class Reader implements IReader {
    public String read() {
        return "Test";
    }
}
