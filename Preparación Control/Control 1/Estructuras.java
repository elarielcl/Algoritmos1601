public class Estructuras {

    public static void main(String[] args) {
        NodoArbol t1 = new NodoArbol(7,new NodoArbol(4), new NodoArbol(6, new NodoArbol(5),null));
        NodoArbol t2 = new NodoArbol(7,new NodoArbol(4), new NodoArbol(6, new NodoArbol(5),new NodoArbol(12)));
        System.out.println(esJerarquico(t1));
        System.out.println(esJerarquico(t2));


        //Primer nodo cabecera
        NodoLista l = new NodoLista(0, new NodoLista(1, new NodoLista(4, new NodoLista(6, new NodoLista(8, null)))));
        buscarYMover(l,6);
        NodoLista a = l;
        while (a!=null){
            System.out.println(a.info);
            a = a.sgte;
        }
    }


    public static boolean esJerarquico(NodoArbol arbol){
        boolean jizq = true;
        boolean jder = true;
        if(arbol.der != null)
            jder = arbol.info >= arbol.der.info && esJerarquico(arbol.der);
        if(arbol.izq != null)
            jizq = arbol.info >= arbol.izq.info && esJerarquico(arbol.izq);
        return jizq && jder;
    }

    public static void buscarYMover(NodoLista lista, int x){
        NodoLista anterior;
        NodoLista anterior2;
        anterior2 = lista;
        lista= lista.sgte;
        if(lista!=null && lista.info==x)
            return;
        anterior = lista;
        lista = lista.sgte;
        while(lista!=null){
            if(lista.info == x){
                anterior.sgte = lista.sgte;
                lista.sgte = anterior;
                anterior2.sgte = lista;
                return;
            }
            else{
                anterior2 = anterior2.sgte;
                anterior = anterior.sgte;
                lista = lista.sgte;
            }
        }
    }


}

class NodoArbol {
    public NodoArbol izq;
    public NodoArbol der;
    public int info;

    public NodoArbol(int v){
        info = v;
        izq=null;
        der=null;
    }

    public NodoArbol(int v, NodoArbol i, NodoArbol d){
        izq = i;
        der = d;
        info = v;
    }
}

class NodoLista {
    int info;
    NodoLista sgte;

    public NodoLista(int i, NodoLista sig){
        info = i;
        sgte = sig;
    }
}