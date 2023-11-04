package pe.buildsoft.erp.core.domain.interfaces.repositories.escalafon;

import java.util.List;

import jakarta.ejb.Local;

import pe.buildsoft.erp.core.domain.entidades.escalafon.HistorialCargoArea;
import pe.buildsoft.erp.core.domain.interfaces.repositories.GenericDAOLocal;
import pe.buildsoft.erp.core.infra.transversal.entidades.BaseSearch;

/**
 * La Class HistorialCargoAreaDaoLocal.
 * <ul>
 * <li>Copyright 2020 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Fri Apr 23 00:16:11 COT 2021
 * @since BUILDERP-CORE 2.1
 */
@Local
public interface HistorialCargoAreaDaoLocal  extends GenericDAOLocal<String,HistorialCargoArea> {
	/**
	 * Listar historial cargo area.
	 *
	 * @param historialCargoArea el historial cargo area
	 * @return the list
	 * @throws Exception the exception
	 */
	List<HistorialCargoArea> listar(BaseSearch filtro);
	
	/**
	 * contar lista historial cargo area.
	 *
	 * @param historialCargoArea el historial cargo area
	 * @return the list
	 * @throws Exception the exception
	 */
	int contar(BaseSearch filtro);
	/**
	 * Generar id historialCargoArea.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarId();
}