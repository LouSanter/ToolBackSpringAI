## 🤖 Generación y Persistencia de Objetos con IA

**Autor:** Lucas Sanchez  
**Lenguaje:** Java  

Este proyecto demuestra cómo una IA puede generar y manipular objetos Java en tiempo real, manteniendo el contexto de la conversación mediante `ChatMemory` y utilizando herramientas (`@Tool`) que interactúan directamente con la lógica de negocio del backend.

---

### 🧪 Ejemplo de Uso

- 🧍 Usuario: "Genera un Producto ..."
- 🤖 IA: "Listo" → (ResponseEntity.ok(Producto)) ✔️
- 🧍 Usuario: "Otro"
- 🤖 IA: "Listo" → Usa `ChatMemory` para mantener el contexto 🧠
- 🧍 Usuario: "Quiero saber algo de un producto"
- 🤖 IA: "Claro, proporcióname el ID"
- 🧍 Usuario: 1
- 🤖 IA: [Ejecuta findById() del controlador y retorna el objeto] 📦



> 📌 Gracias al uso de `@Tool`, la IA sabe que necesita un parámetro (`ID`) para continuar.  
> `ChatMemory` permite conservar el contexto entre interacciones.  
> La respuesta del método se devuelve directamente, sin pasar por el LLM (esto es configurable).

---

### ⚙️ Características Técnicas

- 🧠 Uso de **2 `ChatClient`** para que el LLM interactúe con el código sin necesidad de embeddings ni vectores.
- 🚫 **Sin consumo excesivo de tokens**, ya que se evita el uso de bases vectoriales.
- 🔧 Definición de métodos inteligentes con `@Tool`, incluyendo parámetros requeridos.
- 🧱 Conversión automática de respuestas de IA en objetos Java usando `BeanOutputConverter`.

---

Este enfoque permite integrar IA en sistemas Java de forma modular, flexible y sin complicaciones, ideal para proyectos donde se requiera generación de datos, consultas dinámicas y persistencia eficiente.
