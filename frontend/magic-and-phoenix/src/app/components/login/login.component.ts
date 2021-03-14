import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginData } from 'src/app/interfaces/login-data';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  nameField: FormControl;
  passwordField: FormControl;

  constructor(
      private router: Router,
      private authService: AuthService
  ) { 
    // Initialize Form Control fields
    this.nameField = new FormControl('', [ Validators.required]);
    this.passwordField = new FormControl('', [ Validators.required, Validators.min(7)]);
   

    // Initialzie Form Group
    this.form = new FormGroup({
      name: this.nameField,
      password: this.passwordField
    });
  }

  ngOnInit(): void {
  }


  goToRegister(): void{
    this.router.navigateByUrl("register")
  }

  login(form: FormGroup): void {
    let user: any = {
      "username": form.value.name,
      "password": form.value.password
  }
    this.authService.login(user).subscribe(resp => {
      this.authService.setToken(resp.accessToken);
      this.router.navigateByUrl("/select-game")
    }, err => {
      alert("username or password incorrect");
    })   
    
  }
}
