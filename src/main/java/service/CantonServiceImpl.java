/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Canton;

/**
 *
 * @author andyj
 */
public class CantonServiceImpl implements CantonService {

    private static List<Canton> cantonList = new ArrayList<>();

    @Override
    public void crear(Canton canton) {
        this.cantonList.add(canton);
        this.almacenarArchivo(canton, "C:/Netbeans1/canton.dat");
    }

    @Override
    public Canton buscarPorCodigo(int codigo) {
        Canton retorno = null;
        for (var canton : this.cantonList) {
            if (codigo == canton.getCodigo()) {
                retorno = canton;
                break;
            }
        }
        return retorno;
    }

    @Override
    public List<Canton> listar() {
        return this.cantonList;
    }

    @Override
    public void eliminar(int codigo) {
        var indice = 0;
        for (var materia : this.cantonList) {
            if (materia.getCodigo() == codigo) {
                this.cantonList.remove(indice);
                break;
            } else {
                indice++;
            }
        }
    }

    @Override
    public void almacenarArchivo(Canton canton, String ruta) {
        DataOutputStream salida = null;

        try {
            salida = new DataOutputStream(new FileOutputStream(ruta, true));
            
            salida.writeInt(canton.getCodigo());
            
            
            salida.write(canton.getProvincia());
            

        } catch (IOException ex) {
            Logger.getLogger(CantonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Canton> recuperarArchivo(String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
