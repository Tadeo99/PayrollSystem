export enum ListaItemType {
	//Los datos se encuentrar registrados en item
	//PARA EL T - REGISTRO
	T1_ACTIVIDAD = <any>1,//TIPO DE ACTIVIDAD
	T3_TIPO_DOCUMENTO = <any>3,//TIPO DE DOCUMENTO DE IDENTIFICACION
	T4_NACIONALIDAD = <any>4,//NACIONALIDAD
	T5_VIA = <any>5,//VIA
	T6_ZONA = <any>6,//ZONA
	T8_TIPO_TRAB_PENS_PS = <any>8,//TIPO_DE_TRABAJADOR_PENSIONISTA_O_PRESTADOR_DE_SERVICIOS
	T9_SITUACION_EDUCATIVA = <any>9,//SITUACION_EDUCATIVA
	T10_OCUP_SPUB_PERS_Form = <any>10,//OCUPACION_APLICABLE_A_TRABAJ_DE_SECTOR_PUBLICO_OTRAS_ENTIDADES_Y_PERS_EN_FORMACION
	T11_REGIMEN_PENSIONARIO = <any>11,//REGIMEN_PENSIONARIO
	T12_CONTRATOS = <any>12,//TIPO_DE_CONTRATO_DE_TRABAJO_CONDICION_LABORAL
	T13_PERIODICIDAD = <any>13,//PERIODICIDAD_DE_LA_REMUNERACION_O_INGRESO
	T14_EPSSERV_PROPIOS = <any>14,//ENTIDADES_PRESTADORAS_DE_SALUD_EPS_SERVICIOS_PROPIOS
	T15_SITUACION = <any>15,//SITUACION_DEL_TRABAJADOR_O_PENSIONISTA
	T16_TIPO_DE_PAGO = <any>16,//TIPO_DE_PAGO
	T17_MOTIVO_DEL_PERIODO = <any>17,//MOTIVO_DEL_FIN_DEL_CONTRATO_O_DE_LA_BAJA_DEL_T_REGISTRO
	T18_TIPO_DE_MODALIDAD_FORMATIVA = <any>18,//TIPO_DE_MODALIDAD_FORMATIVA_LABORAL_Y_OTROS
	T24_CATEGORIA_OCUPACIONAL = <any>24,//CATEGORIA OCUPACIONAL DEL TRABAJADOR
	T25_CONVENIOS = <any>25,//CONVENIOS PARA EVITAR LA DOBLE TRIBUTACIÓN
	T26_PAIS_EMISOR_DEL_DOCUMENTO = <any>26,//PAÍS EMISOR DEL DOCUMENTO
	//- UBIGEO T-REGISTRO=<any>28,
	T29_CODIGOS_LARGA_DISTANCIA_N = <any>29,//CÓDIGOS DE LARGA DISTANCIA NACIONA
	T30_OCUPACION_SECTOR_PRIVADO = <any>30,//OCUPACIÓN APLICABLE AL SECTOR PRIVADO
	T31_PLIEGO_PRESUPUESTAL = <any>31,//PLIEGO PRESUPUESTAL
	T32_REGIMEN_ASEGURAMIENTO_SALUD = <any>32,//REGIMEN DE ASEGURAMIENTO DE SALUD
	T33_REGIMEN_LABORAL = <any>33,//REGIMEN LABORAL
	//- INSTITUCIONES EDUCATIVAS Y SUS CARRERAS=<any>34,//
	T35_SITUACION_ESPECIAL = <any>35,//SITUACIÓN ESPECIAL
	T36_ENTIDADES_BANCARIA = <any>36,//T36 Entidad Bancaria

	//DE USO EXCLUSIVO EN EL REGISTRO DE DERECHOHABIENTES
	T19_VINCULO_FAMILIAR = <any>19,// VÍNCULO FAMILIAR
	T20_MOTIVO_BAJA_DERECHOHABIENTE = <any>20,//  MOTIVO DE BAJA COMO DERECHOHABIENTE.
	T27_DOC_ACREDITA_VINCULO_FAMILIAR = <any>27,//TIPO DE DOCUMENTO QUE ACREDITA VÍNCULO FAMILIAR

	//PLANILLA MENSUAL DE PAGOS - PLAME
	T21_TIPO_SUSPENSION = <any>21,//TIPO DE SUSPENSIÓN DE LA RELACIÓN LABORAL
	//- INGRESOS, TRIBUTOS Y  DESCUENTOS=<any>22,// 
	T23_TIPO_COMPROBANTE_PAGO = <any>23,// TIPO DE COMPROBANTE DE PAGO

	CARRERA = <any>2,//no va
	T16_TIPO_DE_PAGO_PENSION = <any>2,//no va
	SERVICIO_MEDICO = <any>373,//no va
	
	SCTR_PENSION = <any>372,//no va
	// TIPO_PENSION=<any>2,//no va
	SCTR_SALUD = <any>371,//no va
	EMPLEADOR_DESTACA_PERSONAL_TERCERO = <any>2,//no va
	CATEGORIA_TRABAJAR = <any>2,//no va
	// AFP=<any>2,//no va

	ESTADO_CIVIL = <any>376,

	/** El LENGUAJE. */
	LENGUAJE = <any>40,

	/** El COMPONENTE. */
	COMPONENTE = <any>41,

	//new

	/** La ITEM_ENTIDAD_CONFIGURAR. */
	ITEM_ENTIDAD_CONFIGURAR = <any>55,

	/** La ITEM_TIPO_COMPONENTE_CONFIGURAR. */
	ITEM_TIPO_COMPONENTE_CONFIGURAR = <any>56,

	T38_NIVEL = <any>38,

	ITEM_TURNO = <any>377,

	TIPO_INSTITUCION = <any>342,
	TIPO_REGIMEN = <any>341,
	MOTIVO_CESE = <any>384,
	TIPO_CENTRO_FORMACACION = <any>374,
	TIPO_DE_COMPROBANTE = <any>378,
	TIPO_CLASIFICACION = <any>379,
	TIPO_MONEDA = <any>380,
	TIPO_BANCO = <any>381,
	TIPO_MESES = <any>382,/*no va*/
	TIPO_CUENTA_BANCARIA = <any>383,
	TIPO_PENSION = <any>384,
	PROCEDENCIA_DIRECCION = <any>385,
	AFPS = <any>386,
	TIPO_DEPOSITO = <any>387,
	CARGO = <any>388,
	AREA = <any>389,
}