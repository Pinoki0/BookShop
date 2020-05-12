import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';

@Component({
  selector: 'app-add-shopping-cart',
  templateUrl: './add-shopping-cart.component.html',
})
export class AddShoppingCartComponent implements OnInit {
  submitted = false;

  constructor(private shoppingCartService: ShoppingCartService) { }

  ngOnInit() {
  }

  saveShoppingCart() {

    this.shoppingCartService.create()
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newShoppingCart() {
    this.submitted = false;
  }
}
