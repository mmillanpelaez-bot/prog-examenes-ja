import java.util.ArrayList;

public class ListinTelefonico {

    private String nome;
    private ArrayList<Contacto> contactos;

    public ListinTelefonico(String nome) {
        this.nome = nome;
        this.contactos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Contacto getContacto(String nome) {
        for (Contacto c : contactos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public boolean addContacto(Contacto c) {
        if (contactos.contains(c)) {
            return false;
        }
        return contactos.add(c);
    }

    public ArrayList<Contacto> getContactosEmpresa(String empresa) {
        ArrayList<Contacto> resultado = new ArrayList<>();
        for (Contacto c : contactos) {
            if (c.getEmpresa().equalsIgnoreCase(empresa)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public boolean borrarContacto(Contacto cb) {
        return contactos.remove(cb);
    }

    public void mostrarListaContactos(String empresa) {
        ArrayList<Contacto> listaAImprimir;

        if (empresa == null || empresa.equals("")) {
            listaAImprimir = new ArrayList<>(this.contactos); // Clonamos para no desordenar la original si no queremos
        } else {
            listaAImprimir = getContactosEmpresa(empresa);
        }

        // Ordenamos la lista usando nuestro Comparador personalizado antes de mostrarla
        listaAImprimir.sort(new ComparadorContactos());

        if (listaAImprimir.isEmpty()) {
            System.out.println("Non hai contactos que mostrar.");
        } else {
            for (Contacto c : listaAImprimir) {
                System.out.println(c);
            }
        }
    }
}