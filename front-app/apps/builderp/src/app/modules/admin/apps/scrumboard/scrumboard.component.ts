import { ChangeDetectionStrategy, Component, ViewEncapsulation } from '@angular/core';

@Component({
    selector     : 'ng-mf-scrumboard',
    templateUrl    : './scrumboard.component.html',
    encapsulation  : ViewEncapsulation.None,
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class ScrumboardComponent
{
    /**
     * Constructor
     */
    constructor()
    {
    }
}
