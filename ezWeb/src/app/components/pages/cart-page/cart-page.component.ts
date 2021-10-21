import { Component, OnInit } from '@angular/core';
import { Product } from '../../../models/product';
import { CartService } from '../../../../app/services/cart.service';

@Component({
	selector: 'app-cart-page',
	templateUrl: './cart-page.component.html',
	styleUrls: ['./cart-page.component.scss']
})
export class CartPageComponent implements OnInit {
	value: number;
	cartProducts: Product[] = [];
	subTotal: number = 0;
	shipValue: number = 0;
	taxValue: number = 0;
	grandTotal: number = 0;
	linkEnabled: boolean = false;

	constructor(private cartService: CartService) { }

	ngOnInit(): void {
		this.refreshCartProducts();
	}

	pageTitle = [
		{
			bgImage: 'assets/img/page-title-bg.jpg',
			title: 'Cart'
		}
	]

	refreshCartProducts(): void {
		this.cartProducts = this.cartService.getAllItems();
		this.subTotal = 0;
		this.shipValue = 0;
		this.taxValue = 0;
		this.grandTotal = 0;
		for (let i = 0; i < this.cartProducts.length; i++) {
			this.subTotal = this.subTotal + (this.cartProducts[i].newPrice * this.cartProducts[i].quantity);
		}
		this.shipValue = this.subTotal * 0.02;
		this.taxValue = this.subTotal * 0.18;
		this.grandTotal = this.subTotal + (this.shipValue + this.taxValue);
		if (this.cartProducts.length != 0) { this.linkEnabled = true; }
	}

	removeFromCart(item: Product): void {
		this.cartService.deleteItem(item);
		this.refreshCartProducts();
	}

	/*quantityChange(qty: string, item: Product): void {
		item.quantity = parseInt(qty);
		// this.cartService.addItems(item);
		this.getCartProducts();
	}*/

	qtyMinus(item: Product): void {
		this.cartService.saveItem(item, 'minus', 1);
		this.refreshCartProducts();
	}

	qtyPlus(item: Product): void {
		this.cartService.saveItem(item, 'plus', 1);
		this.refreshCartProducts();
	}
}
