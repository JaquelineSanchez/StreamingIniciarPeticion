# StreamingIniciarPeticion
Primeros dos microservicios para proyecto de SOA: Streaming de peliculas

#Colas empleadas en el microservicio de iniciar peticion
queue.name.in = stream.is.in [Recibe un JSON con nombre y contraseña de usuario ademas de el titulo requerido]
queue.name.out = stream.is.out [Recibe un mensaje por cualquier error ocurrido en este microservicio]
queue.name.next = stream.vp.in [Recibe un JSON con id de usuario, nombre y titulo deseado]

#Colas empleadas en el microservicio de validar pelicula
queue.name.in = stream.vp.in [Recibe un JSON con id de usuario, nombre y titulo deseado]
queue.name.out = stream.vp.out [Recibe un mensaje por cualquier error ocurrido en este microservicio]
queue.name.next = stream.rp.in *[Recibe un JSON con id de usuario, nombre, id y titulo deseado]

