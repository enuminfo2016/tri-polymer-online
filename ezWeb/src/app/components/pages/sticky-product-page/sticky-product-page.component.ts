import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { Product } from '../../../models/product';
import { OnlineService } from '../../../services/online.service';

@Component({
    selector: 'app-sticky-product-page',
    templateUrl: './sticky-product-page.component.html',
    styleUrls: ['./sticky-product-page.component.scss']
})
export class StickyProductPageComponent implements OnInit {
	pageTitle = [];
	singleProductsItem: Product = new Product();

	constructor(private route: ActivatedRoute,
		private onlineService: OnlineService) {
		this.onlineService.productDetailByProduct(this.route.snapshot.paramMap.get('id')).subscribe(response => {
			this.singleProductsItem = response;
			console.log(JSON.stringify(this.singleProductsItem));
			this.pageTitle = [
				{
					bgImage: 'assets/img/page-title-bg.jpg',
					title: this.singleProductsItem.title
				}
			]
		});
	}

    ngOnInit(): void {
    }

}