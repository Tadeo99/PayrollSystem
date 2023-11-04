import {
	Component, OnInit, ChangeDetectorRef,
	AfterViewInit, OnDestroy, ViewEncapsulation,
	ChangeDetectionStrategy
} from '@angular/core';
import { FormControl, UntypedFormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { MatDialog } from '@angular/material/dialog';

import { ConceptoPdtService } from "./conceptopdt.service";
import { ConceptoPdt } from "./conceptopdt.types";
import { TranslocoService } from '@ngneat/transloco';
import { BaseComponent } from '@ng-mf/shared/components/core';
import { BasePagination, BsConfirmationService, TypeSelectItemService } from '@ng-mf/shared/service/core';
import { EstadoGeneralState } from '@ng-mf/shared/service/comun';
import { merge, takeUntil } from 'rxjs';
import { bsAnimations } from '@ng-mf/shared/bs';
/**
 * La Class ConceptoPdtComponent.
 * <ul>
 * <li>Copyright 2020 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Wed Oct 21 21:47:02 COT 2020
 * @since BUILDERP-CORE 2.1
 */

@Component({
	selector: 'ng-mf-bs-conceptopdt',
	templateUrl: './conceptopdt.component.html',
	styleUrls: ['./conceptopdt.component.scss'],
	encapsulation: ViewEncapsulation.None,
	changeDetection: ChangeDetectionStrategy.OnPush,
	animations: bsAnimations
})
export class ConceptoPdtComponent extends BaseComponent<ConceptoPdt> implements OnInit, AfterViewInit, OnDestroy {

	selected = new FormControl(0);

	constructor(
		private fb: UntypedFormBuilder,
		public dialog: MatDialog,
		router: Router,
		route: ActivatedRoute,
		private _changeDetectorRef: ChangeDetectorRef,
		private service: ConceptoPdtService,
		public override _translocoService: TranslocoService,
		public override _bsConfirmationService: BsConfirmationService,
		public typeService: TypeSelectItemService
	) {
		super(_translocoService, _bsConfirmationService);
		this.debounceTimeProcesar().subscribe(term => { this.search = term; this.buscar() });
		this.SORT_NAME = 'descripcion';
	}

	/**
	 * After view init
	 */
	ngAfterViewInit(): void {
		if (this._sort && this._paginator) {
			// Set the initial sort
			this._sort.sort({
				id: this.SORT_NAME,
				start: this.SORT_DIR,
				disableClear: true
			});
			// Mark for check
			this._changeDetectorRef.markForCheck();
			// If the user changes the sort order...
			this._sort.sortChange
				.pipe(takeUntil(this._unsubscribeAll))
				.subscribe(() => {
					// Reset back to the first page
					this._paginator.pageIndex = 0;
				});

			// Get products if sort or page changes
			merge(this._sort.sortChange, this._paginator.page).pipe(takeUntil(this._unsubscribeAll))
				.subscribe(() => {
					this.buscar();
				});;
		}
	}

	/**
	 * On destroy
	 */
	override ngOnDestroy(): void {
		// Unsubscribe from all subscriptions
		this._unsubscribeAll.next(null);
		this._unsubscribeAll.complete();
	}

	ngOnInit() {
		this.onInit();
		this.inicializar();
		this.crearFormulario();
	}

	private crearFormulario(): void {
		this.frmGroup = this.fb.group({
			idConceptoPdt: [''],
			descripcion: [''],
			conceptoPdtPadre: this.fb.group({
				idConceptoPdt: [''],
				descripcionView: ['']
			}),
			tipo: [''],
			formula: [''],
			estado: [''],
			codigo: [''],
			abreviatura: [''],
			visible: ['']
		});
		this.onChange();
	}

	private onChange(): void {
		//this.debounceTimeProcesarEmail().subscribe(term =>  {this.valueChangeEmail()});

	}

	onInit() {
		// Get the pagination
		this.service.pagination$
			.pipe(takeUntil(this._unsubscribeAll))
			.subscribe((pagination: BasePagination | null) => {
				// Update the pagination
				this.pagination = pagination;
				// Mark for check
				this._changeDetectorRef.markForCheck();
			});
		// Get the listaData
		this.listaData$ = this.service.listaData$;
	}

	/**
	 * guardar.
	 *
	 */
	public guardar() {
		if (this.frmGroup.invalid) {
			this.mostrarMensajeErrorFrmInvalid();
			return;
		}
		try {
			if (this.accionNuevo) {
				this.service.crear(this.frmGroup.value).subscribe(
					data => {
						if (this.isProcesoOK(data)) {
							this.guardoExito();
							this.buscar();
						}
					},
					error => {
						this.mostrarMensajeError(error);
					}
				);
			} else {
				this.service.modificar(this.frmGroup.value, this.frmGroup.value.idConceptoPdt).subscribe(
					data => {
						if (this.isProcesoOK(data)) {
							this.actualizadoExito();
							this.buscar();
						}
					},
					error => {
						this.mostrarMensajeError(error);
					}
				);
			}
		} catch (e) {
			this.mostrarMensajeError(e);
		}
	}

	/**
	 * Nuevo.
	 *
	 */
	public nuevo() {
		this.crearFormulario();
		this.frmGroup.get("estado")?.setValue(EstadoGeneralState.ACTIVO.toString());
		this.frmGroup.get("conceptoPdtPadre.idConceptoPdt")?.setValue(this.selectedData?.idConceptoPdt);
		this.frmGroup.get("conceptoPdtPadre.descripcionView")?.setValue(this.selectedData?.descripcionView);
		this.mostrarPanelForm = true;
		this.accionNuevo = true;
		if (this.typeService.listaTipoPDT != null) {
			this.frmGroup.get('tipo')?.setValue((this.typeService.listaTipoPDT[this.selected?.value ?? 0]?.id));
		}
	}

	/**
	 * Inicializar.
	 *
	 */
	private inicializar() {
		try {
			this.buscar();
		} catch (e) {
			this.mostrarMensajeError(e);
		}

	}

	/**
	 * eliminar.
	 *
	 */
	private eliminar(id: any) {
		try {
			this.service.eliminar(id).subscribe(
				data => {
					if (this.isProcesoOK(data)) {
						this.eliminoExito();
						this.buscar();
					}
				},
				error => {
					this.mostrarMensajeError(error);
				}
			);
		} catch (e) {
			this.mostrarMensajeError(e);
		}
	}

	/**
	 * confirmar eliminar.
	 *
	 */
	public confirmarEliminar(obj: ConceptoPdt) {
		const dialogRef = this.abrirModalConfirDialogEliminar();
		dialogRef.afterClosed().subscribe(result => {
			if (result === 'confirmed') {
				this.eliminar(obj.idConceptoPdt);
			}
		});
	}

	/**
	 * find id
	 *
	 */
	public find(obj: ConceptoPdt) {
		try {
			this.frmGroup.patchValue(obj, { onlySelf: true, emitEvent: false });
			this.mostrarPanelForm = true;
			this.accionNuevo = false;
		} catch (e) {
			this.mostrarMensajeError(e);
		}
	}

	/**
	 * Buscar.
	 *
	 */
	public buscar() {
		if (this.typeService.listaTipoPDT != null) {
			this.params = this.params.set("tipo", (this.typeService.listaTipoPDT[this.selected?.value ?? 0]?.id) + "");
		}
		this.isLoading = true;
		this.service.paginador(
			this.nvl(this._paginator?.pageIndex, 0),
			this.nvl(this._paginator?.pageSize, 10),
			this.nvl(this._sort?.active, this.SORT_NAME),
			this.nvl(this._sort?.direction, this.SORT_DIR),
			this.search, this.params)
			.subscribe(
				data => {
					if (this.isProcesoOK(data)) {
						// Mark for check
						this.isLoading = false;
						this.mostrarPanelForm = false;
						this._changeDetectorRef.markForCheck();
					}
				},
				error => {
					this.isLoading = false;
					this.mostrarMensajeError(error);
				});
	}

	/**
	  * cancelar.
	  *
	*/
	public cancelar() {
		this.mostrarPanelForm = false;
	}
	public changeEmitterEvent(event: any) {
		const isNuevo = event.isNuevo;
		if (isNuevo === true) {
			this.nuevo();
		} else if (isNuevo === false) {
			this.regresarDependencia();
		}
	}

	public verDependecia(obj: ConceptoPdt) {
		this.verDependeciaView(obj);
		this.buscar();
	}
	public verDependeciaView(obj: ConceptoPdt) {
		this.searchInputControl.setValue("");
		this.params = this.params.set("id", '');
		this.titlePage = '';
		this._paginator.pageIndex = 0;
		this._paginator.pageSize = 10;
		if (obj.idConceptoPdt != '') {
			this.params = this.params.set("id", obj.idConceptoPdt + '');
			this.titlePage = this.typeService?.tipoPDTMap.get(obj?.tipo) + ' : ' + obj.descripcion;
			this.selectedData = obj;
		}
	}

	public regresarDependencia() {
		this.search = '';
		if ((this.selectedData?.conceptoPdtPadre != null) && (this.selectedData?.conceptoPdtPadre != null && this.selectedData?.conceptoPdtPadre?.idConceptoPdt)) {
			this.verDependecia(this.selectedData?.conceptoPdtPadre);
		} else {
			this.params = this.params.set("id", '');
			this.titlePage = '';
			this.buscar();
			this.selectedData = null;
		}
	}

	public tabChanged = (tabChangeEvent: any): void => {
		this.params = this.params.set("id", '');
		this.titlePage = '';
		this.selectedData = null;
		this.buscar();
	}
}