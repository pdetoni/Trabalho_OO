/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import Classes.Agenda;
import Classes.Consulta;
import Classes.Paciente;
import Classes.Perfil;
import Classes.Usuario;

/**
 *
 * @author pdper
 */
public class Teste {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(12, "Paulo", "121131", 'M', 54, "HASDF", "sfjsdf", "chefe" );
        Paciente paciente = new Paciente(23, "Sergio", "1234131", 'F', 54, "HASDfsdF","36604000", "rua 1" );
        
        Consulta consulta = new Consulta(1, "dentista");
        
        System.out.println(usuario.toString());
        System.out.println(paciente.toString());
        
        Agenda agenda = new Agenda(1, "12/11/2023 11:30", paciente , consulta);
        
        System.out.println(agenda);
        
    }
    
    
}
