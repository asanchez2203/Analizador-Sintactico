package test;

import LLDriver.LLDriver;
import java.io.IOException;

/**
 *
 * @author Alexis Sanchez
 */
public class TestLLDriver {
    public static void main(String[] args) throws IOException {
        LLDriver analizador = new LLDriver("src/Programas/programa.txt");
        analizador.run();
    }
}
