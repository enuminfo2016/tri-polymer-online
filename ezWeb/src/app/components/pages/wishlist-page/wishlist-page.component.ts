import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-wishlist-page',
    templateUrl: './wishlist-page.component.html',
    styleUrls: ['./wishlist-page.component.scss']
})
export class WishlistPageComponent implements OnInit {

    constructor() { }

    ngOnInit(): void {
    }

    pageTitle = [
        {
            bgImage: 'assets/img/page-title-bg.jpg',
            title: 'Wishlist'
        }
    ]

}