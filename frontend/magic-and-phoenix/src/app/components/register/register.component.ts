import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

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
    private router: Router,
    private authService: AuthService
  ) {
    // Initialize Form Control fields
    this.nameField = new FormControl('', [Validators.required]);
    this.emailField = new FormControl('', [Validators.required, Validators.email]);
    this.passwordField = new FormControl('', [Validators.required]);


    // Initialzie Form Group
    this.form = new FormGroup({
      name: this.nameField,
      email: this.emailField,
      password: this.passwordField
    });
  }

  ngOnInit(): void {

  }

  createUser(form: FormGroup): void {
    let user = {
      username: form.value.name,
      email: form.value.email,
      password: form.value.password,
      role: ["user"]
    }
    
    this.authService.register(user).subscribe(resp => {
      
      console.log(resp);
      alert(resp.message);
      this.router.navigateByUrl("login");
    }, err =>{
      alert(err.error)
    });
  }

  goToLogin(): void {
    this.router.navigateByUrl("login")
  }

}
