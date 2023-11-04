/**
 * La Class GrupoService.
 * <ul>
 * <li>Copyright 2020 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Sun May 02 02:32:49 COT 2021
 * @since BUILDERP-CORE 2.1
 */
 import { Injectable } from '@angular/core';
 import { HttpClient } from '@angular/common/http';
 
 import { BaseService } from "@ng-mf/shared/service/core";
 import { Pabellon } from './pabellon.types';
 
 @Injectable({
   providedIn: 'root'
 })
 export class PabellonService extends BaseService<Pabellon> {
 
   constructor(http: HttpClient) {
     super(http);
     this.modulo = "matricula";
     this.url = "/pabellon";
   }
 }
 