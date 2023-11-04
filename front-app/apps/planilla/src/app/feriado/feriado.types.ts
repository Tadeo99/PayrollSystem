/**
 * La Class Feriado.
 * <ul>
 * <li>Copyright 2020 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Sun May 02 02:32:49 COT 2021
 * @since BUILDERP-CORE 2.1
 */
export interface Feriado {

  /** El id. */
  idFeriado: string;

  /** El fecha. */
  fecha: Date;

  idAnhio: number;

  idMes: number;
  itemByMes : any;

  fijo: string;

  /** El estado. */
  estado: string;

  descripcionView: string;
}