package pe.buildsoft.erp.core.domain.interfaces.repositories.security;

import java.util.List;

import jakarta.ejb.Local;

import pe.buildsoft.erp.core.domain.entidades.security.Sistema;
import pe.buildsoft.erp.core.domain.interfaces.repositories.GenericDAOLocal;
import pe.buildsoft.erp.core.infra.transversal.entidades.BaseSearch;

/**
 * La Class SistemaDaoLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 11:25:15 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface SistemaDaoLocal  extends GenericDAOLocal<Long,Sistema> {
	/**
	 * Listar sistema.
	 *
	 * @param sistema el sistema
	 * @return the list
	 * @ the exception
	 */
	List<Sistema> listar(BaseSearch filtro) ;
	
	/**
	 * contar lista sistema.
	 *
	 * @param sistema el sistema
	 * @return the list
	 * @ the exception
	 */
	int contar(BaseSearch filtro);
	/**
	 * Generar id sistema.
	 *
	 * @return the Long
	 * @ the exception
	 */
	Long generarId() ;
}