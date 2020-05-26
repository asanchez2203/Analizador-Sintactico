package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lector {
    private String filePath;
    private BufferedReader reader;
    
    public Lector(String filePath) throws FileNotFoundException{
        this.filePath = filePath;
        reader = new BufferedReader(new FileReader(this.filePath));
    }
    
    public String readLine() throws IOException{
        String line = reader.readLine();
        return (line!=null)? line : null;
    }
    
}