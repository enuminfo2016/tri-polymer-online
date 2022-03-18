import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../../models/product';
import { OnlineService } from '../../../services/online.service';
import { CartService } from 'src/app/services/cart.service';

@Component({
	selector: 'app-shop-full-width-page',
	templateUrl: './shop-full-width-page.component.html',
	styleUrls: ['./shop-full-width-page.component.scss']
})
export class ShopFullWidthPageComponent implements OnInit {
	singleProductsItem: Product[] = [];

	constructor(private route: ActivatedRoute,
		private onlineService: OnlineService,
		private cartService: CartService) { }

	ngOnInit(): void {
		this.resetOption = [this.options[0]];
		this.onlineService.allProductsByCategory(this.route.snapshot.paramMap.get('id')).subscribe(response => {
			this.singleProductsItem = response;
		});
	}

	pageTitle = [
		{
			bgImage: 'assets/img/page-title-bg.jpg',
			title: 'Quality assured'
		}
	]

	// For Pagination
	shopFullWidth: number = 1;

	// Category Select
	singleSelect: any = [];
	multiSelect: any = [];
	stringArray: any = [];
	objectsArray: any = [];
	resetOption: any;
	config = {
		displayKey: "name",
		search: true
	};
	options = [
		{
			name: "Default",
		},
		{
			name: "Popularity",
		},
		{
			name: "Latest",
		},
		{
			name: "Price: low to high",
		},
		{
			name: "Price: high to low",
		}
	];
	searchChange($event) {
		console.log($event);
	}
	reset() {
		this.resetOption = [];
	}

	addToCart(item: Product): void { this.cartService.saveItem(item, 'init', 1); }
}