package pe.edu.uigv.educauigv.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uigv.educauigv.db.AccesoDB;
import pe.edu.uigv.educauigv.dto.MatriculaDto;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class EducaService {

	public MatriculaDto matricular(MatriculaDto bean) {
		Connection cn = null;
		PreparedStatement pstm;
		ResultSet rs;
		String sql;
		try {
			// Inicio de Tx.
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Verificar si el curso existe y tiene vacantes
			verificarCurso(cn, bean.getCurso());

			// Fin de Tx
			cn.commit();
			System.out.println("Proceso ok.");

		} catch (SQLException e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException("Error en el proceso.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return bean;
	}

	private void verificarCurso(Connection cn, int curso) throws SQLException {
		String sql = """
               select count(1) cont from curso 
               where cur_id=? and cur_vacantes>cur_matriculados
               """;
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, curso);
		ResultSet rs = pstm.executeQuery();
		rs.next();
		int cont = rs.getInt("cont");
		rs.close();
		pstm.close();
		if(cont==0){
			throw new SQLException("Curso no existe o no tiene vacantes.");
		}
	}

}
