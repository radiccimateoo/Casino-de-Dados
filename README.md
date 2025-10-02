LINK A VIDEO DE YOUTUBE --> https://youtu.be/M3oQ_8N-le4



# Casino-de-Dados
Realización de mejoras partiendo como base del desafío N°3 de la materia

________________________________________________________________________________________________________________________________
*** Instrucciones para correr el juego ***
1. Primero deberá ejecutar el programa, a continuación la salida por consola le solicitará cuántos jugadores participarán (máximo 2, 3 o 4).
2. Luego de haber cargado la cantidad de jugadores solicitado, por cada uno de ellos se le pedirá nombre del jugador, apodo y tipo de jugador al que corresponda representandolo con un número (1=Novato, 2=Experto, 3=VIP).
3. Luego al apretar enter, finalmente de manera automática comenzará el juego, en donde mostrará la seguidilla de las rondas que se jugaron, ganador por cada ronda, estado de dinero de cada uno, registro de las últimas 5 partidas y un reporte final indicando estadisticas y ranking de los jugadores.

   OBSERVACIONES
   * El juego está configurado para que se jueguen de manera automática 8 partidas fijas a 3 rondas cada una, como pedía la consigna y por eso lo mostramos en este caso, se cumple una de las condiciones que es que un jugador se quedó sin dinero, por lo tanto el juego finaliza. Si esa condición no se hubiera cumplido se hubieran jugado las 8 partidas con normalidad.
   * Todos los jugadores arrancan con dinero inicial de $500.
________________________________________________________________________________________________________________________________
*** Ejemplo de partida (pantallazo o salida por consola) ***

�Bienvenidos al Casino de Dados! 
El jugador 'El Casino' (Casino) se ha unido al juego.
�Cu�ntos jugadores participar�n? (2-4): 2
Nombre del jugador 1: mateo
Ingresa un apodo (solo letras y espacios) 1: mateee
Tipo (1=Novato, 2=Experto, 3=VIP): 1
Nombre del jugador 2: ceci
Ingresa un apodo (solo letras y espacios) 2: chechuu
Tipo (1=Novato, 2=Experto, 3=VIP): 1

*************************************

Comienza el juego!

=== Partida 1 ===

---- Ronda 1

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 2 + 5 = 7
mateo (Novato) apost� $50 y sac� 2 + 1 = 3
ceci (Novato) apost� $50 y sac� 2 + 5 = 7

Ganador(es) de la ronda:
-> ceci (Novato) gana $50
-> Casino (El Casino) gana $50

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $550
mateo (Novato): $450
ceci (Novato): $500

---- Ronda 2
�El Casino confunde a mateo (Novato)!

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 6 + 6 = 12
 -> �El efecto de la confusi�n reduce el puntaje de mateo (Novato)!
mateo (Novato) apost� $50 y sac� 3 + 3 = 6
ceci (Novato) apost� $50 y sac� 5 + 6 = 11

Ganador(es) de la ronda:
-> Casino (El Casino) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $650
mateo (Novato): $400
ceci (Novato): $450

---- Ronda 3

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 4 + 2 = 6
mateo (Novato) apost� $50 y sac� 1 + 5 = 6
ceci (Novato) apost� $50 y sac� 6 + 1 = 7

Ganador(es) de la ronda:
-> ceci (Novato) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $650
mateo (Novato): $350
ceci (Novato): $500

=== Partida 2 ===

---- Ronda 1
�El Casino confunde a ceci (Novato)!

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 6 + 6 = 12
mateo (Novato) apost� $50 y sac� 5 + 1 = 6
 -> �El efecto de la confusi�n reduce el puntaje de ceci (Novato)!
ceci (Novato) apost� $50 y sac� 1 + 1 = 2

Ganador(es) de la ronda:
-> Casino (El Casino) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $750
mateo (Novato): $300
ceci (Novato): $450

---- Ronda 2
�El Casino confunde a mateo (Novato)!

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 6 + 6 = 12
 -> �El efecto de la confusi�n reduce el puntaje de mateo (Novato)!
mateo (Novato) apost� $50 y sac� 2 + 3 = 5
ceci (Novato) apost� $50 y sac� 5 + 6 = 11

Ganador(es) de la ronda:
-> Casino (El Casino) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $850
mateo (Novato): $250
ceci (Novato): $400

---- Ronda 3

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 4 + 2 = 6
mateo (Novato) apost� $50 y sac� 3 + 6 = 9
ceci (Novato) apost� $50 y sac� 4 + 6 = 10

Ganador(es) de la ronda:
-> ceci (Novato) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $850
mateo (Novato): $200
ceci (Novato): $450

=== Partida 3 ===

---- Ronda 1

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 6 + 3 = 9
mateo (Novato) apost� $50 y sac� 1 + 5 = 6
ceci (Novato) apost� $50 y sac� 4 + 1 = 5

Ganador(es) de la ronda:
-> Casino (El Casino) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $950
mateo (Novato): $150
ceci (Novato): $400

---- Ronda 2

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 1 + 6 = 7
mateo (Novato) apost� $50 y sac� 5 + 3 = 8
ceci (Novato) apost� $50 y sac� 2 + 2 = 4

Ganador(es) de la ronda:
-> mateo (Novato) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $950
mateo (Novato): $200
ceci (Novato): $350

