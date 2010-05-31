package example.concrete;

import example.spec.ICopier;
import example.spec.IReader;
import example.spec.IWriter;

/**
 * Date: Apr 1, 2010
 * Time: 3:10:21 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class Copier implements ICopier {
    private IReader reader;
    private IWriter writer;

    private String prefix;
    private int repeatCount;

    public Copier() {
        System.out.println("copier constructor");
    }

    public void setReader(IReader reader) {
        this.reader = reader;
    }

    public void setWriter(IWriter writer) {
        this.writer = writer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public void copy() {
        writer.write(prefix);
        for (int i = 0; i < repeatCount; i++) {
            writer.write(reader.read());
        }
    }
}
