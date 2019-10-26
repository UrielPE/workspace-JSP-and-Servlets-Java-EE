/**
 *
 * @author URIEL
 */

package com.sit.webjavamvc.model.vo;

import java.util.Date;

public class Cuenta 
{
    private String name;
    private String email;
    private String saldo;
    private String endeudamientoLevel;
    private String renovationDate;
    
    public Cuenta(){
    }

    public Cuenta(String name, String email, String saldo,
        String endeudamientoLevel, String renovationDate) 
    {
        this.name = name;
        this.email = email;
        this.saldo = saldo;
        this.endeudamientoLevel = endeudamientoLevel;
        this.renovationDate = renovationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getEndeudamientoLevel() {
        return endeudamientoLevel;
    }

    public void setEndeudamientoLevel(String endeudamientoLevel) {
        this.endeudamientoLevel = endeudamientoLevel;
    }

    public String getRenovationDate() {
        return renovationDate;
    }

    public void setRenovationDate(String renovationDate) {
        this.renovationDate = renovationDate;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "name=" + name + ", email=" + email + ","
            + " saldo=" + saldo + ", endeudamientoLevel=" + endeudamientoLevel 
            + ", renovationDate=" + renovationDate + '}';
    }
}
