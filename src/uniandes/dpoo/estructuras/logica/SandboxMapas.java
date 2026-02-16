package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    
    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getValoresComoLista( )
    {
        List<String> lista = new ArrayList<>(mapaCadenas.values());
        Collections.sort(lista);
        return lista;
    }

    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> lista = new ArrayList<>(mapaCadenas.keySet());
        lista.sort(Collections.reverseOrder());
        return lista;
    }

    public String getPrimera( )
    {
        if (mapaCadenas.isEmpty())
            return null;

        List<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        Collections.sort(llaves);
        return llaves.get(0);
    }

    public String getUltima( )
    {
        if (mapaCadenas.isEmpty())
            return null;

        List<String> valores = new ArrayList<>(mapaCadenas.values());
        Collections.sort(valores);
        return valores.get(valores.size() - 1);
    }

    public Collection<String> getLlaves( )
    {
        List<String> lista = new ArrayList<>();

        for (String llave : mapaCadenas.keySet())
        {
            lista.add(llave.toUpperCase());
        }

        return lista;
    }

    public int getCantidadCadenasDiferentes( )
    {
        Set<String> diferentes = new HashSet<>(mapaCadenas.values());
        return diferentes.size();
    }

    public void agregarCadena( String cadena )
    {
        if (cadena == null)
            return;

        String invertida = new StringBuilder(cadena).reverse().toString();
        mapaCadenas.put(invertida, cadena);
    }

    public void eliminarCadenaConLLave( String llave )
    {
        mapaCadenas.remove(llave);
    }

    public void eliminarCadenaConValor( String valor )
    {
        String llaveAEliminar = null;

        for (Map.Entry<String, String> entry : mapaCadenas.entrySet())
        {
            if (entry.getValue().equals(valor))
            {
                llaveAEliminar = entry.getKey();
                break;
            }
        }

        if (llaveAEliminar != null)
        {
            mapaCadenas.remove(llaveAEliminar);
        }
    }

    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear();

        for (Object obj : objetos)
        {
            String cadena = obj.toString();
            String invertida = new StringBuilder(cadena).reverse().toString();
            mapaCadenas.put(invertida, cadena);
        }
    }

    public void volverMayusculas( )
    {
        Map<String, String> nuevoMapa = new HashMap<>();

        for (Map.Entry<String, String> entry : mapaCadenas.entrySet())
        {
            String nuevaLlave = entry.getKey().toUpperCase();
            nuevoMapa.put(nuevaLlave, entry.getValue());
        }

        mapaCadenas = nuevoMapa;
    }

    public boolean compararValores( String[] otroArreglo )
    {
        for (String s : otroArreglo)
        {
            if (!mapaCadenas.containsValue(s))
                return false;
        }

        return true;
    }

}
