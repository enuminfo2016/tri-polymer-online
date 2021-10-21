import { Component, OnInit } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';

@Component({
    selector: 'app-testimonials',
    templateUrl: './testimonials.component.html',
    styleUrls: ['./testimonials.component.scss']
})
export class TestimonialsComponent implements OnInit {

    constructor() { }

    ngOnInit(): void {
    }

    sectionTitle = [
        {
            subTitle: "TESTIMONIALS",
            title: "What Cliens Say About Us"
        }
    ]
    singleTestimonialsItem = [
        {
            feedback: "",
            authorImg: 'assets/img/user1.jpg',
            authorName: 'Raghu CHOWDAREDDY',
            authorDesignation: 'CEO'
        },
        {
            feedback: "",
            authorImg: 'assets/img/user2.jpg',
            authorName: 'Siva Kumar AKURATI',
            authorDesignation: 'CTO'
        }
    ]

    testimonialsSlidesOptions: OwlOptions = {
        loop: true,
        nav: true,
        dots: false,
        autoplayHoverPause: true,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        autoplay: true,
        navText: [
            "<i class='bx bx-left-arrow-alt'></i>",
            "<i class='bx bx-right-arrow-alt'></i>"
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

}