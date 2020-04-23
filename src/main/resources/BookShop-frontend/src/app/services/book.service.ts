import{Injectable}from'@angular/core';
import {HttpClient }from '@angular/common/http';

const baseUrl = 'http://localhost:8080/api/books';

@Injectable({
providedIn: 'root'
})
export class BookService {

constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(baseUrl);
  }

  get(id) {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data) {
    return this.http.post(`${baseUrl}/add`, data);
  }

  update(id, data) {
    return this.http.put(`${baseUrl}/${id}/update`, data);
  }

  delete(id) {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll() {
    return this.http.delete(baseUrl);
  }

  findByTitle(title) {
    return this.http.get(`${baseUrl}?title=${title}`);
  }
}
