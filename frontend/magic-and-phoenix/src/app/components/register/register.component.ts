import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;

  nameField: FormControl;
  emailField: FormControl;
  passwordField: FormControl;

  constructor(
      private router: Router
  ) { 
    // Initialize Form Control fields
    this.nameField = new FormControl('', [ Validators.required]);
    this.emailField = new FormControl('', [ Validators.required, Validators.email ]);
    this.passwordField = new FormControl('', [ Validators.required]);
   

    // Initialzie Form Group
    this.form = new FormGroup({
      name: this.nameField,
      email: this.emailField,
      password: this.passwordField
    });
  }

  ngOnInit(): void {
    
  }

  createUser(form: FormGroup): void{
      console.log(form);
      console.log(form.value.name)
  }

  goToLogin(): void{
    this.router.navigateByUrl("login")
  }

}
