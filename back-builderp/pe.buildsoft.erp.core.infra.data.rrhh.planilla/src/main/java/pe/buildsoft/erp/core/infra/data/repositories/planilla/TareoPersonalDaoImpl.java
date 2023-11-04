package pe.buildsoft.erp.core.infra.data.repositories.planilla;

import java.util.HashMap;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import pe.buildsoft.erp.core.domain.entidades.planilla.TareoPersonal;
import pe.buildsoft.erp.core.domain.interfaces.repositories.planilla.TareoPersonalDaoLocal;
import pe.buildsoft.erp.core.infra.data.repositories.GenericPlanillaDAOImpl;
import pe.buildsoft.erp.core.infra.transversal.entidades.BaseSearch;
import pe.buildsoft.erp.core.infra.transversal.utilitario.CollectionUtil;
import pe.buildsoft.erp.core.infra.transversal.utilitario.StringUtil;
import pe.buildsoft.erp.core.infra.transversal.utilitario.UUIDUtil;

/**
 * La Class TareoPersonalDaoImpl.
 * <ul>
 * <li>Copyright 2020 ndavilal - ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Fri Apr 23 00:16:11 COT 2021
 * @since BUILDERP-CORE 2.1
 */
@Stateless
public class TareoPersonalDaoImpl extends GenericPlanillaDAOImpl<String, TareoPersonal>
		implements TareoPersonalDaoLocal {

	@Override
	public List<TareoPersonal> listar(BaseSearch filtro) {
		var query = generarQuery(filtro, false);
		query.setFirstResult(filtro.getStartRow());
		query.setMaxResults(filtro.getOffSet());
		return query.getResultList();
	}

	/**
	 * Generar query lista Adelanto.
	 *
	 * @param Adelanto   el adelanto
	 * @param esContador el es contador
	 * @return the query
	 */
	private Query generarQuery(BaseSearch filtro, boolean esContador) {
		var parametros = new HashMap<String, Object>();
		var jpaql = new StringBuilder();

		if (esContador) {
			jpaql.append(" select count(o.idTareoPersonal) from TareoPersonal o ");
		} else {
			jpaql.append(" select o from TareoPersonal o   ");
		}

		jpaql.append("  where 1 = 1 ");
		if (!StringUtil.isNullOrEmpty(filtro.getId())) {
			jpaql.append(" and o.idPersonal = :id ");
			parametros.put("id", filtro.getId());
		}
		if (!StringUtil.isNullOrEmptyNumeric(filtro.getIdItemByCategoriaTrabajador())) {
			jpaql.append(" and o.idItemByCategoriaOcupacional = :idItem ");
			parametros.put("idItem", filtro.getIdItemByCategoriaTrabajador());

			if (!StringUtil.isNullOrEmptyNumeric(filtro.getIdItemByMes())) {
				jpaql.append(" and o.idItemByMes = :itemByMes ");
				parametros.put("itemByMes", filtro.getIdItemByMes());
			}
			if (!StringUtil.isNullOrEmptyNumeric(filtro.getIdAnhio())
					&& StringUtil.isNotNullOrBlank(filtro.getIdAnhio())) {
				jpaql.append(" and o.idAnhio = :idAnhio ");
				parametros.put("idAnhio", filtro.getIdAnhio());
			}
			if (!StringUtil.isNullOrEmptyNumeric(filtro.getIdItemByPeriocidad())) {
				jpaql.append(" and o.idItemByPeriocidad = :itemByPeriocidad ");
				parametros.put("itemByPeriocidad", filtro.getIdItemByPeriocidad());
			}
			if (!CollectionUtil.isEmpty(filtro.getListaIdPersonal())) {
				jpaql.append(" and o.idPersonal in (:listaIdPersonal) ");
				parametros.put("listaIdPersonal", filtro.getListaIdPersonal());
			}
		}
		if (!esContador) {
			//jpaql.append(" ORDER BY " + filtro.getSortFields() + " " + filtro.getSortDirections());
		}
		return createQuery(jpaql.toString(), parametros);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.builderp.core.service.rrhh.planilla.dao.local.AdelantoDaoLocal#
	 * contarListar{entity.getClassName()}(pe.com.builderp.core.service.rrhh.
	 * planilla.model.jpa.Adelanto)
	 */
	@Override
	public int contar(BaseSearch filtro) {
		var query = generarQuery(filtro, true);
		return ((Long) query.getSingleResult()).intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.builderp.core.service.rrhh.planilla.dao.local.
	 * AsistenciaPersonalDaoLocal#generarIdAsistenciaPersonal()
	 */
	@Override
	public String generarId() {
		return UUIDUtil.generarElementUUID();
	}

}