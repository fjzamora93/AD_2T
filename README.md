# Relaciones Requisito 2

## Models
1. **Usuario.** Supongamos un jugador en un juego de rol.
2. **Personaje.** Cada uno de los personajes creados por un jugador.
4. **StatSet** Set de características de cada personaje.
3. **Habilidad.** Conjunto de habilidades de cada personaje.

## Relaciones

- **Personaje - StatSet** : OneToOne

- **Usuario - Personaje** : OneToMany
- **Personaje - Usuario:** ManyToOne

- **Personaje - Habilidad:** ManyToMany


