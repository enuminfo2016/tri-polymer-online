import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Category } from 'src/app/models/category';
import { Observable, Subject } from 'rxjs';

@Component({
    selector: 'app-navbar-style',
    templateUrl: './navbar-style.component.html',
    styleUrls: ['./navbar-style.component.scss']
})
export class NavbarStyleComponent implements OnInit {
    categories: Category[] = [];

    constructor(private adminService: AdminService) { }

	private cartCount = new Subject<number>();
  
  	getCartCount(): Observable<number> {
	 console.log("getCartCount is invoked" );
   	 return this.cartCount.asObservable();
    }
    

    ngOnInit(): void {
        this.adminService.allCategories().subscribe(response => { this.categories = response; });
    }

    classApplied = false;
    toggleClass() {
        this.classApplied = !this.classApplied;
    }
}