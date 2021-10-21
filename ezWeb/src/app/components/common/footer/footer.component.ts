import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { AdminService } from 'src/app/services/admin.service';
import { Category } from 'src/app/models/category';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
  providers: [
    Location, {
      provide: LocationStrategy,
      useClass: PathLocationStrategy
    }
  ]
})
export class FooterComponent implements OnInit {

  location: any;
  bgClass: any;
  categories: Category[] = [];

  constructor(
    private router: Router,
    private adminService: AdminService) {
    this.router.events
      .subscribe((event) => {
        if (event instanceof NavigationEnd) {
          this.location = this.router.url;
          // tslint:disable-next-line: triple-equals
          if (this.location == '/' || this.location == '/index-2' || this.location == '/index-3' || this.location == '/about') {
            this.bgClass = '';
          } else {
            this.bgClass = 'bg-f5f5f5';
          }
        }
      });
  }

  ngOnInit(): void {
    this.adminService.allCategories().subscribe(response => { this.categories = response; });
  }
}
