// Comandos concretos: cada botón guarda el televisor y le pide una sola cosa

class ComandoEncenderApagar implements Comando {
    private Televisor tv;

    public ComandoEncenderApagar(Televisor tv) {
        this.tv = tv;
    }

    public void ejecutar() {
        tv.encenderApagar();
    }
}

class ComandoSubirVolumen implements Comando {
    private Televisor tv;

    public ComandoSubirVolumen(Televisor tv) {
        this.tv = tv;
    }

    public void ejecutar() {
        tv.subirVolumen();
    }
}

class ComandoBajarVolumen implements Comando {
    private Televisor tv;

    public ComandoBajarVolumen(Televisor tv) {
        this.tv = tv;
    }

    public void ejecutar() {
        tv.bajarVolumen();
    }
}

class ComandoCanalSiguiente implements Comando {
    private Televisor tv;

    public ComandoCanalSiguiente(Televisor tv) {
        this.tv = tv;
    }

    public void ejecutar() {
        tv.canalSiguiente();
    }
}

class ComandoCanalAnterior implements Comando {
    private Televisor tv;

    public ComandoCanalAnterior(Televisor tv) {
        this.tv = tv;
    }

    public void ejecutar() {
        tv.canalAnterior();
    }
}
