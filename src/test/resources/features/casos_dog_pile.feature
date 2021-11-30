# language: es
Característica: Validación de Captcha Google

   necesitamos validar que el captcha de google verifique que soy un robot

  @Regresion
  Escenario: Validar Captcha de Google
    Dado Que Francisco entra en pago online Coopeuch
    Cuando Francisco ingresa rut: 87790088
    Entonces Francisco deberia poder ver el container de Captcha
