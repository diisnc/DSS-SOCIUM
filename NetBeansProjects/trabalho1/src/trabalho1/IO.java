/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class IO {
    
    public void WriteHashMap(HashMap<String, SociUM> l) {

        // creating output stream variables

        FileOutputStream fileoutput = null;
        ObjectOutputStream objectoutput = null;

        try {

            // writing data
            fileoutput = new FileOutputStream("data");

            // converting object to binary
            objectoutput = new ObjectOutputStream(fileoutput);

            // writing HashMap to stream

            objectoutput.writeObject(l);
            objectoutput.flush();
            objectoutput.close();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
    
    public void ReadHashMap(HashMap<String, SociUM> l) {

       // creating a new hash to import object from file
       HashMap newHash = new HashMap();

       // creating input stream variables
       FileInputStream fileinput = null;
       ObjectInputStream objectinput = null;

       try {

            // reading data

            fileinput = new FileInputStream("data");

            // converting data to object
            objectinput = new ObjectInputStream(fileinput);

            // reading object's value and checking if input object is HashMap

            newHash = (HashMap<String, SociUM>) objectinput.readObject();
            if (!(newHash instanceof HashMap)){
                newHash = null;
                System.out.println("ERROR - input object is not Hashmap");
            }
            objectinput.close();
       }
       catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
       }
       catch (IOException ioex) {
            ioex.printStackTrace();
       }
       catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
       }


       l.putAll(newHash);

       }
    
}
