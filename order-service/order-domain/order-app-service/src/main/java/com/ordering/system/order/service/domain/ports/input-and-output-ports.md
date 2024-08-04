We have two types of ports in hexagonal architecture.

- **Input ports** are the interfaces that's implemented in the domain layer 
and used by the clients of the domain layer.

- **Output ports** are the interfaces that's implemented in the infrastructure layers
like data access or messaging modules and used by the domain layer to reach to
those infrastructure layers.