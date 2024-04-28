package condicion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import config.Config;

public class Top10000 implements Condicion{
private File archivoRockyou= new File(Config.PATH_ARCHIVO_ROCKYOU);

    public boolean buscarPalabra(String contrasenia, File archivo) throws Exception {
    boolean estaEnElArchivo = false;
    try{
        if(archivo.exists()){
            BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
            String palabraLeida;
            while((palabraLeida = leerArchivo.readLine()) != null){
                if(palabraLeida.equals(contrasenia)){
                    estaEnElArchivo = true;
                    break;
                }
            }
            leerArchivo.close();
        }
    }catch (Exception e){
        throw new Exception("Error al buscar el archivo.", e);
    }
    return estaEnElArchivo;
}
    public boolean verificar(String nombreUsuario, String contrasenia) throws Exception {
        boolean esValida = !this.buscarPalabra(contrasenia, archivoRockyou);

        if(!esValida){
         throw new Exception("Su contraseña no es segura. Por favor, intente con otra contraseña");
        }else return esValida;
    }
}
