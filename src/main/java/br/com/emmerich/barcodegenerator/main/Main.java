/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emmerich.main;

import com.emmerich.control.Control;
import com.emmerich.util.BarCodeGenerator;
import com.emmerich.view.Tela;

/**
 *
 * @author estagiodev
 */
public class Main {
    public static void main(String[] args) {
        
        Tela tela = new Tela();
        BarCodeGenerator bcg = new BarCodeGenerator();
        Control controle = new Control(tela, bcg);
        controle.exibirTela();
        
    }
}
