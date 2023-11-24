package com.croptalk.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document
public class User {
  @Id
  private String id;
  private String name;
  private String email;
  private String phone;
  private String password;
  private String confirmPassword;
  private boolean isActive;

  public User(String name, String email, String phone, String password, String confirmPassword, boolean isActive) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.isActive = isActive;
  }

  public User() {
  }

  // getters
  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getPassword() {
    return this.password;
  }

  public String getConfirmPassword() {
    return this.confirmPassword;
  }

  public boolean getActive() {
    return this.isActive;
  }

  // setters

  //valida nome para nao ter número
  private boolean isValidateName(String name){
    if (name.matches(".*\\d.*")) return false;
    return true;
}
  public void setName(String name) throws Exception {
    if(name == null) throw new Exception("Nome ausente");
    if(!isValidateName(name)) throw new Exception("Nome inválido!");
    this.name = name;
  }

  //valida o email para o padrão
  private boolean isValidateEmail(String email){  
    if (!email.matches("^[^@]+@[^@]+\\.(com|br)$")) return false;
    return true;
}  


  public void setEmail(String email) throws Exception{
    if(email == null) throw new Exception("E-mail ausente");
    if(!isValidateEmail(email))throw new Exception("E-mail inválido");
    this.email = email;
  }

  private boolean isValidatePhone(String phone) {
    // Remover caracteres especiais usando expressão regular
    phone = phone.replaceAll("[^0-9]", "");
    if(phone.length() != 11) return false;
    return true;
}

  public void setPhone(String phone) throws Exception {
    if(phone == null) throw new Exception("Telefone ausente!");
    if(!isValidatePhone(phone)) throw new Exception("Telefone inválido!");
    this.phone = phone;
  }

  private boolean isValidatePassword(String password){
    if(password.length() < 8) return false;
    return true;
}  
  public void setPassword(String password) throws Exception {
    if(password == null) throw new Exception("Senha ausente");
    if(!isValidatePassword(password)) throw new Exception("A senha deve ter pelo menos 8 dígitos");
    this.password = password;
  }

  private boolean isValidateConfirmPass(String password,String confirmPassword){
    if(password.length()!= confirmPassword.length()) return false;
    if(!password.equals(confirmPassword)) return false;
    return true;
}

  public void setConfirmPassword(String confirmPassword) throws Exception {
    if(confirmPassword == null) throw new Exception("Confirmar senha ausente!");
    if(!isValidateConfirmPass(this.password, confirmPassword)) throw new Exception("Senhas não conferem!");
    this.confirmPassword = confirmPassword;
  }

  public void isActive(boolean isActive) {
    this.isActive = isActive;
  }

}
