import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { IconsService } from './icons.service';

@Injectable({
    providedIn: 'root'
})
export class IconsResolver implements Resolve<any>
{
    /**
     * Constructor
     */
    constructor(private _iconsService: IconsService)
    {
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Resolve
     *
     * @param route
     * @param state
     */
    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any>
    {
        return this._iconsService.getIcons(state.url);
    }
}
