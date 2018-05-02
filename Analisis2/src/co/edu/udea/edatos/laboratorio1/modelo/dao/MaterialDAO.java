/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.edatos.laboratorio1.modelo.dao;

import co.edu.udea.edatos.laboratorio1.modelo.Material;
import java.util.List;

/**
 *
 * @author Carolina
 */
public interface MaterialDAO {

    public List<Material> listarMateriales();

    public Material consultarMaterialxISBN(String identificacion);

    public boolean guardarMaterial(Material material); 

}
