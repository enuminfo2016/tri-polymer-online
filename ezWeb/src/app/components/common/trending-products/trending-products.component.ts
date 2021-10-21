import { Component, OnInit } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';

@Component({
    selector: 'app-trending-products',
    templateUrl: './trending-products.component.html',
    styleUrls: ['./trending-products.component.scss']
})
export class TrendingProductsComponent implements OnInit {

    constructor() { }

    ngOnInit(): void {
    }

    sectionTitle = [
        {
            title: "Trending This Week",
            paragraph: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida."
        }
    ]
    singleProductsBox = [
        {
            mainImg: 'assets/img/products/products4.jpg',
            title: 'Ergonomic Desk Sofa',
            newPrice: '$150.00',
            oldPrice: '',
            outOfStock: 'Out of Stock',
            detailsLink: 'simple-product'
        },
        {
            mainImg: 'assets/img/products/products5.jpg',
            title: 'Office Desk Sofa',
            newPrice: '$199.00',
            oldPrice: '$210.00',
            sale: 'Sale!',
            outOfStock: '',
            detailsLink: 'simple-product'
        },
        {
            mainImg: 'assets/img/products/products6.jpg',
            title: 'Swivel Sofa',
            newPrice: '$223.99',
            oldPrice: '',
            outOfStock: '',
            detailsLink: 'simple-product'
        },
        {
            mainImg: 'assets/img/products/products7.jpg',
            title: 'Home Alisa Sofa',
            newPrice: '$199.00',
            oldPrice: '$210.00',
            outOfStock: '',
            detailsLink: 'simple-product'
        }
    ]

    productsSlidesOptions: OwlOptions = {
		loop: true,
		nav: false,
		dots: true,
		autoplayHoverPause: true,
		autoplay: true,
		margin: 30,
		navText: [
			"<i class='bx bx-left-arrow-alt'></i>",
			"<i class='bx bx-right-arrow-alt'></i>"
		],
		responsive: {
			0: {
				items: 1
			},
			576: {
				items: 2
			},
			768: {
				items: 2
			},
			992: {
				items: 3
			},
			1200: {
				items: 3
			}
		}
    }

}