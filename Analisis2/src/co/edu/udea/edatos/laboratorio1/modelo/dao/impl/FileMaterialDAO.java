package co.edu.udea.edatos.laboratorio1.modelo.dao.impl;

import co.edu.udea.edatos.laboratorio1.modelo.Material;
import co.edu.udea.edatos.laboratorio1.modelo.dao.MaterialDAO;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.StandardOpenOption.APPEND;

public class FileMaterialDAO implements MaterialDAO {

    private static final String NOMBRE_ARCHIVO = "Material.txt";
    private static final int LONGITUD_REGISTRO = 119;
    private static final int ISBN_LONGITUD = 10;
    private static final int TITULO_LONGITUD = 20;
    private static final int AUTOR_LONGITUD = 20;
    private static final int ANIO_LONGITUD = 4;
    private static final int DISPONIBILIDAD_LONGITUD = 5;
    private static final int IDIOMA_LONGITUD = 10;
    private static final int PAIS_LONGITUD = 15;
    private static final int CATEGORIA_LONGITUD = 10;
    private static final int EDITORIAL_LONGITUD = 15;
    private static final int DIASPRESTAMO_LONGITUD = 10;


    private static final Path archivo = Paths.get(NOMBRE_ARCHIVO);
    public static final String ENCODING_WINDOWS = "Cp1252";

    private static final Map<String, Material> CACHE_MATERIALES = new HashMap<>();

    @Override
    public List<Material> listarMateriales() {
        List<Material> materiales = new ArrayList<>();
        try (SeekableByteChannel sbc = Files.newByteChannel(archivo)) {
            ByteBuffer buf = ByteBuffer.allocate(LONGITUD_REGISTRO);
            while (sbc.read(buf) > 0) {
                buf.rewind();
                CharBuffer registro = Charset.forName(ENCODING_WINDOWS).decode(buf);
                Material material = parseMaterial(registro);
                materiales.add(material);
                buf.flip();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return materiales;
    }

    @Override
    public Material consultarMaterialxISBN(String ISBN) {
        Material material = CACHE_MATERIALES.get(ISBN);
        if (material != null) {
            return material;
        }
        try (SeekableByteChannel sbc = Files.newByteChannel(archivo)) {
            ByteBuffer buf = ByteBuffer.allocate(LONGITUD_REGISTRO);
            while (sbc.read(buf) > 0) {
                buf.rewind();
                CharBuffer registro = Charset.forName(ENCODING_WINDOWS).decode(buf);
                String isbn = registro.subSequence(0, ISBN_LONGITUD).toString().trim();
                if (isbn.equals(ISBN)) {
                    material = parseMaterial(registro);
                    CACHE_MATERIALES.put(isbn, material);
                    return material;
                }
                buf.flip();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean guardarMaterial(Material material) {
        if (consultarMaterialxISBN(material.getISBN()) != null) {
            return false;
        }
        String registro = parseMaterialString(material);
        byte[] datos = registro.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(datos);
        try (FileChannel fc = (FileChannel.open(archivo, APPEND))) {
            fc.write(buffer);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return true;
    }

    private String parseMaterialString(Material material) {
        StringBuilder registro = new StringBuilder();
        registro.append(rellenarCampo(material.getISBN(), ISBN_LONGITUD));
        registro.append(rellenarCampo(material.getAutor(), TITULO_LONGITUD));
        registro.append(rellenarCampo(material.getAutor(), AUTOR_LONGITUD));
        registro.append(rellenarCampo(material.getAnio(), ANIO_LONGITUD));
        registro.append(rellenarCampo(String.valueOf(material.isDisponible()), DISPONIBILIDAD_LONGITUD));
        registro.append(rellenarCampo(material.getIdioma(), IDIOMA_LONGITUD));
        registro.append(rellenarCampo(material.getPais(), PAIS_LONGITUD));
        registro.append(rellenarCampo(material.getCategoria(), CATEGORIA_LONGITUD));
        registro.append(rellenarCampo(material.getEditorial(), EDITORIAL_LONGITUD));
        registro.append(rellenarCampo(String.valueOf(material.getDiasPrestamo()), DIASPRESTAMO_LONGITUD));

        return registro.toString();
    }

    private String rellenarCampo(String campo, int tamanio) {
        if (campo.length() > tamanio) {
            return campo.substring(0, tamanio);
        }
        return String.format("%1$-" + tamanio + "s", campo);
    }

    /**
     * Convierte un registro almacenado en un CharBuffer a un Objeto de Persona
     *
     * @param registro
     * @return
     */
    private Material parseMaterial(CharBuffer registro) {
        Material c = new Material();
        String isbn = registro.subSequence(0, ISBN_LONGITUD).toString().trim();
        registro.position(ISBN_LONGITUD);
        registro = registro.slice();
        c.setISBN(isbn);

        String titulo = registro.subSequence(0, TITULO_LONGITUD).toString().trim();
        registro.position(TITULO_LONGITUD);
        registro = registro.slice();
        c.setTitulo(titulo);

        String autor = registro.subSequence(0, AUTOR_LONGITUD).toString().trim();
        registro.position(AUTOR_LONGITUD);
        registro = registro.slice();
        c.setAutor(autor);

        String anio = registro.subSequence(0, ANIO_LONGITUD).toString().trim();
        registro.position(ANIO_LONGITUD);
        registro = registro.slice();
        c.setAnio(anio);

        boolean disponibilidad = Boolean.valueOf(registro.subSequence(0, DISPONIBILIDAD_LONGITUD).toString());
        registro.position(DISPONIBILIDAD_LONGITUD);
        registro = registro.slice();
        c.setDisponible(disponibilidad);

        String idioma = registro.subSequence(0, IDIOMA_LONGITUD).toString().trim();
        registro.position(IDIOMA_LONGITUD);
        registro = registro.slice();
        c.setIdioma(idioma);
        
        String pais = registro.subSequence(0, PAIS_LONGITUD).toString().trim();
        registro.position(PAIS_LONGITUD);
        registro = registro.slice();
        c.setPais(pais);
        
        String categoria = registro.subSequence(0, CATEGORIA_LONGITUD).toString().trim();
        registro.position(CATEGORIA_LONGITUD);
        registro = registro.slice();
        c.setCategoria(categoria);
        
        String editorial = registro.subSequence(0, EDITORIAL_LONGITUD).toString().trim();
        registro.position(EDITORIAL_LONGITUD);
        registro = registro.slice();
        c.setEditorial(editorial);

        int diasPres = Integer.valueOf(registro.toString().trim());
        c.setDiasPrestamo(diasPres);

        return c;
    }

}
