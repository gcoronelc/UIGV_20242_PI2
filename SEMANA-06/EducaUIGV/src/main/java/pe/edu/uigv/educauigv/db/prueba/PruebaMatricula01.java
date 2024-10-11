package pe.edu.uigv.educauigv.db.prueba;

import pe.edu.uigv.educauigv.dto.MatriculaDto;
import pe.edu.uigv.educauigv.service.EducaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class PruebaMatricula01 {

	// Probando que el curso no existe o no tiene vacantes
	public static void main(String[] args) {
		try {
			// Datos
			MatriculaDto bean = new MatriculaDto();
			bean.setCurso(1);
			// Proceso
			EducaService educaService = new EducaService();
			bean = educaService.matricular(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
