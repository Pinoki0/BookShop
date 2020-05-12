import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BooksListComponent } from './components/books-list/books-list.component';
import { BookDetailsComponent } from './components/book-details/book-details.component';
import { AddBookComponent } from './components/add-book/add-book.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { AddShoppingCartComponent } from './components/add-shopping-cart/add-shopping-cart.component';

const routes: Routes = [
  { path: '', redirectTo: 'books', pathMatch: 'full' },
  { path: 'books', component: BooksListComponent },
  { path: 'books/:id/update', component: BookDetailsComponent },
  { path: 'add', component: AddBookComponent },
  { path: 'shoppingCart', component: ShoppingCartComponent },
  { path: 'shoppingCart/add', component: AddShoppingCartComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
