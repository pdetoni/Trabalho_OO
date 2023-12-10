/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Controller.Helper;

import Classes.Paciente;
import Telas.CriaPaciente;
import javax.swing.JOptionPane;

public class PacienteH implements IHelper{
    private final CriaPaciente view;

    public PacienteH(CriaPaciente view) {
        this.view = view;
    }

    @Override
    public Paciente obterModelo() {
        
        String nome = view.getNome().getText();
        
        String cpf = view.getCpf().getText();
        
        char sexo = view.getSexo().getText().charAt(0);
        
        int idade = Integer.parseInt(view.getIdade().getText());
        
        String email = view.getEmail().getText();
        
        String cep = view.getCep().getText();
        
        String endereco = view.getEndereco().getText();
        
        
        /*if(!cpf.matches("[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}")){
            JOptionPane.showMessageDialog(null, "CPF no formato incorreto, favor utilizar o formato: 000.000.000-00");
            limpa();
            return paciente;
            
        
        
        if(sexo != 'M' && sexo != 'm' && sexo != 'F' && sexo != 'f'){
            JOptionPane.showMessageDialog(null, "Por favor, insira o sexo no formato M,F,m,f.");
            limpa();
            return paciente;
        }
        
        if(!cep.matches("[0-9]{5}[\\-]?[0-9]{3}")){
            JOptionPane.showMessageDialog(null, "CEP no formato incorreto, favor utilizar o formato: 00000-000");
            limpa();
            return paciente;
        
        
        if(!idade.matches("[0-9]{3}")){
            JOptionPane.showMessageDialog(null, "Insira um valor válido para a idade");
            limpa();
            return paciente;
        }*/
        
        Paciente paciente = new Paciente(0, nome, cpf, sexo, idade, email, cep, endereco);
        
        return paciente;
        
    }

    @Override
    public void limpa() {
        /*
        view.setNome(null);
        view.setCpf(null);
        view.setSexo(null);
        view.setIdade(null);
        view.setEmail(null);
        view.setCep(null);
        view.setEndereco(null);
        
        
        view.getNome().setText("");
        view.getCpf().setText("");
        view.getSexo().setText("");
        view.getIdade().setText("");
        view.getEmail().setText("");
        view.getCep().setText("");
        view.getEndereco().setText("");
        */
    }
}