---- Ronda 3

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 5 + 6 = 11
mateo (Novato) apost� $50 y sac� 6 + 4 = 10
ceci (Novato) apost� $50 y sac� 5 + 1 = 6

Ganador(es) de la ronda:
-> Casino (El Casino) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $1050
mateo (Novato): $150
ceci (Novato): $300

=== Partida 4 ===

---- Ronda 1

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 6 + 5 = 11
mateo (Novato) apost� $50 y sac� 6 + 6 = 12
ceci (Novato) apost� $50 y sac� 4 + 6 = 10

Ganador(es) de la ronda:
-> mateo (Novato) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $1050
mateo (Novato): $200
ceci (Novato): $250

---- Ronda 2

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 6 + 4 = 10
mateo (Novato) apost� $50 y sac� 2 + 2 = 4
ceci (Novato) apost� $50 y sac� 6 + 5 = 11

Ganador(es) de la ronda:
-> ceci (Novato) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $1050
mateo (Novato): $150
ceci (Novato): $300

---- Ronda 3

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 6 + 1 = 7
mateo (Novato) apost� $50 y sac� 2 + 2 = 4
ceci (Novato) apost� $50 y sac� 3 + 6 = 9

Ganador(es) de la ronda:
-> ceci (Novato) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $1050
mateo (Novato): $100
ceci (Novato): $350

=== Partida 5 ===

---- Ronda 1
�El Casino confunde a mateo (Novato)!

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 6 + 4 = 10
 -> �El efecto de la confusi�n reduce el puntaje de mateo (Novato)!
mateo (Novato) apost� $50 y sac� 4 + 1 = 5
ceci (Novato) apost� $50 y sac� 6 + 5 = 11

Ganador(es) de la ronda:
-> ceci (Novato) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $1050
mateo (Novato): $50
ceci (Novato): $400

---- Ronda 2

Apuestas y lanzamientos:
Casino (El Casino) apost� $0 y sac� 6 + 6 = 12
mateo (Novato) apost� $50 y sac� 5 + 5 = 10
ceci (Novato) apost� $50 y sac� 1 + 1 = 2

Ganador(es) de la ronda:
-> Casino (El Casino) gana $100

Estado de dinero de los jugadores tras la ronda:
Casino (El Casino): $1150
mateo (Novato): $0

? El jugador mateo (Novato) qued� sin dinero. El juego finaliza.
? Juego finalizado anticipadamente en la ronda 2 de la partida 5


Juego terminado. Generando reporte final...
========================================
      REPORTE FINAL DEL CASINO
========================================
Jugadores participantes: 3
Total de partidas jugadas: 5

--- RANKING FINAL ---
1. Casino (El Casino) - $1150 - 3 partidas ganadas
2. ceci (Novato) - $350 - 1 partidas ganadas
3. mateo (Novato) - $0 - 0 partidas ganadas

--- ESTAD�STICAS GENERALES ---
Mayor apuesta realizada: $50 (mateo (Novato))
Mejor puntaje de dados: 12 (Casino (El Casino))
Jugadores afectados por trampas: ceci(1), mateo(3)
La trampa 'Dados Cargados' fue usada 14 veces por el casino.

--- HISTORIAL RECIENTE ---
PARTIDA #8 - Jugadores: Casino, mateo, ceci | Ganador: Casino (El Casino) | Rondas ganadas: 3 de 3
PARTIDA #1 - Jugadores: Casino, mateo, ceci | Ganador: Casino (El Casino) | Rondas ganadas: 2 de 3
PARTIDA #2 - Jugadores: Casino, mateo, ceci | Ganador: Casino (El Casino) | Rondas ganadas: 2 de 3
PARTIDA #3 - Jugadores: Casino, mateo, ceci | Ganador: Casino (El Casino) | Rondas ganadas: 2 de 3
PARTIDA #4 - Jugadores: Casino, mateo, ceci | Ganador: ceci (Novato) | Rondas ganadas: 2 de 3
========================================
________________________________________________________________________________________________________________________________

*** Integrantes y rol de cada uno ***
Mateo Radicci - inicializador del repositorio, encargado de la consigna 1 y de subir todos los cambios fusionados a la rama principal main
Cecilia Mastrocola, Lucas Vaquero y Esthepany Malqui - colaboradores del repositorio con todos los permisos, cada uno encargado de sus puntos respectivos y de subir los cambios asignados a sus ramas con el formato Nombre-Consigna-Numero de consigna

________________________________________________________________________________________________________________________________


*** desafíos que encontramos al integrar las nuevas funcionalidades ***
Por ahora lo único desafiante encontrado fue tratar de mostrar cuantas veces fue usado por el jugador casino la trampa 'Dados Cargados'.
El resto no fueron desafíos sino pequeños detalles que se fueron encontrando, por ejemplo antes se mostraba siempre en el reporte final del casino 8 partidas jugadas en total sin importar si se cortaba antes el ciclo porque un jugador se quedó sin dinero, el cual ya fue solucionado.
Luego otra observación como detalle que decidimos poner fue indicar con un mensaje en qué ronda y de qué partida correspondiente finalizó el juego y poniendo el jugador que se qeudó sin dinero, a modo de ejemplo: "Juego finalizado anticipadamente en la ronda 2 de la partida 5" , "El jugador mateo (Novato) qued� sin dinero. El juego finaliza."
