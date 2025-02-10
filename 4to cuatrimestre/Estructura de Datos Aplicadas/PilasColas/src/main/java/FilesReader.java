import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilesReader {
    public static void main(String[] args) {
        System.out.println("Prueba de lectura: ");
        //Aqui iran los contenidos de un archivo

        ArrayList<String> cadenas = obtenerLineas("hola.txt");

        System.out.println(cadenas.get(0) + "Esta linea es de java");
    }

    public static ArrayList<String> obtenerLineas(
            String ruta){
        ArrayList<String> contenido = new
                ArrayList<>();

        //Código
        // "ruta/del/archivo.txt"
        try(BufferedReader br =
                    new BufferedReader(
                            new FileReader(ruta)
                    )
        ){
            //Código para el try
            String linea;
            while((linea = br.readLine()) != null){
                System.out.println(linea);
                contenido.add(linea);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return contenido;
    }
}