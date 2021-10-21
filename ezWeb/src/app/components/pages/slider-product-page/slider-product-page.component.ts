import { Component, OnInit } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { ActivatedRoute } from '@angular/router'
import { Product } from '../../../models/product';
import { OnlineService } from '../../../services/online.service';

@Component({
	selector: 'app-slider-product-page',
	templateUrl: './slider-product-page.component.html',
	styleUrls: ['./slider-product-page.component.scss']
})
export class SliderProductPageComponent implements OnInit {
	pageTitle = [];
	singleProductsItem: Product = new Product();
	productsDetailsImageSlidesOptions: OwlOptions = {};

	constructor(private route: ActivatedRoute,
		private onlineService: OnlineService) {
		this.onlineService.productDetailByProduct(this.route.snapshot.paramMap.get('id')).subscribe(response => {
			this.singleProductsItem = response;
			this.pageTitle = [
				{
					bgImage: 'assets/img/page-title-bg.jpg',
					title: this.singleProductsItem.title
				}
			]
			let responseImages: string[] = this.singleProductsItem.images;
			this.productsDetailsImageSlidesOptions = {
				loop: true,
				nav: true,
				dots: false,
				autoplayHoverPause: true,
				autoplay: true,
				margin: 30,
				navText: [
					"<i class='bx bx-left-arrow-alt'></i>",
					"<i class='bx bx-right-arrow-alt'></i>"
				],
				responsive: {
					0: {
						items: responseImages.length,
					}
				}
			};
		});
	}

	ngOnInit(): void {
	}

	/* productsDetailsImageSlidesOptions: OwlOptions = {
		loop: true,
		nav: true,
		dots: false,
		autoplayHoverPause: true,
		autoplay: true,
		margin: 30,
		navText: [
			"<i class='bx bx-left-arrow-alt'></i>",
			"<i class='bx bx-right-arrow-alt'></i>"
		],
		responsive: {
			0: {
				items: 1,
			},
			576: {
				items: 2,
			},
			768: {
				items: 2,
			},
			1200: {
				items: 3,
			}
		}
	} */

}