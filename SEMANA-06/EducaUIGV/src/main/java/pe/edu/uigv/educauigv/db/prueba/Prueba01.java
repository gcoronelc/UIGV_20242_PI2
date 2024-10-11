package pe.edu.uigv.educauigv.db.prueba;

import java.sql.Connection;
import pe.edu.uigv.educauigv.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba01 {
	
	public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Conexión ok.");
			cn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
