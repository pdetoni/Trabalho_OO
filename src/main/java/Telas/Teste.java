/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import Classes.Consulta;
import Classes.Perfil;
import Classes.Usuario;

/**
 *
 * @author pdper
 */
public class Teste {
    public static void main(String[] args) {
        Perfil pessoa = new Usuario(12, "Paulo", "121131", 'M', 54, "HASDF", "sfjsdf", "chefe" );
        
        System.out.println(pessoa.toString());
    }
    
    
}
