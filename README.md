
### Escuela Colombiana de IngenierÃ­a

### Arquitecturas de Software â€“ ARSW
## Laboratorio ProgramaciÃ³n concurrente, condiciones de carrera, esquemas de sincronizaciÃ³n, colecciones sincronizadas y concurrentes - Caso Dogs Race

### DescripciÃ³n:
Este ejercicio tiene como fin que el estudiante conozca y aplique conceptos propios de la programaciÃ³n concurrente.

### Parte I 
Antes de terminar la clase.

CreaciÃ³n, puesta en marcha y coordinaciÃ³n de hilos.

1. Revise el programa â€œprimos concurrentesâ€� (en la carpeta parte1), dispuesto en el paquete edu.eci.arsw.primefinder. Este es un programa que calcula los nÃºmeros primos entre dos intervalos, distribuyendo la bÃºsqueda de los mismos entre hilos independientes. Por ahora, tiene un Ãºnico hilo de ejecuciÃ³n que busca los primos entre 0 y 30.000.000. EjecÃºtelo, abra el administrador de procesos del sistema operativo, y verifique cuantos nÃºcleos son usados por el mismo.

Revisión a través del Administrador de Tareas:

![](./img/CapturaTaskM.png)

Revisión a través de jVisualVM:

![](./img/CapturaJVisual.png)



2. Modifique el programa para que, en lugar de resolver el problema con un solo hilo, lo haga con tres, donde cada uno de Ã©stos harÃ¡ la tarcera parte del problema original. Verifique nuevamente el funcionamiento, y nuevamente revise el uso de los nÃºcleos del equipo.

3. Lo que se le ha pedido es: debe modificar la aplicaciÃ³n de manera que cuando hayan transcurrido 5 segundos desde que se iniciÃ³ la ejecuciÃ³n, se detengan todos los hilos y se muestre el nÃºmero de primos encontrados hasta el momento. Luego, se debe esperar a que el usuario presione ENTER para reanudar la ejecuciÃ³n de los mismo.



### Parte II 


Para este ejercicio se va a trabajar con un simulador de carreras de galgos (carpeta parte2), cuya representaciÃ³n grÃ¡fica corresponde a la siguiente figura:

![](./img/media/image1.png)

En la simulaciÃ³n, todos los galgos tienen la misma velocidad (a nivel de programaciÃ³n), por lo que el galgo ganador serÃ¡ aquel que (por cuestiones del azar) haya sido mÃ¡s beneficiado por el *scheduling* del
procesador (es decir, al que mÃ¡s ciclos de CPU se le haya otorgado durante la carrera). El modelo de la aplicaciÃ³n es el siguiente:

![](./img/media/image2.png)

Como se observa, los galgos son objetos â€˜hiloâ€™ (Thread), y el avance de los mismos es visualizado en la clase Canodromo, que es bÃ¡sicamente un formulario Swing. Todos los galgos (por defecto son 17 galgos corriendo en una pista de 100 metros) comparten el acceso a un objeto de tipo
RegistroLLegada. Cuando un galgo llega a la meta, accede al contador ubicado en dicho objeto (cuyo valor inicial es 1), y toma dicho valor como su posiciÃ³n de llegada, y luego lo incrementa en 1. El galgo que
logre tomar el â€˜1â€™ serÃ¡ el ganador.

Al iniciar la aplicaciÃ³n, hay un primer error evidente: los resultados (total recorrido y nÃºmero del galgo ganador) son mostrados antes de que finalice la carrera como tal. Sin embargo, es posible que una vez corregido esto, haya mÃ¡s inconsistencias causadas por la presencia de condiciones de carrera.

Parte III

1.  Corrija la aplicaciÃ³n para que el aviso de resultados se muestre
    sÃ³lo cuando la ejecuciÃ³n de todos los hilos â€˜galgoâ€™ haya finalizado.
    Para esto tenga en cuenta:

    a.  La acciÃ³n de iniciar la carrera y mostrar los resultados se realiza a partir de la lÃ­nea 38 de MainCanodromo.

    b.  Puede utilizarse el mÃ©todo join() de la clase Thread para sincronizar el hilo que inicia la carrera, con la finalizaciÃ³n de los hilos de los galgos.

2.  Una vez corregido el problema inicial, corra la aplicaciÃ³n varias
    veces, e identifique las inconsistencias en los resultados de las
    mismas viendo el â€˜rankingâ€™ mostrado en consola (algunas veces
    podrÃ­an salir resultados vÃ¡lidos, pero en otros se pueden presentar
    dichas inconsistencias). A partir de esto, identifique las regiones
    crÃ­ticas () del programa.

3.  Utilice un mecanismo de sincronizaciÃ³n para garantizar que a dichas
    regiones crÃ­ticas sÃ³lo acceda un hilo a la vez. Verifique los
    resultados.

4.  Implemente las funcionalidades de pausa y continuar. Con estas,
    cuando se haga clic en â€˜Stopâ€™, todos los hilos de los galgos
    deberÃ­an dormirse, y cuando se haga clic en â€˜Continueâ€™ los mismos
    deberÃ­an despertarse y continuar con la carrera. DiseÃ±e una soluciÃ³n que permita hacer esto utilizando los mecanismos de sincronizaciÃ³n con las primitivas de los Locks provistos por el lenguaje (wait y notifyAll).

