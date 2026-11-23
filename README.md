Simulador de la Jerarquía de Chomsky
Descripción: 
======================================
Este proyecto consiste en el desarrollo de una aplicación gráfica en Java Swing que permite visualizar y simular el comportamiento de los modelos computacionales asociados a los cuatro niveles de la Jerarquía de Chomsky.
======================================
Autor: KAMYLA GABRIELA ROSARIO CANO
======================================
Tecnologías Utilizadas:
- Java
- Java Swing
- Apache NetBeans
- Git
- GitHub
========================
Estructura del Proyecto
========================
src
│
├── principal
│ └── Main.java
│
├── vista
│ ├── VentanaPrincipal.java
│ ├── PanelNivel3.java
│ ├── PanelNivel2.java
│ ├── PanelNivel1.java
│ └── PanelNivel0.java
│
└── modelo
==============================================================
Requisitos para ejecutar el proyecto es necesario contar con:
==============================================================
- Java JDK 17 o superior
- Apache NetBeans (recomendado ya que fue el utilizado para este proyecto)

===========
Instalación
===========
1. Clonar el repositorio
-git clone https://github.com/KamylaRossari/Jerarquia-Chomsky.git
2. Abrir el proyecto
-Abrir Apache NetBeans y seleccionar:
- File → Open Project
- Buscar la carpeta del proyecto.
- Abrir el proyecto.
3. Ejecutar la aplicación

Ejecutar la clase principal:
- principal.Main

La aplicación contiene cuatro módulos independientes correspondientes a los niveles de la Jerarquía de Chomsky.

=============================
Nivel 3 – Lenguajes Regulares
=============================
Modelo Computacional

Autómata Finito Determinista (AFD)

Lenguaje Implementado:  ab*
Características
1. Procesamiento símbolo por símbolo.
2. Visualización de estados.
3. Visualización de transiciones.
4. Validación de cadenas.
5. Funcionamiento

El autómata inicia en el estado q0.

Cuando lee un símbolo a pasa al estado q1.

Posteriormente puede consumir cero o más símbolos b permaneciendo en el mismo estado.

=======================================
Nivel 2 – Lenguajes Libres de Contexto
=======================================
Modelo Computacional

Autómata con Pila (PDA)

Lenguaje Implementado: aⁿbⁿ
Características
1. Memoria tipo LIFO.
2. Operaciones Push y Pop.
3. Evolución gráfica de la pila.
4. Procesamiento paso a paso.
5. Funcionamiento

Por cada símbolo a leído se ejecuta una operación:
Push(a)

Por cada símbolo b leído se ejecuta una operación:
Pop(a)

La cadena será aceptada únicamente cuando la pila quede vacía al finalizar el procesamiento.

=========================================
Nivel 1 – Lenguajes Sensibles al Contexto
=========================================
Modelo Computacional

Autómata Linealmente Acotado (LBA)

Lenguaje Implementado: aⁿbⁿcⁿ
Características
1. Cinta acotada.
2. Delimitadores de frontera.
3. Movimiento bidireccional del cabezal.
4. Marcado de símbolos procesados.
5. Funcionamiento

La simulación construye una cinta utilizando delimitadores:
# cadena #

Los símbolos procesados son marcados mediante:
a → X
b → Y
c → Z

El cabezal se desplaza tanto hacia la derecha como hacia la izquierda sobre la cinta para representar el comportamiento de un Autómata Linealmente Acotado.

===========================
Nivel 0 – Máquina de Turing
===========================
Modelo Computacional

Máquina de Turing

Lenguaje Implementado: aⁿbⁿ
Características
1. Cinta extendible.
2. Lectura de símbolos.
3. Escritura de símbolos.
4. Estado activo.
5. Movimiento del cabezal.
   
 Alfabeto de la Cinta
 ====================
a, b = símbolos de entrada
X, Y = símbolos marcados
□ = símbolo blanco
Estados Utilizados: q0, q1, qAceptacion
La máquina recorre la cinta:
1. Lee símbolos.
2. Escribe nuevos símbolos.
3. Cambia de estado.
4. Desplaza el cabezal.
5. Finaliza en un estado de aceptación.
                                  ====================
                                    Cadenas de Prueba:
                                 ======================
Nivel	  |  Lenguaje	|  Cadena de ejemplo	|    Válidas	            |      No válidas
___________________________________________________________________________________________
Nivel 3	| ab*    	  |  abb	              |  a, ab, abb, abbb	      |  b, aa, aba
Nivel 2	|  aⁿbⁿ	    |  aaabbb	            |  ab, aabb, aaabbb	      |  abb, aab, aaabb
Nivel 1	|  aⁿbⁿcⁿ	  |  aaabbbccc	        |  abc, aabbcc, aaabbbccc	|  abbc, aabccc, aaabbcc
Nivel 0	|  aⁿbⁿ	    |  aaabbb	            |  ab, aabb, aaabbb	      |  abb, aab, aaabb

Objetivo Académico
==================
Este proyecto fue desarrollado con el propósito de visualizar y comprender el funcionamiento interno de los distintos modelos computacionales asociados a la Jerarquía de Chomsky, evidenciando las diferencias existentes entre:

Autómatas Finitos.
Autómatas con Pila.
Autómatas Linealmente Acotados.
Máquinas de Turing.

Asimismo, permite observar cómo cada nivel incorpora mecanismos adicionales de memoria y procesamiento para reconocer lenguajes cada vez más complejos.

Resultado
=========
La aplicación proporciona una representación gráfica e interactiva de los cuatro niveles de la Jerarquía de Chomsky, permitiendo observar el procesamiento de cadenas, el uso de memoria, las transiciones de estado y el comportamiento de los diferentes modelos computacionales estudiados en Teoría de la Computación.
