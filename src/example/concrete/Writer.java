package example.concrete;

import example.spec.IWriter;

/**
 * Date: Apr 1, 2010
 * Time: 3:10:08 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class Writer implements IWriter {
    public void write(String data) {
        System.out.println(data);
    }
}
