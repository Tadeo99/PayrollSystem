import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuarioComponent } from './usuario.component';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { BsAlertModule, BsCardModule, SharedModule } from '@ng-mf/shared/components/core';


import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatSelectModule } from '@angular/material/select';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatSortModule } from '@angular/material/sort';
import { MatTabsModule } from '@angular/material/tabs';
import { BsFindByKeyPipeModule } from '@ng-mf/shared/bs';
//import { UsuarioResolver } from './usuario.resolvers';
/**
 * La Class UsuarioModulo.
 * <ul>
 * <li>Copyright 2020 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Sun May 02 02:32:49 COT 2021
 * @since BUILDERP-CORE 2.1
 */
const routes: Routes = [
  {
    path: '', component: UsuarioComponent/*,
    resolve: {
      listaData: UsuarioResolver,
    }*/
  }
];
export const routing = RouterModule.forChild(routes);
@NgModule({
  imports: [
    routing,
    MatButtonModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatProgressSpinnerModule,
    BsCardModule,
    BsAlertModule,
    SharedModule,

    MatCardModule,
    MatListModule,
    MatSelectModule,
    MatPaginatorModule,
    MatTooltipModule,
    MatProgressBarModule,
    MatSortModule,

    MatMenuModule,
    MatTabsModule,

    BsFindByKeyPipeModule,

  ],
  declarations: [
    UsuarioComponent
  ],
  exports: [
    UsuarioComponent
  ],
  providers: [
  ]
})
export class UsuarioModule { }