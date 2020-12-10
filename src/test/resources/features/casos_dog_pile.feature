# language: es
Característica: Busquedas en dogpile

   esta feature se trata de hacer una busqueda o multiples busquedas en dogpile y revisar
   los resultados obtenidos de esas busquedas.

  @Regresion
  Escenario: Buscar resultados relevante
    Dado Que Francisco entra en dogpile
    Cuando Francisco realiza una busqueda de: rock nacional
    Entonces Francisco deberia poder ver resultados que contengan la palabra: rock

  Esquema del escenario: Verificar que los resultados con texto relevante al titulo
    Dado Que Francisco entra en dogpile
    Cuando Francisco realiza una busqueda de: rock nacional
    Entonces Francisco deberia ver un texto: <texto> relevante con el titulo: <titulo>

    Ejemplos:
      | Descripcion | titulo                                 | texto                                                           |
      | Caso 1      | Argentine rock - Wikipedia             | Argentine rock (known locally as rock nacional                  |
      | Caso 2      | LO MEJOR DE EL ROCK NACIONAL - YouTube | la neta son las mejores rolitas saludos a toda la banda rockera |
      | Caso 3      | Radio Nacional Rock - 93.7 en vivo     | Radio rock national 93.7 fm es una emisora de radio musical     |