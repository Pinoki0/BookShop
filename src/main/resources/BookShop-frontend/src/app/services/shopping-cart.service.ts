import{Injectable}from'@angular/core';
import {HttpClient }from '@angular/common/http';

const baseUrl = 'http://localhost:8080/api/shoppingCart';

@Injectable({
providedIn: 'root'
})
export class ShoppingCartService {

constructor(private http: HttpClient) { }

  get() {
    return this.http.get(`${baseUrl}`);
  }

  create() {
    return this.http.post(`${baseUrl}/add`, null);
  }

  update(id, data) {
    return this.http.put(`${baseUrl}/${id}/update`, data);
  }

  delete(id) {
    return this.http.delete(`${baseUrl}/${id}`);
  }

}
