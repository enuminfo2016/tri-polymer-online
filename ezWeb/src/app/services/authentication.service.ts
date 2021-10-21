import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  currentUserSubject: BehaviorSubject<User>;
  loggedUser: Observable<User>;

  constructor(private router: Router,
              private http: HttpClient) {
    const userJson = localStorage.getItem('currentUser');
    const currentUser = userJson != null ? JSON.parse(userJson) : new User();
    this.currentUserSubject = new BehaviorSubject<User>(currentUser);
    this.loggedUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  // tslint:disable-next-line: typedef
  public login(username: string, password: string) {
    // tslint:disable-next-line: object-literal-key-quotes
    return this.http.post<User>('/api/security/user/authentication', { 'username': username, 'password': password })
      .pipe(map(user => {
        if (user && user.loggedIn) {
          localStorage.setItem('loggedUser', JSON.stringify(user));
          this.currentUserSubject.next(user);
        }
        return user;
      }));
  }

  // tslint:disable-next-line: typedef
  public logout() {
    localStorage.removeItem('loggedUser');
    localStorage.removeItem('loggedChannel');
    this.currentUserSubject.next(new User());
    this.router.navigate(['/profile-authentication'], { queryParams: { returnUrl: '/' } });
  }
}
