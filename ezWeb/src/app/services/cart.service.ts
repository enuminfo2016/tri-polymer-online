import { Injectable } from '@angular/core';
import { Product } from '../models/product';

@Injectable({
	providedIn: 'root'
})
export class CartService {
	products!: Product[];

	constructor() {
		this.products = JSON.parse(localStorage.getItem("cart_item")) || [];
		localStorage.removeItem("cart_item");
	}

	saveItem(item: Product, change: string, qty: number): void {
		if (this.products.length === 0 || change == 'init') {
			item.quantity = qty;
			this.products.push(item);
		} else {
			for (let i = 0; i < this.products.length; i++) {
				if (this.products[i].id === item.id) {
					if (change === 'plus') {
						this.products[i].quantity = this.products[i].quantity + qty;
					} else if (change === 'minus' && qty != 0) {
						this.products[i].quantity = this.products[i].quantity - qty;
					}
					break;
				}
			}
		}
		localStorage.setItem("cart_item", JSON.stringify(this.products));
	}

	getAllItems(): Product[] {
		const products: Product[] =
			JSON.parse(localStorage.getItem("cart_item")) || [];
		return products;
	}

	deleteItem(item: Product): void {
		for (let i = 0; i < this.products.length; i++) {
			if (this.products[i].id === item.id) {
				this.products.splice(i, 1);
				break;
			}
		}
		localStorage.setItem("cart_item", JSON.stringify(this.products));
	}
}
