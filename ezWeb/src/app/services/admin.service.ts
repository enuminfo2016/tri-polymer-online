import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../models/category';

@Injectable({
	providedIn: 'root'
})
export class AdminService {
	// tslint:disable-next-line: no-inferrable-types
	private apiUrl: string = '/api/secured/v1';

	constructor(private http: HttpClient) { }

	allCategories(): Observable<Category[]> {
		return this.http.get<Category[]>(this.apiUrl + '/category');
	}
}
