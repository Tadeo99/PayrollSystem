import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { Route, RouterModule } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { BsHighlightModule } from '../../../../../@bs/components/highlight';
import { SharedModule } from '@ng-mf/shared/components/core'
import { IconsComponent } from './icons.component';
import { IconsResolver } from './icons.resolvers';

export const routes: Route[] = [
    {
        // Redirect /icons to /icons/material-twotone
        path      : '',
        pathMatch : 'full',
        redirectTo: 'material-twotone'
    },
    {
        path     : '**',
        component: IconsComponent,
        resolve  : {
            icons: IconsResolver
        }
    }
];

@NgModule({
    declarations: [
        IconsComponent
    ],
    imports     : [
        ReactiveFormsModule,
        RouterModule.forChild(routes),
        MatFormFieldModule,
        MatIconModule,
        MatInputModule,
        MatSelectModule,
        BsHighlightModule,
        SharedModule
    ]
})
export class IconsModule
{
}
