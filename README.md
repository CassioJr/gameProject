# GameProject

A game project developed with **JavaFX** for the purpose of practicing framework's tools and features.

## 🛠 Tools & Technologies

* **Java** (Programming Language)
* **JavaFX** (UI Framework)
* **Gson Library** (Included in the `lib` folder)
* **Scene Builder** (Visual layout tool)

## ⚙️ Requirements & Setup

To run this project correctly, you need to configure the JavaFX environment in your IDE.

> [!CAUTION]
> **Important:** If you do not follow the steps below, the application will fail to start.

1. **Build Path:** Add all JavaFX `.jar` files (from your local SDK) to the project's Build Path.
2. **VM Arguments:** You must configure the VM arguments in your Run Configuration. 

Example of VM arguments:
```bash
--module-path "/path/to/your/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml
