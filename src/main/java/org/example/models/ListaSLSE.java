package org.example.models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;



public class ListaSLSE {

    private Producto head; // nodo iniziale della lista

    public class Producto {
        private String nombre;
        private Long id;
        private Double price;
        private Long stock;
        private String brand;
        Producto next;

        public Producto(String nombre, Long id, Double price, Long stock, String brand) {
            this.nombre = nombre;
            this.id = id;
            this.price = price;
            this.stock = stock;
            this.brand = brand;
            this.next = null;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Long getStock() {
            return stock;
        }

        public void setStock(Long stock) {
            this.stock = stock;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public Producto getNext() {
            return next;
        }

        public void setNext(Producto next) {
            this.next = next;
        }
    }

    public ListaSLSE() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void agregar(String nombre, Long id, Double price, Long stock, String brand) {
        Producto prod = new Producto(nombre, id, price, stock, brand);

        if (isEmpty()) {
            head = prod;
        } else {
            Producto actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(prod);
        }
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("LA LISTA ESTA VACIA");
        }
        Producto aux = head;
        while (aux != null) {
            System.out.println("ID: ".concat(String.valueOf(aux.getId())) + "\n" + "NOMBRE: ".concat(aux.getNombre())+"\n"+"PRECIO: "
                    .concat(String.valueOf(aux.getPrice()))+"\n"+"STOCK: ".concat(String.valueOf(aux.getStock()))+"\n"+"BRAND: ".concat(aux.getBrand()));
            System.out.println();
            aux = aux.getNext();
        }

    }

    public void delete(Long id)
    {
        if(isEmpty())
        {
            System.out.println("ESTA VACIA");
        }
        Producto aux = head;
        int valor = Long.compare(aux.getId(),id);
        if(valor == 0)
        {
            head = head.getNext();
        }else
        {
            Producto anterior = head;
            Producto actual = head.getNext();

            while(actual != null &&!actual.getId().equals(id))
            {
                anterior = actual;
                actual = actual.getNext();
            }
            if(actual != null)
            {
                anterior.setNext(actual.getNext());
            }
        }

    }

    public Producto Ultimo()
    {
        if(isEmpty())
        {
            return null;
        }

        Producto aux = head;
        while(aux.getNext() != null)
        {
            aux = aux.getNext();
        }

        return aux;
    }

    public Producto Buscar(Long id)
    {
        Producto aux = head;
        if(isEmpty())
        {
            System.out.println("LA LISTA ESTA VACIA");
        }
        while(aux != null && aux.getId()!= id)
        {
            aux = aux.getNext();
        }
        return aux;
    }

    public Producto BuscarNombre(String nombre)
    {
        Producto aux = head;
        if(isEmpty())
        {
            System.out.println("LA LISTA ESTA VACIA");
        }
        while(aux != null && !(aux.getNombre().equals(nombre)))
        {
            aux = aux.getNext();
        }
        return aux;
    }

    public void Nombres()
    {
        Producto aux = head;
        int contador =0;

        while(aux != null && contador < 3)
        {
            System.out.println("ID: ".concat(String.valueOf(aux.getId())) + "\n" + "NOMBRE: ".concat(aux.getNombre())+"\n"+"PRECIO: "
                    .concat(String.valueOf(aux.getPrice()))+"\n"+"STOCK: ".concat(String.valueOf(aux.getStock()))+"\n"+"BRAND: ".concat(aux.getBrand()));
            System.out.println();
            aux = aux.getNext();
            contador++;
        }
    }

    public void deleteUltimo(Producto p) {
        if (isEmpty()) {
            System.out.println("ESTA VACIA");
            return;
        }
        if (head.getNext() == null) {
            head = null;
            return;
        }
        Producto aux = head;

        while (aux.getNext() != Ultimo()) {
            aux = aux.getNext();
        }

        return;
    }

    public void leerJson() {
          Gson gson = new Gson();
          ListaSLSE<JsonObject> Listaligada = new ListaSLSE<>();

          try(Reader reader = new FileReader("archivo.json")){
              JsonParser parser = new JsonParser();
              JsonArray jsonArray = (JsonArray) parser.parse
          }

    }
     public void escribirJson()
    {
  String filePath = "output.json";
        Gson gson = new Gson();

        Producto producto = new Producto("MARCOS",123L,213.45,12345L,"NEGRO");
        Producto producto2 = new Producto("ANGELA",123456L,213.45,12345L,"NEGRO");

        try(FileWriter writer = new FileWriter(filePath))
        {
            gson.toJson(producto,writer);
            gson.toJson(producto2,writer);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

     ListaSLSE lista = new ListaSLSE();
        Producto pos;
        Scanner s = new Scanner(System.in);
        int op;
       do {
            System.out.println("\t".concat("MENU"));
            System.out.println("\t".concat("1.- AGREGAR"));
            System.out.println("\t".concat("2.- IMPRIMIR"));
            System.out.println("\t".concat("3.- ELIMINAR"));
            System.out.println("\t".concat("4.- BUSCAR POR ID"));
            System.out .println("\t".concat("5.- BUSCAR POR NOMBRE"));
            System.out.println("\t".concat("6.- MODIFICAR"));
            System.out.println("\t".concat("7.- MOSTRAR LOS 3 PRIMEROS PRODUCTOS"));
            System.out.println("\t".concat("8.- ELIMINAR ULTIMO"));
            System.out.println("\t".concat("9.- LEER ARCHIVO JSON"));
           System.out.println("\t".concat("10.- ESCRIBIR ARCHIVO JSON"));

            op = s.nextInt();

            switch (op) {
                case 1: {
                    System.out.println("INGRESAR EL NOMBRE");
                    String nom = s.next();
                    System.out.println("INGRESAR ID");
                    Long id = s.nextLong();
                    System.out.println("INGRESAR PRECIO");
                    Double precio = s.nextDouble();
                    System.out.println("INGRESAR STOCK");
                    Long sto = s.nextLong();
                    System.out.println("INGRESAR BRAND");
                    String bran = s.next();

                    lista.agregar(nom, id, precio, sto, bran);
                    break;
                }
                case 2: {

                    lista.mostrar();
                    break;
                }
                case 3:
                {
                    System.out.println("DAME EL ID A ELIMINAR");
                    Long id = s.nextLong();
                    System.out.println("ELIMINANDO....");
                    lista.delete(id);
                    break;
                }
                case 4:
                {
                    System.out.println("DAME EL ID A BUSCAR");
                    Long id = s.nextLong();
                    pos = lista.Buscar(id);

                    if(pos == null)
                    {
                        System.out.println("NO SE ENCONTRO");
                    }
                    else
                    {
                        System.out.println("SE ENCONTRO CON EXITO");
                    }
                    break;
                }
                case 5:
                {
                    System.out.println("DAME EL NOMBRE A BUSCAR");
                    String nombre = s.next();
                    pos = lista.BuscarNombre(nombre);

                    if(pos == null)
                    {
                        System.out.println("NO SE ENCONTRO");
                    }
                    else
                    {
                        System.out.println("SE ENCONTRO CON EXITO");
                    }
                    break;
                }

                case 6:
                {
                    System.out.println("DAME EL ID PARA MODIFICARLO");
                    Long ide = s.nextLong();

                    pos = lista.Buscar(ide);

                    if(pos == null)
                    {
                        System.out.println("NO SE PUEDE MODIFICAR, PORQUE NO FUE ENCONTRADO");
                    }
                    else
                    {
                        System.out.println("INGRESAR EL NOMBRE");
                        String nom = s.next();
                        System.out.println("INGRESAR ID");
                        Long id = s.nextLong();
                        System.out.println("INGRESAR PRECIO");
                        Double precio = s.nextDouble();
                        System.out.println("INGRESAR STOCK");
                        Long sto = s.nextLong();
                        System.out.println("INGRESAR BRAND");
                        String bran = s.next();

                        lista.delete(ide);
                        lista.agregar(nom, id, precio, sto, bran);
                        System.out.println("MODIFICADO CON EXITO");
                    }
                    break;
                }
                case 7:
                {
                    lista.Nombres();
                    break;
                }
                case 8:
                {
                    pos = lista.Ultimo();

                    if(pos == lista.Ultimo())
                    {
                        lista.deleteUltimo(pos);
                    }

                    break;
                }
                case 9:
                {

                    lista.leerJson();
                    System.out.println("LEYENDO...");
                    break;
                }
                case 10:
                {
                    System.out.println("ESCRIBIENDO ARCHIVO JSON");
                    lista.escribirJson();
                    break;
                }
            }

        } while (op != 11);

    }
}