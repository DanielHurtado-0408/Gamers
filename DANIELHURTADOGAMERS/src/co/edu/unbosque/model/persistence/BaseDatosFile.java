  
package co.edu.unbosque.model.persistence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Representa los datos de persistencia que van a ser utilizados por el mundo y/o controlador
//es opcional: ser puede o no tener datos.

public class BaseDatosFile {


	private String ruta = "C:\\proyectoVacaciones\\archivos.out";
	private String rutaReg = "C:\\proyectoVacaciones\\registro.txt";

	private File f; 
	private FileOutputStream fos;     
	private DataOutputStream dos;
	private FileInputStream fis;     
	private DataInputStream dis;
	private List<GamerDTO> gamers;
	

	
	

	public BaseDatosFile() {
		// TODO Auto-generated constructor stub
	}



	public void escribirArchivo(List<GamerDTO> gamers) {
		String mensaje = "Registro de GAMER!";

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(rutaReg));
			out.writeObject(gamers);
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			mensaje = "Error de IO";
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GamerDTO> leerArchivo(List<GamerDTO> gamers) {
        ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(rutaReg));
	        gamers = (ArrayList<GamerDTO>)in.readObject();
	        in.close();
	        

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return gamers;
	}
	



	public String getRuta() {
		return ruta;
	}



	public void setRuta(String ruta) {
		this.ruta = ruta;
	}



	public String getRutaReg() {
		return rutaReg;
	}



	public void setRutaReg(String rutaReg) {
		this.rutaReg = rutaReg;
	}



	public File getF() {
		return f;
	}



	public void setF(File f) {
		this.f = f;
	}



	public FileOutputStream getFos() {
		return fos;
	}



	public void setFos(FileOutputStream fos) {
		this.fos = fos;
	}



	public DataOutputStream getDos() {
		return dos;
	}



	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}



	public FileInputStream getFis() {
		return fis;
	}



	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}



	public DataInputStream getDis() {
		return dis;
	}



	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}



	public List<GamerDTO> getGamers() {
		return gamers;
	}



	public void setGamers(List<GamerDTO> gamers) {
		this.gamers = gamers;
	}




	
}