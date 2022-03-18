import { Component, OnInit } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';

@Component({
	selector: 'app-home-banner',
	templateUrl: './home-banner.component.html',
	styleUrls: ['./home-banner.component.scss']
})
export class HomeBannerComponent implements OnInit {

	constructor() { }

	mainBannerItem = [
		{
			title: 'Main Banner Img1',
			paragraph: 'Main Banner Img1!',
			buttonIcon: 'bx bx-shopping-bag',
			buttonText: 'SHOP OUR PRODUCTS',
			buttonLink: 'shop-full-width-2',
			image: 'assets/img/main-banner-img1.jpg'
		},
		{
			title: 'Main Banner Img2',
			paragraph: 'Main Banner Img2!',
			buttonIcon: 'bx bx-shopping-bag',
			buttonText: 'SHOP OUR PRODUCTS',
			buttonLink: 'shop-full-width-2',
			image: 'assets/img/main-banner-img2.jpg'
		},
		{
			title: 'Main Banner Img3',
			paragraph: 'Main Banner Img3!',
			buttonIcon: 'bx bx-shopping-bag',
			buttonText: 'SHOP OUR PRODUCTS',
			buttonLink: 'shop-full-width-2',
			image: 'assets/img/main-banner-img3.jpg'
		},
		{
			title: 'Main Banner Img4',
			paragraph: 'Main Banner Img4!',
			buttonIcon: 'bx bx-shopping-bag',
			buttonText: 'SHOP OUR PRODUCTS',
			buttonLink: 'shop-full-width-2',
			image: 'assets/img/main-banner-img4.jpg'
		},
		{
			title: 'Main Banner Img5',
			paragraph: 'Main Banner Img5!',
			buttonIcon: 'bx bx-shopping-bag',
			buttonText: 'SHOP OUR PRODUCTS',
			buttonLink: 'shop-full-width-2',
			image: 'assets/img/main-banner-img5.jpg'
		},
		{
			title: 'Main Banner Img6',
			paragraph: 'Main Banner Img6!',
			buttonIcon: 'bx bx-shopping-bag',
			buttonText: 'SHOP OUR PRODUCTS',
			buttonLink: 'shop-full-width-2',
			image: 'assets/img/main-banner-img6.jpg'
		},
	]

	homeSlidesOptions: OwlOptions = {
		loop: true,
		nav: true,
		margin: 5,
		dots: false,
		autoplay: true,
		autoHeight: true,
		animateIn: 'fadeIn',
		animateOut: 'fadeOut',
		autoplayHoverPause: true,
		navText: [
			'<i class=\'bx bx-left-arrow-alt\'></i>',
			'<i class=\'bx bx-right-arrow-alt\'></i>'
		],
		responsive: {
			0: {
				items: 1
			},
			576: {
				items: 1
			},
			768: {
				items: 1
			},
			992: {
				items: 1
			},
			1200: {
				items: 1
			}
		}
	}

	ngOnInit(): void {
	}
}
