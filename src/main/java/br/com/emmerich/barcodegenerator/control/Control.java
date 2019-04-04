/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emmerich.control;

import com.emmerich.util.BarCodeGenerator;
import com.emmerich.view.Tela;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

/**
 *
 * @author estagiodev
 */
public class Control {

    private final Tela tela;
    private final BarCodeGenerator barCodeGenerator;

    public Control(Tela tela, BarCodeGenerator barCodeGenerator) {
        this.tela = tela;
        this.barCodeGenerator = barCodeGenerator;
    }

    public void exibirTela() {
        tela.setControl(this);
        this.tela.setVisible(true);
    }

    public void fecharTela() {
        this.tela.dispose();
    }

    public String gerarBarCode(String code, String path, String type) {

        String info = "";

        try {
            if (type.equalsIgnoreCase("Code128")) {
                this.barCodeGenerator.create128BBarCode(code, path);
            }
            if (type.equalsIgnoreCase("EAN13")) {
                this.barCodeGenerator.createEAN13BarCode(code, path);
            }
            info = "Codigo gerado com sucesso";
        } catch (BarcodeException | OutputException ex) {
            System.out.println("Erro: " + ex);
            info = "Falha ao gerar codigo";
        }
        return info;
    }

    public String gerarBarCodeList(String code, String intervalo, String path, String type) {

        String info = "";
        int loop = Integer.parseInt(intervalo);

        for (Integer i = 1; i <= loop; i++) {
            try {
                if (type.equalsIgnoreCase("Code128")) {
                    this.barCodeGenerator.create128BBarCode(code + i, path);
                }
                if (type.equalsIgnoreCase("EAN13")) {
                    this.barCodeGenerator.createEAN13BarCode(code + i, path);
                }
                info = "Codigo gerado com sucesso";
            } catch (BarcodeException | OutputException ex) {
                System.out.println("Erro: " + ex);
                info = "Falha ao gerar codigo";
            }
        }
        return info;
    }
}
