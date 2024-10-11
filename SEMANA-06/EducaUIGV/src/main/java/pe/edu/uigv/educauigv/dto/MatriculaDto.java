package pe.edu.uigv.educauigv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class MatriculaDto {
	
	private int curso;
	private int alumno;
	private int empleado;
	private String tipo;
	private int cuotas;
	private double precio;
	private String fecha;

}
