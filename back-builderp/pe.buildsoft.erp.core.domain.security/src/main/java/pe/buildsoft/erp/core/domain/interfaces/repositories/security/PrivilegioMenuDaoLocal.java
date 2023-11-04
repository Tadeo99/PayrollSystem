package pe.buildsoft.erp.core.domain.interfaces.repositories.security;

import java.util.List;

import jakarta.ejb.Local;

import pe.buildsoft.erp.core.domain.entidades.security.PrivilegioMenu;
import pe.buildsoft.erp.core.domain.interfaces.repositories.GenericDAOLocal;
import pe.buildsoft.erp.core.infra.transversal.entidades.BaseSearch;

/**
 * La Class PrivilegioMenuDaoLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 11:25:07 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface PrivilegioMenuDaoLocal  extends GenericDAOLocal<String,PrivilegioMenu> {
	/**
	 * Listar privilegio menu.
	 *
	 * @param privilegioMenu el privilegio menu
	 * @return the list
	 * @ the exception
	 */
	List<PrivilegioMenu> listar(BaseSearch filtro) ;
	
	/**
	 * contar lista privilegio menu.
	 *
	 * @param privilegioMenu el privilegio menu
	 * @return the list
	 * @ the exception
	 */
	int contar(BaseSearch filtro);
	/**
	 * Generar id privilegioMenu.
	 *
	 * @return the Long
	 * @ the exception
	 */
	String generarId() ;
}