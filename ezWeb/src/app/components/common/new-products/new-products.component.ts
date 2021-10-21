import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-new-products',
    templateUrl: './new-products.component.html',
    styleUrls: ['./new-products.component.scss']
})
export class NewProductsComponent implements OnInit {

    constructor() { }

    ngOnInit(): void {
    }

    sectionTitle = [
        {
            title: "New Collection",
            paragraph: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida."
        }
    ]
    singleProductsItem = [
        {
            mainImg: 'assets/img/products/products10.jpg',
            title: 'Wood Patio Chair',
            newPrice: '$226.00',
            oldPrice: '',
            sale: 'Sale!',
            outOfStock: '',
            detailsLink: 'slider-product'
        },
        {
            mainImg: 'assets/img/products/products6.jpg',
            title: 'Winsome Wood Benjamin',
            newPrice: '$98.99',
            oldPrice: '',
            sale: '',
            outOfStock: '',
            detailsLink: 'slider-product'
        },
        {
            mainImg: 'assets/img/products/products11.jpg',
            title: 'Brown Vinyl Padded',
            newPrice: '$107.99',
            oldPrice: '$140.99',
            sale: '',
            outOfStock: '',
            detailsLink: 'slider-product'
        },
        {
            mainImg: 'assets/img/products/products12.jpg',
            title: 'Antique Walnut',
            newPrice: '$98.99',
            oldPrice: '',
            sale: '',
            outOfStock: '',
            detailsLink: 'slider-product'
        },
        {
            mainImg: 'assets/img/products/products13.jpg',
            title: 'Christopher Knight Home',
            newPrice: '$212.99',
            oldPrice: '',
            sale: '',
            outOfStock: '',
            detailsLink: 'slider-product'
        },
        {
            mainImg: 'assets/img/products/products4.jpg',
            title: 'Ergonomic Desk Sofa',
            newPrice: '$150.00',
            oldPrice: '',
            sale: '',
            outOfStock: '',
            detailsLink: 'slider-product'
        },
        {
            mainImg: 'assets/img/products/products5.jpg',
            title: 'Office Desk Sofa',
            newPrice: '$199.00',
            oldPrice: '$210.00',
            sale: 'Sale!',
            outOfStock: '',
            detailsLink: 'slider-product'
        },
        {
            mainImg: 'assets/img/products/products8.jpg',
            title: 'Grey Harrington Sofa',
            newPrice: '$199.00',
            oldPrice: '$210.00',
            sale: '',
            outOfStock: 'Out of Stock',
            detailsLink: 'slider-product'
        }
    ]

}