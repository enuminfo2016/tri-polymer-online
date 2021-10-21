import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-simple-product-page',
    templateUrl: './simple-product-page.component.html',
    styleUrls: ['./simple-product-page.component.scss']
})
export class SimpleProductPageComponent implements OnInit {

    constructor() { }

    ngOnInit(): void {
    }

    pageTitle = [
        {
            bgImage: 'assets/img/page-title-bg.jpg',
            title: 'Ergonomic Desk Sofa'
        }
    ]

}