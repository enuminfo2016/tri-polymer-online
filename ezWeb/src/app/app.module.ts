import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxScrollTopModule } from 'ngx-scrolltop';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { SelectDropDownModule } from 'ngx-select-dropdown';

import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { GalleryPageComponent } from './components/pages/gallery-page/gallery-page.component';
import { ContactPageComponent } from './components/pages/contact-page/contact-page.component';
import { HomeComponent } from './components/pages/home/home.component';
import { NavbarStyleComponent } from './components/common/navbar-style/navbar-style.component';
import { PartnerComponent } from './components/common/partner/partner.component';
import { TestimonialsComponent } from './components/common/testimonials/testimonials.component';
import { DealInThisWeekComponent } from './components/common/deal-in-this-week/deal-in-this-week.component';
import { FacilityStyleComponent } from './components/common/facility-style/facility-style.component';
import { SubscribeComponent } from './components/common/subscribe/subscribe.component';
import { HomeBannerComponent } from './components/pages/home/home-banner/home-banner.component';
import { FooterComponent } from './components/common/footer/footer.component';
import { NotFoundPageComponent } from './components/pages/not-found-page/not-found-page.component';
import { ComingSoonPageComponent } from './components/pages/coming-soon-page/coming-soon-page.component';
import { FaqPageComponent } from './components/pages/faq-page/faq-page.component';
import { OrderTrackingPageComponent } from './components/pages/order-tracking-page/order-tracking-page.component';
import { MyAccountPageComponent } from './components/pages/my-account-page/my-account-page.component';
import { CustomerServicePageComponent } from './components/pages/customer-service-page/customer-service-page.component';
import { UpcomingProductsComponent } from './components/common/upcoming-products/upcoming-products.component';
import { TrendingProductsComponent } from './components/common/trending-products/trending-products.component';
import { PopularProductsComponent } from './components/common/popular-products/popular-products.component';
import { NewProductsComponent } from './components/common/new-products/new-products.component';
import { DiscountComponent } from './components/common/discount/discount.component';
import { StickyProductPageComponent } from './components/pages/sticky-product-page/sticky-product-page.component';
import { SliderProductPageComponent } from './components/pages/slider-product-page/slider-product-page.component';
import { CartPageComponent } from './components/pages/cart-page/cart-page.component';
import { CheckoutPageComponent } from './components/pages/checkout-page/checkout-page.component';
import { WishlistPageComponent } from './components/pages/wishlist-page/wishlist-page.component';
import { AboutPageComponent } from './components/pages/about-page/about-page.component';
import { VideoComponent } from './components/common/video/video.component';
import { WhyChooseUsComponent } from './components/common/why-choose-us/why-choose-us.component';
import { ShopFullWidthPageComponent } from './components/pages/shop-full-width-page/shop-full-width-page.component';
import { AuthGuard } from './services/auth.guard';
import { AuthenticationService } from './services/authentication.service';
import { AdminService } from './services/admin.service';
import { OnlineService } from './services/online.service';
import { CartService } from './services/cart.service';

const routes: Routes = [
	{ path: '', component: HomeComponent },
	{ path: 'about', component: AboutPageComponent },
	{ path: 'shop-full-width/:id', component: ShopFullWidthPageComponent },
	{ path: 'sticky-product/:id', component: StickyProductPageComponent },
	{ path: 'slider-product/:id', component: SliderProductPageComponent },
	{ path: 'customer-service', component: CustomerServicePageComponent },
	{ path: 'profile-authentication', component: MyAccountPageComponent },
	{ path: 'order-tracking', component: OrderTrackingPageComponent, canActivate: [AuthGuard] },
	{ path: 'gallery', component: GalleryPageComponent },
	{ path: 'cart', component: CartPageComponent },
	{ path: 'checkout', component: CheckoutPageComponent },
	{ path: 'wishlist', component: WishlistPageComponent },
	{ path: 'faq', component: FaqPageComponent },
	{ path: 'coming-soon', component: ComingSoonPageComponent },
	{ path: 'contact', component: ContactPageComponent },
	{ path: '**', component: NotFoundPageComponent }
];

@NgModule({
	declarations: [
		AppComponent,
		GalleryPageComponent,
		ContactPageComponent,
		HomeComponent,
		NavbarStyleComponent,
		PartnerComponent,
		TestimonialsComponent,
		DealInThisWeekComponent,
		FacilityStyleComponent,
		SubscribeComponent,
		HomeBannerComponent,
		FooterComponent,
		NotFoundPageComponent,
		ComingSoonPageComponent,
		FaqPageComponent,
		OrderTrackingPageComponent,
		MyAccountPageComponent,
		CustomerServicePageComponent,
		UpcomingProductsComponent,
		TrendingProductsComponent,
		PopularProductsComponent,
		NewProductsComponent,
		DiscountComponent,
		StickyProductPageComponent,
		CartPageComponent,
		CheckoutPageComponent,
		WishlistPageComponent,
		AboutPageComponent,
		VideoComponent,
		WhyChooseUsComponent,
		ShopFullWidthPageComponent,
		SliderProductPageComponent
	],
	imports: [
		BrowserModule,
		RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' }),
		BrowserAnimationsModule,
		CarouselModule,
		NgxScrollTopModule,
		HttpClientModule,
		ReactiveFormsModule,
		NgxPaginationModule,
		SelectDropDownModule
	],
	providers: [
		AuthGuard,
		AuthenticationService,
		AdminService,
		OnlineService,
		CartService
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
