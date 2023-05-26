# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)}
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
      
      class IU { mostrarVentana()}
      
      class Dialog { mostrarVelocidad() }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    View "1" *-- "1" IU : association
    View "1" *-- "1" Dialog : association
```

---

## Evento en el View

Cuando ocurre un evento en la vista, el `controller` se tiene que enterar.
Tenemos que tener en cuenta que en el MVC estricto, la vista no se comunica con el modelo.

En el listener del botón llamamos al `controller`


```mermaid
sequenceDiagram
    actor usuario
    participant View
    participant Controller
    participant Model
    
    usuario->>View: click! Crear coche
    View->>Controller: el usuario quiere crear un coche
    activate Controller
    Controller->>Model: crea un coche, porfa
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>View: ok, coche creado!
    deactivate Controller
    View-->>usuario: tu coche se creó!
```

Ahora la parte de la Arquitectura de la vista, son tres clases
```mermaid
sequenceDiagram
    autonumber
    actor usuario
    box gray Vista con JFrame
        participant IU
        participant Dialog
        participant View
        end
        
    participant Controller
    participant Model

    usuario->>IU: click! Crear coche
    IU->>Controller: crearCoche()
    activate Controller
    Controller->>Model: crearCoche
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: mostrarVelocidad
    deactivate Controller
    View-->>-Dialog: mostrarVelocidad()
```
---
## Examen e pasos que realicei;

1. Creo a clase ObsExceso:
    + Nesta clase implemento o Observer 
    + Despois instancio a View e o metodo update cun if para cando
    cambie de velocidade poña un mensaxe sobre esa velocidade, no caso de if si a velocidade pasa dos
    120 mostra o mensaxe que esta na View como mostrarExceso, e no caso de else o mensaje normal notificando 
    a velocidade
2. No Model:
   + Primeiro extendemos Observable, logo nos metodos subir e baixar velocidade instancio a clase Coche
    logo facemos un if onde si o coche existe, no caso do metodo subirVelocidade a velocidade aumente, 
    e no caso do metodo bajarVelocidad a velocidade baixa, despois en ambos casos e igual cos metodos 
    setChanged e notifyObservers(coche), para que notifique sobre o cambio realizado na velocidade.
3. No Controller:
   + Instancio a clase ObsExceso e añado o Observer ao Observable
4. Na View:
    + Creo o metodo mostrarExceso para que mandar o mensaxe

5. Fago o diagrama de secuencias
```mermaid
sequenceDiagram
actor usuario
participant View
participant Controller
participant Model
participant ObsExceso

    usuario->>View: click! Crear coche
    View->>Controller: el usuario quiere crear un coche
    activate Controller
    Controller->>Model: crea un coche
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>View: ok, coche creado!
    deactivate Controller
    View-->>usuario: tu coche se creó!
    usuario->>View: click! Subir velocidad
    View->>Controller: el usuario quiere subir la velocidad
    activate Controller
    Controller->>Model: sube la velocidad
    activate Model
    Model-->>ObsExceso: Sube la Velocidad
    activate ObsExceso
    ObsExceso-->>View: cambio en la velocidad
    View-->usuario: tu coche ha cambiado la velocidad. Si la velocidad sobrepasa los 120km/h procede a saltar una alerta.
```

