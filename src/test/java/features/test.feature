
Feature: Login de un usuario al sistema AC y Hacer una reserva - Smoke Test
  Como usuario quiero acceder al sistema y realizar operaciones en Reservas

  Scenario:
    Ingresar credenciales validas para ingresar al sistema y realizar una reserva
    Given El usuario se encuentra en la pagina de Login de AC
    When  Ingrese Las credenciales validas
    And   Haga click en la flecha verde
    And   Ingreso al Sistema AC y veo la pagina Home
    And   El usuario se encuentra logueado en la pagina home de AC
    And   Hago Click al Menu Principal y Entro al modudo de reservas
    And   Elijo la Fecha en el calendario
    And   Hago click en el enlace Nueva AWB
    And   Completo los datos de la nueva AWB
    And   Se presiona el icono guardar
    Then  Se inserta una nueva fila vacìa en la tabla de reservas

  #Scenario:
  #Gestion de Reservas - Nueva Reserva -  Como usuarios quiero crear una nueva reserva para generar una Guia

