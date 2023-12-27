// @ts-ignore
import {Injectable} from '@angular/core';
// @ts-ignore
import {HttpClient} from '@angular/common/http';
// @ts-ignore
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class GoogleMapsService {
    private apiUrl = 'http://localhost:8080/maps'; // Adres serwera pośredniczącego

    constructor(private http: HttpClient) {
    }

    getMapData(): Observable<any> {
        return this.http.get(`${this.apiUrl}/map-data`);
    }
}