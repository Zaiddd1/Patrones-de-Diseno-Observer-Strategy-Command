<h1 align="center">🧩 Patrones de Diseño: Observer, Strategy y Command — Lenguajes de Programación III</h1>

<p align="center">
  <em>Tres patrones de comportamiento en Java: avisar a muchos objetos (Observer), cambiar de algoritmo
  en tiempo de ejecución (Strategy) y convertir acciones en objetos que se pueden deshacer (Command).</em>
</p>

<p align="center">
  <img alt="Lenguaje" src="https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk&logoColor=white">
  <img alt="Tema" src="https://img.shields.io/badge/Tema-Patrones%20de%20dise%C3%B1o-blue">
  <img alt="Curso" src="https://img.shields.io/badge/Curso-LP%20III-6f42c1">
  <img alt="Sesión" src="https://img.shields.io/badge/Sesi%C3%B3n-11-brightgreen">
  <img alt="Estado" src="https://img.shields.io/badge/Compila-OK-success">
</p>

---

## 📌 Sobre este repositorio

Reúne el código de la **Sesión N.° 11** del curso **Lenguajes de Programación III**
(Escuela Profesional de Ingeniería de Sistemas — Universidad Católica de Santa María).
Todos los programas son de consola, compilan con **JDK 21** y se ejecutaron de verdad: las imágenes de
[`capturas/`](capturas) son capturas reales de la ventana de la consola.

---

## 🗂️ Estructura del repositorio

```
Patrones-de-Diseno-Observer-Strategy-Command/
├── actividades/
│   ├── actividad-01-observer-ejemplo/        Ejemplo de la guía: Subject y dos observadores
│   ├── actividad-02-strategy-ejemplo/        Ejemplo de la guía: calculadora de precios con descuentos
│   ├── actividad-03-command-ejemplo/         Ejemplo de la guía: control remoto que enciende y apaga una luz
│   ├── actividad-04-control-remoto-tv/       Command: control remoto de un televisor con 5 funciones
│   └── actividad-05-tienda-en-linea/         Aplicación que combina los tres patrones
├── ejercicios/
│   ├── ejercicio-01-notificaciones-observer/ Observer: usuarios que se suscriben y desuscriben
│   └── ejercicio-02-descuentos-strategy/     Strategy: cuatro estrategias de descuento con menú
├── capturas/                                 Capturas reales de la consola
└── README.md
```

> El ejercicio 3 de la guía dice solo «Desarrolle una aplicación»: se resolvió con la tienda en línea de la
> actividad 5, que combina los tres patrones.

---

## 🧪 ¿Dónde está cada patrón?

| Patrón | Programa | Participantes |
|---|---|---|
| **Observer** | `actividad-01`, `ejercicio-01`, `actividad-05` | Interfaz observador (`Observer` / `Observador`), observadores concretos (`ConcreteObserver`, `Usuario`, `Cliente`) y sujeto (`Subject`, `CentroDeNotificaciones`, `Tienda`) con `attach` / `detach` / `notifyObservers` o `suscribir` / `desuscribir` / `publicar`. |
| **Strategy** | `actividad-02`, `ejercicio-02`, `actividad-05` | Interfaz de estrategia (`DiscountStrategy`, `EstrategiaDescuento`), estrategias concretas y un contexto (`PriceCalculator`, `CalculadoraDePrecios`, `Tienda`) con un método `set` para cambiar la estrategia. |
| **Command** | `actividad-03`, `actividad-04`, `actividad-05` | Interfaz `Command` / `Comando`, receptor (`Light`, `Televisor`, `Carrito`), comandos concretos, invocador (`RemoteControl`, `ControlRemoto`, `HistorialDeComandos`) y cliente (`Main`). |

Cada carpeta con menú incluye un `salida-ejemplo.txt` con una sesión de ejemplo (las mismas opciones que se
escribieron en las capturas).

---

## ▶️ Cómo compilar y ejecutar

Necesitas un **JDK 17 o superior**. Cada carpeta se compila y se ejecuta por separado, desde dentro de ella:

```bash
cd actividades/actividad-05-tienda-en-linea
javac -encoding UTF-8 *.java
java Main
```

Los programas leen opciones por teclado (un número y Enter). Si ves caracteres raros en las tildes, usa una
consola con página de códigos UTF-8 o ejecuta con `java -Dstdout.encoding=UTF-8 Main`.

---

## 🧠 Conceptos cubiertos

`Observer` · `Strategy` · `Command` · interfaces · polimorfismo · `ArrayList` · `ArrayDeque` (pila para deshacer) ·
`Scanner` · principio de responsabilidad única

---

<p align="center"><sub>
Material con fines educativos — Universidad Católica de Santa María · Ingeniería de Sistemas · Lenguajes de Programación III · Sesión N.° 11
</sub></p>
