# Spicardo API

## Descripción del Proyecto

**Spicardo API** Prueba técnica cargo TL- tenpo.

### Funciones Implementadas:

1. **Cálculo con porcentaje dinámico**:

   - Implementa un endpoint para recibir dos números (`num1`, `num2`), sumarlos y aplicar un porcentaje adicional obtenido de un servicio externo.
   - Ejemplo: Si `num1 = 5` y `num2 = 5`, y el servicio externo retorna un 10%, el resultado será `(5 + 5) + (10%) = 11`.

2. **Caché del porcentaje**:

   - El porcentaje obtenido del servicio externo se almacena en memoria durante 30 minutos.
   - Si el servicio externo falla, se usa el valor último almacenado en caché.
   - Si no hay un valor en caché, se retorna un error adecuado.

3. **Reintentos ante fallos del servicio externo**:

   - Implementa lógica de reintentos con un máximo de 3 intentos antes de devolver un error o usar el valor en caché.

4. **Historial de llamadas**:
   - Implementa un endpoint para consultar el historial de todas las llamadas realizadas.
   - Incluye detalles como fecha, hora, parámetros recibidos, y la respuesta (éxito o error).
   - Soporta paginación.
   - El registro de las llamadas es asíncrono para no afectar la ejecución principal del servicio.

---
