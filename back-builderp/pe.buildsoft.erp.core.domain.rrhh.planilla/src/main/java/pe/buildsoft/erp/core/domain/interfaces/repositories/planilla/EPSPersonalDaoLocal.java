package pe.buildsoft.erp.core.domain.interfaces.repositories.planilla;

import java.util.List;

import jakarta.ejb.Local;
import pe.buildsoft.erp.core.domain.entidades.planilla.EPSPersonal;
import pe.buildsoft.erp.core.domain.interfaces.repositories.GenericDAOLocal;
import pe.buildsoft.erp.core.infra.transversal.entidades.BaseSearch;

/**
 * La Class EPSPersonalDaoLocal.
 * <ul>
 * <li>Copyright 2020 ndavilal - ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Fri Apr 23 00:16:11 COT 2021
 * @since BUILDERP-CORE 2.1
 */
@Local
public interface EPSPersonalDaoLocal extends GenericDAOLocal<String, EPSPersonal> {

	List<EPSPersonal> listar(BaseSearch filtro);

	int contar(BaseSearch filtro);

	/**
	 * Generar id.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarId();
}